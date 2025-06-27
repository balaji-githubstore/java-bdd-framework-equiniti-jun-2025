package com.eq.steps;

import org.testng.Assert;

import com.eq.pages.DashboardPage;
import com.eq.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

	private final LoginPage loginPage;
	private final DashboardPage dashboardPage;

	public LoginSteps(LoginPage loginPage, DashboardPage dashboardPage) {
		this.loginPage = loginPage;
		this.dashboardPage = dashboardPage;
	}

	@Given("I have browser with OrangeHRM application")
	public void i_have_browser_with_orange_hrm_application() {
		loginPage.navigateToUrl();
	}

	@When("I enter username as {string}")
	public void i_enter_username_as(String username) {
		loginPage.enterUsername(username);
	}

	@When("I enter password as {string}")
	public void i_enter_password_as(String password) {
		loginPage.enterPassword(password);
	}

	@When("I click on login")
	public void i_click_on_login() {
		loginPage.clickOnLogin();
	}

	@Then("I should get access to dashboard with content as {string}")
	public void i_should_get_access_to_dashboard_with_content_as(String expectedValue) {
		String actualValue = dashboardPage.getTimeAtWorkHeader();
		Assert.assertEquals(actualValue, expectedValue);
	}

	@Then("I should not get access to portal with error {string}")
	public void i_should_not_get_access_to_portal_with_error(String expectedError) {
		String actualError = loginPage.getInvalidErrorMessage();
		Assert.assertEquals(actualError, expectedError);
	}
}
