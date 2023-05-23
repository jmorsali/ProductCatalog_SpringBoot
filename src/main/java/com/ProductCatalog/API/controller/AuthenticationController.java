package com.ProductCatalog.API.controller;

import com.ProductCatalog.API.dtos.requests.AuthenticationRequest;
import com.ProductCatalog.API.dtos.response.AuthenticationResponse;
import com.ProductCatalog.API.security.JwtTokenUtil;
import com.ProductCatalog.API.security.JwtUserDetailsService;
import com.ProductCatalog.API.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {
    private final JwtUserDetailsService userDetailsService;
    private final JwtTokenUtil jwtTokenUtil;
    private IUserService userService;

    @Autowired
    public AuthenticationController(JwtUserDetailsService userDetailsService, JwtTokenUtil jwtTokenUtil, IUserService userService) {
        this.userDetailsService = userDetailsService;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userService = userService;
    }

    public AuthenticationController(JwtUserDetailsService userDetailsService, JwtTokenUtil jwtTokenUtil) {
        this.userDetailsService = userDetailsService;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(@RequestBody AuthenticationRequest authenticationRequest) {
        try {
            // Authenticate user
            authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

            // Generate JWT token
            UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
            String token = jwtTokenUtil.generateToken(userDetails);

            // Return the token in the response
            return ResponseEntity.ok(new AuthenticationResponse(token));
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    private void authenticate(String username, String password) throws AuthenticationException {
        var user = userService.IsValidUser(username, password);
        if (user == null) {
            throw new BadCredentialsException("Invalid username or password");
        }
    }

}
