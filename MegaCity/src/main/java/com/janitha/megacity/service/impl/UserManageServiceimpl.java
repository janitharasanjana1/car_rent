package com.janitha.megacity.service.impl;



import com.janitha.megacity.dao.UserManageDAO;
import com.janitha.megacity.entity.User;
import com.janitha.megacity.service.UserManageService;

import java.util.List;

public class UserManageServiceimpl implements UserManageService {

    private UserManageDAO userManagDAO = new UserManageDAO();

    @Override
    public List<User> getAllUsers() {
        return userManagDAO.getAllUsers();
    }

    @Override
    public List<User> getUsersByEmail(String email) {
        return userManagDAO.getUsersByEmail(email);
    }

    @Override
    public List<User> getUsersByRole(String role) {
        return userManagDAO.getUsersByRole(role);
    }

    @Override
    public boolean updateUser(int userId, User updatedUser) {
        return userManagDAO.updateUser(userId, updatedUser);
    }

    @Override
    public boolean deleteUser(int userId) {
        return userManagDAO.deleteUser(userId);
    }
}
