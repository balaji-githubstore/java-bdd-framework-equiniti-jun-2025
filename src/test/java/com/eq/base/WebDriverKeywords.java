package com.eq.base;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WebDriverKeywords {

	private final WebDriver driver;

	public WebDriverKeywords(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnElement(By locator) {
		// presence
		// visible
		// enabled
		// click
		driver.findElement(locator).click();
	}

	public void setInputTextToElement(By locator, String text) {
		driver.findElement(locator).sendKeys(text);
	}

	public String getElementText(By locator) {
		return driver.findElement(locator).getText();
	}
	
	public void SwitchTabUsingTitle(String title)
	{
		ArrayList<String> windows=new ArrayList<String>(driver.getWindowHandles());
		
		for (String window : windows) {
			driver.switchTo().window(window);
			if (driver.getTitle().equals(title)) {
				break;
			}
		}
	}
}




