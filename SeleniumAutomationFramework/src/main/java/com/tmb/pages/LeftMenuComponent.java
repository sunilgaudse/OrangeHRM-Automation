package com.tmb.pages;

import org.openqa.selenium.By;

public final class LeftMenuComponent extends BasePage{

	private final String menuItem = "//span[text()='%s']/parent::a";
	
	public void setLinkMainMenu(String mainMenu) {
		String newXpath= String.format(menuItem, mainMenu);
		click(By.xpath(newXpath), mainMenu);
	}
}
