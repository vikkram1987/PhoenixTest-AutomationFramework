package com.api.tests;

import static com.api.utils.AuthTokenProvider.getToken;
import static com.api.utils.ConfigManager.getProperty;
import static io.restassured.RestAssured.given;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.api.constants.Role;
import com.api.utils.SpecUtil;

import groovyjarjarpicocli.CommandLine.Spec;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;

public class CountAPITest {
   
  @Test    
	public void getCountAPI() {
		given()
		.spec(SpecUtil.requestSpecWithAuth(Role.FD))
		.get("dashboard/count")
		.then()
		.spec(SpecUtil.responseSpec())
		.body("message", Matchers.equalTo("Success"))
		.body("data.size()",Matchers.equalTo(3))
		.body("data.count",Matchers.everyItem(Matchers.greaterThanOrEqualTo(0)))
		.body("data.label",Matchers.everyItem(Matchers.not(Matchers.blankOrNullString())))
		.body("data.key", Matchers.containsInAnyOrder("pending_for_delivery","pending_fst_assignment","created_today"))
		.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("response-schema/CountAPIResponse_schema.json"));
		
	}
  
  @Test
  public void countAPITest_MissingAuthToken() {
		given()
		.spec(SpecUtil.requestSpec())
		.when()
		.get("dashboard/count")
		.then()
		.log().all()
		.statusCode(401)
		.statusLine("HTTP/1.1 401 Unauthorized");
  }
}
