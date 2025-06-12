package com.springboot.app.serviceImpl;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.app.dto.EmployeeDto;
import com.springboot.app.entities.Employee;
import com.springboot.app.mapper.EmployeeMapper;
import com.springboot.app.repo.EmployeeRepository;
import com.springboot.app.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeRepository employeeRepository;
	
	
	@Override
	public void CreateEmployee(EmployeeDto dto)
	{
		Employee employee=EmployeeMapper.mapToEmployee(dto);
		employeeRepository.save(employee);
	}

	@Override
	public void DeleteEmployee(long id)
	{
		employeeRepository.deleteById(id);		
	}

	@Override
	public void updateEmployee(EmployeeDto dto) 
	{
		Employee employee=EmployeeMapper.mapToEmployee(dto);
		employeeRepository.save(employee);
	}

	@Override
	public EmployeeDto getEmployeeById(long id) 
	{
		Employee employee=employeeRepository.findById(id).get();
		EmployeeDto dto=EmployeeMapper.mapToEmployeeDto(employee);
		return dto;
	}

	@Override
	public List<EmployeeDto> getAllEmployees() {
		List<Employee> empList = null;
		empList = employeeRepository.findAll();
		List<EmployeeDto> dtos = EmployeeMapper.mapToEmployeeDtoList(empList);
		return dtos;
	}

	

}
