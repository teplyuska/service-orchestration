package service.orchestation.account.restapi.config;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import service.orchestation.shared.eurekaclient.config.EurekaClientConfig;
import service.orchestation.shared.security.config.ActuatorSecurityConfig;

@Configuration
@ComponentScan("service.orchestation.account.restapi.controller")
@ComponentScan("service.orchestation.account.restapi.config.implementations")
@Import({
        EurekaClientConfig.class,
        ActuatorSecurityConfig.class
})
// @RibbonClient(name = "account-rest-api")
public class RestApiConfig {
}
