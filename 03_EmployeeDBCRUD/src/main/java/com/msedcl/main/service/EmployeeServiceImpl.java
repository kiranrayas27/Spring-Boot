package com.msedcl.main.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.msedcl.main.domain.Employee;
import com.msedcl.main.dto.EmployeeRequestDTO;
import com.msedcl.main.dto.EmployeeResponseDTO;
import com.msedcl.main.mapper.EmployeeMapper;
import com.msedcl.main.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository=employeeRepository;
	}
	@Override
	public EmployeeResponseDTO addNewEmployee(EmployeeRequestDTO employee) {
		
		return EmployeeMapper.mapEmployeeToEmployeeResponse(employeeRepository.addNewEmployee(EmployeeMapper.mapEmployeeRequestToEmployee(employee)));
	}

	@Override
	public EmployeeResponseDTO updateEmployee(EmployeeRequestDTO employee) {
		return EmployeeMapper.mapEmployeeToEmployeeResponse(employeeRepository.updateEmployee(EmployeeMapper.mapEmployeeRequestToEmployee(employee)));
	}

	@Override
	public EmployeeResponseDTO getEmployeeByEmployeeId(int employeeId) {
		return EmployeeMapper.mapEmployeeToEmployeeResponse(employeeRepository.getEmployeeByEmployeeId(employeeId));
	}

	@Override
	public boolean deleteEmployeeByEmployeeId(int employeeId) {
		return employeeRepository.deleteEmployeeByEmployeeId(employeeId);
	}

	@Override
	public List<EmployeeResponseDTO> getAllEmployees() {
		List<Employee> employeeList=employeeRepository.getAllEmployees();
		List<EmployeeResponseDTO> employeeResponseList=new ArrayList<>();
		for (Employee e : employeeList) {
			employeeResponseList.add(EmployeeMapper.mapEmployeeToEmployeeResponse(e));
		}
		return employeeResponseList;
	}

}
