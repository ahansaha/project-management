package com.Souvik.pma.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import org.springframework.boot.convert.DataSizeUnit;
import org.springframework.lang.NonNull;

import com.Souvik.pma.markerInterfaces.IMarkerOnCreate;
import com.Souvik.pma.validators.UniqueValue;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_seq")
	@SequenceGenerator(name = "employee_seq", sequenceName = "employee_seq", allocationSize = 1, initialValue = 1)
	private long employeeId;
	
	@NonNull
	@Size(min = 2, max = 50)
	private String firstName;
	
	@NonNull
	@Size(min = 1, max = 50)
	private String lastName;
	
	@NonNull //NonNull, Size, Email is a client side validation i.e when filling forms or sending the json body request.
	@Email
	@UniqueValue(groups = IMarkerOnCreate.class)
	private String email;
	
	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
			   fetch = FetchType.LAZY)
	@JoinTable(name = "project_employee",
			   joinColumns = @JoinColumn(name = "employee_id"),
			   inverseJoinColumns = @JoinColumn(name = "project_id"))
	@JsonIgnore
	private List<Project> projects;    //Many employees can be assigned to many projects.

	public Employee() {
		
	}
	
	public Employee(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
