package com.ex.adminuser;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
@Transactional
public class UserService {

	@Autowired
	UserRepository repo;
	
	@Autowired
	private MailSender mailsender;
	

	public List<UserEntity> getallUsers(int id) {
		if(repo.existsById(id)){
            UserEntity use = repo.findById(id).get();
            if(use.getIsAdmin()){
		return repo.findAll();
	    }
		}
		return null;
	}
	
//	public Optional<UserEntity> getUserById(int id) {
//		return repo.findById(id);
//	}

	public UserEntity addUser(int id,UserEntity use) {
		if(repo.existsById(id)) {
		return repo.save(use);
	}
    return null;
}

	public String updateUser(int id, UserEntity use) {
		if(checkid(id)) {
			use.setUserId(id);
			repo.save(use);
			return "Updated successfully";
		}
		return "Id not found";
	}

	private boolean checkid(int id) {
		List<UserEntity> user=repo.findAll();
		for(UserEntity u:user) {
			if(u.getUserId()==id) {			
				return true;
			}
		return false;
	}
		return false;
		
	}

	public String deleteUser(int id) {
		if(checkid(id)) {
			repo.deleteById(id);
			return "deleted successfully";
		}
		return "Id not found";
	}
	
	
}
