package com.Souvik.pma.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.Souvik.pma.dao.IProjectRepository;
import com.Souvik.pma.entities.Project;

@RestController
@RequestMapping("/app-api/projects")
public class ProjectApiController {

	@Autowired
	IProjectRepository projectRepository;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Project> getAllProjects() {
		return projectRepository.findAll();
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Project getProject(@PathVariable("id") long id) {
		return projectRepository.findById(id).get();
	}
	
	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Project createProject(@RequestBody Project project) {
		return projectRepository.save(project);
	}
	
	@PutMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public Project updateProject(@RequestBody Project updatedProject) {
		return projectRepository.save(updatedProject);
	}
	
	@PatchMapping(path = "/{id}", consumes = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public Project patchProject(@PathVariable("id") long id, @RequestBody Project patchedProject) {
		
		Project prj = projectRepository.findById(id).get();
		
		if(patchedProject.getName() != null) {
			prj.setName(patchedProject.getName());
		}
		if(patchedProject.getStage() != null) {
			prj.setStage(patchedProject.getStage());
		}
		if(patchedProject.getDescription() != null) {
			prj.setDescription(patchedProject.getDescription());
		}
		
		return projectRepository.save(prj);
	}
	
	@DeleteMapping(path = "/{id}", consumes = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public void deleteProject(@PathVariable("id") long id) {
		try {
			projectRepository.deleteById(id);
		}
		catch(EmptyResultDataAccessException e) {
			
		}
	}
	
	
	
	
	
	
	
	
	
	
	
}
