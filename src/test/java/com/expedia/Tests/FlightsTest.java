package com.expedia.Tests;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.expedia.Config.DataConifg;
import com.expedia.base.TestBase;
import com.expedia.extentreport.ReportGen;
import com.expedia.extentreport.TestListener;
import com.expedia.pages.ExpediaHomePage;
import com.expedia.pages.FlightResultPage;
import com.expedia.pages.FlightSearchPage;
import com.expedia.utilities.BrowserConfig;

@Listeners(TestListener.class)
public class FlightsTest extends TestBase {
	WebDriver driver;
	FlightSearchPage oneWaysearchPage;
	FlightResultPage resultPage;
	@BeforeSuite
	public void initialsetup() throws Exception {
		ReportGen.reportCreation();
	}

	@AfterSuite
	public void finaltest() throws Exception {
		extent.flush();
	}
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browser) throws InterruptedException {
		driver = initialization(browser);
		// This Class is for testing Flights functionality
		// then the flight tab much be selected before performing test
		ExpediaHomePage home = new ExpediaHomePage(driver);
		home.preRequisite();
		oneWaysearchPage = new FlightSearchPage(driver);
		resultPage = new FlightResultPage(driver);
	}

	@AfterClass
	public void destroy() {
		BrowserConfig.close(driver);
	}

	

	@Test(priority = 1, groups = { "smoke" })
	public void oneWaySearchTest() throws InterruptedException {
		FlightResultPage resultPage = oneWaysearchPage.oneWayFlight(DataConifg.ORIGIN, DataConifg.DESTINATION,
				DataConifg.DEPAETURE_DATE);
		String resultText = resultPage.resultOfOneWayFlight();
		assertTrue(resultText.contains("from " + DataConifg.ORIGIN));
		assertTrue(resultText.contains("in " + DataConifg.DESTINATION));
	}

	@Test(priority = 2)
	public void directFlightsTest() throws InterruptedException {
		String resultText = resultPage.getDirectFlights();
		assertTrue(resultText.contains(DataConifg.DIRECT));
	}

	@Test(priority = 3)
	public void airlinesFilterTest() throws InterruptedException {
		String resultText = resultPage.getIndiGoAirlinesFlights();
		System.out.println(resultText);
		assertTrue(resultText.contains(DataConifg.AIRLINES));
	}

	@Test(priority = 4)
	public void sortFlightsLowToHighTest() throws InterruptedException {
		int[] flightPrice = resultPage.sortFlights(DataConifg.PRICEASC);
		System.out.println(flightPrice[0] + " " + flightPrice[1] + " " + flightPrice[2]);
		assertTrue(flightPrice[0] <= flightPrice[1]);
		assertTrue(flightPrice[1] <= flightPrice[2]);
	}

	@Test(priority = 5, dependsOnMethods = "oneWaySearchTest")
	public void sortFlightsPopular() throws InterruptedException {
		int[] flightPrice = resultPage.sortFlights(DataConifg.POPULAR);
		System.out.println(flightPrice[0] + " " + flightPrice[1] + " " + flightPrice[2]);
		assertTrue(flightPrice[0] >= flightPrice[1]);
		assertTrue(flightPrice[1] >= flightPrice[2]);
	}
	@Test(priority = 6, dependsOnMethods = "sortFlightsPopular")
	public void skipFlightsPopular() throws InterruptedException {
		assertTrue(true);
	}

	@AfterMethod
	public void postTestMethod(ITestResult itr) throws IOException, InterruptedException {
		Thread.sleep(3000);
		ReportGen.finishReportAfterTest(itr, driver);
	}
	
//	@BeforeTest
//	public void initialsetup() throws Exception {
//		ReportGen.reportCreation();
//	}
//
//	@AfterTest
//	public void finaltest() throws Exception {
//		extent.flush();
//	}

}
