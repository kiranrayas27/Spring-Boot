package com.msedcl.main.repository;

import java.util.List;

import com.msedcl.main.domain.Employee;

public interface EmployeeRepository {
	Employee addNewEmployee(Employee employee);
	
	Employee updateEmployee(Employee employee);
	
	Employee getEmployeeByEmployeeId(int employeeId);
	
	boolean deleteEmployeeByEmployeeId(int employeeId);
	
	List<Employee> getAllEmployees();
	
	public List<Employee> getEmployeeByName(String name);
	
	public long getCountOfEmployees();
	
	public List<Employee> findHighestSalaryEmployee();
}
