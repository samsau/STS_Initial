package com.employee.model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "User")
public class User {
	
	@Id
	@Column(name = "user_Id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;

	@Column(name = "user_Username", nullable = false)
	private String userUsername;
	
	@Column(name = "user_Password", nullable = false)
	private String userPassword;
	
	@Column(name = "mobile_No")
	private long mobileNo;
	
	@Column(name = "user_Department")
	private String userDepartment;
	
	@Column(name = "user_Salary")
	private float userSalary;
	
	@Column(name = "user_Country")
	private String userCountry;
	
	@Column(name = "user_City")
	private String userCity;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(Long userId, String userUsername, String userPassword, long mobileNo, String userDepartment,
			float userSalary, String userCountry, String userCity) {
		super();
		this.userId = userId;
		this.userUsername = userUsername;
		this.userPassword = userPassword;
		this.mobileNo = mobileNo;
		this.userDepartment = userDepartment;
		this.userSalary = userSalary;
		this.userCountry = userCountry;
		this.userCity = userCity;
	}

	public User(String userUsername, String userPassword) {
		super();
		this.userUsername = userUsername;
		this.userPassword = userPassword;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserUsername() {
		return userUsername;
	}

	public void setUserUsername(String userUsername) {
		this.userUsername = userUsername;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getUserDepartment() {
		return userDepartment;
	}

	public void setUserDepartment(String userDepartment) {
		this.userDepartment = userDepartment;
	}

	public float getUserSalary() {
		return userSalary;
	}

	public void setUserSalary(float userSalary) {
		this.userSalary = userSalary;
	}

	public String getUserCountry() {
		return userCountry;
	}

	public void setUserCountry(String userCountry) {
		this.userCountry = userCountry;
	}

	public String getUserCity() {
		return userCity;
	}

	public void setUserCity(String userCity) {
		this.userCity = userCity;
	}
	
	
	
}
