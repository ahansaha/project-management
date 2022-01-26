package com.Souvik.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.Souvik.pma.ProjectManagementApplication;
import com.Souvik.pma.dao.IEmployeeRepository;
import com.Souvik.pma.dao.IProjectRepository;
import com.Souvik.pma.entities.Project;


@ContextConfiguration(classes = ProjectManagementApplication.class)
@ExtendWith(SpringExtension.class)
@DataJpaTest

//@Sql group is used to run sql files, but since we are using an in memory db i.e. h2 db
//Spring runs these files dusring the start itself by default
//Enabling the below annotation will duplicate the entries in the table
//@SqlGroup({@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = {"classpath:schema.sql", "classpath:import.sql"}), 
//		   @Sql(executionPhase = ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:drop.sql")})
public class ProjectRepositoryIntegrationTest {
	
	@Autowired
	IProjectRepository projectRepository;
	
	@Test
	public void ifNewProjectSaved_thenSuccess() {
		Project project = new Project("New Test Project", "COMPLETED", "Test Description");
		projectRepository.save(project);
		System.out.println("PROJECT_REPO_COUNT : " + projectRepository.count());
		assertEquals(5, projectRepository.findAll().size());
	}
}
