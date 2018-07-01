package service.orchestation.configserver.controllers;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.config.environment.Environment;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.orchestation.configserver.EnvironmentUtil;
import service.orchestation.configserver.service.interfaces.IApplicationConfigService;
import service.orchestation.configserver.service.interfaces.IConfigService;
import service.orchestation.shared.eurekaclient.model.ServiceOrchestationClient;
import service.orchestation.shared.eurekaclient.service.interfaces.IServiceOrchestration;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("client")
public class ClientController {
//    private IServiceOrchestration eurekaService;
//    private IApplicationConfigService applicationConfigService;
//    private IConfigService configService;
//
//    @Autowired
//    public ClientController(IServiceOrchestration eurekaService, IApplicationConfigService applicationConfigService, IConfigService configService) {
//        this.eurekaService = eurekaService;
//        this.applicationConfigService = applicationConfigService;
//        this.configService = configService;
//    }
//
//    @RequestMapping
//    public List<ServiceOrchestationClient> getAllServices() {
//        return eurekaService.getClients();
//    }
//
//    @RequestMapping("config/refresh")
//    public void refreshAllServiceConfigs(@RequestParam(required = false) String profile) throws IOException {
//        if (StringUtils.isEmpty(profile)) {
//            profile = configService.getProfile();
//        }
//
//        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
//
//        // Send "refresh" request to all clients that are not the client where this controller is located (config-server)
//        // The "refresh" request is part of Spring Actuator and it is not certain that the endpoint is enabled.
//        // Use the config-server to figure out if the application has the refresh management endpoint enabled.
//        String finalProfile = profile;
//        eurekaService.getClients().stream()
//                .filter(c -> !c.getApplicationName().equals(configService.getApplicationName()))
//                .forEach(c -> {
//                    Optional<Environment> environmentOptional = applicationConfigService.getApplicationConfig(c.getApplicationName(), finalProfile, null);
//                    if (environmentOptional.isPresent()) {
//                        Environment environment = environmentOptional.get();
//                        List<String> managementEndpoints = EnvironmentUtil.getManagementEndpoints(environment);
//                        if (managementEndpoints.contains(configService.getRefreshEndpoint())) {
//                            HttpPost request = new HttpPost(String.format("%s/%s", c.getManagementBaseUrl(), configService.getRefreshEndpoint()));
//                            try {
//                                HttpResponse httpResponse = httpClient.execute(request);
//                                System.out.println(httpResponse.getStatusLine().getStatusCode());
//                            } catch (IOException e) {
//                                e.printStackTrace();
//                            }
//                        }
//                    }
//                });
//
//        httpClient.close();
//    }
}
