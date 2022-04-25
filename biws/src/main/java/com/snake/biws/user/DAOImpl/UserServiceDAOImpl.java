package com.snake.biws.user.DAOImpl;

import com.snake.biws.user.DAO.UserServiceDAO;

public class UserServiceDAOImpl implements UserServiceDAO{

	@Override
	public boolean isExistsSameUsername(String username) {
		return false;
	}

}
