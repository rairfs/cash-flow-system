package com.ufs.cash_flow_system_gui.controllers;

import com.ufs.cash_flow_system_gui.auth.AuthHelper;
import com.ufs.cash_flow_system_gui.models.Client;
import com.ufs.cash_flow_system_gui.ui.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

public class ClientController {

    @FXML
    public Label userInfo;

    @FXML
    public void initialize() {
        Client client = AuthHelper.getLoggedInClient();
        if (client != null) {
            String info = "Usuário: " + client.getName() + " | Conta: " + client.getAccount().getAccountNumber();
            userInfo.setText(info);
        } else {
            userInfo.setText("Nenhum usuário logado.");
        }
    }

    @FXML
    public void doWithdraw(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchScene("withdraw-view.fxml", "Sacar Dinheiro", actionEvent);
    }

    @FXML
    public void doDeposit(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchScene("deposit-view.fxml", "Depositar Dinheiro", actionEvent);
    }

    @FXML
    public void generateReport(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchScene("report-view.fxml", "Gerar Relatório", actionEvent);
    }

    @FXML
    public void exit(ActionEvent actionEvent) throws IOException {
        AuthHelper.logout();
        SceneSwitcher.switchScene("login-view.fxml", "Login", actionEvent);
    }
}
