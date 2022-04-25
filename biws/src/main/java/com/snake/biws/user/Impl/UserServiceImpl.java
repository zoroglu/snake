package com.snake.biws.user.Impl;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.snake.biws.user.User;
import com.snake.biws.user.UserRepository;
import com.snake.biws.user.DAO.UserServiceDAO;
import com.snake.biws.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	UserRepository userRepository;

	PasswordEncoder passwordEncoder;
	
	UserServiceDAO userServiceDAO;

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
		this.passwordEncoder = new BCryptPasswordEncoder();
	}

	@Override
	public void save(User user) {
		user.setPassword(this.passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
	}
}
