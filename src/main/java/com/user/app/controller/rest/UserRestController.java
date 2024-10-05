package com.user.app.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.user.app.converter.ApiConverter;
import com.user.app.entity.User;
import com.user.app.model.UserModel;
import com.user.app.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping(value = "/user")
public class UserRestController {

	@Autowired
	private UserService userService;

	@Operation(summary = "Save User") 
	@ApiResponses(value = { 
	        @ApiResponse(responseCode = "201", description = "User created successfully"), 
	@ApiResponse(responseCode = "401",description = "Unauthorized User"), 
	        @ApiResponse(responseCode = "404",description = "Resource not found"), 
	        @ApiResponse(responseCode = "400",description = "Invalid user object")}) 
	@PostMapping(value = "/save-user")
	public ResponseEntity<?> createUser(@RequestBody UserModel userModel) {
		User user = ApiConverter.getUserJpaObject(userModel);
		userService.createUser(user);
		String message = "User Created Successfully....";
		return ResponseEntity.ok(message);
	}

	@PutMapping(value = "/update-user")
	public ResponseEntity<?> updateUser(@RequestBody UserModel userModel) {
		User userJpa = ApiConverter.getUserJpaObject(userModel);
		User user = userService.updateUser(userJpa);
		return ResponseEntity.ok(user);
	}

	@GetMapping(value = "find-user-by-id/{userId}")
	public ResponseEntity<?> findUserById(@PathVariable(name = "userId") Integer userId) {
		UserModel userModel = userService.findUserById(userId);

		return ResponseEntity.ok(userModel);
	}

	@GetMapping(value = "/find-all-user")
	public ResponseEntity<?> findAllUser() {
		List<User> userList = userService.findAllUser();
		List<UserModel> userModelList = ApiConverter.getUserModelListObject(userList);
		return ResponseEntity.ok(userModelList);
	}

	@GetMapping(value = "/delete-user-by-id")
	public ResponseEntity<?> deleteUserById(@RequestParam(value = "userId") Integer userId) {
		boolean isDeleted = userService.deleteUserById(userId);
		String message = "";
		if (isDeleted) {
			message = "User Deleted successfully";
		} else {
			message = "User not deleted successfully";
		}
		return ResponseEntity.ok(message);
	}

	@GetMapping(value = "/find-user-by-id-mobile")
	public ResponseEntity<?> findUserByIdAndMobileNumber(@RequestParam(value = "userId") Integer userId,
			@RequestParam(value = "mobileNumber") String mobileNumber) {
		User user = userService.findUserByIdAndMobileNumber(userId, mobileNumber);
		UserModel userModel = ApiConverter.getUserModelObject(user);
		return ResponseEntity.ok(userModel);
	}
	
	@GetMapping(value = "/find-user-by-id-or-mobile")
	public ResponseEntity<?> findUserByIdORMobileNumber(@RequestParam(value = "userId") Integer userId,
			@RequestParam(value = "mobileNumber", required = false) String mobileNumber) {
		User user = userService.findUserByIdORMobileNumber(userId, mobileNumber);
		UserModel userModel = ApiConverter.getUserModelObject(user);
		return ResponseEntity.ok(userModel);
	}
}
