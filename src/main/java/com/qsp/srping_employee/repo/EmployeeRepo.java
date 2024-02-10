package com.qsp.srping_employee.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.qsp.srping_employee.dto.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{
	Employee findEMployeeByPhone(long phone);
//	Employee findEmployeeByEmail(String email);
	@Query("SELECT e FROM Employee e WHERE e.email=?1")
	Employee employeeByEmail(String email);
	
	
	List<Employee> findEmployeeByName(String name);
	
	
	List<Employee> findEmployeeBySalaryLessThan(double salary);
	List<Employee> findEmployeeBySalaryLessThanEqual(double salary);
	
	List<Employee> findEmployeeBySalaryGreaterThan (double salary);
	
	@Query("SELECT e FROM Employee e  WHERE e.salary BETWEEN ?1 And ?2")
	List<Employee> findEmployeeBySalaryBetween (double salary1,double salary2);
}


