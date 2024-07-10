package com.springbootdemo.example.service;

import java.util.List;

import com.springbootdemo.example.model.Employee;

public interface EmployeeService {
	
	List<Employee> get();
	
	Employee get(int id);
	Employee find(Employee employee);
	
	void save(Employee employee);
	
	void delete(int id);
	

}
