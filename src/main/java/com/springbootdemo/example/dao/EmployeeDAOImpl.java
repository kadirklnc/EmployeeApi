package com.springbootdemo.example.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springbootdemo.example.model.Employee;

import jakarta.persistence.EntityManager;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Employee> get() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Employee> query  =  currentSession.createQuery("from Employee",Employee.class);
        return query.getResultList();
	}

	@Override
	public Employee get(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.get(Employee.class, id);
		

	}

	@Override
	public void save(Employee employee) {
			Session currentSession = entityManager.unwrap(Session.class);
			currentSession.saveOrUpdate(employee);
		
	}

	@Override
	public void delete(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Employee employeeObj = currentSession.get(Employee.class, id);
		
		currentSession.remove(employeeObj);
	}

	@Override
	public Employee find(Employee employee) {
	   Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.find(Employee.class, employee.getId());
	}

}
