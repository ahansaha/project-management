package com.Souvik.pma.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

//To emulate to run on a random test server
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
public class HttpRequestTest {
	
	@LocalServerPort //Auto wiring a random port number
	private int port;
	
	@Autowired
	private TestRestTemplate testRestTemplate; //this template is used to retrieve web resources
											   //Retrieve pojo's, json's etc. Basically mimicking the
											   //the things that we do on a browser using http methods.
	
	
	@Test
	public void homePageReturnsVersionNumberCorrectly_thenSuccess() {
		
		//Now using the restTemplate let's get the whole rendered html home page in the form of a string
		//by giving the url of the home page.
		String renderedHtml = testRestTemplate.getForObject("http://localhost:" + port + "/", String.class);
		assertEquals(renderedHtml.contains("3.3.3.test"), true);
	}
}
