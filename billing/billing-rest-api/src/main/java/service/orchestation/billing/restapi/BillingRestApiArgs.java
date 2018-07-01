package service.orchestation.billing.restapi;

import com.beust.jcommander.Parameter;

public class BillingRestApiArgs {
//    @Parameter(names = "--config-server-username", description = "Config Server username", required = true)
//    private String configServerUsername;
//
//    @Parameter(names = "--config-server-password", description = "Config Server password", required = true)
//    private String configServerPassword;

    @Parameter(names = "--profile", description = "Spring Profile", required = true)
    private String profile;

    public BillingRestApiArgs() {
    }

//    public String getConfigServerUsername() {
//        return configServerUsername;
//    }
//
//    public void setConfigServerUsername(String configServerUsername) {
//        this.configServerUsername = configServerUsername;
//    }
//
//    public String getConfigServerPassword() {
//        return configServerPassword;
//    }
//
//    public void setConfigServerPassword(String configServerPassword) {
//        this.configServerPassword = configServerPassword;
//    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }
}
