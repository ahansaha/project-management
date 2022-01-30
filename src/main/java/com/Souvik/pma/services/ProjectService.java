package com.Souvik.pma.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Souvik.pma.dao.IProjectRepository;
import com.Souvik.pma.dto.IChartData;
import com.Souvik.pma.entities.Project;

@Service
public class ProjectService {
	
	@Autowired
	IProjectRepository projectRepository;
	
	public Project save(Project project) {
		return projectRepository.save(project);
	}
	
	public List<Project> getAll() {
		return projectRepository.findAll();
	}
	
	public List<IChartData> getProjectStatus() {
		return projectRepository.getProjectStatus();
	}
}
