**Initial Notes**  

 - All security is disabled for now  
 - Actuator endpoints are configured to be located on /management/\*  
 - service.orchestation.postman_collection.json contains some of the requests mentioned later and can be imported in postman.  
 - All modules can be build with maven by using the master pom in the root directory.  
 - Attempt to manage depencency imports in shared-\* modules so one can pick and choose when creating a new \*-rest-api  

**System setup**  

Edit your hosts file so that "so-eureka" points to the location of your eureka server.

Windows C:\Windows\System32\drivers\etc\hosts:
 - 127.0.0.1 so-eureka
 
**config-server git repository**

Initialize a git repository. We need the path for this repository later.

Add the files:  

_account-rest-api-dev.properties_
```
# Test message returned by the TestController on .../message
message=account-rest-api configuration message

# Following configurations are loaded on app start and cannot be refreshed runtime
management.endpoints.web.exposure.include=env,health,auditevents,info,refresh,beans,shutdown,scheduledtasks,metrics,configprops
management.endpoints.web.base-path=/management

# 0 for random
server.port=8081
```

_billing-rest-api-dev.properties_
```
# Test message returned by the TestController on .../message
message=billing-rest-api configuration message

# Following configurations are loaded on app start and cannot be refreshed runtime
management.endpoints.web.exposure.include=env,health,auditevents,info,refresh,beans,shutdown,scheduledtasks,metrics,configprops
management.endpoints.web.base-path=/management

# 0 for random
server.port=8082
```

It is important to note that the config-server reads the files in the most recent commit, so be sure to commit the changes or it will not be picked up.
 
**Run apps:**  

1) Start eureka-server with argument:

_--server-port 8090_

All other apps are hardcoded to find eureka-server on "http://so-eureka:8090/eureka/", so probably don't change this.
    
The eureka-server will attempt to find a replica (backup) eureka-server on localhost:8761, which will fail.  
This however does not affect this example, but should be used in production where nothing works if there is no eureka-server.

2) Start config-server with arguments:

_--git-uri "Path to root of config-server git repository"_

git-uri is the path to the git repository that holds the {spring.application.name}-{spring.profiles.active}.properties files which contains configurations for the apps (\*-rest-api).

_--profile dev_

profile is used to set spring.profiles.active
    
The config server will register with the eureka-server so other apps can discover it through eureka.

3) Start account-rest-api, billing-rest-api and *-rest-api ... with argument:

_--profile dev_
    
**Eureka**
    
Using eureka-server on "http://so-eureka:8090/eureka/"  
 - The \*-rest-api will register it self with the eureka-server so other apps can locate it.
 - In addition it will fetch a list of other apps (\*-rest-api) and servers (config-server) from the eureka-server.

**Config**
    
Every app contains a bootstrap.properties  
This file contains all the configurations that needs to be available before reaching the eureka-server and config-server.  
The configurations fetched from the config-server is what you would normally put in application.properties
    
Using the config-server located using the eureka-server on "http://so-eureka:8090/eureka/"
 - Automatically fetch configurations from the config-server.  
 - Fetch configurations using {spring.application.name} and {spring.profiles.active} so you can start the app pointing to different profile (environment) configs.  
 - The {spring.application.name} is hardcoded in the bootstrap.properties file off the app.

If the config-server is not available the \*-rest-api will retry a configured amount of time. (see properties: spring.cloud.config.retry.\*)
    
You can try this out by starting account-rest-api and then the config-server.

**Update application properties runtime using config-server:**

The account-rest-api and billing-rest-api both have a TestController which returns the configuration "message" on .../message

1) Go to the config-server git repository (--git-uri when starting config-server)  
2) Update the {spring.application.name}-{spring.profiles.active}.properties matching the app (account-rest-api) and profile (dev) with the property "message=MESSAGE HERE"  
3) Commit the changes made  
4) Send POST request to the actuator refresh endpoint of the app of which you have updated properties (.../management/refresh)  
5) Check the .../message endpoint where the new message config should be returned.  

**Using Feign Client with Eureka Service Discovery**

All of the above is really done to facilitate this functionality. This is where one can easily build new services.

account-rest-api has a @ RestController called `AccountIntegrationServiceImp`.  
This implements the interface `AccountIntegrationService` in account-integration, and defines the @ RequestMapping  
The @ FeignClient is created by the interface `AccountIntegrationClient` extending `AccountIntegrationService`

Modules depending on account-integration and using @ Import on `AccountIntegrationConfig` will be able to autowire `AccountIntegrationClient`.
By using `AccountIntegrationClient` the depending app will automatically find the account-rest-api through eureka-server and the feign client will automatically handle all communications and mapping by using the information defined in `AccountIntegrationService`

The `BillingIntegrationServiceImp` created the same way.

The billing-rest-api depends on the account-integration and `BillingIntegrationServiceImp` autowires `AccountIntegrationClient`

Try starting all the servers and rest-api's and set a debugger in `BillingIntegrationServiceImp.getAccountInvoices()`

Then send a request to .../billing/account/8675/invoice and watch how Eureka and Feign client magically finds and gets information from account-rest-api