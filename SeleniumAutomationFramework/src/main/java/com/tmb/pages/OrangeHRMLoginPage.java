package com.tmb.pages;

import org.openqa.selenium.By;

import com.tmb.driver.DriverManager;

public final class OrangeHRMLoginPage extends BasePage{
	
	private final By textboxUsername = By.xpath("//input[@name='username']");
	private final By textboxPassword =By.xpath("//input[@name='password' and @type='password'] ");
	private final By buttonLogin = By.xpath("//button[text()=' Login ']");
	
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
	public String getTitle() {
		return getPageTitle();
	}
}
