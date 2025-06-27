package com.eq.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eq.base.AutomationWrapper;
import com.eq.base.WebDriverKeywords;

public class PIMPage extends WebDriverKeywords  {

private final WebDriver driver;
	
	public PIMPage(AutomationWrapper wrapper) {
		super(wrapper.driver);
		this.driver = wrapper.driver;
	}
	
	public void clickOnAddEmployee()
	{
		driver.findElement(By.linkText("Add Employee")).click();
	}
}
