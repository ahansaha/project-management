package com.Souvik.pma.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.Souvik.pma.entities.Project;

public interface IProjectRepository extends CrudRepository<Project, Long> {
	
	@Override
	public List<Project> findAll();
}
