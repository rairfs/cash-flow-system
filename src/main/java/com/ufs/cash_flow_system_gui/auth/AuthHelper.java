package com.ufs.cash_flow_system_gui.auth;

import com.ufs.cash_flow_system_gui.models.Client;

public class AuthHelper {
    private static Client loggedInClient;

    public static Client getLoggedInClient() {
        return loggedInClient;
    }

    public static void setLoggedInClient(Client client) {
        loggedInClient = client;
    }
}
