package service.orchestation.configserver.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import service.orchestation.shared.eurekaclient.config.EurekaClientConfig;

@Configuration
@Import({
        EurekaClientConfig.class
})
// @ComponentScan("service.orchestation.configserver.service")
public class ConfigServerConfig {
}
