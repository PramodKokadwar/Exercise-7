package com.qa.wikipedia.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.wikipedia.base.BaseTest;
import com.qa.wikipedia.utils.Constants;
import com.qa.wikipedia.utils.Errors;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class WikiAdvanceSearchTest extends BaseTest {
	

	
	@Description("pre WikiHomePage for accounts page tests")
	@BeforeClass
	public void wikiAdvanceSearchPageSetUp() {
		wikiAdvanceSearchPage = wikiHomePage.clickOnSearchButton();
	}


	@Test
	@Description("Wiki advanceSearch Page Title Test.....")
	@Severity(SeverityLevel.NORMAL)
	public void advanceSearchPageTitleTest() {
		String actTitle = wikiAdvanceSearchPage.getWikiAdvnavePageTitle();
		System.out.println("page title : " + actTitle);
		Assert.assertEquals(actTitle, Constants.WIKI_ADVANCE_SEARCH_PAGE_TITLE, Errors.WIKI_PAGE_TITLE_MISMATCHED);
	}


	@Test
	public void wikiAdvanceUrlTest()
	{
		String url = wikiAdvanceSearchPage.getwikiAdvancePageUrl();
		System.out.println("Wiki Advance Page url : "+url);
		Assert.assertTrue(url.contains(Constants.WIKIADVNACE_PAGE_FRACTION_URL));
	}

	@Test
	public void performAdvanceSearchTest()
	{
		wikiAdvanceSearchPage.fillTheAdvanceSearchFields();
		
		String searrchResult = wikiAdvanceSearchPage.getResultsPageValue();
		Assert.assertTrue(searrchResult.contains("Sunil Chhetri"));
	}

}
