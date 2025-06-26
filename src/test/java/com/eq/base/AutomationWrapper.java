package com.eq.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class AutomationWrapper {
	
	public static WebDriver driver;

	@Before
	public void setupScenario()
	{
		//launch browser
	}
	
	@After
	public void teardownScenario()
	{
		//close browser
		if(driver !=null)
		{
			driver.quit();
		}
	}
}
