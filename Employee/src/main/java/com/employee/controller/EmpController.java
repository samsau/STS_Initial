package com.employee.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.model.Emp;
import com.employee.repository.EmpRepository;

@RestController
@RequestMapping("/api")
public class EmpController {

	@Autowired
	EmpRepository empRepository;
	
	@PostMapping("/employee")
	public String createNewEmployee(@RequestBody Emp emp) {
		empRepository.save(emp);
		return "successful created employee";
	}
	
	@GetMapping("/employee")
	public ResponseEntity<List<Emp>> getAllEmployee(){
		List<Emp> list = new ArrayList();
		empRepository.findAll().forEach(list::add);
		return new ResponseEntity<List<Emp>>(list, HttpStatus.OK);
	}
//	@GetMapping("/employee")
//	public List<Emp> getAllEmployee(){
//		List<Emp> list = new ArrayList();
//		empRepository.findAll().forEach(list::add);
//		return list;
//	}
}
