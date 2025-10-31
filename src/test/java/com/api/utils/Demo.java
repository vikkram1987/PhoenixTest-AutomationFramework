package com.api.utils;

import java.util.Iterator;

import com.dataProviders.api.bean.CreateJobBean;
import com.dataProviders.api.bean.UserBean;

public class Demo {

	public static void main(String[] args) {
		Iterator<CreateJobBean> iterator = CSVReaderUtility.loadCSV("testData/CreateJobData.csv", CreateJobBean.class);
		
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}

	}

}
