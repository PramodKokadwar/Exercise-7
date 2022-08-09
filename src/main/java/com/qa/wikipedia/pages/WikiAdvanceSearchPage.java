package com.qa.wikipedia.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.qa.wikipedia.utils.Constants;
import com.qa.wikipedia.utils.ElementUtil;

import io.qameta.allure.Step;

public class WikiAdvanceSearchPage {

	private WebDriver driver;
	private ElementUtil eleutil;



	// 1. private by locators:	
	private By searchButton = By.xpath("//button[@type='submit']");

	private By AdvanceTab = By.xpath("//label[normalize-space()='Advanced search:']");
	private By theseWords = By.id("ooui-33");
	private By exactlyThisText = By.id("ooui-37");
	private By notTheseWords = By.id("ooui-41");
	private By oneOfTheseWords = By.id("ooui-45");
	
	private By linkSunilChhetri = By.xpath("//a[@title='List of international goals scored by Sunil Chhetri']");
	

	// 2. public page const....
	public WikiAdvanceSearchPage(WebDriver driver) {
		this.driver = driver;
		eleutil = new ElementUtil(driver);
	}

	// 3. public page actions:
	@Step("getting advance title.....")
	public String getWikiAdvnavePageTitle() {
		return eleutil.waitForTitleIs(Constants.DEFAULT_TIME_OUT, Constants.WIKI_ADVANCE_SEARCH_PAGE_TITLE);
	}

	@Step("getting wikiAdvnaceSearchPage url title.....")
	public String getwikiAdvancePageUrl() {
		return eleutil.waitForUrl(Constants.DEFAULT_TIME_OUT, Constants.WIKIADVNACE_PAGE_FRACTION_URL);
	}


	// 4. public page actions:
	@Step("fill the advance search details")
	public void fillTheAdvanceSearchFields() {

		
		
		eleutil.doClick(AdvanceTab);

		eleutil.doSendKeys(theseWords, "Sunil Chhetri");
		eleutil.doSendKeys(exactlyThisText, "Sunil Chhetri");
		eleutil.doSendKeys(notTheseWords, "Sachin");
		eleutil.doSendKeys(oneOfTheseWords, "Football");
		
		eleutil.doClick(searchButton);
		
	}
	
	@Step("getResultsPageValue")
	public String getResultsPageValue() {
		if (eleutil.doIsDisplayed(linkSunilChhetri)) {
			return eleutil.doElementGetText(linkSunilChhetri);
		}
		return null;
	}


}
