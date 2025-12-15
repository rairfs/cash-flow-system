package com.ufs.cash_flow_system_gui.controllers;

import com.ufs.cash_flow_system_gui.services.ClientService;
import com.ufs.cash_flow_system_gui.ui.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.time.LocalDate;

public class CreateAccountController {

    private final ClientService clientService = new ClientService();
    @FXML
    public TextField fullName;
    @FXML
    public DatePicker birthDate;

    @FXML
    public void createAccount(ActionEvent event) throws IOException {
        String name = fullName.getText();
        LocalDate date = birthDate.getValue();
        clientService.createClient(name, date);

        SceneSwitcher.switchScene("login-view.fxml", "Autenticação - Cash Flow System", event);
    }
}
