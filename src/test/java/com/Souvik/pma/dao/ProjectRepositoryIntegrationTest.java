//package com.Souvik.pma.dao;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.jdbc.Sql;
//import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
//import org.springframework.test.context.jdbc.SqlGroup;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import com.Souvik.pma.ProjectManagementApplication;
//import com.Souvik.pma.entities.Project;
//
//
//
//@SpringBootTest
//@ExtendWith(SpringExtension.class)
//public class ProjectRepositoryIntegrationTest {
//	
//	@Autowired
//	IProjectRepository projectRepository;
//	
//	@Test
//	public void ifNewProjectSaved_thenSuccess() {
//		Project project = new Project("New Test Project", "COMPLETED", "Test Description");
//		projectRepository.save(project);
//		System.out.println("PROJECT_REPO_COUNT : " + projectRepository.count());
//		assertEquals(5, projectRepository.findAll().size());
//	}
//}
