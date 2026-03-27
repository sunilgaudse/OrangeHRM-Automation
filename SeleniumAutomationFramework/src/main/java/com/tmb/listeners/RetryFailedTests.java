package com.tmb.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.tmb.enums.ConfigProperties;
import com.tmb.utils.PropertyUtils;

public class RetryFailedTests implements IRetryAnalyzer {

	private int count =0;
	private static final int retries =1;
	@Override
	public synchronized boolean retry(ITestResult result) {
		try {
			if(PropertyUtils.get(ConfigProperties.RETRYFAILEDTESTS).equalsIgnoreCase("yes")&& (count<retries)) {
				count++;
				result.setStatus(ITestResult.FAILURE);
	            return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
