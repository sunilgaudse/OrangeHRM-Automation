package com.tmb.tests;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.tmb.driver.DriverManager;

public final class HomepageTests extends BaseTests{
	private HomepageTests() {
		
	}
/*Validate whether the title is containing Google search or google search
 * validate whether the title is containing not null and length of title is greater than 15 and less than 100
 * Check for the links in the page --> Testing mini bytes - youtube
 * number of links displayed are exactly 10 or 15.
*/
	@Test
	public void test1() {
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("Testing mini bytes - Youtube", Keys.ENTER);
		String title = DriverManager.getDriver().getTitle();
			assertThat(title)
			.isNotNull()
			.containsIgnoringCase("google search")
			.matches("\\w.*"+"Google Search")
			.hasSizeBetween(15, 100);
			
			List<WebElement> elements =DriverManager.getDriver().findElements(By.xpath("//span/a"));
			assertThat(elements)
			.hasSize(15)
			.extracting(e->e.getText())
			.contains("Testing Mini Bytes\r\n"
					+ "YouTube");

	}

}
