package service.orchestation.billing.integration.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.orchestation.billing.integration.model.InvoiceDTO;

import java.util.List;

@RequestMapping("billing")
public interface BillingIntegrationService {
    @RequestMapping(value = "account/{accountId}/invoice", method = RequestMethod.GET)
    List<InvoiceDTO> getAccountInvoices(@PathVariable("accountId") Long accountId);
}