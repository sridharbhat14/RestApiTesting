package com.restassured.examples.jsonassert;

import java.nio.file.Files;

import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

import com.jayway.restassured.RestAssured;

public class JsonAssertExample {
	
	@Test
	public void getStudents() {
		String expectedValue = new String(Files.readAllBytes(Paths.get(System.getProperty("userdir"),FileSeparator+"file.txt")));
		String actualValue = RestAssured.given().when().get("http://localhost:8080/student/list").asString();
		System.out.println(expectedValue);
		System.out.println(actualValue);
		JSONAssert.assertEquals(expectedValue,actualValue,JSONCompareMode.LENIENT);
		
	}

}
