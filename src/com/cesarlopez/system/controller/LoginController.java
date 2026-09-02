package com.cesarlopez.system.controller;

import com.cesarlopez.system.service.AuthenticationService;
import com.cesarlopez.system.service.AuthenticationStatus;
import com.cesarlopez.system.utils.AlertInformation;
import com.cesarlopez.system.utils.ViewFactory;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
/**
 *
 * @author informatica
 */
public class LoginController implements Initializable{

    @FXML
    private TextField txtUserOrEmail;
    @FXML
    private PasswordField pwdPassword;

    private AlertInformation alertInfo = new AlertInformation();
    private AuthenticationService authService = new AuthenticationService();

    @Override 
    public void initialize(URL url, ResourceBundle rb){
    
    }
    
    @FXML
    public void onRegister(MouseEvent event){
        ViewFactory viewFacto = new ViewFactory();
        viewFacto.viewRegister();
    }

    @FXML
    public void onLogin(MouseEvent event) {
        String userOrEmail = txtUserOrEmail.getText().trim();
        String password = pwdPassword.getText().trim();

        if (userOrEmail.isEmpty() || password.isEmpty()) {
            alertInfo.viewAlert("ERROR", "ERROR DE CAMPO",
                    "ERROR CAMPOS VACIOS",
                    "INGRESA USUARIO/CORREO Y CONTRASEÑA");
            return;
        }

        AuthenticationStatus status = authService.login(userOrEmail, password);

        switch (status) {
            case LOGIN_SUCCESS -> {
                ViewFactory viewFacto = new ViewFactory();
                viewFacto.viewDashboard();
            }
            case NOT_EXIST_USER ->
                alertInfo.viewAlert("ERROR", "USUARIO NO EXISTE",
                        "CUENTA NO ENCONTRADA",
                        "NO EXISTE UNA CUENTA CON ESE USUARIO O CORREO, REGISTRATE");
            case WRONG_PASSWORD ->
                alertInfo.viewAlert("ERROR", "CONTRASEÑA INCORRECTA",
                        "ERROR DE CONTRASEÑA",
                        "LA CONTRASEÑA INGRESADA ES INCORRECTA");
        }
    }
}