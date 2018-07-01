package service.orchestation.configserver.service.interfaces;

import org.springframework.cloud.config.environment.Environment;

import java.util.Optional;

public interface IApplicationConfigService {

    Optional<Environment> getApplicationConfig(String application, String profile, String label);
}
