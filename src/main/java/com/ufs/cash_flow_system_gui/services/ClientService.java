package com.ufs.cash_flow_system_gui.services;

import com.ufs.cash_flow_system_gui.models.Account;
import com.ufs.cash_flow_system_gui.models.Client;
import com.ufs.cash_flow_system_gui.persistence.ClientsPersistence;

public class ClientService {

    public ClientService() {
    }

    public Client getClientByName(String clientName) {
        return ClientsPersistence.getClientByName(clientName);
    }

    public void createClient(String name, String birthDate) {
        Client client = new Client(name, birthDate);
        ClientsPersistence.addClient(client);
    }

    public void updateClient(Client client) {
        ClientsPersistence.updateClient(client);
    }

    public void deleteClient(String clientName) {
        ClientsPersistence.deleteClient(clientName);
    }
}
