package com.employee.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.model.User;
import com.employee.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@PostMapping("/registerUser")
	public String registerUser(@RequestBody User user) {
		if(user.getUserPassword() == null || user.getUserUsername() == null) {
			return "user name or user password is null";
		} else {
			userRepository.save(user);
			return "user "+ user.getUserUsername() +" saved";
		}
	}
	
	@PostMapping("/loginUserUsingIdAndPass")
	public String loginUserUsingIdAndPass(@RequestBody User usr) {
		System.out.println(usr);
		if(usr != null) {
			User user = userRepository.findByUserUsernameAndUserPassword(usr.getUserUsername(), usr.getUserPassword());
			if(user != null) {
				System.out.println(user.getUserUsername());
				return "login";				
			} else {
				return "error";
			}
		}
		return "error";
	}
	
	@PostMapping("/loginUserUsingIdOrMobileAndPass")
	public String loginUserUsingIdPassAndMobile(@RequestBody User usr) {
		System.out.println(usr);
		if(usr != null) {
			User user = userRepository.findByUserUsernameOrMobileNoAndUserPassword(usr.getUserUsername(), usr.getMobileNo(), usr.getUserPassword());
			if(user != null) {
				System.out.println(user.getUserUsername());
				return "login";				
			} else {
				return "error";
			}
		}
		return "error";
	}
	/*
	 * @RequestMapping(path = "/mno/objectKey/{id}/{name}", method = RequestMethod.GET)
public Book getBook(@PathVariable int id, @PathVariable String name) {
    // code here
}
	 */
	
	@GetMapping("/pn={PN}&ps={PS}")
	public List<User> showPaginatedData(@PathVariable int PN, @PathVariable int PS){
		List<User> usr = new ArrayList<User>();
		int startIndex = (PN * PS - (PS - 1));
		int endIndex = (PN * PS);
			usr = userRepository.pagination(startIndex, endIndex);
		return usr;
	}
}
