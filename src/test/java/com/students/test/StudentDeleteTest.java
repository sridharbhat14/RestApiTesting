package com.students.test;
import static org.hamcrest.Matchers.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.jayway.restassured.RestAssured;
import com.student.base.TestBase;

import static com.jayway.restassured.RestAssured.*;

public class StudentDeleteTest extends TestBase{


	
	@Test
	public void deleteStudent() {
		given()
		.when()
		.delete("/114")
		.then()
		.statusCode(204);
		
		
		
	}

}
