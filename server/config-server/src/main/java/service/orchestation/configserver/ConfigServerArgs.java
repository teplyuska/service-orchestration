package service.orchestation.configserver;

import com.beust.jcommander.Parameter;

public class ConfigServerArgs {
    @Parameter(names = "--git-uri", description = "Path to the git repository containing configurations", required = true)
    private String gitUri;

//    @Parameter(names = "--server-port", description = "Config Server port")
//    private String serverPort;

    @Parameter(names = "--profile", description = "Spring Profile", required = true)
    private String profile;

    public ConfigServerArgs() {
    }

    public String getGitUri() {
        return gitUri;
    }

    public void setGitUri(String gitUri) {
        this.gitUri = gitUri;
    }

//    public String getServerPort() {
//        return serverPort;
//    }
//
//    public void setServerPort(String serverPort) {
//        this.serverPort = serverPort;
//    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }
}
