package com.qa.wikipedia.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.wikipedia.base.BaseTest;
import com.qa.wikipedia.utils.Constants;
import com.qa.wikipedia.utils.Errors;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;


public class WikiPageTest extends BaseTest {
	
	@Test
	@Description("login Page Title Test.....")
	@Severity(SeverityLevel.NORMAL)
	public void WikiHomePageTitleTest() {
		String actTitle = wikiHomePage.getWikiPageTitle();
		System.out.println("page title : " + actTitle);
		Assert.assertEquals(actTitle, Constants.WIKI_PAGE_TITLE, Errors.WIKI_PAGE_TITLE_MISMATCHED);
	}

	
	@Description("check searchButton Test.....")
	@Severity(SeverityLevel.CRITICAL)
	@Test
	public void searchButtonTest() {
		Assert.assertTrue(wikiHomePage.isSearchButtonExist());
	}
	
	
}
	