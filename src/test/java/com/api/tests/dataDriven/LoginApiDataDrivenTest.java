package com.api.tests.dataDriven;

import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Model.UserCredentials;
import com.api.utils.ConfigManager;
import com.api.utils.SpecUtil;
import com.dataProviders.api.bean.UserBean;

import groovy.util.logging.Log;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class LoginApiDataDrivenTest {
	


	@Test(description = "Veifying if login api is working for FD user", 
	groups = { "api", "regression", "smoke" },
	dataProviderClass=com.dataProviders.dataproviderUtils.class,
	dataProvider="loginAPIDataProvider"
	)
	public void LoginApiTest(UserBean userBean) throws IOException {
		given().spec(SpecUtil.requestSpec(userBean))
				.post("login").then()
				.spec(SpecUtil.responseSpec())
				.body("message", equalTo("Success")).and()
				.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("response-schema/Login_response_schema.json"));
	}

}
