package com.user.app.service;

import java.util.List;

import com.user.app.entity.User;
import com.user.app.model.UserModel;


public interface UserService {

	public User createUser(User user);
	public User updateUser(User user);
	public UserModel findUserById(Integer userId);
	public List<User> findAllUser();
	public boolean deleteUserById(Integer userId);
	public User findUserByIdAndMobileNumber(Integer userId, String mobileNumber);
	public User findUserByIdORMobileNumber(Integer userId, String mobileNumber);
}
