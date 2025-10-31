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

	public static <T> Iterator<T> loadCSV(String pathOfCSVFile,Class<T> bean ) {
		System.out.println(Thread.currentThread().getName());
		InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(pathOfCSVFile);

		InputStreamReader isr = new InputStreamReader(is);
		CSVReader csvReader = new CSVReader(isr);

		// Code to Map the csv to POJO
	//	Class<UserBean> bean1 = UserBean.class;
		CsvToBean<T> csvToBean = new CsvToBeanBuilder(csvReader)
				.withType(bean).withIgnoreEmptyLine(true)
				.build();

		List<T> list = csvToBean.parse();
		return list.iterator();
		// System.out.println(userList);
	}

}
