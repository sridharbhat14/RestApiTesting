package com.XMLPathExamples;
import static org.hamcrest.Matchers.*;

import java.util.List;

import static com.jayway.restassured.RestAssured.*;


import org.junit.BeforeClass;
import org.junit.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.internal.path.xml.NodeChildrenImpl;



public class SearchXMLPathExamples {

	static final String APIKEY = "75eiggifgijkbhcghc";
	

	@BeforeClass
		public static void init() {
		RestAssured.baseURI="http://api.walmartlabs.com";
		RestAssured.basePath="/v1";
	}
	
	//  1)-----Extract Num Items------
	@Test
	public  void test001() {
		String numItems = given()
		.queryParam("query","ipod")
		.queryParam("apikey","APIKEY")
		.queryParam("format","xml")
		.when()
		.get("/search")
		.then()
		.extract()
		.path("Searchresponse.numItems");
		
		System.out.println("-----------Starting Test----------");
		System.out.println("The value of numItems are:  "+numItems);
		System.out.println("-----------End of the Test----------");
		
	}
	
	//  2)-----Extract first product name by providing list index value------
	@Test
	public  void test002() {
		String productName = given()
		.queryParam("query","ipod")
		.queryParam("apikey","APIKEY")
		.queryParam("format","xml")
		.when()
		.get("/search")
		.then()
		.extract()
		.path("Searchresponse.items.item[0].name");
		
		System.out.println("-----------Starting Test----------");
		System.out.println("The product name is :  "+productName);
		System.out.println("-----------End of the Test----------");
		
	}
	
//  3)-----Get the gift options for the first product------
	@Test
	public  void test003() {
		String xml = given()
		.queryParam("query","ipod")
		.queryParam("apikey","APIKEY")
		.queryParam("format","xml")
		.when()
		.get("/search").asString();
		
		String giftOptions = with(xml).getString("Searchresponse.items.item[0].giftOptions");
		
		
		System.out.println("-----------Starting Test----------");
		System.out.println("The gift options under the first product are  :  "+giftOptions);
		System.out.println("-----------End of the Test----------");
		
	}
	
	

//  4)-----Get the size of items------
	@Test
	public  void test004() {
		NodeChildrenImpl val = given()
				.queryParam("query","ipod")
				.queryParam("apikey","APIKEY")
				.queryParam("format","xml")
				.when()
				.get("/search")
				.then()
				.extract()
				.path("Searchresponse.items.item");
		
		
		System.out.println("-----------Starting Test----------");
		System.out.println("The gift options under the first product are  :  "+val.size());
		System.out.println("-----------End of the Test----------");
		
	}
	
	// 5)-----Get all the names of all the products------
	@Test
	public  void test005() {
		String xml = given()
		.queryParam("query","ipod")
		.queryParam("apikey","APIKEY")
		.queryParam("format","xml")
		.when()
		.get("/search").asString();
		
		List<String> names = with(xml).getList("Searchresponse.items.item.name");
		
		
		System.out.println("-----------Starting Test----------");
		System.out.println("The gift options under the first product are  :  "+names);
		System.out.println("-----------End of the Test----------");
		
	}
	
	// 5)-----Get the saleprice for name == Apple ipod touch 32gb------
		@Test
		public  void test006() {
			String xml = given()
			.queryParam("query","ipod")
			.queryParam("apikey","APIKEY")
			.queryParam("format","xml")
			.when()
			.get("/search").asString();
			
			List<String> salePrice = with(xml).getList("Searchresponse.items.item.findAll{it.name=='Apple ipod touch 32gb'}.salePrice");
			
			
			System.out.println("-----------Starting Test----------");
			System.out.println("The sale Price is :  "+salePrice);
			System.out.println("-----------End of the Test----------");
			
		}
}
