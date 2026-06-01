package com.msedcl.main.service;

import java.util.List;

import com.msedcl.main.domain.Employee;

public interface EmployeeService {
	Employee addNewEmployee(Employee employee);
	Employee updateEmployee(Employee employee);
	Employee getEmployeeByEmployeeId(int employeeId);
	List<Employee> getAllEmployees();
	boolean deleteEmployeeByEmployeeId(int employeeId);
}
