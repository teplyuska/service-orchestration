package service.orchestration.eurekaserver;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication(exclude = GsonAutoConfiguration.class)
@EnableEurekaServer
public class EurekaServerAppInit {
    public static void main(String[] args) {
        new SpringApplicationBuilder(EurekaServerAppInit.class)
                .bannerMode(Banner.Mode.LOG)
                .run();
    }
}