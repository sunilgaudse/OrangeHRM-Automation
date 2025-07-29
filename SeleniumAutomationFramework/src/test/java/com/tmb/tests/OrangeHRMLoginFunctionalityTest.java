package com.tmb.tests;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.tmb.listeners.MethodInterceptor;
import com.tmb.pages.OrangeHRMLoginPage;
import com.tmb.reports.ExtentLogger;

@Listeners(MethodInterceptor.class)
public class OrangeHRMLoginFunctionalityTest extends BaseTests{
	private OrangeHRMLoginFunctionalityTest() {
		
	}
	
	@Test
	public void verifyThatAdminCanLogInWithValidCredentials(Map<String, String>data) {
		try {
			ExtentLogger.pass("Test is running in "+ data.get("browser") +" browser." , true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String title = new OrangeHRMLoginPage()
				.enterUsername(data.get("username")).enterPassword(data.get("password")).clickLogin()
				.clickWelcome().clickLogout()
				.getTitle();
		Assertions.assertThat(title)
		.isEqualTo("OrangeHRM");
	}
	

	@Test
	public void verifyThatAdminCannotLogInWithInvalidCredentials(Map<String, String>data) {
		try {
			ExtentLogger.pass("Test is running in "+ data.get("browser") +" browser." , true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String title = new OrangeHRMLoginPage()
				.enterUsername(data.get("username")).enterPassword(data.get("password")).clickLogin1()
				.errorMessageText();
		Assertions.assertThat(title)
		.isEqualTo("Invalid credentials");
	}
	@Test
	public void verifyThatAdminCannotLogInWithOnlyUsernameFilled(Map<String, String>data) {
		try {
			ExtentLogger.pass("Test is running in "+ data.get("browser") +" browser." , true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String requiredString =new OrangeHRMLoginPage()
				.enterUsername(data.get("username")).clickLogin1().requiredText();
		Assertions.assertThat(requiredString)
		.isEqualTo("Required");
	}
	@Test
	public void verifyThatAdminCannotLogInWithOnlyPasswordFilled(Map<String, String>data) {
		try {
			ExtentLogger.pass("Test is running in "+ data.get("browser") +" browser." , true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String requiredString =new OrangeHRMLoginPage()
				.enterUsername(data.get("password")).clickLogin1().requiredText();
		Assertions.assertThat(requiredString)
		.isEqualTo("Required");
	}
}
