package com.api.tests;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.api.constants.Roles;
import com.api.utils.AuthTokenProvider;
import com.api.utils.ConfigManager;

import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;

import static com.api.utils.ConfigManager.getProperty;
import static io.restassured.RestAssured.*;

public class MasterAPITest {

@Test
	public void MasterAPI() {
	
	given().baseUri(ConfigManager.getProperty("BASE_URI"))
	.contentType(ContentType.JSON)
	.header("Authorization",AuthTokenProvider.getToken(Roles.FD))
	.log().all()
	.when()
	.post("master")
	.then()
	.log().all()
	.statusCode(200)
	.body("message", Matchers.equalTo("Success"))
	.time(Matchers.lessThan(1000L))
	.body("data",Matchers.not(Matchers.notNullValue()))
	.body("data", Matchers.hasKey("mst_oem"))
	.body("data", Matchers.hasKey("mst_model"))
	.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("response-schema/MasterAPIResponse_schema.json"));
	}

@Test
public void countAPITest_MissingAuthToken() {
	  given().baseUri(getProperty("BASE_URI"))
		.contentType(ContentType.JSON)
		.and()
//		.header("Authorization", getToken(Roles.FD))
//		.and()
		.when()
		.post("master")
		.then()
		.log().all()
		.statusCode(401)
		.statusLine("HTTP/1.1 401 Unauthorized");
}

}
