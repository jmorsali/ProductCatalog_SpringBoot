package com.ProductCatalog.API.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ApplicationUser {
    @jakarta.persistence.Id
    Long Id;
    String UserName;
    String Password;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
