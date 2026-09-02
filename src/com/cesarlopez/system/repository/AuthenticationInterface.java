package com.cesarlopez.system.repository;

import com.cesarlopez.system.model.User;

public interface AuthenticationInterface {

    User login(String email, String password);

}
