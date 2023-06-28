package com.vaishnavi.fms.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vaishnavi.fms.bean.UserCredentials;
import com.vaishnavi.fms.proxy.ProfileProxy;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/fms")
public class ProfileController {
	
	@Autowired
	private ProfileProxy profile;
	
	@PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserCredentials credentials) {
		return profile.login(credentials);
	}
	
	@PostMapping("/logout")
    public ResponseEntity<String> logout(HttpServletRequest request) {
		return profile.logout(request);
	}

}
