package com.vaishnavi.profile.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vaishnavi.profile.bean.UserCredentials;
import com.vaishnavi.profile.util.JwtTokenUtil;

@RestController
@RequestMapping("/Profile")
public class Controller {
	
	private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;

    public Controller(AuthenticationManager authenticationManager, JwtTokenUtil jwtTokenUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
    }
    
    @PostMapping("/Login")
    public ResponseEntity<String> login(@RequestBody UserCredentials credentials) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(credentials.getUsername(), credentials.getPassword());
        Authentication authentication = authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        // Generate and return the JWT token
        
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String jwtToken = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(jwtToken);
    }
    
    @PostMapping("/Logout")
    public ResponseEntity<String> logout(HttpServletRequest request) {
    	// Extract the JWT token from the request
        String token = jwtTokenUtil.extractJwtToken(request);

        // Validate and invalidate the JWT token
        if (jwtTokenUtil.validateToken(token)) {
            jwtTokenUtil.invalidateToken(token);
            return ResponseEntity.ok().body("{\"message\": \"Logout Successful!\"}");
        }
        
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Token!");
    }

}
