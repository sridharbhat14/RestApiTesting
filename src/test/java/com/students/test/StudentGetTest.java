package com.students.test;

import static org.hamcrest.Matchers.*;
import static com.jayway.restassured.RestAssured.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.student.base.TestBase;

public class StudentGetTest extends TestBase{

	

	
	  @Test
	  public void getAllStudentInformation(){
	 /**
		 * given() Set cookies.add auth.adding parameters,setting header info
		 * 
		 * .when() used for Get,Post,Put,Delete etc CRUD operations
		 * 
		 * .Then() used for Validating statuscode,extract response,extract
		 * headers,cookies,extract the response body
		 * 
		 */
	
	  
	  Response response = given() 
			  .when() 
			  .get("/list");
	  
	 // System.out.println(response.body().prettyPrint());
	  
	 /**
		 * Validating the status code
		 */
			  
			  given() 
			  .when()
			  .get("/list") 
			  .then() 
			  .statusCode(200);
			  
			  }
			  
			  @Test public void getStudentInfo() 
			  {
				  Response response = given()
						  .when()
			              .get("/1");
				  //System.out.println(response.body().prettyPrint());
				 
				  given() 
				  .when() 
				  .get("/1") 
				  .then() 
				  .statusCode(200);
			  
			 
			  }
			 
	
	  @Test public void getStudentsFromFA() {
		  Response response =given()
				  .when()
				  .get("/list?programme=Financial Analysis&limit=2"); 
		  System.out.println(response.body().prettyPrint());
	  
	  Response response2 = given()
			  .param("programme","Financial Analysis")
			  .param("limit", 2)
			  .when()
			  .get("/list"); 
	  System.out.println(response2.body().prettyPeek());
	  
	  
	  }
			  
	 

}
