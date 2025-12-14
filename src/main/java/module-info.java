module com.ufs.cash_flow_system_gui {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.ufs.cash_flow_system_gui to javafx.fxml;
    exports com.ufs.cash_flow_system_gui;
    exports com.ufs.cash_flow_system_gui.controllers;
    opens com.ufs.cash_flow_system_gui.controllers to javafx.fxml;
}