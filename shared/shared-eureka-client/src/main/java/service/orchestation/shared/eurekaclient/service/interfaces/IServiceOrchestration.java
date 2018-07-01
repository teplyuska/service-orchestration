package service.orchestation.shared.eurekaclient.service.interfaces;

import service.orchestation.shared.eurekaclient.model.ServiceOrchestationClient;

import java.util.List;

public interface IServiceOrchestration {
    List<ServiceOrchestationClient> getClients();
}
