// src/test/java/com/ufs/cash_flow_system_gui/services/ClientServiceTest.java
package com.ufs.cash_flow_system_gui.services;

import com.ufs.cash_flow_system_gui.models.Client;
import com.ufs.cash_flow_system_gui.persistence.ClientsPersistence;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;

class ClientServiceTest {

    @Test
    void testGetClientByName_returnsClient() {
        Client expected = new Client("Alice", LocalDate.of(1990, 1, 1));

        try (MockedStatic<ClientsPersistence> mocked = Mockito.mockStatic(ClientsPersistence.class)) {
            mocked.when(() -> ClientsPersistence.getClientByName("Alice")).thenReturn(expected);

            ClientService service = new ClientService();
            Client actual = service.getClientByName("Alice");

            assertNotNull(actual);
            assertEquals("Alice", actual.getName());
            assertEquals(expected, actual);
            mocked.verify(() -> ClientsPersistence.getClientByName("Alice"), times(1));
        }
    }

    @Test
    void testCreateClient_callsAddClient() {
        LocalDate bd = LocalDate.of(2000, 5, 20);

        try (MockedStatic<ClientsPersistence> mocked = Mockito.mockStatic(ClientsPersistence.class)) {
            ClientService service = new ClientService();
            service.createClient("Bob", bd);

            // verifica que addClient foi chamado uma vez com qualquer Client
            mocked.verify(() -> ClientsPersistence.addClient(Mockito.any(Client.class)), times(1));
        }
    }

    @Test
    void testUpdateClient_callsUpdateClient() {
        Client client = new Client("Carol", LocalDate.of(1985, 3, 3));

        try (MockedStatic<ClientsPersistence> mocked = Mockito.mockStatic(ClientsPersistence.class)) {
            ClientService service = new ClientService();
            service.updateClient(client);

            mocked.verify(() -> ClientsPersistence.updateClient(client), times(1));
        }
    }

    @Test
    void testDeleteClient_callsDeleteClient() {
        try (MockedStatic<ClientsPersistence> mocked = Mockito.mockStatic(ClientsPersistence.class)) {
            ClientService service = new ClientService();
            service.deleteClient("Dave");

            mocked.verify(() -> ClientsPersistence.deleteClient("Dave"), times(1));
        }
    }
}
