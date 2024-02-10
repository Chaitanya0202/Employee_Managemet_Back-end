package com.qsp.srping_employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qsp.srping_employee.dao.EmployeeDao;
import com.qsp.srping_employee.dto.Employee;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeDao dao;
	
	public Employee saveEmployee(Employee employee) {
		double sal=employee.getSalary();
		if(sal<=10000) {
			employee.setGrade('D');
		}
		else if(sal>10000 && sal<=20000) {
			employee.setGrade('C');
		}
		else if(sal>20000 && sal<=35000) {
			employee.setGrade('B');
		}
		else {
			employee.setGrade('A');
		}
		return dao.saveEmployee(employee);
	}

}
