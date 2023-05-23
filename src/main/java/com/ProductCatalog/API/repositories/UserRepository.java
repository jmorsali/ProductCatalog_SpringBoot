package com.ProductCatalog.API.repositories;

import com.ProductCatalog.API.entities.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<ApplicationUser,Long> {
    @Query("SELECT u FROM ApplicationUser u WHERE u.UserName= :username and u.Password= :password ")
    ApplicationUser isValidUser(@Param("username") String username, @Param("password") String password);

    @Query("SELECT u FROM ApplicationUser u WHERE u.UserName= :username ")
    ApplicationUser findByUserName(String username);
}
