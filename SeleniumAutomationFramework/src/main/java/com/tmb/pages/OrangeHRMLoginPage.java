package com.tmb.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tmb.driver.DriverManager;

public final class OrangeHRMLoginPage extends BasePage{
	
	private final By textboxUsername = By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input");
	private final By textboxPassword =By.xpath("//input[@name='password' and @type='password'] ");
	private final By buttonLogin = By.xpath("//button[@type='submit']");
	private final By errorMessageElement = By.xpath("//p[text()='Invalid credentials']");
	private final By requiredElement =By.xpath("//span[text()='Required']");
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
		new WebDriverWait(DriverManager.getDriver(), Duration.ofMillis(15000))
		.until(ExpectedConditions.visibilityOfElementLocated(errorMessageElement));
		return DriverManager.getDriver().findElement(errorMessageElement).getText();
	}
	public String requiredText() {
		return DriverManager.getDriver().findElement(requiredElement).getText();
	}
}
