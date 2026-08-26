/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cesarlopez.system.controller;

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
public class RegisterController implements Initializable{
    
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
    
    private Validations validate = new Validations();
    
    @FXML
    public void onCancelRegister (MouseEvent event){
        ViewFactory viewFacto = new ViewFactory ();
        viewFacto.viewLogin();
    
    }
    
    @FXML
    public void onRegisterUser (MouseEvent event){
        String email = txtEmail.getText().trim();
        boolean validEmail = validate.validateEmail(email);
        
        if(validEmail == true)
            System.out.println("Si esta valido");
        else
            System.out.println("No esta valido");
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    
    
    
}
