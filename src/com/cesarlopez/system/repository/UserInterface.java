/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cesarlopez.system.repository;

import com.cesarlopez.system.config.ConexionDB;
import com.cesarlopez.system.model.User;
import com.mysql.cj.jdbc.CallableStatement;

/**
 *
 * @author informatica
 */
public interface UserInterface {
    
    
    
    void create (User user);
    
}
