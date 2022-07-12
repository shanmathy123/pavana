package com.ex.adminuser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class LoginController {

	@Autowired
	LoginService login;
	
	@Autowired
    EmailService service;
	
	 @PostMapping("/login")
	    public String UserLogin(@RequestBody LoginEntity logine){
	        return login.UserLogin(logine);
	    }
	 
	 @PostMapping("/sendotp")
	    public void sendEmail(@RequestParam("to") String toEmail){
	        service.sendSimpleEmail(toEmail);
	    }
	 
	 @PostMapping("/verifyotp")
	    public String verifyOtp(@RequestParam("otp") int otp){
	        if(service.verifyOtp(otp)){
	            return "Success";
	        }
	        return "Wrong Otp";
	    }
}
