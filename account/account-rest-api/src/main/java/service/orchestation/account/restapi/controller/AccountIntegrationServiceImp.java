package service.orchestation.account.restapi.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import service.orchestation.account.integration.controller.AccountIntegrationService;
import service.orchestation.account.integration.model.AccountDTO;

import java.util.UUID;

@RestController
public class AccountIntegrationServiceImp implements AccountIntegrationService {
    @Override
    public AccountDTO getAccount(@PathVariable Long accountId) {
        AccountDTO account = new AccountDTO();
        account.setId(accountId);
        account.setInvoiceEmail(accountId + "@abc.xyz");
        account.setIdentifier(UUID.randomUUID().toString());
        return account;
    }
}
