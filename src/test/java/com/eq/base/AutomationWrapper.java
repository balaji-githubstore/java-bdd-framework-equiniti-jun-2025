package com.eq.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.DriverManager;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class AutomationWrapper {
	
	public WebDriver driver;

	@Before
	public void setupScenario() throws FileNotFoundException, IOException
	{
		Properties prop=new Properties();
		prop.load(new FileInputStream("src/test/resources/config/data.properties"));
		
		String browserName=prop.getProperty("browser", "ch");
		if(browserName.equalsIgnoreCase("edge"))
		{
//			System.setProperty("webdriver.edge.driver", "driver/msedgedriver.exe");
			driver = new EdgeDriver();
		}
		else if(browserName.equalsIgnoreCase("ff"))
		{
//			System.setProperty("webdriver.gecko.driver", "driver/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else
		{
			System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@After
	public void teardownScenario()
	{
		//close browser
		try {
            driver.quit();
            LoggerUtils.info("Browser closed successfully");
        } catch (Exception e) {
            LoggerUtils.error("Failed to close browser: " + e.getMessage());
        }
	}
}
