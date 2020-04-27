package com.students.loggingexamples;

import com.jayway.restassured.http.ContentType;
import com.student.base.TestBase;
import com.student.model.Student;

import static org.hamcrest.Matchers.*;

import java.util.ArrayList;

import static com.jayway.restassured.RestAssured.*;
import org.junit.Test;
import static com.jayway.restassured.RestAssured.given;

public class LoggingRequestValues extends TestBase{
	
	/* This test will print all the Request Headers */
   
	
	@Test
	public void test001(){
		System.out.println("------Printing Request Headers-------");
	given()
	.log()
	.headers()
	.when()
	.get("/1")
    .then()
    .statusCode(200);
}
	/* This test will print all the Request Parameters */
	@Test
	public void test002(){
		System.out.println("------Printing Request Parameters-------");
	given()
	.param("programme","Computer Science")
	.param("limit",1)
	.log()
	.params()
	.when()
	.get("/list")
    .then()
    .statusCode(200);
}
	
	
	/* This test will print all the Request Body */
	@Test
	public void test003() {
		ArrayList<String> courses = new ArrayList<>();
		System.out.println("------Printing Request Body-------");
		
		courses.add("Java");
		courses.add("C++");
		
		Student student = new Student();
		student.setFirstName("Tej");
		student.setLastName("Hegde");
		student.setEmail("xyz@gmail.com");
		student.setProgramme("ComputerScience");
		student.setCourses(courses);
		
		given()
		.contentType(ContentType.JSON)
		.log()
		.body()
		.when()
		.body(student)
		.post();
		
		
		

	}
	

	/* This test will print out all the details */
	@Test
	public void test004() {
		ArrayList<String> courses = new ArrayList<>();
		System.out.println("------Printing all the Request details-------");
		
		courses.add("Java");
		courses.add("C++");
		
		Student student = new Student();
		student.setFirstName("Tej");
		student.setLastName("Hegde");
		student.setEmail("xyz@gmail.com");
		student.setProgramme("ComputerScience");
		student.setCourses(courses);
		
		given()
		.contentType(ContentType.JSON)
		.log()
		.all()
		.when()
		.body(student)
		.post();
		
		
		

	}
	
	/* This test will print request details if validation fails */
	@Test
	public void test005() {
		ArrayList<String> courses = new ArrayList<>();
		System.out.println("------Printing all the Request details if validation fails-------");
		
		courses.add("Java");
		courses.add("C++");
		
		Student student = new Student();
		student.setFirstName("Tejj");
		student.setLastName("Hegde1");
		student.setEmail("xyz123@gmail.com");
		student.setProgramme("ComputerScience");
		student.setCourses(courses);
		
		given()
		.contentType(ContentType.JSON)
		.log()
		.ifValidationFails()
		.when()
		.body(student)
		.post()
		.then()
         .statusCode(201)	;	
		
		

	}
	
	}
	
	
	
	

