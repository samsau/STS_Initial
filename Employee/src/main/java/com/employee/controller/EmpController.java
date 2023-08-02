package com.employee.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
		List<Emp> list = new ArrayList<Emp>();
		empRepository.findAll().forEach(list::add);
		return new ResponseEntity<List<Emp>>(list, HttpStatus.OK);
	}
//	@GetMapping("/employee")
//	public List<Emp> getAllEmployee(){
//		ArrayList<Emp> list = new ArrayList<Emp>();
//		empRepository.findAll().forEach(list::add);
//		return list;
//	}
	
	@GetMapping("/employee/{empid}")
	public ResponseEntity<Emp> getParticularEmployee(@PathVariable long empid) {
		Optional<Emp> emp = empRepository.findById(empid);
		if(emp.isPresent()) {
			return new ResponseEntity<Emp>(emp.get(), HttpStatus.FOUND);			
		} else {
			return new ResponseEntity<Emp>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/employee/{empid}")
	public String updateEmployeeById(@PathVariable long empid, @RequestBody Emp emp) {
		Optional<Emp> nEmp = empRepository.findById(empid);
		if(nEmp.isPresent()) {
			Emp existEmp = nEmp.get();
			existEmp.setEmp_age(emp.getEmp_age());
			existEmp.setEmp_salary(emp.getEmp_salary());
			existEmp.setEmp_city(emp.getEmp_city());
			existEmp.setEmp_name(emp.getEmp_name());
			empRepository.save(existEmp);
			return "employee updated";
		} else {
			return "employee not updated";			
		}
	}
	
	@DeleteMapping("/employee/{empid}")
	public String deleteEmployeeById(@PathVariable long empid) {
		Optional<Emp> emp = empRepository.findById(empid);
		if(emp.isPresent()) {
			empRepository.deleteById(empid);
			return "employee deleted";			
		} else {
			return "employee doesn't exists";
		}
	}
	
	@DeleteMapping("/employee")
	public ResponseEntity<Emp> deleteAllEmployees(){
		empRepository.deleteAll();
		return new ResponseEntity<Emp>(HttpStatus.OK);
	}
}
