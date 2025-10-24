package com.api.tests;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.api.constants.Model;
import com.api.constants.Product;
import com.api.constants.Role;
import com.api.utils.AuthTokenProvider;
import com.api.utils.ConfigManager;
import com.api.utils.DateTimeUtil;
import com.api.utils.SpecUtil;
import com.pojo.CreateJobPayload;
import com.pojo.Customer;
import com.pojo.CustomerAddress;
import com.pojo.CustomerProduct;
import com.pojo.Problems;

import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

public class CreateJobAPITest {


	@Test
	public void creatJobAPITest() {
		

		Customer customer = new Customer("Vikkram", "Sasidharan", "9344086123", "", "vikkram87@gmail.com",
				"alternate@gmail.com");
		CustomerAddress customerAddress = new CustomerAddress("23", "qwerty", "22 parkside avenue", "qwert",
				"Newcastle upon Tyne", "560045", "India", "Assam");
		CustomerProduct customerProduct = new CustomerProduct(DateTimeUtil.getTimeWithDaysAgo(10), "13231644980993",
				"13231644980903", "13231644980903", DateTimeUtil.getTimeWithDaysAgo(10), Product.NEXUS_2.getCode(), Model.NEXUS_2_BLUE.getCode());
		Problems problems=new Problems(3,"Slow phone and apps crashing");
		List<Problems> problemsList=new ArrayList<Problems>();
		problemsList.add(problems);
		
		CreateJobPayload createJobPayload = new CreateJobPayload(0, 2, 1, 2, customer, customerAddress, customerProduct,
				problemsList);

		given().spec(SpecUtil.requestSpecWithAuth(Role.FD, createJobPayload))
				/*
				 * .baseUri(ConfigManager.getProperty("BASE_URI")) .and()
				 * .header("Authorization", AuthTokenProvider.getToken(Role.FD))
				 * .contentType(ContentType.JSON) .body(createJobPayload)
				 */
		.and()
		.when().log().all()
		.post("job/create").then()
		.spec(SpecUtil.responseSpec())
		.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("response-schema/CreatJobApiResponse_schema.json"))
		.body("message",Matchers.equalTo("Job created successfully. "))
		.body("data.mst_service_location_id",Matchers.equalTo(1))
		.body("data.mst_platform_id",Matchers.equalTo(2))
		.body("data.mst_warrenty_status_id",Matchers.equalTo(1))
		.body("data.job_number",Matchers.startsWith("JOB"));
		

	}

}
