package com.api.utils;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;

import com.dataProviders.api.bean.UserBean;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class CSVReaderUtility {

	private CSVReaderUtility() {

	}

	public static Iterator<UserBean> loadCSV(String pathOfCSVFile) {
		System.out.println(Thread.currentThread().getName());
		InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(pathOfCSVFile);
		
		InputStreamReader isr = new InputStreamReader(is);
		CSVReader csvReader = new CSVReader(isr);

		// Code to Map the csv to POJO

		CsvToBean<UserBean> csvToBean = new CsvToBeanBuilder(csvReader)
				.withType(UserBean.class)
				.withIgnoreEmptyLine(true).build();
		
		List<UserBean> userList = csvToBean.parse();
		return userList.iterator();
		//System.out.println(userList);
	}

}
