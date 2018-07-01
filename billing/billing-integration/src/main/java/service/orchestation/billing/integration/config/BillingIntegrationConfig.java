package service.orchestation.billing.integration.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import service.orchestation.shared.feign.config.SharedFeignConfig;

@Configuration
@EnableFeignClients(basePackages = "service.orchestation.billing.integration.client")
@Import(SharedFeignConfig.class)
public class BillingIntegrationConfig {
}
