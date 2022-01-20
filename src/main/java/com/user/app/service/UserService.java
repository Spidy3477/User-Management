package com.user.app.service;


import com.user.app.models.User;

public interface UserService {
	User saveStudent(User user);
	User getUserByUserName(String userName);
	User updateUserById(User user,String userName);
	void deleteUserById(String userName);
}
