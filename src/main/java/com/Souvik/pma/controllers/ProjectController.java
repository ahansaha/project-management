package com.Souvik.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Souvik.pma.dao.IEmployeeRepository;
import com.Souvik.pma.dao.IProjectRepository;
import com.Souvik.pma.entities.Employee;
import com.Souvik.pma.entities.Project;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	
	@Autowired
	IProjectRepository projectRepository;
	
	@Autowired
	IEmployeeRepository employeeRepository;
	
	@GetMapping
	public String displayProjects(Model model) {
		List<Project> projects = projectRepository.findAll();
		model.addAttribute("projects", projects);
		return "projects/project-list";
	}
	
	@GetMapping("/new")
	public String displayProjectForm(Model model) {
		
		Project aProject = new Project();
		model.addAttribute("project", aProject);
		
		List<Employee> employees = employeeRepository.findAll();
		model.addAttribute("allEmployees", employees);
		
		return "projects/new-project";
	}
	
	@PostMapping("/save")
	public String createProject(Project project, @RequestParam List<Long> employees) { //Here employees in the arguments
																					   //are the list of the employeeIds
		//This method should save project to DB.
		projectRepository.save(project);
		
		
		//Code for one to many. One project can have multiple employees.
//		Iterable<Employee> chosenEmployees = employeeRepository.findAllById(employees);
//		
//		for(Employee emp : chosenEmployees) {
//			emp.setProject(project);
//			employeeRepository.save(emp);
//		}
		
		//Use a redirect here to prevent the user from submitting the data multiple times to prevent duplicates.
		return "redirect:/projects/new";
	}
	
}
