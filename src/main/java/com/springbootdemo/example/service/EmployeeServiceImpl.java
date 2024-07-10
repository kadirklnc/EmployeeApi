package com.springbootdemo.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.springbootdemo.example.dao.EmployeeDAO;
import com.springbootdemo.example.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeDAO employeeDAO;
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Override
	public List<Employee> get() {
		return employeeDAO.get();
		
	}
	public Employee find(Employee employeeObj) {
		
		return employeeDAO.find(employeeObj);
		
	}
	
	@Transactional
	@Override
	public Employee get(int id) {
		return employeeDAO.get(id);
	}
	
	@Transactional
	@Override
	public void save(Employee employee) {
		employeeDAO.save(employee);
		
	}
	
	@Transactional
	@Override
	public void delete(int id) {
		employeeDAO.delete(id);
		
	}

}
