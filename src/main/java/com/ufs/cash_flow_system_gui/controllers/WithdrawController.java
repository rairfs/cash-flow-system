package com.ufs.cash_flow_system_gui.controllers;

import com.ufs.cash_flow_system_gui.auth.AuthHelper;
import com.ufs.cash_flow_system_gui.models.Client;
import com.ufs.cash_flow_system_gui.services.AccountService;
import com.ufs.cash_flow_system_gui.ui.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class WithdrawController {

    @FXML
    public TextField withdrawAmountField;
    @FXML
    public Label userInfo;
    @FXML
    public Label balance;

    private final Client client = AuthHelper.getLoggedInClient();
    private final AccountService accountService = new AccountService();

    @FXML
    public void initialize() {
        if (client != null) {
            String info = "Usuário: " + client.getName() + " | Conta: " + client.getAccount().getAccountNumber();
            userInfo.setText(info);
            balance.setText("Saldo Atual: $" + client.getAccount().getBalance());
        } else {
            userInfo.setText("Nenhum usuário logado.");
            userInfo.setText("Saldo Atual: $0.00");
        }
    }

    @FXML
    public void doWithdraw(ActionEvent actionEvent) {
        String text = withdrawAmountField.getText();
        try {
            Double amount = Double.parseDouble(text);
            boolean withdraw = accountService.withdraw(client.getAccount(), amount);
            if (!withdraw) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erro");
                alert.setHeaderText("Saldo insuficiente");
                alert.setContentText("Você não possui saldo suficiente para realizar este saque.");
                alert.showAndWait();
                return;
            }
            balance.setText("Saldo Atual: $" + client.getAccount().getBalance());
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Valor inválido");
            alert.setContentText("Por favor, insira um valor numérico válido para saque.");
            alert.showAndWait();
        }
    }

    @FXML
    public void goBack(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchScene("client-view.fxml", "Bem Vindo - " + client.getName(), actionEvent);
    }
}
