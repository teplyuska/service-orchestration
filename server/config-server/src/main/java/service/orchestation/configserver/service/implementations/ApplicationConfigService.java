package service.orchestation.configserver.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.config.environment.Environment;
import org.springframework.cloud.config.server.environment.MultipleJGitEnvironmentRepository;
import org.springframework.stereotype.Service;
import service.orchestation.configserver.service.interfaces.IApplicationConfigService;

import java.util.Optional;

@Service
public class ApplicationConfigService implements IApplicationConfigService {
    private MultipleJGitEnvironmentRepository multipleJGitEnvironmentRepository;

    @Autowired
    public ApplicationConfigService(MultipleJGitEnvironmentRepository multipleJGitEnvironmentRepository) {
        this.multipleJGitEnvironmentRepository = multipleJGitEnvironmentRepository;
    }

    @Override
    public Optional<Environment> getApplicationConfig(String application, String profile, String label) {
        if (multipleJGitEnvironmentRepository != null) {
            Environment environment = multipleJGitEnvironmentRepository.findOne(application, profile, label);
            return Optional.of(environment);
        }

        return Optional.empty();
    }
}
