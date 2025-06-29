package com.eq.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class AutomationWrapper {
    
    public WebDriver driver;
    public WebDriverWait wait;
    private Properties config;
    private static final Logger logger = LogManager.getLogger(AutomationWrapper.class);
    
    @Before
    public void setupScenario(Scenario scenario) throws FileNotFoundException, IOException {
        logger.info("Starting scenario: " + scenario.getName());
        
        try {
            // Load configuration properties
            loadConfiguration();
            logger.info("Configuration loaded successfully");
            
            // Initialize WebDriver based on config
            String browser = config.getProperty("browser", "chrome").toLowerCase();
            initializeDriver(browser);
            logger.info("WebDriver initialized for browser: " + browser);
            
            // Set up WebDriverWait
            int timeout = Integer.parseInt(config.getProperty("timeout", "10"));
            wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
            logger.info("WebDriverWait configured with timeout: " + timeout + " seconds");
            
            // Configure browser settings
            configureBrowser();
            logger.info("Browser configuration completed for scenario: " + scenario.getName());
            
        } catch (Exception e) {
            logger.error("Error during scenario setup: " + e.getMessage(), e);
            throw e;
        }
    }
    
    @After
    public void teardownScenario(Scenario scenario) {
        logger.info("Ending scenario: " + scenario.getName() + " - Status: " + 
                   (scenario.isFailed() ? "FAILED" : "PASSED"));
        
        try {
            // Take screenshot if scenario failed
            if (scenario.isFailed() && driver != null) {
                takeScreenshot(scenario);
            }
            
            if (driver != null) {
                driver.quit();
                logger.info("WebDriver closed successfully");
            }
        } catch (Exception e) {
            logger.error("Error during scenario teardown: " + e.getMessage(), e);
        }
    }
    
    private void loadConfiguration() throws FileNotFoundException, IOException {
        config = new Properties();
        try (FileInputStream fis = new FileInputStream("src/test/resources/config.properties")) {
            config.load(fis);
        }
    }
    
    private void initializeDriver(String browser) {
        switch (browser) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-maximized");
                chromeOptions.addArguments("--disable-notifications");
                if (Boolean.parseBoolean(config.getProperty("headless", "false"))) {
                    chromeOptions.addArguments("--headless");
                }
                driver = new ChromeDriver(chromeOptions);
                break;
                
            case "firefox":
                driver = new FirefoxDriver();
                break;
                
            case "edge":
                driver = new EdgeDriver();
                break;
                
            default:
                logger.error("Unsupported browser: " + browser);
                throw new IllegalArgumentException("Browser not supported: " + browser);
        }
    }
    
    private void configureBrowser() {
        driver.manage().timeouts().implicitlyWait(
            Duration.ofSeconds(Integer.parseInt(config.getProperty("implicitWait", "5")))
        );
        driver.manage().window().maximize();
        
        String baseUrl = config.getProperty("baseUrl");
        if (baseUrl != null && !baseUrl.isEmpty()) {
            driver.get(baseUrl);
            logger.info("Navigated to base URL: " + baseUrl);
        }
    }
    
    private void takeScreenshot(Scenario scenario) {
        try {
            byte[] screenshot = ((org.openqa.selenium.TakesScreenshot) driver)
                .getScreenshotAs(org.openqa.selenium.OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Screenshot");
            logger.info("Screenshot captured for failed scenario: " + scenario.getName());
        } catch (Exception e) {
            logger.error("Failed to capture screenshot: " + e.getMessage(), e);
        }
    }
}