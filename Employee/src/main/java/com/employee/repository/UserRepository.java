package com.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.employee.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

	@Query("Select a from User a where userUsername = ?1 and userPassword = ?2")
	User findByUserUsernameAndUserPassword(String userUsername, String userPassword);
	
	@Query("Select a from User a where (userUsername = ?1 or mobileNo = ?2) and userPassword = ?3 ")
	User findByUserUsernameOrMobileNoAndUserPassword(String userUsername, long mobileNo, String userPassword);
	
	@Query("Select a from User a where  a.userId BETWEEN ?1 and ?2")
	List<User> pagination(int startIndex, int endIndex);
}
