package com.ufs.cash_flow_system_gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CashFlowSystemApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CashFlowSystemApplication.class.getResource("cash-flow-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 860, 640);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
}
