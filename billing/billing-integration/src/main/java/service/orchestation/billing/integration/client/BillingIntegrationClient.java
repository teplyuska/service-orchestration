package service.orchestation.billing.integration.client;

import org.springframework.cloud.openfeign.FeignClient;
import service.orchestation.billing.integration.controller.BillingIntegrationService;

@FeignClient(name = "billing-rest-api")
public interface BillingIntegrationClient extends BillingIntegrationService {
}