package com.Souvik.pma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.Souvik.pma.dto.IEmployeeProject;
import com.Souvik.pma.entities.Employee;

@RepositoryRestResource(collectionResourceRel = "spring-rest-employees", path = "spring-rest-employees")
public interface IEmployeeRepository extends PagingAndSortingRepository<Employee, Long> {
	
	@Override
	public List<Employee> findAll();
	
	public Employee findByEmail(String email);
	
	@Query(nativeQuery = true, value = "select e.FIRST_NAME as firstName, e.LAST_NAME as lastName, count(pe.EMPLOYEE_ID) as projectCount from EMPLOYEE e left join PROJECT_EMPLOYEE pe on e.EMPLOYEE_ID = pe.EMPLOYEE_ID group by e.FIRST_NAME, e.LAST_NAME order by projectCount desc")
	public List<IEmployeeProject> employeeProjects();
}
