package com.api.utils;

import org.hamcrest.Matchers;

import com.Model.UserCredentials;
import com.api.constants.Role;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecUtil {

//GET Method 
	public static RequestSpecification requestSpec() {
		//will takecare of common request methods
		
		RequestSpecification request = new RequestSpecBuilder()
		.setBaseUri(ConfigManager.getProperty("BASE_URI"))
		.setContentType(ContentType.JSON)
		.setAccept(ContentType.JSON)
		.log(LogDetail.URI)
		.log(LogDetail.HEADERS)
		.log(LogDetail.METHOD)
		.log(LogDetail.BODY)
		.build();
		
		return request;
	}
	
	public static RequestSpecification requestSpec(Object payload) {
		//will takecare of common request methods
		
		RequestSpecification requestSpecification = new RequestSpecBuilder()
		.setBaseUri(ConfigManager.getProperty("BASE_URI"))
		.setContentType(ContentType.JSON)
		.setAccept(ContentType.JSON)
		.setBody(payload)
		.log(LogDetail.URI)
		.log(LogDetail.HEADERS)
		.log(LogDetail.METHOD)
		.log(LogDetail.BODY)
		.build();
		
		return requestSpecification;
	}
	
	
	public static ResponseSpecification responseSpec() {
	ResponseSpecification responseSpecification = new ResponseSpecBuilder()
		.expectContentType(ContentType.JSON)
		.expectStatusCode(200)
		.expectResponseTime(Matchers.lessThan(1000L))
		.log(LogDetail.ALL)
		.build();
		
		return responseSpecification;
	}
	
	public static RequestSpecification requestSpecWithAuth(Role role) {
		RequestSpecification requestSpecification = new RequestSpecBuilder()
		.setBaseUri(ConfigManager.getProperty("BASE_URI"))
		.setContentType(ContentType.JSON)
		.setAccept(ContentType.JSON)
		.addHeader("Authorization",AuthTokenProvider.getToken(role))
		.log(LogDetail.URI)
		.log(LogDetail.HEADERS)
		.log(LogDetail.METHOD)
		.log(LogDetail.BODY)
		.build();
		
		return requestSpecification;
		
	}
	
	
	public static RequestSpecification requestSpecWithAuth(Role role,Object payload) {
		RequestSpecification requestSpecification = new RequestSpecBuilder()
		.setBaseUri(ConfigManager.getProperty("BASE_URI"))
		.setContentType(ContentType.JSON)
		.setAccept(ContentType.JSON)
		.addHeader("Authorization",AuthTokenProvider.getToken(role))
		.setBody(payload)
		.log(LogDetail.URI)
		.log(LogDetail.HEADERS)
		.log(LogDetail.METHOD)
		.log(LogDetail.BODY)
		.build();
		
		return requestSpecification;
		
	}
	
	
}
