package com.qsp.srping_employee.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.srping_employee.dto.Employee;
import com.qsp.srping_employee.repo.EmployeeRepo;

@Repository
public class EmployeeDao {
	@Autowired
	private EmployeeRepo repo;

	public Employee saveEmployee(Employee employee) {
		return repo.save(employee);
	}

	public Employee getEmployee(int id) {
		
//		return repo.findById(id).get();
		// for no such elements
		Optional<Employee>optional=repo.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	public List<Employee> getAllEmployee() {
		
		return repo.findAll();
	}

	public Employee deleteEmployee(int id) {
		Optional<Employee>optional=repo.findById(id);
		if(optional.isEmpty()) {
			return null;
		}
		
		repo.deleteById(id);
		return  optional.get();
	}
	
	public Employee updateEmployee(int id, Employee employee) {
		Optional<Employee>optional=repo.findById(id);
		if(optional.isPresent()) {
			employee.setId(id);
			return repo.save(employee);
		}
		return null;
	}

	public Employee updatePhone(int id, long phone) {
		Optional<Employee>optional=repo.findById(id);
		if(optional.isPresent()) {
			Employee employee=optional.get();
			employee.setPhone(phone);
			return repo.save(employee);
		}
		return null;
	}

	public Employee updateEmail(int id, String email) {
		// TODO Auto-generated method stub
		
		Optional<Employee>optional=repo.findById(id);
		if(optional.isPresent()) {
			Employee employee=optional.get();
			employee.setEmail(email);
			return repo.save(employee);
		}
		return null;
	}

	public Employee findEmployeeByPhno(long phone) {
		// TODO Auto-generated method stub
		
		return repo.findEMployeeByPhone(phone);
	}

	public Employee findEmployeeByEMail(String email) {
		
//		return repo.findEmployeeByEmail(email);
		return repo.employeeByEmail(email);
	}

	public List<Employee> findEmployeeByName(String name) {
		// TODO Auto-generated method stub
		return repo.findEmployeeByName(name);
	}

	public List<Employee> findsalLessThan(double salary) {
		
		return repo.findEmployeeBySalaryLessThan(salary);
	}

	public List<Employee> findsalLessThanEqual(double salary) {
		// TODO Auto-generated method stub
		return repo.findEmployeeBySalaryLessThanEqual(salary);
	}

	public List<Employee> findsalGreterThan(double salary) {
		// TODO Auto-generated method stub
		return repo.findEmployeeBySalaryGreaterThan(salary);
	}

	public List<Employee> findsalBetween(double salary1, double salary2) {
		// TODO Auto-generated method stub
		return repo.findEmployeeBySalaryBetween(salary1,salary2);
	}
}
