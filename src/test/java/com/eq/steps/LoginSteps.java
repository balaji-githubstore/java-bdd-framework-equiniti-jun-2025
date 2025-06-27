package com.eq.steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.eq.base.AutomationWrapper;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps  {
	
	@Given("I have browser with OrangeHRM application")
	public void i_have_browser_with_orange_hrm_application() {
		AutomationWrapper.driver.get("https://opensource-demo.orangehrmlive.com/");
	}

	@When("I enter username as {string}")
	public void i_enter_username_as(String username) {
		AutomationWrapper.driver.findElement(By.name("username")).sendKeys(username);
	}

	@When("I enter password as {string}")
	public void i_enter_password_as(String password) {
		AutomationWrapper.driver.findElement(By.name("password")).sendKeys(password);
	}

	@When("I click on login")
	public void i_click_on_login() {
		AutomationWrapper.driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
	}

	@Then("I should get access to dashboard with content as {string}")
	public void i_should_get_access_to_dashboard_with_content_as(String expectedValue) {
		String actualValue =AutomationWrapper.driver.findElement(By.xpath("//p[contains(normalize-space(),'at Work')]")).getText();
		Assert.assertEquals(actualValue, expectedValue);
	}

	@Then("I should not get access to portal with error {string}")
	public void i_should_not_get_access_to_portal_with_error(String expectedError) {
		String actualError=AutomationWrapper.driver.findElement(By.xpath("//p[contains(normalize-space(),'Invalid')]")).getText();
		Assert.assertEquals(actualError, expectedError);
	}
}
