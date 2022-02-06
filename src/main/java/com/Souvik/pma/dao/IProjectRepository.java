package com.Souvik.pma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.Souvik.pma.dto.IChartData;
import com.Souvik.pma.entities.Project;

@RepositoryRestResource(collectionResourceRel = "spring-rest-projects", path = "spring-rest-projects")
public interface IProjectRepository extends PagingAndSortingRepository<Project, Long> {
	
	@Override
	public List<Project> findAll();
	
	@Query(nativeQuery = true, value = "select STAGE as label, count(STAGE) as value from PROJECT group by STAGE")
	public List<IChartData> getProjectStatus();
}
