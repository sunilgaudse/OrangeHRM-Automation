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
	public void loginLogoutTest(Map<String, String>data) {
		String title = new OrangeHRMLoginPage()
				.enterUsername(data.get("username")).enterPassword(data.get("password")).clickLogin()
				.clickWelcome().clickLogout()
				.getTitle();
		Assertions.assertThat(title)
		.isEqualTo("OrangeHRM");
	}
	
	@Test
	public void newTest(Map<String, String>data) {
		String title = new OrangeHRMLoginPage()
				.enterUsername(data.get("username")).enterPassword(data.get("password")).clickLogin()
				.clickWelcome().clickLogout()
				.getTitle();
		Assertions.assertThat(title)
		.isEqualTo("OrangeHRM");
	}

}
