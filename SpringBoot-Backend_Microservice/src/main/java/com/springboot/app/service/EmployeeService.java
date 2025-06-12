package com.springboot.app.service;

import java.util.List;

import com.springboot.app.dto.*;

public interface EmployeeService {

	public void CreateEmployee(EmployeeDto dto);
	
	public void DeleteEmployee(long id);
	
	public void updateEmployee(EmployeeDto dto);
	
	public EmployeeDto getEmployeeById(long id);
	
	public List<EmployeeDto> getAllEmployees();
	
}
