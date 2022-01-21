package com.Souvik.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.Souvik.pma.dao.IEmployeeRepository;
import com.Souvik.pma.dao.IProjectRepository;
import com.Souvik.pma.dto.IEmployeeProject;
import com.Souvik.pma.entities.Employee;
import com.Souvik.pma.entities.Project;

@Controller
public class HomeController {
	
	@Autowired
	IProjectRepository projectRepository;
	
	@Autowired
	IEmployeeRepository employeeRepository;
	
	@GetMapping("/")
	public String displayHome(Model model) {
		
		List<Project> projects = projectRepository.findAll();
		model.addAttribute("projects", projects);
		
//		List<Employee> employees = employeeRepository.findAll();
//		model.addAttribute("employees", employees);
		
		List<IEmployeeProject> employeesProjectsCnt = employeeRepository.employeeProjects();
		model.addAttribute("employeesListProjectsCnt", employeesProjectsCnt);
		
		return "main/home";
	}
}
