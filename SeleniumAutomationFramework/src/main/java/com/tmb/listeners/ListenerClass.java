package com.tmb.listeners;
import java.io.IOException;
import java.util.Arrays;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.tmb.reports.ExtentLogger;
import com.tmb.reports.ExtentReport;

public class ListenerClass implements ITestListener ,ISuiteListener{
//public static Logger logger = LogManager.getLogger(ListenerClass.class);

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
		ExtentReport.createTests(result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentLogger.pass(result.getMethod().getMethodName()+ " is passed.");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		try {
			ExtentLogger.fail(result.getMethod().getMethodName()+ " is failed.",true);
			ExtentLogger.fail(result.getThrowable().toString());
			ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentLogger.skip(result.getMethod().getMethodName()+ " is skip.");
	}

	
	

}
