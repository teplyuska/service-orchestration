package service.orchestation.billing.restapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import service.orchestation.account.integration.client.AccountIntegrationClient;
import service.orchestation.account.integration.model.AccountDTO;
import service.orchestation.billing.integration.controller.BillingIntegrationService;
import service.orchestation.billing.integration.model.InvoiceDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class BillingIntegrationServiceImp implements BillingIntegrationService {
    private AccountIntegrationClient accountIntegrationClient;

    @Autowired
    public BillingIntegrationServiceImp(AccountIntegrationClient accountIntegrationClient) {
        this.accountIntegrationClient = accountIntegrationClient;
    }

    @Override
    public List<InvoiceDTO> getAccountInvoices(@PathVariable Long accountId) {
        AccountDTO account = accountIntegrationClient.getAccount(accountId);

        List<InvoiceDTO> invoices = new ArrayList<>();
        InvoiceDTO invoice = new InvoiceDTO();
        invoice.setEmail(account.getInvoiceEmail());
        invoice.setIdentifier(UUID.randomUUID().toString());
        invoices.add(invoice);

        return invoices;
    }
}