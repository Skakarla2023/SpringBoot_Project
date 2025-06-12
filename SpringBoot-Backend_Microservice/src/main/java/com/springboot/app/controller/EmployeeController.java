package com.springboot.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.app.dto.EmployeeDto;
import com.springboot.app.service.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/employees")

public class EmployeeController
{
	@Autowired
	EmployeeService employeeService;
	
	@Operation(summary = "Save Employee", description = "Save Employee into Database")
	@PostMapping(value="/")
	public ResponseEntity<Object> createEmployee(@RequestBody EmployeeDto dto)
	{
		employeeService.CreateEmployee(dto);
		return new ResponseEntity<Object>("Successfully Saved", HttpStatus.CREATED);
	}
	
	@Operation(summary = "Get Employee", description = "Get Employee from Database")
	@GetMapping(value="/{id}")
	public ResponseEntity<Object> GetEmployee(@PathVariable long id)
	{
		EmployeeDto employee = employeeService.getEmployeeById(id);
		return new ResponseEntity<Object>(employee, HttpStatus.OK);
		
	}
	
	@Operation(summary = "Update Employee", description = "Update Employee into Databases")
	@PutMapping(value="/{id}")
	public ResponseEntity<Object> UpdateEmployee(@RequestBody EmployeeDto employee)
	{
		employeeService.updateEmployee(employee);
		return new ResponseEntity<Object>("Successfully Updated", HttpStatus.OK);
		
	}
	
	@Operation(summary = "Delete Employee", description = "Delete Employee from Database")
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Object> DeleteEmployee(@PathVariable long id)
	{
		employeeService.DeleteEmployee(id);
		return new ResponseEntity<Object>("Successfully Deleted", HttpStatus.NO_CONTENT);
		
	}
	
	@Operation(summary = "Get all Employees", description = "Get all Employees from the Database")
	@GetMapping(value="/")
	public ResponseEntity<Object> GetAllEmployee()
	{
		return new ResponseEntity<Object>(employeeService.getAllEmployees(),HttpStatus.OK);
		
	}
	
}

