/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cesarlopez.system.repository;

import com.cesarlopez.system.model.User;
import java.sql.CallableStatement;
import com.cesarlopez.system.config.ConexionDB;
/**
 *
 * @author informatica
 */
public class UserRepository implements UserInterface {
    
    private com.mysql.cj.jdbc.CallableStatement callSP;
    private ConexionDB conexionDB = ConexionDB.getInstanciaConexionDB();
    @Override 
    public void create (User user){
        try {
            callSP = conexionDB.getConnection().prepareCall("{call sp_create_user(?,?,?,?,?)");
            callSP.setString
        } catch (Exception e) {
        }
    }
}
