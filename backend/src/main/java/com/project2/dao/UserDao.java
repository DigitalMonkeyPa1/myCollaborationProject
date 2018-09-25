package com.project2.dao;

import com.project2.model.User;

public interface UserDao
{

	void registration(User user);
	boolean isEmailValid(String email);
	User login(User user);
	void update(User user);
	User getUser(String email);
}
