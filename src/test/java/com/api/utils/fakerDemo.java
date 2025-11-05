package com.api.utils;

import java.util.Locale;

import com.github.javafaker.Faker;

public class fakerDemo {

	public static void main(String[] args) {
//to create fake testdata creation using faker library
		Locale local=new Locale("en-IND");
		Faker faker=new Faker(local);
		faker.address();
	
		String firstname = faker.name().firstName();
		String country=faker.address().country();
		System.out.println(country);
		System.out.println(firstname);
		String mailId = faker.internet().emailAddress();
		System.out.println(mailId);

	}

}
