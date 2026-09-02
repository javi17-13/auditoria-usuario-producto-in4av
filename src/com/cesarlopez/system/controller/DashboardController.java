package com.cesarlopez.system.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 *
 * @author informatica
 */
public class DashboardController implements Initializable {

    @FXML
    private Label lblBienvenida;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lblBienvenida.setText("BIENVENIDO AL DASHBOARD");
    }
}
