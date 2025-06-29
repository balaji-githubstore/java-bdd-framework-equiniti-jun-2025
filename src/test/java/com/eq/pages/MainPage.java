package com.eq.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eq.base.AutomationWrapper;
import com.eq.base.WebDriverKeywords;

/**
 * This class handles all common elements
 */
public class MainPage extends WebDriverKeywords {

	private final WebDriver driver;

	private By pimLocator = By.xpath("//span[text()='PIM']");

	public MainPage(AutomationWrapper wrapper) {
		super(wrapper.driver);
		this.driver = wrapper.driver;
	}

	public void clickOnPIMMenu() {
		clickElement(pimLocator);
	}

}
