package com.ProductCatalog.API.services;

import com.ProductCatalog.API.entities.ApplicationUser;
import com.ProductCatalog.API.security.JwtTokenUtil;

public interface IUserService {
    ApplicationUser GetUserByUserName(String username);

    ApplicationUser IsValidUser(String username, String password);
}
