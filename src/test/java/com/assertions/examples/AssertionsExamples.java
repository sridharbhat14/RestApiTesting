package com.assertions.examples;

import static com.jayway.restassured.RestAssured.given;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;

import static org.hamcrest.Matchers.*;
import com.jayway.restassured.RestAssured;

public class AssertionsExamples {
	
static final String APIKEY = "75eiggifgijkbhcghc";
	
	@BeforeClass
		public static void init() {
		RestAssured.baseURI="http://api.walmartlabs.com";
		RestAssured.basePath="/v1";

}
	
	
	//-1)-------Verify if number of items equals to 10-----------
	
	@Test
	public  void test001() {
		int numItems = given()
		.queryParam("query","ipod")
		.queryParam("apikey","APIKEY")
		.queryParam("format","json")
		.when()
		.get("/search")
		.then()
		.extract()
		.path("numItems");
		assertEquals(10,numItems);
		
		
		
	}
	

	
	//2)--------Verify the query-----------
	
	@Test
	public  void test002() {
		given()
		.queryParam("query","ipod")
		.queryParam("apikey","APIKEY")
		.queryParam("format","json")
		.when()
		.get("/search")
		.then()
		.body("query", equalTo("ipod"));
		
		
		
		
	}
	
	//3)--------check single name in Arraylist-----------
	
		@Test
		public  void test003() {
			given()
			.queryParam("query","ipod")
			.queryParam("apikey","APIKEY")
			.queryParam("format","json")
			.when()
			.get("/search")
			.then()
			.body("items.name",hasItem("Refurbished Apple Ipod nano 16gb,blue"));
			
			
			
			
		}
		

		//4)--------check multiple Names in Arraylist-----------
		
			@Test
			public  void test004() {
				given()
				.queryParam("query","ipod")
				.queryParam("apikey","APIKEY")
				.queryParam("format","json")
				.when()
				.get("/search")
				.then()
				.body("items.name",hasItems("Refurbished Apple Ipod nano 16gb,blue","Apple ipod touch 6th generation 16gb"));
				
				}
			
			//5)--------Verify the giftoptions for the first product ( checking values inside map using hasValue()-----------
			
			@Test
			public  void test005() {
				given()
				.queryParam("query","ipod")
				.queryParam("apikey","APIKEY")
				.queryParam("format","json")
				.when()
				.get("/search")
				.then()
				.body("items[0].giftOptions",hasKey("allowGiftWrap"));
				
				}
			
	//6)--------check HashMap values inside a list-----------
			
			@Test
			public  void test006() {
				given()
				.queryParam("query","ipod")
				.queryParam("apikey","APIKEY")
				.queryParam("format","json")
				.when()
				.get("/search")
				.then()
				.body("items.findAll{it.name=='Apple ipod touch 32gb'}",hasItems(hasEntry("name","Apple ipod touch 32gb")));
				
				}
	
						
				
	//7)--------checking multiple values in the same statement-----------
			
			@Test
			public  void test007() {
				 given()
						.queryParam("query","ipod")
						.queryParam("apikey","APIKEY")
						.queryParam("format","json")
						.when()
						.get("/search")
						.then()
						.body("items.findAll{it.name=='Apple ipod touch 32gb'}",hasItems(hasEntry("name","Apple ipod touch 32gb")))
				         .body("items[0].giftOptions",hasKey("allowGiftWrap"))
				         .body("items.name",hasItems("Refurbished Apple Ipod nano 16gb,blue","Apple ipod touch 6th generation 16gb"))
				 .statusCode(200);
				}
			
			//----8)--- Logical Assertions
			
			@Test
			public  void test008() {
			     given()
				.queryParam("query","ipod")
				.queryParam("apikey","APIKEY")
				.queryParam("format","json")
				.when()
				.get("/search")
				.then()
				
				.body("items.size()",equalTo(10))
			     .body("items.size()",greaterThan(5))
			     .body("items.size()",lessThan(11))
			     .body("items.size()",greaterThanOrEqualTo(10))
			     .body("items.size()",lessThanOrEqualTo(10));
			}		
}