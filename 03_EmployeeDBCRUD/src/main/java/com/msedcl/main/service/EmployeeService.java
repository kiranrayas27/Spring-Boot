package com.msedcl.main.service;

import java.util.List;

import com.msedcl.main.domain.Employee;
import com.msedcl.main.dto.EmployeeRequestDTO;
import com.msedcl.main.dto.EmployeeResponseDTO;

public interface EmployeeService {
	EmployeeResponseDTO addNewEmployee(EmployeeRequestDTO employee);
	
	EmployeeResponseDTO updateEmployee(EmployeeRequestDTO employee);
	
	EmployeeResponseDTO getEmployeeByEmployeeId(int employeeId);
	
	boolean deleteEmployeeByEmployeeId(int employeeId);
	
	List<EmployeeResponseDTO> getAllEmployees();
	
}
