package com.cesarlopez.system.service;

import com.cesarlopez.system.model.User;
import com.cesarlopez.system.repository.AuthenticationRepository;
import com.cesarlopez.system.service.AuthenticationStatus;
import com.cesarlopez.system.service.UserService;

public class AuthenticationService {

    private AuthenticationRepository authRepo = new AuthenticationRepository();
    private UserService userService = new UserService();

    public AuthenticationStatus login(String email, String password) {
        boolean exists = userService.existsUser(email);
        if (!exists) {
            return AuthenticationStatus.NOT_EXIST_USER;
        }

        User user = authRepo.login(email, password);
        if (user == null) {
            return AuthenticationStatus.WRONG_PASSWORD;
        }

        return AuthenticationStatus.LOGIN_SUCCESS;
    }
}
