package service.orchestration.eurekaserver;

import com.beust.jcommander.Parameter;

public class EurekaServerArgs {
    @Parameter(names = "--server-port", description = "Eureka Server port", required = true)
    private String serverPort;

    public EurekaServerArgs() {
    }

    public String getServerPort() {
        return serverPort;
    }

    public void setServerPort(String serverPort) {
        this.serverPort = serverPort;
    }
}
