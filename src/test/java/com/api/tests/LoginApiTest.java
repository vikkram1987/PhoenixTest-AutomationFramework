package com.api.tests;

import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import com.pojo.UserCredentials;

import groovy.util.logging.Log;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;


public class LoginApiTest {
	

@Test		
	public void LoginApiTests() {
		
		baseURI="http://64.227.160.186:9000/v1";
		
		UserCredentials userCredentials=new UserCredentials("iamfd","password");
		given().baseUri(baseURI).
		contentType(ContentType.JSON).
		and().
        body(userCredentials).and().
        log().all().
        when().
        post("/login").then().log().all()
        .statusCode(200)
        .and()
        .body("message", equalTo("Success")).and()
        .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("response-schema/Login_response_schema.json"));
	}

}


