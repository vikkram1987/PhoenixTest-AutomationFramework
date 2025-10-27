package com.api.tests;

import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Model.UserCredentials;
import com.api.utils.ConfigManager;
import com.api.utils.SpecUtil;

import groovy.util.logging.Log;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class LoginApiTest {
	
	UserCredentials userCredentials;
	
	@BeforeMethod(description="create payload for the loagin API")
	public void setup() {
		userCredentials = new UserCredentials("iamfd", "password");
	}
	

	@Test(description = "Veifying if login api is working for FD user", groups = { "api", "regression", "smoke" })
	public void LoginApiTests() throws IOException {
		//UserCredentials userCredentials = new UserCredentials("iamfd", "password");
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
