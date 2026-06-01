package com.msedcl.main.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.msedcl.main.domain.Employee;


@Repository
@Transactional// transaction commits only if everything goes normal, else rolls back
public class EmployeeRepositoryImpl implements EmployeeRepository {

	
	private JdbcTemplate jdbcTemplate;
	private static final String ADD_NEW_EMPLOYEE="insert into employee_details(name, salary) values(?,?)";
	private static final String UPDATE_EMPLOYEE="update employee_details set name=?, salary=? where employee_id=?";
	private static final String DELETE_EMPLOYEE="delete from employee_details where employee_id=?";
	private static final String SELECT_EMPLOYEE_BY_EMPLOYEEID="select * from employee_details where employee_id=?";
	private static final String SELECT_ALL_EMPLOYEES="select * from employee_details";
	
	
	public EmployeeRepositoryImpl(JdbcTemplate jdbcTemplate) {
		System.out.println("Overloaded constructor called - EmployeeRepository");
		this.jdbcTemplate=jdbcTemplate;
	}
	
	@Override
	public Employee addNewEmployee(Employee employee) {
		int rowInserted = jdbcTemplate.update(ADD_NEW_EMPLOYEE, employee.getName(),employee.getSalary());
		if(rowInserted > 0)
			return employee;
		else
		return null;
	}
	
	

	@Override
	public Employee updateEmployee(Employee employee) {
		int rowInserted = jdbcTemplate.update(UPDATE_EMPLOYEE, employee.getName(),employee.getSalary(),employee.getEmployeeId());
		if(rowInserted > 0)
			return employee;
		else
		return null;
	}

	@Override
	public Employee getEmployeeByEmployeeId(int employeeId) {
		RowMapper<Employee> employeeRowMapper=(rs,rowCnt)->new Employee(rs.getInt("employee_id"),rs.getString("name"),rs.getDouble("salary"));
		return jdbcTemplate.queryForObject(SELECT_EMPLOYEE_BY_EMPLOYEEID,employeeRowMapper,employeeId);
	}

	@Override
	public boolean deleteEmployeeByEmployeeId(int employeeId) {
		int rowInserted = jdbcTemplate.update(DELETE_EMPLOYEE, employeeId);
		if(rowInserted > 0)
			return true;
		else
		return false;
	}

	@Override
	public List<Employee> getAllEmployees() {
		RowMapper<Employee> employeeRowMapper=(rs,rowCnt)->new Employee(rs.getInt("employee_id"),rs.getString("name"),rs.getDouble("salary"));
		return jdbcTemplate.query(SELECT_ALL_EMPLOYEES,employeeRowMapper);
	}

	@Override
	public List<Employee> getEmployeeByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getCountOfEmployees() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Employee> findHighestSalaryEmployee() {
		// TODO Auto-generated method stub
		return null;
	}

//	
	
	

}
