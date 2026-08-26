/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cesarlopez.system.controller;

import com.cesarlopez.system.utils.AlertInformation;
import com.cesarlopez.system.utils.Validations;
import com.cesarlopez.system.utils.ViewFactory;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author informatica
 */
public class RegisterController implements Initializable {

    @FXML
    private TextField txtUser;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtLastName;
    @FXML
    private TextField txtEmail;
    @FXML
    private PasswordField pwdPassword;
    @FXML
    private PasswordField pwdconfirmPassword;

    @FXML
    private Button btnCancel;
    @FXML
    private Button btnCreateUser;

    private AlertInformation alertInfo = new AlertInformation();
    private Validations validate = new Validations();
    private UserService
    @FXML
    public void onCancelRegister(MouseEvent event) {
        ViewFactory viewFacto = new ViewFactory();
        viewFacto.viewLogin();

    }

    @FXML
    public void onRegisterUser(MouseEvent event) {
        String email = txtEmail.getText().trim();
        boolean validEmail = validate.validateEmail(email);
        if (validEmail == false) {
            alertInfo.viewAlert("ERROR", "ERROR DE EMAIL",
                    "ERROR CAMPO EMAIL",
                    "INGRESASTE UN EMAIL INCORRECTO");
            return;
        }
        String user, name, lastName, password, confirmPassword;
        user = txtUser.getText().trim();
        name = txtName.getText().trim();
        lastName = txtLastName.getText();
        password = pwdPassword.getText().trim();
        confirmPassword = pwdconfirmPassword.getText().trim();
        if (validate.validateTextEmpty(user) == true
                || validate.validateTextEmpty(name) == true
                || validate.validateTextEmpty(lastName) == true
                || validate.validateTextEmpty(email) == true
                || validate.validateTextEmpty(password) == true
                || validate.validateTextEmpty(confirmPassword) == true) {
            alertInfo.viewAlert("ERROR", "ERROR DE CAMPO",
                    "ERROR CAMPOS VACIOS",
                    "NO LLENASTE TODOS LOS CAMPOS");
            return;
        }
        String msgField = "";
        if (validate.validateTextLength(user, 25) == false) {
            msgField = "El campo USUARIO es mayor a 25 letras";
        }
        if (validate.validateTextLength(name, 50) == false) {
            msgField = "El campo NOMBRES es mayor a 50 letras";
        }
        if (validate.validateTextLength(lastName, 50) == false) {
            msgField = "El campo APELLIDOS es mayor a 50 letras";
        }
        if (validate.validateTextLength(email, 50) == false) {
            msgField = "El campo CORREO es mayor a 50 letras";
        }
        if (validate.validateTextLength(password, 35) == false) {
            msgField = "El campo CONTRASEÑA es mayor a 35 letras";
        }
        if (validate.validateTextLength(confirmPassword, 35) == false) {
            msgField = "El campo CONFIRMAR CONTRASEÑA es mayor a 35 letras";
        }
        if (msgField.isEmpty() == false) {
            alertInfo.viewAlert("ERROR", "ERROR DE CAMPO",
                    "ERROR LONGITUD DE CAMPO",
                    msgField);
            return;
        }
        if (validate.equalsText(password, confirmPassword) == false) {
            alertInfo.viewAlert("ERROR", "ERROR DE CONTRASEÑA",
                    "ERROR AL CONFIRMAR CONTRASEÑA",
                    "LAS CONTRASEÑAS NO COINCIDEN");
            return;
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

      UserStatus status = userService.createUser();
      
      switch (status){
          case USER_CREATED:
              System.out.println("se creo el usuario");
          case ERROR_USER_CREATE ->
               System.out.println("se creo el usuario");
              default ->
      
      }
}
