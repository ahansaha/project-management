package com.Souvik.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.Souvik.pma.dao.IEmployeeRepository;
import com.Souvik.pma.dao.IProjectRepository;
import com.Souvik.pma.dto.IChartData;
import com.Souvik.pma.dto.IEmployeeProject;
import com.Souvik.pma.entities.Employee;
import com.Souvik.pma.entities.Project;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class HomeController {
	
	@Autowired
	IProjectRepository projectRepository;
	
	@Autowired
	IEmployeeRepository employeeRepository;
	
	@GetMapping("/")
	public String displayHome(Model model) throws JsonProcessingException {
		
		List<Project> projects = projectRepository.findAll();
		model.addAttribute("projects", projects);
		
		List<IChartData> projectData = projectRepository.getProjectStatus();
		
		//Converting the projectData object to json for use in javaScript pie chart.
		ObjectMapper objectMapper = new ObjectMapper();
		String projectDatajsonString = objectMapper.writeValueAsString(projectData);
		//projectDatajsonString will now have a json structure like this:
		//[["NOT STARTED", 1], ["INPROGRESS", 2], ["COMPLETED", 3]]
		
		model.addAttribute("projectStatusCnt", projectDatajsonString);
		
		List<IEmployeeProject> employeesProjectsCnt = employeeRepository.employeeProjects();
		model.addAttribute("employeesListProjectsCnt", employeesProjectsCnt);
		
		return "main/home";
	}
}
