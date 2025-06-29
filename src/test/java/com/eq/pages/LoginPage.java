package com.eq.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eq.base.AutomationWrapper;
import com.eq.base.WebDriverKeywords;

public class LoginPage extends WebDriverKeywords {
	private final WebDriver driver;

	private By usernameLocator = By.name("username");
	private By passwordLocator = By.name("password");
	private By loginLocator = By.xpath("//button[normalize-space()='Login']");
	private By errorLocator = By.xpath("//p[contains(normalize-space(),'Invalid')]");
	private By headerLocator = By.xpath("//h5");

	public LoginPage(AutomationWrapper wrapper) {
		super(wrapper.driver);
		this.driver = wrapper.driver;
	}
	
	public void navigateToUrl()
	{
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}

	public void enterUsername(String username) {
		super.enterText(usernameLocator, username);
	}

	public void enterPassword(String password) {
		enterText(passwordLocator, password);
	}

	public void clickOnLogin() {
		clickElement(loginLocator);
	}

	public String getInvalidErrorMessage() {
		return getElementText(errorLocator);
	}

	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	public String getLoginHeader() {
		return getElementText(headerLocator);
	}

	public String getUsernamePlaceholder() {
		return getElementAttribute(usernameLocator, "placeholder");
	}

}
