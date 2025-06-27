package com.eq.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eq.base.AutomationWrapper;
import com.eq.base.WebDriverKeywords;

public class PersonalDetailsPage extends WebDriverKeywords {

	private String profileNameLocator="//h6[text()='@@@@@']";
	
	private final WebDriver driver;
	
	public PersonalDetailsPage(AutomationWrapper wrapper) {
		super(wrapper.driver);
		this.driver = wrapper.driver;
	}
	
	public String getProfileName(String profileName)
	{
		return driver.findElement(By.xpath(profileNameLocator.replace("@@@@@", profileName))).getText();
	}
	
	public String getFirtNameValue()
	{
		return driver.findElement(By.name("firstName")).getAttribute("value");
	}
}
