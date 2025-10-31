package com.dataProviders;

import java.util.Iterator;

import org.testng.annotations.DataProvider;

import com.api.utils.CSVReaderUtility;
import com.dataProviders.api.bean.CreateJobBean;
import com.dataProviders.api.bean.UserBean;

public class dataproviderUtils {
	
	@DataProvider(name="loginAPIDataProvider",parallel=true)
	public static Iterator<UserBean> loginAPIDataProvider() {
		return CSVReaderUtility.loadCSV("testData/LoginCreds.csv",UserBean.class);
		
	}
	
	@DataProvider(name="CreateJobAPIDataProvider",parallel=true)
	public static void CreateJobAPIDataProvider() {
		Iterator<CreateJobBean> createJobBeanIterator = CSVReaderUtility.loadCSV("testData/CreateJobData.csv",CreateJobBean.class);
	}

}
