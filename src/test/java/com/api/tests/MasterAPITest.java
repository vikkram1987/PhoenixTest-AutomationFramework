package com.api.tests;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.api.constants.Role;

import com.api.utils.AuthTokenProvider;
import com.api.utils.ConfigManager;
import com.api.utils.SpecUtil;

import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;

import static com.api.utils.ConfigManager.getProperty;
import static io.restassured.RestAssured.*;

public class MasterAPITest {

@Test
	public void MasterAPI() {
	
	given()
	.spec(SpecUtil.requestSpecWithAuth(Role.FD))
	.when()
	.post("master")
	.then()
    .spec(SpecUtil.responseSpec())
	.body("data", Matchers.hasKey("mst_oem"))
	.body("data", Matchers.hasKey("mst_model"));

	}

@Test
public void MasterAPITest_MissingAuthToken() {
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
