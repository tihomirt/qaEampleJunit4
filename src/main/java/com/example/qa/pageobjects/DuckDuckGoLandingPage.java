package com.example.qa.pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.example.qa.testbase.BrowsersEnum;
import com.example.qa.wait.WaitConstants;
import com.example.qa.wait.WaitForElementToAppear;

public class DuckDuckGoLandingPage extends BasePage {

	@FindBy(id = "search_form_input_homepage")
	private WebElement searchField;

	public DuckDuckGoLandingPage(WebDriver driver, BrowsersEnum browser) {
		super(driver, browser);
	}

	@Override
	protected void isLoaded() throws Error {
		driver.get(WaitConstants.URL);
		
		new WaitForElementToAppear(driver).apply(searchField);
	}
	
	public DuckDuckGoResultsPage fillSearchFieldAndClickEnter(String text) {
		searchField.sendKeys(text);
		searchField.sendKeys(Keys.ENTER);
		return new DuckDuckGoResultsPage(driver, browser);
	}
}
