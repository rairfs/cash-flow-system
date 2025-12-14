package com.ufs.cash_flow_system_gui.persistence;

import com.ufs.cash_flow_system_gui.models.Client;
import java.util.List;

public class ClientsPersistence {

    private static List<Client> clients;

    public static List<Client> getClients() {
        return clients;
    }

    public static void setClients(List<Client> clients) {
        ClientsPersistence.clients = clients;
    }

    public static Client getClientByName(String name) {
        for (Client client : clients) {
            if (client.getName().equals(name)) {
                return client;
            }
        }
        return null;
    }

    public static void addClient(Client client) {
        clients.add(client);
    }

    public static void updateClient(Client client) {
        for (int i = 0; i < clients.size(); i++) {
            if (clients.get(i).getName().equals(client.getName())) {
                clients.set(i, client);
                return;
            }
        }
    }

    public static void deleteClient(String name) {
        clients.removeIf(client -> client.getName().equals(name));
    }
}
