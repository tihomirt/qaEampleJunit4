package com.tihomir.example.qa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.tihomir.example.qa.testbase.BrowsersEnum;
import com.tihomir.example.qa.wait.WaitForElementToAppear;

public class DuckDuckGoResultsPage extends BasePage {

	@FindBy(css = ".result__a")
	private WebElement firstLink;

	public DuckDuckGoResultsPage(WebDriver driver, BrowsersEnum browser) {
		super(driver, browser);
	}

	@Override
	protected void isLoaded() throws Error {
		new WaitForElementToAppear(driver).apply(firstLink);
	}

	public AdoptOpenJdkPage clickFirstLink() {
		firstLink.click();
		return new AdoptOpenJdkPage(driver, browser);
	}
}
