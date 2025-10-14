package com.api.tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

import java.io.IOException;

import org.testng.annotations.Test;

import static com.api.utils.AuthTokenProvider.*;

import com.api.constants.Roles;
import com.api.utils.ConfigManager;

import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.module.jsv.JsonSchemaValidator;

public class UserDetailsAPITest {
	
	@Test	
	public void UserDetailsAPITest() throws IOException {
		//baseURI="http://64.227.160.186:9000/v1";
	Header authHeader=new Header("Authorization",getToken(Roles.FD));
	given().baseUri(ConfigManager.getProperty("BASE_URI")).and()
	.header(authHeader)
	.and()
	.contentType(ContentType.JSON)
	.log().all()
	.when()
	.get("/userdetails")
	.then()
    .log().all()
	.statusCode(200)
	.time(lessThan(1500l))
	.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("response-schema/UserDetailsResponse_schema.json"));
		
	}

}
