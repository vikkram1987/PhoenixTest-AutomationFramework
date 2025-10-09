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
	public static String path="config/config.properties";

	private ConfigManager() {
		// This constructer restricts creating object for ConfigManager Class
	}

	static {
	  InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
	  
	  if(input==null) {
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
