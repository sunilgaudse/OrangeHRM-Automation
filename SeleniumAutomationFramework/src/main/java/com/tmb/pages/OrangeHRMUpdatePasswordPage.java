package com.tmb.pages;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tmb.driver.DriverManager;

public final class OrangeHRMUpdatePasswordPage extends BasePage{
	private final By currentPassword = By.xpath("//label[text()='Current Password']/following::input[1]");
	private final By newPassword = By.xpath("//label[text()='Password']/following::input[1]");
	private final By confirmPassword =By.xpath("//label[text()='Confirm Password']/following::input[1]");
	private final By saveButton =By.xpath("//button[@type='submit']"); 
	private final By successToastMessage = By.cssSelector("div.oxd-toast-content.oxd-toast-content--success p");
	
	public OrangeHRMUpdatePasswordPage enterCurrentPassword(String password) {
		sendKeys(currentPassword, password,"Current Password");
		return this;
	}
	public OrangeHRMUpdatePasswordPage enterNewPassword(String password) {
		sendKeys(newPassword, password,"New Password");
		return this;
	}
	public OrangeHRMUpdatePasswordPage enterConfirmPassword(String password) {
		sendKeys(confirmPassword, password,"Confirm Password");
		return this;
	}
	public OrangeHRMUpdatePasswordPage clickSaveButton() {
		click(saveButton, "Save Button");
		return this;
	}
	public String getSuccessToastmessgae() {
		return new WebDriverWait(DriverManager.getDriver(),10).until(ExpectedConditions.visibilityOfElementLocated(successToastMessage)).getText();
	}
}
