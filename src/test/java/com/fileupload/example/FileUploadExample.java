package com.fileupload.example;

import static org.hamcrest.Matchers.*;
import static com.jayway.restassured.RestAssured.*;

import java.io.File;

import org.junit.Test;

import static com.jayway.restassured.RestAssured.*;

public class FileUploadExample {
	
	@Test
	public void uploadFileExample() {
		
		String apiKey = "498685ea6ca398dbac6dd852860e0df631f54e9c";
		
		File inputFile = new File(System.getProperty("user.dir")+File.separator+"Presentation1.pptx");
		System.out.println(inputFile.length());
		String endpoint = "https://sandbox.zamzar.com/v1/jobs";
		
		given()
		.auth()
		.basic(apiKey,"")
		.multiPart("source_file",inputFile)
		.multiPart("target_format","png")
		.when()
		.post(endpoint)
		.then()
		.log()
		.all();
		
	}

}
