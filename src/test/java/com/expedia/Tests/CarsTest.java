package com.expedia.Tests;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
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

import com.expedia.base.TestBase;
import com.expedia.extentreport.ReportGen;
import com.expedia.extentreport.TestListener;
import com.expedia.pages.CarSearchResultPage;
import com.expedia.pages.CarsSearchPage;
import com.expedia.pages.CustomerServicePage;
import com.expedia.pages.ExpediaHomePage;
import com.expedia.utilities.BrowserConfig;
import com.expedia.utilities.TestUtil;

@Listeners(TestListener.class)
public class CarsTest extends TestBase {
	WebDriver driver;
	CarsSearchPage carsPage;
	CarSearchResultPage carResultPage;
	CustomerServicePage customerServicePage;
	Actions actions;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browser) throws InterruptedException {
		driver = initialization(browser);
		carsPage = new CarsSearchPage(driver);
		carsPage.preRequisite();
		carResultPage = new CarSearchResultPage(driver);
		customerServicePage = new CustomerServicePage(driver);
		actions = new Actions(driver);
	}

	@AfterClass
	public void destroy() {
		BrowserConfig.close(driver);
	}

	@BeforeSuite
	public void initialsetup() throws Exception {
		ReportGen.reportCreation();
	}

	@AfterSuite
	public void finaltest() throws Exception {
		extent.flush();
	}

	@Test(priority = 1)
	public void testSearchWithValidLocations() throws InterruptedException {

		carsPage.clickPickUpSearch();
		carsPage.inputPickupLocation("San Francisco");
		carsPage.selectPickupLocation();

		Thread.sleep(3000);

		carsPage.clickDropoffSearch();
		carsPage.inputDropoffLocation("Los Angeles");
		carsPage.selectDropoffLocation();

		// Select travel dates
		carsPage.selectDate();
		Thread.sleep(3000);

		// Select time
		carsPage.selectPickupTime("1030AM");
		carsPage.selectDropoffTime("1030PM");

		// Verify search results are displayed
		carsPage.clickSearch();

		Assert.assertTrue(carResultPage.getResultCount() > 0, "No cars available at the moment.");
		System.out.println("Done");
		actions.sendKeys(Keys.PAGE_DOWN).perform();
		actions.sendKeys(Keys.PAGE_DOWN).perform();
		Thread.sleep(7000);

	}

	@Test(priority = 2)
	public void testResultsWithFilters() throws InterruptedException {
		driver.get(prop.getProperty("site.filter.url"));
		int resultCount = carResultPage.getResultCount();
		carResultPage.applyPickupLocFilterInTerminal();
		carResultPage.applyFuelPolicyFilterFullToFull();
		carResultPage.applyCustomerRatingFilterGood();
		carResultPage.applyPassengersFilterFive();
		int filteredResultCount = carResultPage.getResultCount();

		if (filteredResultCount < resultCount) {
			System.out.println("Filtering successful.");
		} else {
			System.out.println("Filtering failed.");
		}

		actions.sendKeys(Keys.PAGE_UP).perform();
		actions.sendKeys(Keys.PAGE_UP).perform();
		Assert.assertTrue(filteredResultCount < resultCount, "Filters not applied");
//		Thread.sleep(5000);
	}

	@Test(priority = 3)
	public void testResultsWithSort() throws InterruptedException {
		actions.sendKeys(Keys.PAGE_UP).perform();
		actions.sendKeys(Keys.PAGE_UP).perform();

		int priceBeforeSort = carResultPage.getPrice();
		System.out.println("Price of first car before sorting : " + priceBeforeSort);

		carResultPage.applySortPriceLowToHigh();

		int priceAfterSort = carResultPage.getPrice();
		System.out.println("Price of first car after sorting : " + priceAfterSort);

		if (priceBeforeSort > priceAfterSort) {
			System.out.println("Sorting successful.");
		} else {
			System.out.println("Sorting failed.");
		}
		Assert.assertTrue(priceBeforeSort > priceAfterSort, "Sorting not applied");
		Thread.sleep(2000);
	}

	@Test(priority = 4)
	public void testCarTypeSearch() throws InterruptedException {
		actions.sendKeys(Keys.PAGE_UP).perform();
		carResultPage.clickEconomy();
		String carType = carResultPage.getCarTypeOfFirstResult();
		Assert.assertEquals(carType, "Economy");
	}

	@AfterMethod
	public void postTestMethod(ITestResult itr) throws IOException, InterruptedException {
		Thread.sleep(3000);
		ReportGen.finishReportAfterTest(itr, driver);
	}
}
