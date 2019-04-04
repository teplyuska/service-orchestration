package service.orchestation.configserver;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.Import;
import service.orchestation.configserver.config.ConfigServerConfig;

@SpringBootApplication(exclude = GsonAutoConfiguration.class)
@EnableConfigServer
@Import(ConfigServerConfig.class)
public class ConfigServerAppInit {
    public static void main(String[] args) {
        new SpringApplicationBuilder(ConfigServerAppInit.class)
                .bannerMode(Banner.Mode.LOG)
                .run();
    }
}