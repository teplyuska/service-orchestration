package service.orchestration.eurekaserver;

import com.beust.jcommander.JCommander;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import service.orchestation.shared.util.PropertiesConstants;

@SpringBootApplication
@EnableAutoConfiguration(exclude = GsonAutoConfiguration.class)
@EnableEurekaServer
public class EurekaServerAppInit {
    public static void main(String[] args) {
        EurekaServerArgs bootArgs = new EurekaServerArgs();
        JCommander.newBuilder()
                .addObject(bootArgs)
                .build()
                .parse(args);

        String serverPort = PropertiesConstants.SERVER_PORT + "=" + bootArgs.getServerPort();

        new SpringApplicationBuilder(EurekaServerAppInit.class)
                .bannerMode(Banner.Mode.LOG)
                .properties(serverPort)
                .run();
    }
}