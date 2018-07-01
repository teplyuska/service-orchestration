package service.orchestation.configserver;

import org.springframework.cloud.config.environment.Environment;
import org.springframework.cloud.config.environment.PropertySource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class EnvironmentUtil {
    private static String managementEndpointPropertyKey = "management.endpoints.web.exposure.include";

    public static List<String> getManagementEndpoints(Environment environment) {
        Optional<PropertySource> propertySource = environment.getPropertySources().stream()
                .filter(pr -> pr.getSource().containsKey(managementEndpointPropertyKey))
                .findFirst();

        return propertySource.map(propertySource1 -> Arrays.asList(propertySource1.getSource().get(managementEndpointPropertyKey).toString().split(","))).orElseGet(ArrayList::new);
    }
}
