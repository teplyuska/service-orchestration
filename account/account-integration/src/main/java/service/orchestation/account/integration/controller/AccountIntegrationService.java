package service.orchestation.account.integration.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.orchestation.account.integration.model.AccountDTO;

@RequestMapping("account")
public interface AccountIntegrationService {
    @RequestMapping(value = "{accountId}", method = RequestMethod.GET)
    AccountDTO getAccount(@PathVariable("accountId") Long accountId);
}