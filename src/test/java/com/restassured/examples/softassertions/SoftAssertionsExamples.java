package com.restassured.examples.softassertions;

import org.junit.Test;
import static org.hamcrest.Matchers.*;
import static com.jayway.restassured.RestAssured.*;


import com.jayway.restassured.RestAssured;

public class SoftAssertionsExamples {
	
	//Hard Assertion Examples
	
@Test
public void hardAssertions() {
	RestAssured.given()
	.when()
	.get("http://localhost:8090/student/list")
	.then()
	.body("[0].firstName",equalTo("Vernon"))
	.body("[0].LastName",equalTo("Harper"))
	.body("[0].email",equalTo("xyz@gmail.com"))
	.body("[0].programme",equalTo("Financial Analysis"));
	
	}
//Soft Assertions

@Test
public void softAssertions() {
	RestAssured.given()
	.when()
	.get("http://localhost:8090/student/list")
	.then()
	.body("[0].firstName",equalTo("Vernon"),
	     "[0].LastName",equalTo("Harper"),
	     "[0].email",equalTo("xyz@gmail.com"),
	     "[0].programme",equalTo("Financial Analysis"));
	
	}


	
	
}
