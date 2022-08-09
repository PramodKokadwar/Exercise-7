package com.qa.wikipedia.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.qa.wikipedia.factory.DriverFactory;
import com.qa.wikipedia.pages.WikiAdvanceSearchPage;
import com.qa.wikipedia.pages.WikiHomePage;
 

public class BaseTest {

	public DriverFactory df;
	public Properties prop;
	public WebDriver driver;
	public WikiHomePage wikiHomePage;
	public WikiAdvanceSearchPage wikiAdvanceSearchPage;
 
	public SoftAssert softAssert;

	@Parameters({ "browser", "browserversion" })
	@BeforeTest
	public void setup(String browser, String browserVersion) {
		df = new DriverFactory();
		prop = df.init_prop();

		if (browser != null) {
			prop.setProperty("browser", browser);
			prop.setProperty("browserversion", browserVersion);
		}

		driver = df.init_driver(prop);
		wikiHomePage = new WikiHomePage(driver);
		softAssert = new SoftAssert();
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
