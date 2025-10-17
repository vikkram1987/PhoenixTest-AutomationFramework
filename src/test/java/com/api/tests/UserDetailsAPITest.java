package com.api.tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

import java.io.IOException;

import org.testng.annotations.Test;

import static com.api.utils.AuthTokenProvider.*;

import static com.api.constants.Role.*;
import com.api.utils.ConfigManager;
import com.api.utils.SpecUtil;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.module.jsv.JsonSchemaValidator;

public class UserDetailsAPITest {
	
	@Test	
	public void UserDetailsAPITest() throws IOException {

	given().spec(SpecUtil.requestSpecWithAuth(FD))
	.when()
	.get("/userdetails")
	.then()
    .spec(SpecUtil.responseSpec())
    .and()
	.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("response-schema/UserDetailsResponse_schema.json"));
		
	}

}
