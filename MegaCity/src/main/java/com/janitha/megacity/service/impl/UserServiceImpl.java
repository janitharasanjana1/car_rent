package com.janitha.megacity.service.impl;


import com.janitha.megacity.dao.UserDAO;
import com.janitha.megacity.dto.ProfileImageDTO;
import com.janitha.megacity.entity.ProfileImage;
import com.janitha.megacity.entity.User;
import com.janitha.megacity.service.UserService;

public class UserServiceImpl implements UserService {
    private final UserDAO userDAO = new UserDAO();

    @Override
    public boolean registerUser(User user) {
        System.out.println(user+"service impl");
        return userDAO.save(user);
    }

    @Override
    public User authenticateUser(String email, String password) {
        User user = userDAO.findByEmail(email); // Get user by email
        System.out.println("authenticateUser"+email+password);
        if (user == null) {
            return null; // If no user is found, return null
        }

        // Check if password matches using BCrypt
        if (userDAO.checkPassword(user, password)) {
            System.out.println("authenticateUser BCrypt "+email+password);
            return user; // Return user if password is correct
        }
        return null; // Return null if password is incorrect
    }




    public User getUserByUsername(String email) {
        return userDAO.findByEmail(email);
    }


    public User getUserByEmail(String email) {
        return userDAO.findByEmail(email);
    }
//    @Override
//    public UserDTO getUserByUsername(String username) {
//        User user = userDAO.findByUsername(username);
//        return (user != null) ? new UserDTO(user.getUsername(), user.getEmail(), user.getPhone()) : null;
//    }




    public boolean uploadProfileImage(String email, String imagePath) {
        return userDAO.insertProfileImage(email, imagePath);  // Save profile image to DB
    }


    public ProfileImageDTO getProfileImage(String email) {
        ProfileImage profileImage = userDAO.getProfileImage(email);  // Retrieve profile image from DB
        if (profileImage != null) {
            ProfileImageDTO profileImageDTO = new ProfileImageDTO();
            profileImageDTO.setImageId(profileImage.getImageId());
            profileImageDTO.setUserEmail(profileImage.getUserEmail());
            profileImageDTO.setImagePath(profileImage.getImagePath());
            profileImageDTO.setUploadDate(profileImage.getUploadDate());
            return profileImageDTO;
        }
        return null;  // Return null if no profile image is found for the user
    }
}
