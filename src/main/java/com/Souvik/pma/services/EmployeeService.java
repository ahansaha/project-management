package com.Souvik.pma.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.Souvik.pma.dao.IEmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	@Qualifier("staffRepositoryImp2")
	IStaffRepository staffRepository;
	
	//Field injection
//	@Autowired
//	IEmployeeRepository employeeRepository;
	
	//Constructor injection
//	IEmployeeRepository employeeRepository;
//	public EmployeeService(IEmployeeRepository employeeRepository) {
//		this.employeeRepository = employeeRepository;
//	}

	//Setter injection
//	IEmployeeRepository employeeRepository;	
//	@Autowired
//	public void setEmployeeRepository(IEmployeeRepository employeeRepository) {
//		this.employeeRepository = employeeRepository;
//	}
}
