package com.demo.csv;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvException;

public class ReadcsvFile_mapToPOJO {

	public static void main(String[] args) throws IOException, CsvException {
		System.out.println(Thread.currentThread().getName());
		InputStream is = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("TestData/LoginCreds.csv");
		InputStreamReader isr = new InputStreamReader(is);
		CSVReader csvReader = new CSVReader(isr);

		// Code to Map the csv to POJO
		
		  CsvToBean<UserBean> csvToBean = new CsvToBeanBuilder(csvReader)
		  .withType(UserBean.class)
		  .withIgnoreEmptyLine(true).build();
		  List<UserBean> userList = csvToBean.parse();
		  System.out.println(userList);
		 
		  
			/*
			 * Part                                     What It Does  
			 *new CsvToBeanBuilder<UserPOJO>(csvReader) Creates a builder that will convert CSV rows into UserPOJO objects.
			 * .withType(UserPOJO.class)                Specifies which class represents each CSV row.
			 * .withIgnoreEmptyLine(true)               Tells OpenCSV to skip blank lines in the file.
			 * .build()                                 Finalizes setup and creates a CsvToBean<UserPOJO> ready to parse.
			 */

	}

}
