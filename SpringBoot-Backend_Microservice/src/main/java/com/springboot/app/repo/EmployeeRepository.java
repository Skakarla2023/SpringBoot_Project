package com.springboot.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.app.entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>
{
	
}