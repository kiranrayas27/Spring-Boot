package com.msedcl.main.mapper;

import com.msedcl.main.domain.Employee;
import com.msedcl.main.dto.EmployeeRequestDTO;
import com.msedcl.main.dto.EmployeeResponseDTO;

public class EmployeeMapper {
	public static Employee mapEmployeeRequestToEmployee(EmployeeRequestDTO employeeRequestDTO) {
		Employee employee=new Employee();
		employee.setEmployeeId(employeeRequestDTO.getEmployeeId());
		employee.setName(employeeRequestDTO.getName());
		employee.setSalary(employeeRequestDTO.getSalary());
		
		return employee;
	}
	
	public static EmployeeResponseDTO mapEmployeeToEmployeeResponse(Employee employee) {
		EmployeeResponseDTO employeeResponseDTO=new EmployeeResponseDTO();
		employeeResponseDTO.setEmployeeId(employee.getEmployeeId());
		employeeResponseDTO.setName(employee.getName());
		employeeResponseDTO.setSalary(employee.getSalary());
		
		return employeeResponseDTO;
	}
}
