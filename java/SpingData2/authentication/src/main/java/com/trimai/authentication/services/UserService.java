package com.trimai.authentication.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trimai.authentication.models.User;
import com.trimai.authentication.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository uR;
	
	public User registerUser(User user) {
		String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hashed);
		return uR.save(user);
	}
	
	public User findByEmail(String email) {
		return uR.findByEmail(email);
	}
	
	public User findUserById(Long id) {
		Optional<User> user = uR.findById(id);
		if (user.isPresent()) {
			return user.get();
		}
		return null;
	}
	
	public String authenticateUser(String email, String password) {
		User user = uR.findByEmail(email);
		if (user == null) {
			return "null";
		}
		
		if (BCrypt.checkpw(password, user.getPassword())) {
			return "" + user.getId();
		}
		
		return "false";
	}
}
