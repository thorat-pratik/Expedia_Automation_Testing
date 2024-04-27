package com.expedia.Tests;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.expedia.utilities.*;
import com.expedia.Config.DataConifg;
import com.expedia.base.TestBase;
import com.expedia.extentreport.ReportGen;
import com.expedia.extentreport.TestListener;
import com.expedia.pages.ExpediaHomePage;
import com.expedia.pages.FlightResultPage;
import com.expedia.pages.FlightSearchPage;
import com.expedia.utilities.BrowserConfig;

@Listeners(TestListener.class)
public class HomePageTest extends TestBase {
	WebDriver driver;
	ExpediaHomePage home;
	@Parameters("browser")
	@BeforeClass
	public void beforeClass() throws InterruptedException {
		driver = initialization("chrome");
		// This Class is for testing Flights functionality
		// then the flight tab much be selected before performing test
		 home = new ExpediaHomePage(driver);
	}

	@AfterClass
	public void destroy() {
		BrowserConfig.close(driver);
	}
	
	@Test(dataProvider = "optionsData",priority = 1, groups = { "smoke" })
	public void moreTravelOptionDDTTest(String option) throws InterruptedException {
		String optionText=home.moreTravelOptions(option);
		System.out.println(optionText);
		assertTrue(optionText.equals("a"));
	}
	@DataProvider
	public Object[][] optionsData() throws IOException{
		Object[][] data = FetchingData.fetchdata();
		return data;
			
	}
	
	@AfterMethod
	public void postTestMethod(ITestResult itr) throws IOException, InterruptedException {
		Thread.sleep(3000);
		String optionValue = (String) itr.getParameters()[0];
		ReportGen.finishReportAfterTest(itr, driver,optionValue);
	}

}
