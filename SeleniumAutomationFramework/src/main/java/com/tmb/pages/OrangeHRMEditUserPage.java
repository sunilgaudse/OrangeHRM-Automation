package com.tmb.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tmb.driver.DriverManager;
import com.tmb.utils.UniqueUsernameUtils;

public class OrangeHRMEditUserPage extends BasePage{
	
	private final By userRoleDropdown = By.xpath("//label[text()='User Role']/parent::div/following-sibling::div");
	private final By adminRole = By.xpath("//div[@role='option']/span[text()='ESS']");
	private final By statusDropdown = By.xpath("//label[text()='Status']/parent::div/following-sibling::div");
	private final By enableStatus = By.xpath("//div[@role='option']/span[text()='Enabled']");
	private final By textBoxEmployeeName = By.xpath("//input[@placeholder='Type for hints...']");
	private final By eNameDropDown = By.xpath("//div[@role='listbox']/div[2]");
	private final By textBoxUsername = By.xpath("//label[text()='Username']/parent::div/following-sibling::div/input");
	private final By textBoxPassword = By.xpath("//label[text()='Password']/parent::div/following-sibling::div/input");
	private final By textBoxConfirmPassword = By.xpath("//label[text()='Confirm Password']/parent::div/following-sibling::div/input");
	private final By saveButton = By.xpath("//button[text()=' Save ']");
	private final By successToastMessage = By.cssSelector("div.oxd-toast-content.oxd-toast-content--success p");
	
	public OrangeHRMEditUserPage selectUserRole() {
		click(userRoleDropdown, "User Role Dropdown");
		new WebDriverWait(DriverManager.getDriver(), Duration.ofMillis(1000))
		.until(ExpectedConditions.visibilityOfElementLocated(adminRole));
		click(adminRole,"Admin");
		return this;
	}
	public OrangeHRMEditUserPage selectStatus() {
		click(statusDropdown, "Status Dropdown");
		new WebDriverWait(DriverManager.getDriver(), Duration.ofMillis(1000))
		.until(ExpectedConditions.visibilityOfElementLocated(enableStatus));
		click(enableStatus,"Enable");
		return this;
	}
	public OrangeHRMEditUserPage enterEmployeeName(String employeeName) {
		click(textBoxEmployeeName, "Type for Hints...");
		
		sendKeys(textBoxEmployeeName, employeeName,"Employee Name");
		new WebDriverWait(DriverManager.getDriver(), Duration.ofMillis(1000))
		.until(ExpectedConditions.visibilityOfElementLocated(eNameDropDown));
		click(eNameDropDown, "Employee Name");
		return this;
	}
	public OrangeHRMEditUserPage enterUsername(String username) {
		
		sendKeys(textBoxUsername, UniqueUsernameUtils.getuniqueUsername(username), "Username");
		return this;
	}
	public OrangeHRMEditUserPage clickSaveButton() {
		click(saveButton, "Save Button");
		return this;
	}
	public String getSuccessToastmessgae() {
		return new WebDriverWait(DriverManager.getDriver(), Duration.ofMillis(1000)).until(ExpectedConditions.visibilityOfElementLocated(successToastMessage)).getText();
	}
}
