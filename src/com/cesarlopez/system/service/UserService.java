/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cesarlopez.system.service;

import com.cesarlopez.system.model.User;
import com.cesarlopez.system.repository.UserRepository;

/**
 *
 * @author informatica
 */
public class UserService {
    private UserRepository userRepo = new UserRepository();
    
    public UserStatus createUser(String User,
                                 String name,String lastName,
                                 String email,String password){
        try {
            User newUser = new User(name, lastName, email, User, password);
            userRepo.create(newUser);
            return UserStatus.USER_CREATED;
        } catch (Exception e) {
           return UserStatus.ERROR_USER_CREATE;
        }
    
    }
    
    public User findUser(String login){
        return userRepo.findByUserOrEmail(login);
    }
    
    public boolean existsUser(String login){
        return userRepo.findByUserOrEmail(login) != null;
    }
}