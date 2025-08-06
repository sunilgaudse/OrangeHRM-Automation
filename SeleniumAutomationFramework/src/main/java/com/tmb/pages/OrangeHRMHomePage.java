  package com.tmb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tmb.driver.DriverManager;
import com.tmb.reports.ExtentLogger;
import com.tmb.reports.ExtentManager;
import com.tmb.reports.ExtentReport;

public final class OrangeHRMHomePage extends BasePage{
	private final By profileName = By.className("oxd-userdropdown-name");
	private final By logout = By.className("oxd-userdropdown-link");
	private final By changePassword =By.xpath("//a[text()='Change Password']");
	private final LeftMenuComponent leftMenuComponent;
	
	public OrangeHRMHomePage() {
		this.leftMenuComponent = new LeftMenuComponent();
	}
	
	
	public OrangeHRMHomePage clickWelcome() {
		click(profileName,"profile name");
		return this;
	}
	public OrangeHRMUpdatePasswordPage clickChangePassword() {
		click(changePassword, "Change Password");
		return new OrangeHRMUpdatePasswordPage();
	}
	public OrangeHRMLoginPage clickLogout() {
		new WebDriverWait(DriverManager.getDriver(), 10)
			.until(ExpectedConditions.elementToBeClickable(logout));// old fashioned way.
		//wait.until(d->d.findElement(logout).isEnabled());//Java 8 way.
		click(logout,"logout button");
		return new OrangeHRMLoginPage();
	}
	public OrangeHRMAdminFunctionalityPage navigateToAddCustomerPage() {
		leftMenuComponent.setLinkMainMenu("Admin");
		return new OrangeHRMAdminFunctionalityPage();
	}

}
