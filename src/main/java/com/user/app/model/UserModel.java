package com.user.app.model;

import java.time.LocalDate;
import java.util.List;

public class UserModel {

	private Long id;
	private String name;
	private String address;
	private String dept;
	private String mobileNumber;
	private String email;
	private LocalDate dateOfBirth;
	private Double salary;

	private List<HotelModel> hotelModelList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public List<HotelModel> getHotelModelList() {
		return hotelModelList;
	}

	public void setHotelModelList(List<HotelModel> hotelModelList) {
		this.hotelModelList = hotelModelList;
	}
}
