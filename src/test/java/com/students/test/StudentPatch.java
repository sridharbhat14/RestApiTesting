package com.students.test;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.student.base.TestBase;
import com.student.model.Student;

import static com.jayway.restassured.RestAssured.*;

public class StudentPatch extends TestBase {

	
	
	@Test
	public void updateStudent() {
		ArrayList<String> courses = new ArrayList<>();
		courses.add("Java");
		courses.add("C++");
		courses.add("Embedded C");
		
		Student student = new Student();
		student.setFirstName("MS");
		student.setLastName("Ramayya");
		student.setEmail("msRama@gmail.com");
		student.setProgramme("ECE");
		student.setCourses(courses);
		
		given()
		.contentType(ContentType.JSON)
		.when()
		.body(student)
		.patch("/102")
		.then()
		.statusCode(200);
	}

}
