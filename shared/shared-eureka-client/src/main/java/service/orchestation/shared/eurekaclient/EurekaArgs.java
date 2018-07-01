package service.orchestation.shared.eurekaclient;

import com.beust.jcommander.Parameter;

public class EurekaArgs {
    @Parameter(names = "--eureka-server-uri", description = "Eureka Server Uri", required = true)
    private String eurekaServerPort;

    public EurekaArgs() {
    }

    public String getEurekaServerUri() {
        return eurekaServerPort;
    }

    public void setEurekaServerPort(String eurekaServerPort) {
        this.eurekaServerPort = eurekaServerPort;
    }
}
