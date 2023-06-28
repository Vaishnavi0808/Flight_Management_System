package com.vaishnavi.fms.proxy;

import javax.servlet.http.HttpServletRequest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.vaishnavi.fms.bean.UserCredentials;

@FeignClient(name="Profile", url="localhost:8200")
public interface ProfileProxy {
		
		@PostMapping("/Profile/Login")
	    public ResponseEntity<String> login(@RequestBody UserCredentials credentials);
		
		@PostMapping("/Profile/Logout")
	    public ResponseEntity<String> logout(HttpServletRequest request);

	

}
