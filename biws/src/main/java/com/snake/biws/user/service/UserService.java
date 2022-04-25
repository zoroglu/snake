package com.snake.biws.user.service;

import org.springframework.stereotype.Service;

import com.snake.biws.user.User;

@Service
public interface UserService {
	void save(User user);
}
