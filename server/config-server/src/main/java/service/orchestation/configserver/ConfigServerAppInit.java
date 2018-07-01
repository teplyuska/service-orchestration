package service.orchestation.configserver;

import com.beust.jcommander.JCommander;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.Import;
import org.springframework.util.StringUtils;
import service.orchestation.configserver.config.ConfigServerConfig;
import service.orchestation.shared.util.PropertiesConstants;

@SpringBootApplication
@EnableAutoConfiguration(exclude = GsonAutoConfiguration.class)
@EnableConfigServer
@Import(ConfigServerConfig.class)
public class ConfigServerAppInit {
    public static void main(String[] args) {
        ConfigServerArgs bootArgs = new ConfigServerArgs();
        JCommander.newBuilder()
                .addObject(bootArgs)
                .build()
                .parse(args);

        String profile = PropertiesConstants.SPRING_PROFILES_ACTIVE + "=" + bootArgs.getProfile();
        String gitUri = PropertiesConstants.SPRING_CLOUD_CONFIG_SERVER_GIT_URI + "=" + bootArgs.getGitUri();
        // For some reason eureka.client.serviceUrl.defaultZone is not picked up from bootstrap.properties
        String eurekaServerUri = "eureka.client.serviceUrl.defaultZone=http://so-eureka:8090/eureka/";

        new SpringApplicationBuilder(ConfigServerAppInit.class)
                .bannerMode(Banner.Mode.LOG)
                .properties(profile, gitUri, eurekaServerUri)
                .run();
    }
}