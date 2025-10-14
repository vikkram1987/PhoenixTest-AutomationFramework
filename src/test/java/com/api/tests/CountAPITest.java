package com.api.tests;

import static com.api.utils.AuthTokenProvider.getToken;
import static com.api.utils.ConfigManager.getProperty;
import static io.restassured.RestAssured.given;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.api.constants.Roles;

import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;

public class CountAPITest {
   
  @Test    
	public void getCountAPI() {
		given().baseUri(getProperty("BASE_URI"))
		.contentType(ContentType.JSON)
		.and()
		.header("Authorization", getToken(Roles.FD))
		.and()
		.when()
		.get("dashboard/count")
		.then()
		.log().all()
		.statusCode(200)
		.body("message", Matchers.equalTo("Success"))
		.time(Matchers.lessThan(1000L))
		.body("data.size()",Matchers.equalTo(3))
		.body("data.count",Matchers.everyItem(Matchers.greaterThanOrEqualTo(0)))
		.body("data.label",Matchers.everyItem(Matchers.not(Matchers.blankOrNullString())))
		.body("data.key", Matchers.containsInAnyOrder("pending_for_delivery","pending_fst_assignment","created_today"))
		.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("response-schema/CountAPIResponse_schema.json"));
		
	}
  
  @Test
  public void countAPITest_MissingAuthToken() {
	  given().baseUri(getProperty("BASE_URI"))
		.contentType(ContentType.JSON)
		.and()
//		.header("Authorization", getToken(Roles.FD))
//		.and()
		.when()
		.get("dashboard/count")
		.then()
		.log().all()
		.statusCode(401)
		.statusLine("HTTP/1.1 401 Unauthorized");
  }
}
