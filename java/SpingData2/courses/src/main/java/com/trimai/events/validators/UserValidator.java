package com.trimai.events.validators;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.trimai.events.models.User;
import com.trimai.events.services.UserService;

@Component
public class UserValidator implements Validator {
	@Autowired
	private UserService uS;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		User user = (User) target;
		if (!user.getPasswordConfirmation().equals(user.getPassword())) {
			errors.rejectValue("passwordConfirmation", "Match");
		}
		
		if (uS.findUserByEmail(user.getEmail()) != null) {
			errors.rejectValue("email", "Exist");
		}
		
	}
	
}
