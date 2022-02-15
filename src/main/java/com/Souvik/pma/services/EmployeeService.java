package com.Souvik.pma.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Souvik.pma.dao.IEmployeeRepository;
import com.Souvik.pma.dto.IEmployeeProject;
import com.Souvik.pma.entities.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	IEmployeeRepository employeeRepository;
	
	public Employee save(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	public List<Employee> getAll() {
		return employeeRepository.findAll();
	}
	
	public List<IEmployeeProject> employeeProjects() {
		return employeeRepository.employeeProjects();
	}
	
	public Employee getEmployeeById(long id) {
		return employeeRepository.findById(id).get();
	}
	
	public Employee getEmployeeByEmail(String email) {
		return employeeRepository.findByEmail(email);
	}
	
	public void deleteEmployee(Employee employee) {
		employeeRepository.delete(employee);
	}
}