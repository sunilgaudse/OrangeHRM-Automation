package com.tmb.listeners;
import java.io.IOException;
import java.util.Arrays;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.tmb.reports.ExtentLogger;
import com.tmb.reports.ExtentReport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public  class ListenerClass implements ITestListener ,ISuiteListener{
public static Logger logger = LoggerFactory.getLogger(ListenerClass.class);
	private static int counter =1;

	@Override
	public void onStart(ISuite suite) {
		try {
			ExtentReport.initReports();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	

	@Override
	public void onFinish(ISuite suite) {
		try {
			ExtentReport.flushReport();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
 			e.printStackTrace();
		}
	}

	@Override
	public void onTestStart(ITestResult result) {
		String name = result.getMethod().getMethodName();
		String numberString = String.format("%02d", counter++);
		ExtentReport.createTests(numberString+". "+name);
		logger.info("STARTED: " + result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentLogger.pass(result.getMethod().getMethodName()+ " is passed.");
		logger.info("PASSED: " + result.getMethod().getMethodName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		try {
			ExtentLogger.fail(result.getMethod().getMethodName()+ " is failed.",true);
			ExtentLogger.fail(result.getThrowable().toString());
			ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));
			logger.error("FAILED: " + result.getMethod().getMethodName());
	        logger.error("Reason: ", result.getThrowable());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentLogger.skip(result.getMethod().getMethodName()+ " is skip.");
		logger.warn("SKIPPED: " + result.getMethod().getMethodName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	
	

}
