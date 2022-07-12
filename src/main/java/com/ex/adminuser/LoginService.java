package com.ex.adminuser;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Transactional
@Component
public class LoginService {

	@Autowired
    UserRepository repo;
    
    @Autowired
    EmailService service;
    

public String UserLogin(LoginEntity logine) {
	List<UserEntity> list = repo.findAll();
    for (UserEntity u:list) {
        if (u.getEmail().equals(logine.getEmail())){
            if(u.getPassword().equals(logine.getPassword())){
            	if (u.getIsAdmin()){
                service.sendSimpleEmail(u.getEmail());
                return "Check otp";
            }
              return "User Logged in";
            }else {
                return "Incorrect Password";
            }
        }
    }
    return "Invalid Email";
}
}
