package com.user.app.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.user.app.converter.ApiConverter;
import com.user.app.model.HotelModel;
import com.user.app.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.app.entity.User;
import com.user.app.repository.UserRepository;
import com.user.app.service.UserService;
import org.springframework.web.client.RestTemplate;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User updateUser(User user) {
		
		return userRepository.save(user);
	}

	@Override
	public UserModel findUserById(Integer userId) {

		 Optional<User> optional = userRepository.findById(userId);
		 if(optional.isPresent()) {
			 User user= optional.get();
			 UserModel userModel = ApiConverter.getUserModelObject(user);
			 List<HotelModel> hotelModelList= restTemplate.getForObject("http://localhost:1001/hotel/find-hotel-by-user-id/"+userId, ArrayList.class);
			 userModel.setHotelModelList(hotelModelList);
			 return userModel;
		 }
		 return null;
	}

	@Override
	public List<User> findAllUser() {
		return userRepository.findAll();
	}

	@Override
	public boolean deleteUserById(Integer userId) {
		userRepository.deleteById(userId);
		return true;
	}

	@Override
	public User findUserByIdAndMobileNumber(Integer userId, String mobileNumber) {
	return	userRepository.findUserByIdAndMobileNumber(userId, mobileNumber);
	}
	

	@Override
	public User findUserByIdORMobileNumber(Integer userId, String mobileNumber) {
	return	userRepository.findUserByIdORMobileNumber(userId, mobileNumber);
	}

}
