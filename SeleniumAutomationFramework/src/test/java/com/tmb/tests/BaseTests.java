package com.tmb.tests;

import java.util.Map;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.tmb.driver.Driver;

public class BaseTests {

	protected BaseTests() {

	}

	@SuppressWarnings("unchecked")
	@BeforeMethod
	protected void setup(Object[]data) throws Exception {
		Map<String, String> map = (Map<String, String>)data[0];
		Driver.initDriver(map.get("browser"));
	}

	@AfterMethod
	protected void teardown() {
		Driver.quiteDriver();
	}
}
