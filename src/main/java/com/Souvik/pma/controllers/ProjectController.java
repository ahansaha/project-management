package com.Souvik.pma.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
		
		Errors errors;
		if(model.containsAttribute("errors")) {
			errors = (Errors) model.getAttribute("errors");
		}
		
		return "projects/new-project";
	}
	
	@PostMapping("/save")
	public String createProject(@Valid Project project, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			return "projects/project-creation-error";
		}
		
		projectService.save(project);
		return "redirect:/projects";
	}
	
	@GetMapping("update")
	public String updateProject(@RequestParam("id") long id, Model model) {
		
		Project project = projectService.getProjectById(id);
		model.addAttribute("project", project);
		
		List<Employee> employees = employeeService.getAll();
		model.addAttribute("allEmployees", employees);
		
		return "projects/new-project";
	}
	
	@GetMapping("delete")
	public String deleteProject(@RequestParam("id") long id) {
		projectService.deleteProject(projectService.getProjectById(id));
		return "redirect:/projects";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
