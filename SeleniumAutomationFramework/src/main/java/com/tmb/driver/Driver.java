package com.tmb.driver;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.tmb.enums.ConfigProperties;
import com.tmb.utils.PropertyUtils;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Driver {

	private Driver() {
		
	}

	public static void initDriver(String browser) throws Exception {
		if (Objects.isNull(DriverManager.getDriver())) {
			System.out.println(browser);
			if(browser.equalsIgnoreCase("chrome")) {
				//System.setProperty("webdriver.chrome.driver", FrameworkConstants.getChromeDriverPath());
				WebDriverManager.chromedriver().setup();
				WebDriver driver = new ChromeDriver();
				DriverManager.setDriver(driver);
			}
			else if (browser.equalsIgnoreCase("firefox")) {
				//System.setProperty("webdriver.gecko.driver", FrameworkConstants.getGeckoDriverPath());
				WebDriverManager.firefoxdriver().setup();
				WebDriver driver = new FirefoxDriver();
				DriverManager.setDriver(driver);
			}
			DriverManager.getDriver().get(PropertyUtils.get(ConfigProperties.URL));
			DriverManager.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}	
	}

	public static void quiteDriver() {
		if(Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
		
	}

}
