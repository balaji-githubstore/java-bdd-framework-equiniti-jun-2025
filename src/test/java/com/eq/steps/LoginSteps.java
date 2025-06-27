package com.eq.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.eq.base.AutomationWrapper;
import com.eq.base.DataTransfer;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	
	private final WebDriver driver;
	
	public LoginSteps(AutomationWrapper wrapper,DataTransfer dt)
	{
		this.driver=wrapper.driver;
		dt.a=1000;
		dt.list.add("LoginSteps");
	}
	
	@Given("I have browser with OrangeHRM application")
	public void i_have_browser_with_orange_hrm_application() {
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}

	@When("I enter username as {string}")
	public void i_enter_username_as(String username) {
		driver.findElement(By.name("username")).sendKeys(username);
	}

	@When("I enter password as {string}")
	public void i_enter_password_as(String password) {
		driver.findElement(By.name("password")).sendKeys(password);
	}

	@When("I click on login")
	public void i_click_on_login() {
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
	}

	@Then("I should get access to dashboard with content as {string}")
	public void i_should_get_access_to_dashboard_with_content_as(String expectedValue) {
		String actualValue =driver.findElement(By.xpath("//p[contains(normalize-space(),'at Work')]")).getText();
		Assert.assertEquals(actualValue, expectedValue);
	}

	@Then("I should not get access to portal with error {string}")
	public void i_should_not_get_access_to_portal_with_error(String expectedError) {
		String actualError=driver.findElement(By.xpath("//p[contains(normalize-space(),'Invalid')]")).getText();
		Assert.assertEquals(actualError, expectedError);
	}
}
