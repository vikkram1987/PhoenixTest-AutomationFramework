package com.api.utils;

import static io.restassured.RestAssured.*;

import com.api.constants.Roles;
import com.pojo.UserCredentials;

import io.restassured.http.ContentType;

public class AuthTokenProvider {

	private AuthTokenProvider() {

	}

	public static String getToken(Roles role) {
		UserCredentials userCred = null;
		if(role==Roles.FD) {
			userCred = new UserCredentials("iamfd", "password");
		}
		else if(role==Roles.SUP) {
			userCred = new UserCredentials("iamsup", "password");
		}
		else if(role==Roles.ENG) {
			userCred = new UserCredentials("iameng", "password");
		}
		else if(role==Roles.QC) {
			userCred = new UserCredentials("iamqc", "password");
		}

		// MAke login request to generate tolen and extract

		String token = given().baseUri(ConfigManager.getProperty("BASE_URI")).contentType(ContentType.JSON)
				.body(userCred).when().post("login").then().log().all().extract().body()
				.jsonPath().getString("data.token");

		return token;

	}

}
