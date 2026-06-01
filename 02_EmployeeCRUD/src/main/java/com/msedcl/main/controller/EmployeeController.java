package com.msedcl.main.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.msedcl.main.domain.Employee;
import com.msedcl.main.service.EmployeeService;

@RestController
@RequestMapping("employeecrudapi")
public class EmployeeController {
	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	@DeleteMapping("deleteEmployee/{employeeId}")
	public boolean deleteEmployee(@PathVariable int employeeId) {
		return employeeService.deleteEmployeeByEmployeeId(employeeId);
	}
	
	@PutMapping("updateEmployee")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return employeeService.updateEmployee(employee);
	}
	
	@PostMapping("addEmployee")
	public Employee addEmployee(@RequestBody Employee employee) {
		System.out.println(employee);
		return employeeService.addNewEmployee(employee);
	}
	
	@GetMapping("employees/{employeeId}")
	public Employee getEmployeeByEmployeeId(@PathVariable int employeeId) {
		return employeeService.getEmployeeByEmployeeId(employeeId);
	}
	
	@GetMapping("employees")
	public List<Employee> allEmployees(){
		return employeeService.getAllEmployees();
	}
}
