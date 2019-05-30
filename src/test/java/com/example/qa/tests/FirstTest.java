package com.example.qa.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.example.qa.pageobjects.AdoptOpenJdkPage;
import com.example.qa.pageobjects.DuckDuckGoLandingPage;
import com.example.qa.pageobjects.DuckDuckGoResultsPage;
import com.example.qa.testbase.TestBase;

public class FirstTest extends TestBase {

	private DuckDuckGoLandingPage duckDuckGoPage;
	
	public FirstTest() throws Exception {
		super();
	}

	@Before
	public void before() {
		duckDuckGoPage = new DuckDuckGoLandingPage(driver, getBrowser());		
	}

	/**
	 * Test autocomplete
	 * 1. Load google.com
	 * 2. Search for adoptOpendJdk
	 * 3. Click on the first non ad link
	 * 4. Test the title of the page
	 * 5. Print the latest jdk 8 version
	 */
	@Test
	public void searchForAdoptOpenJDK() {
		final String searchQuery = "adoptOpenJdk";
		final String resultUrl = "https://adoptopenjdk.net/";
		
		DuckDuckGoResultsPage resultsPage = duckDuckGoPage.fillSearchFieldAndClickEnter(searchQuery);
		AdoptOpenJdkPage openJdkPage = resultsPage.clickFirstLink();
		
		Assert.assertEquals(resultUrl, openJdkPage.getUrl());
		
		System.out.println(openJdkPage.getVersion());
	}
}
