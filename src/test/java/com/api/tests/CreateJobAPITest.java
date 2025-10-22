package com.api.tests;

import org.testng.annotations.Test;

import com.api.constants.Role;
import com.api.utils.AuthTokenProvider;
import com.api.utils.ConfigManager;
import com.api.utils.SpecUtil;
import com.pojo.CreateJobPayload;
import com.pojo.Customer;
import com.pojo.CustomerAddress;
import com.pojo.CustomerProduct;
import com.pojo.Problems;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateJobAPITest {


	@Test
	public void creatJobAPITest() {
		

		Customer customer = new Customer("Vikkram", "Sasidharan", "9344086123", "", "vikkram87@gmail.com",
				"alternate@gmail.com");
		CustomerAddress customerAddress = new CustomerAddress("23", "qwerty", "22 parkside avenue", "qwert",
				"Newcastle upon Tyne", "560045", "India", "Assam");
		CustomerProduct customerProduct = new CustomerProduct("2025-07-15T23:00:00.000Z", "13231644980993",
				"13231644980996", "13231644980996", "2025-07-15T23:00:00.000Z", 3, 3);
		Problems problems=new Problems(3,"Slow phone and apps crashing");
		Problems[] problemsArray=new Problems[1];
		problemsArray[0]=problems;
		
		CreateJobPayload createJobPayload = new CreateJobPayload(0, 2, 1, 2, customer, customerAddress, customerProduct,
				problemsArray);

		given().spec(SpecUtil.requestSpecWithAuth(Role.FD, createJobPayload))
				/*
				 * .baseUri(ConfigManager.getProperty("BASE_URI")) .and()
				 * .header("Authorization", AuthTokenProvider.getToken(Role.FD))
				 * .contentType(ContentType.JSON) .body(createJobPayload)
				 */
		.and()
		.when().log().all()
		.post("job/create").then()
		.spec(SpecUtil.responseSpec());

	}

}
