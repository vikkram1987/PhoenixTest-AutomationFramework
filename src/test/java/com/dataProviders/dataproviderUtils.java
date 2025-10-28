package com.dataProviders;

import java.util.Iterator;

import org.testng.annotations.DataProvider;

import com.api.utils.CSVReaderUtility;
import com.dataProviders.api.bean.UserBean;

public class dataproviderUtils {
	
	@DataProvider(name="loginAPIDataProvider",parallel=true)
	public static Iterator<UserBean> loginAPIDataProvider() {
		return CSVReaderUtility.loadCSV("testData/LoginCreds.csv");
		
	}

}
