package com.eq.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Demo1Steps {
	
	@Given("I have browser with OrangeHRM application")
	public void i_have_browser_with_orange_hrm_application() {
	    System.out.println("given");
	}
	@When("I enter username as {string}")
	public void i_enter_username_as(String username) {
		 System.out.println("when"+username);
	}
	@When("I enter password as {string}")
	public void i_enter_password_as(String password) {
		System.out.println("when"+password);
	}
	@When("I click on login")
	public void i_click_on_login() {
		System.out.println("when login");
	}
	@Then("I should get access to dashboard with content as {string}")
	public void i_should_get_access_to_dashboard_with_content_as(String expectedValue) {
		System.out.println("then"+expectedValue);
	}
}
