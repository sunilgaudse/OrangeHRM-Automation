package com.tmb.reports;

import com.aventstack.extentreports.ExtentTest;

public class ExtentManager {
	private ExtentManager() {
		
	}
	private static ThreadLocal<ExtentTest> extTest = new ThreadLocal<>();
	
	static ExtentTest getTest() {
		return extTest.get();
	}
	static void setTest(ExtentTest test) {
		extTest.set(test);
	}
	static void unload() {
		extTest.remove();
	}
	
}
