package service.orchestation.configserver.service.interfaces;

public interface IConfigService {
    String getRefreshEndpoint();

    String getApplicationName();

    String getProfile();

    String getManagementBasePath();
}
