package com.trimai.events.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trimai.events.models.User;
import com.trimai.events.repositories.UserRepo;

@Service
public class UserService {
	@Autowired
	private UserRepo uR;
	
	public User createUser(User user) {
		String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hashed);
		return uR.save(user);
	}
	
	public User findUserById(Long id) {
		Optional<User> u = uR.findById(id);
		    	
		if(u.isPresent()) {
		    return u.get();
		} else {
		    return null;
		}
	}
	
	public User findUserByEmail(String email) {
		return uR.findByEmail(email);
	}
	
	public boolean authenticateUser(String email, String password) {
		User foundUser = uR.findByEmail(email);
		if (foundUser == null) {
			return false;
		}
		
		if (BCrypt.checkpw(password, foundUser.getPassword())) {
			return true;
		}
		return false;
		
	}
}
