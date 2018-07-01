package service.orchestation.configserver.service.implementations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;
import service.orchestation.configserver.service.interfaces.IConfigService;
import service.orchestation.shared.eurekaclient.service.interfaces.IServiceOrchestrationConfig;

@Service
@RefreshScope
public class ConfigService implements IConfigService, IServiceOrchestrationConfig {
    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${spring.profiles.active}")
    private String profile;

    @Value("${management.endpoints.web.base-path}")
    private String manamentBasePath;

    private static String refreshEndpoint = "refresh";

    public ConfigService() {
    }

    @Override
    public String getApplicationName() {
        return applicationName;
    }

    @Override
    public String getProfile() {
        return profile;
    }

    @Override
    public String getManagementBasePath() {
        return manamentBasePath;
    }

    @Override
    public String getRefreshEndpoint() {
        return refreshEndpoint;
    }
}
