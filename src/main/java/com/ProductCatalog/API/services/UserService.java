package com.ProductCatalog.API.services;

import com.ProductCatalog.API.entities.ApplicationUser;
import com.ProductCatalog.API.repositories.UserRepository;
import com.ProductCatalog.API.security.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ApplicationUser GetUserByUserName(String username) {
        return userRepository.findByUserName(username);
    }

    @Override
    public ApplicationUser IsValidUser(String username, String password) {
        return userRepository.isValidUser(username, password);
    }

}
