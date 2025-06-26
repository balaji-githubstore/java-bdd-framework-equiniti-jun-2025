package com.eq.steps;

import java.util.List;
import java.util.Map;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EmployeeSteps {

	@When("I click on PIM menu")
	public void i_click_on_pim_menu() {
	   
	}
	@When("I click on add employee")
	public void i_click_on_add_employee() {
	 
	}
	@When("I fill the employee form")
	public void i_fill_the_employee_form(DataTable dataTable) {
	   System.out.println(dataTable);
	    
	   List<Map<String,String>> lists= dataTable.asMaps();
	   
	   System.out.println(lists);
	   System.out.println(lists.get(0));
	   
	   System.out.println(lists.get(0).get("first_name"));
	   System.out.println(lists.get(0).get("middle_name"));
	   System.out.println(lists.get(0).get("last_name"));
	}
	@When("I click on save employee")
	public void i_click_on_save_employee() {
	    
	}
	@Then("I should get the profile name as {string}")
	public void i_should_get_the_profile_name_as(String expectedProfileName) {
	   System.out.println(expectedProfileName);
	}
	@Then("I should get the personal details form filled with added data")
	public void i_should_get_the_personal_details_form_filled_with_added_data() {
	    
	}
}
