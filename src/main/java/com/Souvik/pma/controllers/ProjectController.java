package com.Souvik.pma.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.Souvik.pma.entities.Employee;
import com.Souvik.pma.entities.Project;
import com.Souvik.pma.services.EmployeeService;
import com.Souvik.pma.services.ProjectService;

@Controller
@RequestMapping("/projects")
public class ProjectController{
	
	@Autowired
	ProjectService projectService;
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping
	public String displayProjects(Model model) {
		List<Project> projects = projectService.getAll();
		model.addAttribute("projects", projects);
		return "projects/project-list";
	}
	
	@GetMapping("/new")
	public String displayProjectForm(Model model) {
		
		Project aProject = new Project();
		model.addAttribute("project", aProject);
		
		List<Employee> employees = employeeService.getAll();
		model.addAttribute("allEmployees", employees);
		
		return "projects/new-project";
	}
	
	@PostMapping("/save")
	public String createProject(@Valid Project project) {
		
		//This method should save project to DB.
		projectService.save(project);
		
		
		//Code for one to many. One project can have multiple employees.
//		Iterable<Employee> chosenEmployees = employeeRepository.findAllById(employees);
//		
//		for(Employee emp : chosenEmployees) {
//			emp.setProject(project);
//			employeeRepository.save(emp);
//		}
		
		//Use a redirect here to prevent the user from submitting the data multiple times to prevent duplicates.
		return "redirect:/projects";
	}
	
}
