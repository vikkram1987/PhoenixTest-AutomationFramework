package com.demo.csv;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class ReadCsvFile {

	public static void main(String[] args) throws IOException, CsvException {

		InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("TestData/LoginCreds.csv");

		/*
		 * File csvFile=new File(
		 * "C:\\Users\\VikkramSasidharan\\Desktop\\workspace\\PhoenixTestAutomationFramework\\src\\main\\resources\\TestData\\LoginCreds.csv"
		 * ); FileReader fileReader=new FileReader(csvFile);
		 */
		InputStreamReader isr = new InputStreamReader(is);
		CSVReader csvReader = new CSVReader(isr);// needs a reader

		List<String[]> dataList = csvReader.readAll();
		for (String[] dataArray : dataList) {
			for (String data : dataArray) {
				System.out.print(data + " ");
			}
			System.out.println("");

		}
	}

}
