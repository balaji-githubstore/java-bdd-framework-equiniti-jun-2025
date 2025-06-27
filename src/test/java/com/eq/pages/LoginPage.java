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
//		driver.findElement(usernameLocator).sendKeys(username);
		super.setInputTextToElement(usernameLocator, username);
	}

	public void enterPassword(String password) {
//		driver.findElement(passwordLocator).sendKeys(password);
		setInputTextToElement(passwordLocator, password);
	}

	public void clickOnLogin() {
//		driver.findElement(loginLocator).click();
		super.clickOnElement(loginLocator);
	}

	public String getInvalidErrorMessage() {
//		return driver.findElement(errorLocator).getText();
		return super.getElementText(errorLocator);
	}

	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	public String getLoginHeader() {
		return driver.findElement(headerLocator).getText();
	}

	public String getUsernamePlaceholder() {
		return driver.findElement(usernameLocator).getAttribute("placeholder");
	}

}
