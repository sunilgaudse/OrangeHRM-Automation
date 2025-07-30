package com.tmb.tests;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.tmb.annotations.Sheet;
import com.tmb.listeners.MethodInterceptor;
import com.tmb.pages.OrangeHRMLoginPage;
import com.tmb.reports.ExtentLogger;

@Listeners(MethodInterceptor.class)
@Sheet("USERACCOUNTMANAGEMENTDATA")
public class UserAccountManagementTest extends BaseTests{
	private UserAccountManagementTest() {
		
	}
	
	@Test
	public void verifyThatUserCanChangePasswordWithValidCredentials(Map<String, String>data) {
		try {
			ExtentLogger.pass("Test is running in "+ data.get("browser") +" browser." , true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String toastMessgae =new OrangeHRMLoginPage().enterUsername(data.get("username")).enterPassword(data.get("password")).clickLogin().clickWelcome().clickChangePassword()
				.enterCurrentPassword(data.get("currentpassword")).enterNewPassword(data.get("newpassword")).enterConfirmPassword(data.get("confirmpassword")).clickSaveButton()
				.getSuccessToastmessgae();
		Assertions.assertThat(toastMessgae)
		.contains("Success");
	}
	
	@Test
	public void verifyThatUserCannotChangePasswordWithInvalidCurrentPassword(Map<String, String>data) {
		try {
			ExtentLogger.pass("Test is running in "+ data.get("browser") +" browser." , true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String toastMessgae =new OrangeHRMLoginPage().enterUsername(data.get("username")).enterPassword(data.get("password")).clickLogin().clickWelcome().clickChangePassword()
				.enterCurrentPassword(data.get("currentpassword")).enterNewPassword(data.get("newpassword")).enterConfirmPassword(data.get("confirmpassword")).clickSaveButton()
				.getErrorToastMessage();
		Assertions.assertThat(toastMessgae)
		.contains("Error");
	}
	
	@Test
	public void verifyThatUserCannotChangePasswordWhenTheNewPasswordsDoNotMatch(Map<String, String>data) {
		try {
			ExtentLogger.pass("Test is running in "+ data.get("browser") +" browser." , true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String passwordMissmatchString = new OrangeHRMLoginPage().enterUsername(data.get("username")).enterPassword(data.get("password")).clickLogin()
				.clickWelcome().clickChangePassword().enterCurrentPassword(data.get("currentpassword")).enterNewPassword(data.get("newpassword")).enterConfirmPassword(data.get("confirmpassword"))
				.getpassMissmatchText();
		Assertions.assertThat(passwordMissmatchString)
		.contains("Passwords do not match");
	}
	@Test
	public void verifyThatUserCannotChangePasswordWhenThePasswoedDoesNotMeetSpecifiedCriteria(Map<String, String>data) {
		try {
			ExtentLogger.pass("Test is running in "+ data.get("browser") +" browser." , true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String criteriaText = new OrangeHRMLoginPage().enterUsername(data.get("username")).enterPassword(data.get("password")).clickLogin()
				.clickWelcome().clickChangePassword().enterCurrentPassword(data.get("currentpassword")).enterNewPassword(data.get("newpassword"))
				.getCriteriaText();
		Assertions.assertThat(criteriaText)
		.contains("Should have at least 7 characters");
	}

}
