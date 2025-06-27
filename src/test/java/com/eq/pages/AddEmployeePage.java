package com.eq.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eq.base.AutomationWrapper;
import com.eq.base.WebDriverKeywords;

public class AddEmployeePage extends WebDriverKeywords {

	private final WebDriver driver;

	public AddEmployeePage(AutomationWrapper wrapper) {
		super(wrapper.driver);
		this.driver = wrapper.driver;
	}

	public void fillEmployeeForm(String firstName, String middleName, String lastName) {
		driver.findElement(By.name("firstName")).sendKeys(firstName);
		driver.findElement(By.name("middleName")).sendKeys(middleName);
		driver.findElement(By.name("lastName")).sendKeys(lastName);
	}
	
	public void clickOnSaveEmployee()
	{
		driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();
	}
}
