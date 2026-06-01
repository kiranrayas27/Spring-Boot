package com.msedcl.main.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class EmployeeResponseDTO {
	private int employeeId;
	private String name;
	private double salary;
}
