package service.orchestation.account.restapi.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import service.orchestation.shared.eurekaclient.config.EurekaClientConfig;
import service.orchestation.shared.security.config.ActuatorSecurityConfig;

@Configuration
@ComponentScan("service.orchestation.account.restapi.controller")
@Import({
        EurekaClientConfig.class,
        ActuatorSecurityConfig.class
})
public class RestApiConfig {
}
