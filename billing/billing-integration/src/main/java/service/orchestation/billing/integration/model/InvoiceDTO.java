package service.orchestation.billing.integration.model;

public class InvoiceDTO {
    private String identifier;
    private String email;

    public InvoiceDTO() {
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
