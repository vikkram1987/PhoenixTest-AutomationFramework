package com.api.tests;

import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;

import java.io.IOException;

import org.testng.annotations.Test;

import com.api.utils.ConfigManager;
import com.pojo.UserCredentials;

import groovy.util.logging.Log;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class LoginApiTest {

	@Test
	public void LoginApiTests() throws IOException {


		// baseURI="http://64.227.160.186:9000/v1";
        System.out.println(System.getProperty("env"));
		UserCredentials userCredentials = new UserCredentials("iamfd", "password");
		given().baseUri(ConfigManager.getProperty("BASE_URI")).
		contentType(ContentType.JSON)
		.and().body(userCredentials)
		.and().log().all().when().post("login").then().log().all().statusCode(200).and()
		.body("message", equalTo("Success")).and()
		.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("response-schema/Login_response_schema.json"));
	}

}
