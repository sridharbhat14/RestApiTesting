package com.jsonpath.examples;

import static org.hamcrest.Matchers.*;
import static com.jayway.restassured.RestAssured.*;


import java.util.HashMap;
import java.util.List;


import org.junit.BeforeClass;
import org.junit.Test;

import com.jayway.restassured.RestAssured;

public class SearchJsonPathExample {
	static final String APIKEY = "75eiggifgijkbhcghc";
	
	@BeforeClass
		public static void init() {
		RestAssured.baseURI="http://api.walmartlabs.com";
		RestAssured.basePath="/v1";
	}
	
	
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
		
		System.out.println("-----------Starting Test----------");
		System.out.println("The total number of items are:  "+numItems);
		System.out.println("-----------End of the Test----------");
		
	}
	
//----2)------Extract Query value-------------
	
	@Test
	public  void test002() {
		String queryValue = given()
		.queryParam("query","ipod")
		.queryParam("apikey","APIKEY")
		.queryParam("format","json")
		.when()
		.get("/search")
		.then()
		.extract()
		.path("query");
		
		System.out.println("-----------Starting Test----------");
		System.out.println("The search query is:  "+queryValue);
		System.out.println("-----------End of the Test----------");
		
	}
	
	//----3)--- Extract first productName by providing list index value
	
	@Test
	public  void test003() {
		String productName = given()
		.queryParam("query","ipod")
		.queryParam("apikey","APIKEY")
		.queryParam("format","json")
		.when()
		.get("/search")
		.then()
		.extract()
		.path("items[0].name");
		
		System.out.println("-----------Starting Test----------");
		System.out.println("The product name is:  "+productName);
		System.out.println("-----------End of the Test----------");
		
	}
	
	

	//----4)--- Get the gift options for the first product
	
	@Test
	public  void test004() {
		HashMap<String,String> giftOptions= given()
		.queryParam("query","ipod")
		.queryParam("apikey","APIKEY")
		.queryParam("format","json")
		.when()
		.get("/search")
		.then()
		.extract()
		.path("items[0].giftOptions");
		
		System.out.println("-----------Starting Test----------");
		System.out.println("The product name is:  "+giftOptions);
		System.out.println("-----------End of the Test----------");
		
	}
	
	//----5)--- Print the size of items
	
		@Test
		public  void test005() {
			int size = given()
			.queryParam("query","ipod")
			.queryParam("apikey","APIKEY")
			.queryParam("format","json")
			.when()
			.get("/search")
			.then()
			.extract()
			.path("items.size()");
			
			System.out.println("-----------Starting Test----------");
			System.out.println("Print the size of items is:  "+size);
			System.out.println("-----------End of the Test----------");
			
		}
		
		//----6)--- Get all the names
		
		@Test
		public  void test006() {
			List<String> names= given()
			.queryParam("query","ipod")
			.queryParam("apikey","APIKEY")
			.queryParam("format","json")
			.when()
			.get("/search")
			.then()
			.extract()
			.path("items.name");
			
			System.out.println("-----------Starting Test----------");
			System.out.println("Get all the names is:  "+names);
			System.out.println("-----------End of the Test----------");
			
		}
		
	//----7)--- Get all the values of names==Apple ipod touch 32gb 
		
		@Test
		public  void test007() {
			List<HashMap<String,Object>> values= given()
			.queryParam("query","ipod")
			.queryParam("apikey","APIKEY")
			.queryParam("format","json")
			.when()
			.get("/search")
			.then()
			.extract()
			.path("items.findAll{it.name=='Apple ipod touch 32gb'}");
			
			System.out.println("-----------Starting Test----------");
			System.out.println("Get all the names is:  "+values);
			System.out.println("-----------End of the Test----------");
			
		}
		
		//----7)--- Get the sale price value for name==Apple ipod touch 32gb 
		
				@Test
				public  void test008() {
					List<Float> salePrice= given()
					.queryParam("query","ipod")
					.queryParam("apikey","APIKEY")
					.queryParam("format","json")
					.when()
					.get("/search")
					.then()
					.extract()
					.path("items.findAll{it.name=='Apple ipod touch 32gb'}.salePrice");
					
					System.out.println("-----------Starting Test----------");
					System.out.println("Get all the names is:  "+salePrice);
					System.out.println("-----------End of the Test----------");
					
				}
		

				//----7)--- Get the names which have sale price less than 150 dollars 
				
						@Test
						public  void test009() {
							List<String> names = given()
							.queryParam("query","ipod")
							.queryParam("apikey","APIKEY")
							.queryParam("format","json")
							.when()
							.get("/search")
							.then()
							.extract()
							.path("items.findAll{it.salePrice<150'}.name");
							
							System.out.println("-----------Starting Test----------");
							System.out.println("The items that are priced less than $150 are:  "+names);
							System.out.println("-----------End of the Test----------");
							
						}
						
						//----7)--- Get the MSRP of items that start with name = Ref
						
						@Test
						public  void test010() {
							List<String> msrpvalues = given()
							.queryParam("query","ipod")
							.queryParam("apikey","APIKEY")
							.queryParam("format","json")
							.when()
							.get("/search")
							.then()
							.extract()
							.path("items.findAll{it.name==~/Ref.*/'}.msrp");
							
							System.out.println("-----------Starting Test----------");
							System.out.println("The MSRP of items that start with Ref:  "+msrpvalues);
							System.out.println("-----------End of the Test----------");
							
						}
						
		//----7)--- Get the sale price of items that end  with name = ed ----
						
						@Test
						public  void test011() {
							List<String> saleprice = given()
							.queryParam("query","ipod")
							.queryParam("apikey","APIKEY")
							.queryParam("format","json")
							.when()
							.get("/search")
							.then()
							.extract()
							.path("items.findAll{it.name==~/ .*ed/}.saleprice");
							
							System.out.println("-----------Starting Test----------");
							System.out.println("The msrp of items that end  with ed are :  "+saleprice);
							System.out.println("-----------End of the Test----------");
							
						}
			
}
