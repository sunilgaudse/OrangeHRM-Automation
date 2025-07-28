package com.tmb.tests;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.tmb.listeners.MethodInterceptor;
import com.tmb.pages.OrangeHRMLoginPage;

@Listeners(MethodInterceptor.class)
public class OrangeHRMTest extends BaseTests{
	private OrangeHRMTest() {
		
	}
	
	@Test
	public void verifyThatAdminCanLogInWithValidCredentials(Map<String, String>data) {
		String title = new OrangeHRMLoginPage()
				.enterUsername(data.get("username")).enterPassword(data.get("password")).clickLogin()
				.clickWelcome().clickLogout()
				.getTitle();
		Assertions.assertThat(title)
		.isEqualTo("OrangeHRM");
	}
	

	@Test
	public void verifyThatAdminCannotLogInWithInvalidCredentials(Map<String, String>data) {
		String title = new OrangeHRMLoginPage()
				.enterUsername(data.get("username")).enterPassword(data.get("password")).clickLogin1()
				.errorMessageText();
		Assertions.assertThat(title)
		.isEqualTo("Invalid credentials");
	}
	@Test
	public void verifyThatAdminCannotLogInWithOnlyUsernameFilled(Map<String, String>data) {
		String passwordRequiredString =new OrangeHRMLoginPage()
				.enterUsername(data.get("username")).clickLogin1().requiredText();
		Assertions.assertThat(passwordRequiredString)
		.isEqualTo("Required");
	}
}
