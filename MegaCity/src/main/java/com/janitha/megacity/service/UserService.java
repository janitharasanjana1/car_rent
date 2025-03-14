package com.janitha.megacity.service;

import com.janitha.megacity.entity.User;

public interface UserService {
    boolean registerUser(User user);

    User authenticateUser(String username, String password);
//    UserDTO getUserByUsername(String username);
}
