package com.user.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.user.app.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	@Query("SELECT u FROM User u WHERE u.id=:userId AND u.mobileNumber=:mobileNumber")
	public User findUserByIdAndMobileNumber(@Param("userId") Integer userId, 
											@Param("mobileNumber") String mobileNumber);
	
	@Query("SELECT u FROM User u WHERE u.id=:userId OR u.mobileNumber=:mobileNumber")
	public User findUserByIdORMobileNumber(@Param("userId") Integer userId, 
											@Param("mobileNumber") String mobileNumber);
}
