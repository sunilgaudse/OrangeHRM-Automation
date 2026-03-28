package com.tmb.pages;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tmb.driver.DriverManager;
import com.tmb.reports.ExtentLogger;

public class BasePage {
	public static Logger logger = LoggerFactory.getLogger(BasePage.class);
	protected void click(By by,String elementName) {
		DriverManager.getDriver().findElement(by).click();
		try {
			ExtentLogger.pass(elementName + " clicked.", true);
			logger.info(elementName + " clicked.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	protected void sendKeys(By by, String value,String elementName) {
		DriverManager.getDriver().findElement(by).sendKeys(value);
		try {
			ExtentLogger.pass(value +" is entered successfully in "+ elementName, true);
			logger.info(value +" is entered successfully in "+ elementName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	protected String getPageTitle() {
		return DriverManager.getDriver().getTitle();
	}
	
}
