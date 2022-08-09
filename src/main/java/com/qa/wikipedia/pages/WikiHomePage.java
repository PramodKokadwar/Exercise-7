package com.qa.wikipedia.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.wikipedia.utils.Constants;
import com.qa.wikipedia.utils.ElementUtil;

import io.qameta.allure.Step;

public class WikiHomePage {

	private WebDriver driver;
	private ElementUtil eleutil;



	// 1. private by locators:	
	private By searchInput = By.id("searchInput");
	private By searchButton = By.id("searchButton");


	// 2. public page const....
	public WikiHomePage(WebDriver driver) {
		this.driver = driver;
		eleutil = new ElementUtil(driver);
	}

 
	// 3. public page actions:
	@Step("getting login page title.....")
	public String getWikiPageTitle() {
		return eleutil.waitForTitleIs(Constants.DEFAULT_TIME_OUT, Constants.WIKI_PAGE_TITLE);
	}
	
	@Step("checking that search button is displayed or not.....")
	public boolean isSearchButtonExist() {
		return eleutil.doIsDisplayed(searchButton);
	}
	
	@Step("Clicking on search button from Main Page")
	public WikiAdvanceSearchPage clickOnSearchButton() {
		
		eleutil.doClick(searchButton);
		
		return new WikiAdvanceSearchPage(driver);
	}
	


	
	


}
