package com.ufs.cash_flow_system_gui.controllers;

import com.ufs.cash_flow_system_gui.auth.AuthHelper;
import com.ufs.cash_flow_system_gui.models.Client;
import com.ufs.cash_flow_system_gui.services.ClientService;
import com.ufs.cash_flow_system_gui.ui.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.io.IOException;

public class UseAccountController {
    @FXML
    public TextField fullName;

    private final ClientService clientService = new ClientService();

    @FXML
    public void login(ActionEvent event) throws IOException {
        String name = fullName.getText();
        Client client = clientService.getClientByName(name);

        if (client == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Usuário não encontrado");
            alert.setContentText("Por favor, verifique o nome e tente novamente.");
            alert.showAndWait();
            return;
        }
        AuthHelper.setLoggedInClient(client);
        SceneSwitcher.switchScene("client-view.fxml", "Bem Vindo - " + client.getName(), event);
    }
}
