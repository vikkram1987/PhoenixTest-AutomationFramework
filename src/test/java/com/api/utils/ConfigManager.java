package com.api.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.management.RuntimeErrorException;

public class ConfigManager {
	// Program to read the file properties file from
	// src/test/resources/Config/config.properties

	private static Properties prop = new Properties();
	public static String path;
	private static String env;

	private ConfigManager() {
		// This constructer restricts creating object for ConfigManager Class
	}

	static {
		env = System.getProperty("env");
		if (env == null) {

			env = "qa";
		}

		env = env.toLowerCase().trim();

		switch (env) {
		/*
		 * case "dev":{ path= "Config/config.dev.properties"; break;
		 */

		case "dev" -> path = "Config/config.dev.properties";

		case "qa" -> path = "Config/config.qa.properties";

		case "uat" -> path = "Config/config.dev.properties";

		default -> path = "Config/config.dev.properties";

		}

		InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream(path);

		if (input == null) {
			throw new RuntimeException("Cannot find the file in the path" + path);
		}
		try {
			prop.load(input);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String getProperty(String key) {

		return prop.getProperty(key);

	}

}
