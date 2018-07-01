package service.orchestation.account.integration.client;

import org.springframework.cloud.openfeign.FeignClient;
import service.orchestation.account.integration.controller.AccountIntegrationService;

@FeignClient(name = "account-rest-api")
public interface AccountIntegrationClient extends AccountIntegrationService {
}