package service.orchestation.account.restapi;

import com.beust.jcommander.JCommander;
import org.springframework.boot.Banner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Import;
import service.orchestation.account.restapi.config.RestApiConfig;
import service.orchestation.shared.util.PropertiesConstants;

@SpringBootApplication
@EnableAutoConfiguration(exclude = GsonAutoConfiguration.class)
@Import(RestApiConfig.class)
public class AccountRestApiAppInit {
    public static void main(String[] args) {
        AccountRestApiArgs bootArgs = new AccountRestApiArgs();
        JCommander.newBuilder()
                .addObject(bootArgs)
                .build()
                .parse(args);

        String profile = PropertiesConstants.SPRING_PROFILES_ACTIVE + "=" + bootArgs.getProfile();
//        String configServerUsername = PropertiesConstants.SPRING_CLOUD_CONFIG_USERNAME + "=" +  bootArgs.getConfigServerUsername();
//        String configServerPassword = PropertiesConstants.SPRING_CLOUD_CONFIG_PASSWORD + "=" + bootArgs.getConfigServerPassword();

        // For some reason eureka.client.serviceUrl.defaultZone is not picked up from bootstrap.properties
        String eurekaServerUri = "eureka.client.serviceUrl.defaultZone=http://so-eureka:8090/eureka/";

        new SpringApplicationBuilder(AccountRestApiAppInit.class)
                .web(WebApplicationType.SERVLET)
                .bannerMode(Banner.Mode.LOG)
                .properties(profile, eurekaServerUri)
                .run();
    }
}
