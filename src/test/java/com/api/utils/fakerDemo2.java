package com.api.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import com.Model.CreateJobPayload;
import com.Model.Customer;
import com.Model.CustomerAddress;
import com.Model.CustomerProduct;
import com.Model.Problems;
import com.github.javafaker.Country;
import com.github.javafaker.Faker;
import com.github.javafaker.PhoneNumber;

public class fakerDemo2 {

	public static void main(String[] args) {
//to create fake testdata creation using faker library
		Locale local = new Locale("en-IND");
		Faker faker = new Faker(local);
		String fName = faker.name().firstName();
		String lName = faker.name().lastName();
		String mobileNo = faker.numerify("934#######");
		String altMobileNo = faker.numerify("860#######");
		String emailId = faker.internet().emailAddress();
		String altemailId = faker.internet().emailAddress();
		String flatno=faker.numerify("###");
	//	String aptName=faker.address().streetName();)
		String streetName=faker.address().streetName();
		String landmark=faker.letterify("???????");
		String state=faker.address().state();
		String area=faker.address().cityName();
		String country=faker.address().country();
		String pincode=faker.numerify("####");
		String aptName = faker.address().streetName();
		String dop=DateTimeUtil.getTimeWithDaysAgo(5);
		String serialNo=faker.numerify("###############");
		//String imei1=faker.numerify("###############");
		//String imei2=faker.numerify("###############");
		String popUrl=faker.internet().url();
		String remark=faker.lorem().sentence(4);
		
		Random random=new Random();
		int problemId=random.nextInt(27)+1;
		
        Customer customer = new Customer(fName, lName, mobileNo, altMobileNo, emailId, altemailId);

		System.out.println(customer);
		
	CustomerAddress	customerAddress=new CustomerAddress(flatno, aptName, streetName, landmark, area, pincode, country, state);
	
	System.out.println(customerAddress);
	
	CustomerProduct customerProduct=new CustomerProduct(dop, serialNo, serialNo, serialNo, popUrl, 1, 1);
	
	System.out.println(customerProduct);
	
	Problems problems = new Problems(problemId,remark );
	
	System.out.println(problems);
	
	List<Problems> problemList=new ArrayList<Problems>();
	problemList.add(problems);
	
	CreateJobPayload payload=new CreateJobPayload(0, 2, 1, 1, customer, customerAddress, customerProduct, problemList);
	
	System.out.println(payload);
	}

}
