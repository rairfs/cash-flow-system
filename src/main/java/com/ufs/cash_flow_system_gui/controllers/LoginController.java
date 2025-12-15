// java
package com.ufs.cash_flow_system_gui.controllers;

import com.ufs.cash_flow_system_gui.ui.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class LoginController {


    @FXML
    public Button createAccount;
    @FXML
    public Button useAccount;

    @FXML
    public void createAccount(ActionEvent event) throws IOException {

        SceneSwitcher.switchScene("create-account-view.fxml", "Crie sua Conta - Cash Flow System", event);
    }

    @FXML
    public void useAccount(ActionEvent event) throws IOException {

        SceneSwitcher.switchScene("use-account-view.fxml", "Informe seu usuário - Cash Flow System", event);
    }
}
