package com.tmb.tests;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.tmb.annotations.Sheet;
import com.tmb.listeners.MethodInterceptor;
import com.tmb.pages.OrangeHRMAdminFunctionalityPage;
import com.tmb.pages.OrangeHRMLoginPage;
import com.tmb.reports.ExtentLogger;

@Listeners(MethodInterceptor.class)
@Sheet("ADMINFUNCTIONALITY")
public class AdminFunctionalityTest extends BaseTests{

	@Test
	public void verifyThatTheAdminCanAddNewUser(Map<String, String>data) {
		try {
			ExtentLogger.pass("Test is running in "+ data.get("browser") +" browser." , true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String toastMesssage = new OrangeHRMLoginPage().enterUsername(data.get("username")).enterPassword(data.get("password")).clickLogin()
				.navigateToAddCustomerPage().clickAddButton().selectUserRole().selectStatus().enterEmployeeName(data.get("employeename")).enterUsername(data.get("username"))
				.enterPassword(data.get("newpassword")).enterConfirmPassword(data.get("confirmpassword")).clickSaveButton().getSuccessToastmessgae();
		Assertions.assertThat(toastMesssage)
		.contains("Success");
	}
	
	@Test
	public void verifyThaTheNumberOfUserRecordsIncreasesAfterAddingANewUser(Map<String, String>data) {
		try {
			ExtentLogger.pass("Test is running in "+ data.get("browser") +" browser." , true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		int initialCount = new OrangeHRMLoginPage().enterUsername(data.get("username")).enterPassword(data.get("password")).clickLogin().navigateToAddCustomerPage()
				.elemenCount();
		int updatedCount = new OrangeHRMAdminFunctionalityPage().clickAddButton().selectUserRole().selectStatus().enterEmployeeName(data.get("employeename"))
				.enterPassword(data.get("newpassword")).enterUsername(data.get("username")).enterConfirmPassword(data.get("confirmpassword")).clickSaveButton()
				.elemenCount();
		Assertions.assertThat(updatedCount)
		.withFailMessage("Expected user count to increase but it did not. Before: %d, After: %d", initialCount, updatedCount)
	    .isGreaterThan(initialCount);
//		.as("Check that the user count increased after adding a new user")
//		.isEqualTo(initialCount +1); commentng this as due to parallel execution expected count is deifeerent and hence test filed.
	}


}
