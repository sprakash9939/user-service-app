package com.user.app.converter;

import java.util.ArrayList;
import java.util.List;

import com.user.app.entity.User;
import com.user.app.model.UserModel;

public class ApiConverter {

	public static User getUserJpaObject(UserModel userModel) {

		User user = null;
		if (userModel != null) {
			user = new User();
			user.setId(userModel.getId());
			user.setName(userModel.getName());
			user.setAddress(userModel.getAddress());
			user.setDept(userModel.getDept());
			user.setMobileNumber(userModel.getMobileNumber());
			user.setEmail(userModel.getEmail());
			user.setDateOfBirth(userModel.getDateOfBirth());
			user.setSalary(userModel.getSalary());
		}
		return user;
	}

	public static UserModel getUserModelObject(User user) {

		UserModel userModel = null;
		if (user != null) {
			userModel = new UserModel();
			userModel.setId(user.getId());
			userModel.setName(user.getName());
			userModel.setAddress(user.getAddress());
			userModel.setDept(user.getDept());
			userModel.setMobileNumber(user.getMobileNumber());
			userModel.setEmail(user.getEmail());
			userModel.setDateOfBirth(user.getDateOfBirth());
			userModel.setSalary(user.getSalary());
		}
		return userModel;
	}

	public static List<UserModel> getUserModelListObject(List<User> userList) {
		List<UserModel> userModelList = null;
		if(userList != null && !userList.isEmpty()) {
			userModelList = new ArrayList<>();
			for(User user: userList) {
				//UserModel userModel = getUserModelObject(user);
				userModelList.add(getUserModelObject(user));
			}
		}
		return userModelList;
	}
}
