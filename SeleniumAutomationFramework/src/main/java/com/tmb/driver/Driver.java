package com.tmb.driver;

import java.time.Duration;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tmb.enums.ConfigProperties;
import com.tmb.utils.PropertyUtils;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Driver {

	private Driver() {
		
	}

	public static void initDriver(String browser) throws Exception {
//		if (Objects.isNull(DriverManager.getDriver())) {
			
			if(browser.equalsIgnoreCase("chrome")) {
				WebDriver driver = new ChromeDriver();
				DriverManager.setDriver(driver);
			}
			else if (browser.equalsIgnoreCase("firefox")) {
				WebDriver driver = new FirefoxDriver();
				DriverManager.setDriver(driver);
			}
			DriverManager.getDriver().get(PropertyUtils.get(ConfigProperties.URL));
			DriverManager.getDriver().manage().window().maximize();
//			new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(20))
//		    .until(driver -> ((JavascriptExecutor) driver)
//		        .executeScript("return document.readyState")
//		        .equals("complete"));
			DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		}	
	}

	public static void quitDriver() {
		if(Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
		
	}

}
