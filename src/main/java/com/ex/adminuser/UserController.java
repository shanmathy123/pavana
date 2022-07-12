package com.ex.adminuser;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class UserController {

	@Autowired
	UserService user;
	
	@GetMapping("/getall/{id}")
	public List<UserEntity> getallUsers(@PathVariable("id") int id){
		return user.getallUsers(id);
	}
	
//	@GetMapping("/getuser/{userId}")
//	public Optional <UserEntity> getUserbyId (@PathVariable(value ="id") int id){
//		return user.getUserById(id);
//	}
	
	 @PostMapping("/adduser/{userid}")
	 public UserEntity addUsers(@PathVariable(value ="userid") int id, @RequestBody UserEntity use){
	       return user.addUser(id,use);
	    }
	 
	  @PutMapping("/updateuser/{userid}")
	   public String UpdateUser(@PathVariable("userid") int id, @RequestBody UserEntity use){
	        return user.updateUser(id, use);
	    }
	  
	    @DeleteMapping("/deleteuser/{userid}")
	    public String DeleteUser(@PathVariable("userid") int id){
	        return user.deleteUser(id);
	    }

}
