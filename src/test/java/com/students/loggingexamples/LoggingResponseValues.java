package com.students.loggingexamples;

import static com.jayway.restassured.RestAssured.given;

import org.junit.Test;

import com.student.base.TestBase;

public class LoggingResponseValues extends TestBase{
	
	/* This test will print all the Response Headers */
	@Test
	public void test001(){
		System.out.println("------Printing Response Headers-------");
	given()
	.param("programme","Computer Science")
	.param("limit",1)
	
	.when()
	.get("/list")
    .then()
    .log()
    .headers()
    .statusCode(200);
}
	/* This test will print  the Response Status Line */
	@Test
	public void test002(){
		System.out.println("------Printing Response Status Line-------");
	given()
	.param("programme","Computer Science")
	.param("limit",1)
	
	.when()
	.get("/list")
    .then()
    .log()
    .status()
    .statusCode(200);
}
	
	/* This test will print  the Response Body */
	@Test
	public void test003(){
		System.out.println("------Printing Response Body-------");
	given()
	.param("programme","Computer Science")
	.param("limit",1)
	
	.when()
	.get("/list")
    .then()
    .log()
    .body()
    .statusCode(200);
}
	
	
	/* This test will print  the Response in case of an error */
	@Test
	public void test004(){
		System.out.println("------Printing Response in case of an error-------");
	given()
	.param("programme","Computer Science")
	.param("limit",1)
	
	.when()
	.get("/list")
    .then()
    .log()
    .ifError();
    
}

}
