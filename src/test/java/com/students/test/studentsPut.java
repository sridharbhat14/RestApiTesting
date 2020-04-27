package com.students.test;

import static org.hamcrest.Matchers.*;
import static com.jayway.restassured.RestAssured.*;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.student.base.TestBase;
import com.student.model.Student;



public class studentsPut extends TestBase {
	
	

	@Test
	public void updateStudent() {
		ArrayList<String> courses = new ArrayList<>();
		courses.add("Java");
		courses.add("C++");
		courses.add("Embedded C");
		
		Student student = new Student();
		student.setFirstName("MS");
		student.setLastName("Ramayya");
		student.setEmail("xyz@gmail.com");
		student.setProgramme("ECE");
		student.setCourses(courses);
		
		given()
		.contentType(ContentType.JSON)
		.when()
		.body(student)
		.put("/102")
		.then()
		.statusCode(200);
	}

}
