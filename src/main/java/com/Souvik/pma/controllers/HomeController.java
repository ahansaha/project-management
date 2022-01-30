package com.Souvik.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.Souvik.pma.dto.IChartData;
import com.Souvik.pma.dto.IEmployeeProject;
import com.Souvik.pma.entities.Project;
import com.Souvik.pma.services.EmployeeService;
import com.Souvik.pma.services.ProjectService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class HomeController {
	
	@Value("${version}")
	private String ver;
	
	@Autowired
	ProjectService projectService;
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/")
	public String displayHome(Model model) throws JsonProcessingException {
		
		model.addAttribute("versionNumber", ver);
		
		List<Project> projects = projectService.getAll();
		model.addAttribute("projects", projects);
		
		List<IChartData> projectData = projectService.getProjectStatus();
		
		//Converting the projectData object to json for use in javaScript pie chart.
		ObjectMapper objectMapper = new ObjectMapper();
		String projectDatajsonString = objectMapper.writeValueAsString(projectData);
		//projectDatajsonString will now have a json structure like this:
		//[["NOT STARTED", 1], ["INPROGRESS", 2], ["COMPLETED", 3]]
		
		model.addAttribute("projectStatusCnt", projectDatajsonString);
		
		List<IEmployeeProject> employeesProjectsCnt = employeeService.employeeProjects();
		model.addAttribute("employeesListProjectsCnt", employeesProjectsCnt);
		
		return "main/home";
	}
}
