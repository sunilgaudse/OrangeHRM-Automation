package com.tmb.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tmb.driver.DriverManager;
import com.tmb.utils.UniqueUsernameUtils;

public class OrangeHRMAdminFunctionalityPage extends BasePage{
	
	private final By addButton = By.xpath("//button[text()=' Add ']");
	private final By userRoleDropdown = By.xpath("//label[text()='User Role']/parent::div/following-sibling::div");
	private final By adminRole = By.xpath("//div[@role='option']/span[text()='Admin']");
	private final By statusDropdown = By.xpath("//label[text()='Status']/parent::div/following-sibling::div");
	private final By enableStatus = By.xpath("//div[@role='option']/span[text()='Enabled']");
	private final By textBoxEmployeeName = By.xpath("//input[@placeholder='Type for hints...']");
	private final By eNameDropDown = By.xpath("//div[@role='listbox']/div[2]");
	private final By textBoxUsername = By.xpath("//label[text()='Username']/parent::div/following-sibling::div/input");
	private final By textBoxPassword = By.xpath("//label[text()='Password']/parent::div/following-sibling::div/input");
	private final By textBoxConfirmPassword = By.xpath("//label[text()='Confirm Password']/parent::div/following-sibling::div/input");
	private final By saveButton = By.xpath("//button[text()=' Save ']");
	private final By successToastMessage = By.cssSelector("div.oxd-toast-content.oxd-toast-content--success p");
//	private final By successToastMessage =By.xpath("//div[@class='oxd-toast-content oxd-toast-content--success']/p");
	private final By countElement = By.xpath("//span[@class='oxd-text oxd-text--span']");
	private final By userCheckBox = By.xpath("//label/input[@type='checkbox']");
	private final By editButtonSelectedRow =By.xpath("//input[@type='checkbox' and @value='1']/ancestor::div[contains(@class,'oxd-table-row')]//button/i[contains(@class,'bi-pencil')]");
	
	public OrangeHRMAdminFunctionalityPage clickAddButton() {
		click(addButton,"Add user");
		return this;
	}
	public OrangeHRMAdminFunctionalityPage selectUserRole() {
		click(userRoleDropdown, "User Role Dropdown");
		new WebDriverWait(DriverManager.getDriver(),Duration.ofMillis(100))
		.until(ExpectedConditions.visibilityOfElementLocated(adminRole));
		click(adminRole,"Admin");
		return this;
	}
	public OrangeHRMAdminFunctionalityPage selectStatus() {
		click(statusDropdown, "Status Dropdown");
		new WebDriverWait(DriverManager.getDriver(), Duration.ofMillis(100))
		.until(ExpectedConditions.visibilityOfElementLocated(enableStatus));
		click(enableStatus,"Enable");
		return this;
	}
	public OrangeHRMAdminFunctionalityPage enterEmployeeName(String employeeName) {
		click(textBoxEmployeeName, "Type for Hints...");
		
		sendKeys(textBoxEmployeeName, employeeName,"Employee Name");
		new WebDriverWait(DriverManager.getDriver(), Duration.ofMillis(10))
		.until(ExpectedConditions.visibilityOfElementLocated(eNameDropDown));
		click(eNameDropDown, "Employee Name");
		return this;
	}
	public OrangeHRMAdminFunctionalityPage enterUsername(String username) {
		
		sendKeys(textBoxUsername, UniqueUsernameUtils.getuniqueUsername(username), "Username");
		return this;
	}
	public OrangeHRMAdminFunctionalityPage enterPassword(String password) {
		sendKeys(textBoxPassword, password, "Password");
		return this;
	}
	public OrangeHRMAdminFunctionalityPage enterConfirmPassword(String confirmPassword) {
		sendKeys(textBoxConfirmPassword, confirmPassword, "Confirm Password");
		return this;
	}
	public OrangeHRMAdminFunctionalityPage clickSaveButton() {
		click(saveButton, "Save Button");
		return this;
	}
	public String getSuccessToastmessgae() {
		return new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOfElementLocated(successToastMessage)).getText();
	}
	public int elemenCount() {
//		new WebDriverWait(DriverManager.getDriver(), 10).until(ExpectedConditions.visibilityOfElementLocated(countElement)).getText();
		String countText = new WebDriverWait(DriverManager.getDriver(), Duration.ofMillis(1000)).until(ExpectedConditions.visibilityOfElementLocated(countElement)).getText();
		System.out.println("String is :  "+ countText);
		return Integer.parseInt(countText.replaceAll("[^0-9]",""));
	}
	public OrangeHRMAdminFunctionalityPage selectUserCheckbox() {
		WebElement checkbox = DriverManager.getDriver().findElement(userCheckBox);
		 ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView(true);", checkbox);
		if(!checkbox.isSelected()) {
			((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].click();", checkbox);
		}
		return this;
	}
	public boolean isUserCheckoxSelected() {
		WebElement checkbox = DriverManager.getDriver().findElement(userCheckBox);
		return checkbox.isSelected();
	}
	public OrangeHRMEditUserPage clickEditButton() {
		click(editButtonSelectedRow, "Edit button for selected row");
		return new OrangeHRMEditUserPage();
	}

}
