package com.tmb.tests;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.tmb.listeners.MethodInterceptor;
import com.tmb.pages.OrangeHRMLoginPage;

@Listeners(MethodInterceptor.class)

public class UserAccountManagementTest extends BaseTests{
	private UserAccountManagementTest() {
		
	}
	
	@Test
	public void verifyThatUserCanChangePasswordWithValidCredentials(Map<String, String>data) {
		String toastMessgae =new OrangeHRMLoginPage().enterUsername(data.get("username")).enterPassword(data.get("password")).clickLogin().clickWelcome().clickChangePassword()
				.enterCurrentPassword(data.get("currentpassword")).enterNewPassword(data.get("newpassword")).enterConfirmPassword(data.get("confirmpassword")).clickSaveButton()
				.getSuccessToastmessgae();
		Assertions.assertThat(toastMessgae)
		.contains("Success");
	}
	

}
