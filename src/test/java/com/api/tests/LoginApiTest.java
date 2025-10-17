package com.api.tests;

import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;

import java.io.IOException;

import org.testng.annotations.Test;

import com.api.utils.ConfigManager;
import com.api.utils.SpecUtil;
import com.pojo.UserCredentials;

import groovy.util.logging.Log;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class LoginApiTest {

	@Test
	public void LoginApiTests() throws IOException {
		System.out.println(System.getProperty("env"));
		UserCredentials userCredentials = new UserCredentials("iamfd", "password");
		given().spec(SpecUtil.requestSpec(userCredentials))
				/*
				 * .baseUri(ConfigManager.getProperty("BASE_URI"))
				 * .contentType(ContentType.JSON)
				 * 
				 * .body(userCredentials)
				 */
				.post("login").then().spec(SpecUtil.responseSpec()).body("message", equalTo("Success")).and()
				.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("response-schema/Login_response_schema.json"));
	}

}
