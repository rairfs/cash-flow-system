package com.ufs.cash_flow_system_gui.controllers;

import com.ufs.cash_flow_system_gui.auth.AuthHelper;
import com.ufs.cash_flow_system_gui.models.Client;
import com.ufs.cash_flow_system_gui.models.Report;
import com.ufs.cash_flow_system_gui.services.AccountService;
import com.ufs.cash_flow_system_gui.ui.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ReportController {

    @FXML
    public ListView<String> transactions;

    @FXML
    public Label userInfo;

    private final Client client = AuthHelper.getLoggedInClient();

    @FXML
    public void initialize() {
        if (client != null) {
            String info = "Usuário: " + client.getName() + " | Conta: " + client.getAccount().getAccountNumber();
            userInfo.setText(info);
        } else {
            userInfo.setText("Nenhum usuário logado.");
        }

        AccountService accountService = new AccountService();

        DateTimeFormatter customFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        assert client != null;
        List<Report> transactionHistory = accountService.getTransactionHistory(client.getAccount());
        for (Report transaction : transactionHistory) {
            String type;
            if (transaction.getTransactionAmount() > 0) {
                type = "Depósito";
            } else {
                type = "Saque";
            }
            String item = transaction.getTransactionDate().format(customFormatter) + " - " + type + " - $" + transaction.getTransactionAmount();
            transactions.getItems().add(item);
        }
    }

    public void exit(ActionEvent event) throws IOException {
        SceneSwitcher.switchScene("client-view.fxml", "Bem Vindo - " + client.getName(), event);
    }
}
