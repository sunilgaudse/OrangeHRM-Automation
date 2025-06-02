package com.tmb.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.tmb.driver.Driver;
import com.tmb.driver.DriverManager;

public final class LoginpageTest extends BaseTests{
	private LoginpageTest() {
		
	}
	@Test
	public void test1() {
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("Automation", Keys.ENTER);
	}

	@Test
	public void test2() {
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("Testing mini Bytes", Keys.ENTER);
	}
}
