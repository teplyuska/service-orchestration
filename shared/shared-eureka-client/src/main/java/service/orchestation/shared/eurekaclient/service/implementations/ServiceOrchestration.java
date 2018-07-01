package service.orchestation.shared.eurekaclient.service.implementations;

import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import service.orchestation.shared.eurekaclient.model.ServiceOrchestationClient;
import service.orchestation.shared.eurekaclient.service.interfaces.IServiceOrchestration;
import service.orchestation.shared.eurekaclient.service.interfaces.IServiceOrchestrationConfig;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceOrchestration implements IServiceOrchestration {
    private DiscoveryClient discoveryClient;
    private EurekaClient eurekaClient;
    private IServiceOrchestrationConfig serviceOrchestrationConfig;

    @Autowired
    public ServiceOrchestration(DiscoveryClient discoveryClient, EurekaClient eurekaClient, IServiceOrchestrationConfig serviceOrchestrationConfig) {
        this.discoveryClient = discoveryClient;
        this.eurekaClient = eurekaClient;
        this.serviceOrchestrationConfig = serviceOrchestrationConfig;
    }

    @Override
    public List<ServiceOrchestationClient> getClients() {
        List<Application> applications = eurekaClient.getApplicationsForARegion(null).getRegisteredApplications();
        return applications.stream()
                .map(Application::getInstances)
                .flatMap(List::stream)
                .map(i -> new ServiceOrchestationClient(i.getAppName().toLowerCase(), i.getHomePageUrl(), i.getStatusPageUrl().replace("info", serviceOrchestrationConfig.getManagementBasePath().replaceAll("/", ""))))
                .collect(Collectors.toList());
    }
}
