package service.orchestation.shared.eurekaclient.model;

public class ServiceOrchestationClient {
    private String applicationName;
    private String homePageUrl;
    private String managementBaseUrl;

    public ServiceOrchestationClient(String applicationName, String homePageUrl, String managementBaseUrl) {
        this.applicationName = applicationName;
        this.homePageUrl = homePageUrl;
        this.managementBaseUrl = managementBaseUrl;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getHomePageUrl() {
        return homePageUrl;
    }

    public void setHomePageUrl(String homePageUrl) {
        this.homePageUrl = homePageUrl;
    }

    public String getManagementBaseUrl() {
        return managementBaseUrl;
    }

    public void setManagementBaseUrl(String managementBaseUrl) {
        this.managementBaseUrl = managementBaseUrl;
    }
}
