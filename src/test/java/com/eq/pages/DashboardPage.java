package com.eq.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eq.base.AutomationWrapper;
import com.eq.base.WebDriverKeywords;

public class DashboardPage extends WebDriverKeywords {

	private By timeAtWorkLocator=By.xpath("//p[contains(normalize-space(),'at Work')]");
	
	private final WebDriver driver;
	
	public DashboardPage(AutomationWrapper wrapper) {
		super(wrapper.driver);
		this.driver = wrapper.driver;
	}
	
	public String getTimeAtWorkHeader()
	{
		return driver.findElement(timeAtWorkLocator).getText();
	}

}
