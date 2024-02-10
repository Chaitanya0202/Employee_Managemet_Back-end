package com.qsp.srping_employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.srping_employee.dao.EmployeeDao;
import com.qsp.srping_employee.dto.Employee;
import com.qsp.srping_employee.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeDao dao;
	
	@Autowired
	private EmployeeService employeeService;
	
	//insert data
	@PostMapping("/save")
	public Employee saveEmployee(@RequestBody Employee employee) {

		return employeeService.saveEmployee(employee);
	}
	//fetch data
	@GetMapping("/find")
	public Employee getEmployee(@RequestParam int id) {

		return dao.getEmployee(id);
	}

	@GetMapping("/findAll")
	public List<Employee> getAllEmployee() {
		return dao.getAllEmployee();
	}

	@DeleteMapping("/delete/{id}")
	public Employee deleteEmployee(@PathVariable int id) {
		return dao.deleteEmployee(id);
	}
	/*
	PUT--> is used to update all the data 
	PATCH--> is used for upadate single data
	@RequestParam--> if u used @RequestParam then you have to give 
	data in key value pair in URL 
	@RequestBody--> if we want to pass multiple data/body we use @RequestBody
	  @PathVariable ---> if we used that we have to give data in URL only
	  [direct value without key]
	
	*/
	
	
	@PutMapping("/update")
	public Employee updateEmployee(@RequestParam  int id,@RequestBody Employee employee) {
		return dao.updateEmployee(id,employee);
	}
	@PatchMapping("/updatePhone")
	public Employee updatePhone(@RequestParam int id,@RequestParam long phone) {
		return dao.updatePhone(id,phone);
	}
	@PatchMapping("/updateEmail/{id}/{emial}")
	public Employee updateEmail(@PathVariable int id,@PathVariable String email) {
		return dao.updateEmail(id,email);
	}
	@GetMapping("/findByPhone")
	public Employee findEmployeeByPhno(@RequestParam long phone) {
		return dao.findEmployeeByPhno(phone);
		
	}
	@GetMapping("/findByEMail/{email}")
	public Employee findEmployeeByEMail(@PathVariable String email) {
		return dao.findEmployeeByEMail(email);
	}
	
	@GetMapping("/findByName")
	public List<Employee> findEmployeeByName(@RequestParam String name){
		return dao.findEmployeeByName(name);
	}
	@GetMapping("/findlessSalary")
	public List<Employee> findsalLessThan(@RequestParam double salary){
		return dao.findsalLessThan(salary);
	}
	
	@GetMapping("/findGreaterSalary")
	public List<Employee> findsalGreaterThan(@RequestParam double salary){
		return dao.findsalGreterThan(salary);
	}
	
	
	@GetMapping("/findlessEqualSalary")
	public List<Employee> findsalLessThanEqual(@RequestParam double salary){
		return dao.findsalLessThanEqual(salary);
	}
	
	@GetMapping("/findSalaryBetween/{salary1}/{salary2}")
	public List<Employee> findsalBetween(@PathVariable double salary1, @PathVariable double salary2){
		return dao.findsalBetween(salary1,salary2);
	}
	
	
	
	
	
	
}
