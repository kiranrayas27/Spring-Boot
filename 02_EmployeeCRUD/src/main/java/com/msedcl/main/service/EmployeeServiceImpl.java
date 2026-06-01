package com.msedcl.main.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.msedcl.main.domain.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private List<Employee> employeeList = new ArrayList<>();

	public EmployeeServiceImpl() {
		Employee employee = new Employee(101, "Seema", 1000);
		Employee employee2 = new Employee(102, "Reema", 1000);

		employeeList.add(employee);
		employeeList.add(employee2);
		// employeeList = Arrays.asList(new Employee(101, "Seema", 1000), new
		// Employee(102, "Reema", 1000));
	}

	@Override
	public Employee addNewEmployee(Employee employee) {
		System.out.println("in Service");
		System.out.println(employee);
		boolean result = employeeList.add(employee);
		if (result)
			return employee;
		else
			return null;
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		for (Employee e : employeeList) {
			if (e.getEmployeeId() == employee.getEmployeeId()) {
				e.setName(employee.getName());
				e.setSalary(employee.getSalary());
				return e;
			}
		}
		return null;
	}

	@Override
	public Employee getEmployeeByEmployeeId(int employeeId) {
		for (Employee employee : employeeList) {
			if (employee.getEmployeeId() == employeeId) {
				return employee;
			}
		}
		return null;
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeList;
	}

	@Override
	public boolean deleteEmployeeByEmployeeId(int employeeId) {
		for (Employee employee : employeeList) {
			if (employee.getEmployeeId() == employeeId)
				return employeeList.remove(employee);
		}
		return false;
	}

}
