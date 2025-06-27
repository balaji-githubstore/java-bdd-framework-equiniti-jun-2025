package com.eq.steps;

import org.testng.Assert;

import com.eq.base.DataTransfer;
import com.eq.pages.PersonalDetailsPage;

import io.cucumber.java.en.Then;

public class Demo3Steps {
	
	private final PersonalDetailsPage personalDetailPage;
	private final DataTransfer dt;
	public Demo3Steps(PersonalDetailsPage personalDetailPage,DataTransfer dt) {
		this.personalDetailPage=personalDetailPage;
		this.dt=dt;
	}
	

	@Then("I should get the personal details form filled with added data")
	public void i_should_get_the_personal_details_form_filled_with_added_data() {
		Assert.assertEquals(personalDetailPage.getFirtNameValue(), dt.listOfMapsDt.get(0).get("first_name"));
	}
}
