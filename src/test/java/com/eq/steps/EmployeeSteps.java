package com.eq.steps;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.eq.base.DataTransfer;
import com.eq.pages.AddEmployeePage;
import com.eq.pages.MainPage;
import com.eq.pages.PIMPage;
import com.eq.pages.PersonalDetailsPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EmployeeSteps {

	private final MainPage mainPage;
	private final PIMPage pimPage;
	private final AddEmployeePage addEmpPage;
	private final PersonalDetailsPage personalDetailPage;
	private final DataTransfer dt;

	public EmployeeSteps(MainPage mainPage, PIMPage pimPage, AddEmployeePage addEmpPage, PersonalDetailsPage personalDetailPage,DataTransfer dt) {
		this.mainPage = mainPage;
		this.pimPage = pimPage;
		this.addEmpPage = addEmpPage;
		this.personalDetailPage=personalDetailPage;
		this.dt=dt;
	}
	

	@When("I click on PIM menu")
	public void i_click_on_pim_menu() {
		mainPage.clickOnPIMMenu();
	}

	@When("I click on add employee")
	public void i_click_on_add_employee() {
		pimPage.clickOnAddEmployee();
	}

	@When("I fill the employee form")
	public void i_fill_the_employee_form(DataTable dataTable) {
		System.out.println(dataTable);
		
		dt.listOfMapsDt=dataTable.asMaps();
		System.out.println(dt.listOfMapsDt);
		System.out.println(dt.listOfMapsDt.get(0));

		System.out.println(dt.listOfMapsDt.get(0).get("first_name"));
		System.out.println(dt.listOfMapsDt.get(0).get("middle_name"));
		System.out.println(dt.listOfMapsDt.get(0).get("last_name"));

		addEmpPage.fillEmployeeForm(dt.listOfMapsDt.get(0).get("first_name"), dt.listOfMapsDt.get(0).get("middle_name"),
				dt.listOfMapsDt.get(0).get("last_name"));
	}

	@When("I click on save employee")
	public void i_click_on_save_employee() {
		addEmpPage.clickOnSaveEmployee();
	}

	@Then("I should get the profile name as {string}")
	public void i_should_get_the_profile_name_as(String expectedProfileName) {
		String actualName = personalDetailPage.getProfileName(expectedProfileName);
		Assert.assertEquals(actualName, expectedProfileName);
	}

	@Then("I should get the personal details form filled with added data")
	public void i_should_get_the_personal_details_form_filled_with_added_data() {
		Assert.assertEquals(personalDetailPage.getFirtNameValue(), dt.listOfMapsDt.get(0).get("first_name"));
	}
}
