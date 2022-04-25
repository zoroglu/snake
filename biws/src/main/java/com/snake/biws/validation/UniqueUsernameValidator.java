package com.snake.biws.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.snake.biws.user.UserRepository;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String>{
	@Autowired
	UserRepository userRepository;
	
	@Override
	public boolean isValid(String username, ConstraintValidatorContext context) {
		if (userRepository.findByUsername(username) != null)
			return false;
		return true;
	}

}
