package com.Souvik.pma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.Souvik.pma.dto.IChartData;
import com.Souvik.pma.entities.Project;

public interface IProjectRepository extends CrudRepository<Project, Long> {
	
	@Override
	public List<Project> findAll();
	
	@Query(nativeQuery = true, value = "select STAGE as label, count(STAGE) as value from PROJECT group by STAGE")
	public List<IChartData> getProjectStatus();
}
