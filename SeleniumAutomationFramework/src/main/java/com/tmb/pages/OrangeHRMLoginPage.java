package com.tmb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tmb.driver.DriverManager;

public final class OrangeHRMLoginPage extends BasePage{
	
	private final By textboxUsername = By.xpath("//input[@name='username']");
	private final By textboxPassword =By.xpath("//input[@name='password' and @type='password'] ");
	private final By buttonLogin = By.xpath("//button[text()=' Login ']");
	private final By errorMessageElement = By.xpath("//p[text()='Invalid credentials']");
	public OrangeHRMLoginPage enterUsername(String username) {
		sendKeys(textboxUsername, username, "Username");
		return this;
	}
	
	public OrangeHRMLoginPage enterPassword(String password) {
		sendKeys(textboxPassword, password,"Password");
		return this;
	}
	
	public OrangeHRMHomePage clickLogin() {
		click(buttonLogin,"login button");
		return new OrangeHRMHomePage();
	}
	public OrangeHRMLoginPage clickLogin1() {
		click(buttonLogin,"login button");
		return this;
	}
	public String getTitle() {
		return getPageTitle();
	}
	public String errorMessageText() {
		new WebDriverWait(DriverManager.getDriver(), 15000)
		.until(ExpectedConditions.visibilityOfElementLocated(errorMessageElement));
		String errorMessage=DriverManager.getDriver().findElement(errorMessageElement).getText();
		System.out.println(errorMessage);
		
		return errorMessage;
	}
}
