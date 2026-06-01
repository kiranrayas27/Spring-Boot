package com.msedcl.main.controller;

import java.util.List;

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

import com.msedcl.main.domain.Employee;
import com.msedcl.main.dto.EmployeeRequestDTO;
import com.msedcl.main.dto.EmployeeResponseDTO;
import com.msedcl.main.dto.ResponseDTO;
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
	public ResponseEntity<ResponseDTO> deleteEmployee(@PathVariable int employeeId) {
		boolean result= employeeService.deleteEmployeeByEmployeeId(employeeId);
		if(result)
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO("Employee with Employee Id "+employeeId+"  deleted"));
		else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDTO("Invalid employeeId "+employeeId+"/ Employee ID not found"));
	}
	
	@PutMapping("updateEmployee")
	public EmployeeResponseDTO updateEmployee(@RequestBody EmployeeRequestDTO employee) {
		return employeeService.updateEmployee(employee);
	}
	
	@PostMapping("addEmployee")
	public EmployeeResponseDTO addEmployee(@RequestBody EmployeeRequestDTO employee) {
		System.out.println(employee);
		return employeeService.addNewEmployee(employee);
	}
	
	@GetMapping("employees/{employeeId}")
	public EmployeeResponseDTO getEmployeeByEmployeeId(@PathVariable int employeeId) {
		return employeeService.getEmployeeByEmployeeId(employeeId);
	}
	
	@GetMapping("employees")
	public List<EmployeeResponseDTO> allEmployees(){
		return employeeService.getAllEmployees();
	}
}
