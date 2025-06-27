package com.eq.pages;

import org.openqa.selenium.WebDriver;

import com.eq.base.AutomationWrapper;
import com.eq.base.WebDriverKeywords;

public class MainPage extends WebDriverKeywords {

	private final WebDriver driver;

	public MainPage(AutomationWrapper wrapper) {
		super(wrapper.driver);
		this.driver = wrapper.driver;
	}

}
