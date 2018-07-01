package service.orchestation.billing.restapi.config;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import service.orchestation.account.integration.config.AccountIntegrationConfig;
import service.orchestation.shared.eurekaclient.config.EurekaClientConfig;
import service.orchestation.shared.security.config.ActuatorSecurityConfig;

@Configuration
@ComponentScan("service.orchestation.billing.restapi.controller")
@Import({
        EurekaClientConfig.class,
        AccountIntegrationConfig.class,
        ActuatorSecurityConfig.class
})
// @RibbonClient(name = "billing-rest-api")
public class RestApiConfig {
}
