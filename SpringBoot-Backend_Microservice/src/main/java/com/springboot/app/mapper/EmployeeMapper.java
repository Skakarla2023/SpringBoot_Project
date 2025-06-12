package com.springboot.app.mapper;

import java.util.ArrayList;
import java.util.List;

import com.springboot.app.dto.EmployeeDto;
import com.springboot.app.entities.Employee;

public class EmployeeMapper 
{
	public static EmployeeDto mapToEmployeeDto(Employee employee)
	{
		EmployeeDto employeedto = new EmployeeDto();
		employeedto.setId(employee.getId());
		employeedto.setFirstName(employee.getFirstName());
		employeedto.setLastName(employee.getLastName());
		return employeedto;
		
	}
	
	public static Employee mapToEmployee(EmployeeDto employeedto)
	{
		Employee employee=new Employee();
		employee.setId(employeedto.getId());
		employee.setFirstName(employeedto.getFirstName());
		employee.setLastName(employeedto.getLastName());
		return employee;
		
	}
	
	public static List<Employee> mapToEmployeeList(List<EmployeeDto> employeeDtos)
	{
		List<Employee> list = new ArrayList<>();
		for (EmployeeDto dto : employeeDtos) {
			Employee emp = mapToEmployee(dto);
			list.add(emp);
		}
		return list;
	}
	
	public static List<EmployeeDto> mapToEmployeeDtoList(List<Employee> employees)
	{
		List<EmployeeDto> list = new ArrayList<>();
		for (Employee emp : employees) {
			EmployeeDto dto = mapToEmployeeDto(emp);
			list.add(dto);
		}
		return list;
		
	}
		
}
