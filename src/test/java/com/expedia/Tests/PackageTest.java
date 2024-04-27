package com.expedia.Tests;

import org.testng.annotations.Test;

import com.expedia.pages.ExpediaHomePage;
import com.expedia.pages.ExpediaPackageSearch;
import com.expedia.base.TestBase;
import com.expedia.extentreport.ReportGen;
import com.expedia.extentreport.TestListener;
import com.expedia.utilities.BrowserConfig;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;

@Listeners(TestListener.class)
public class PackageTest extends TestBase {
	WebDriver driver;
	ExpediaHomePage homepage;

	ExpediaPackageSearch packages;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browser) throws InterruptedException {
		this.driver = initialization(browser);
		homepage = new ExpediaHomePage(driver);
		homepage.clickPackageTab();

	}


	@Test(priority = 2)
	public void checkCruiseWithInValidData() throws InterruptedException {

//	  driver.navigate().back();	
		packages = new ExpediaPackageSearch(driver);
		packages.clickRegionButton();
		packages.clickCruiseTab();
		packages.enterGoingTo();
		packages.searchCruise();

		String actualErrorMessage = "Please select a destination";
		String expectedErrorMessage = packages.getErrorMessageForGoingTo();
		assertEquals(expectedErrorMessage, actualErrorMessage);
	}

// Test case for Travel Blog - Success
	@Test(priority = 3)
	public void testTravelBlog() throws InterruptedException {
		driver.navigate().back();

		packages = new ExpediaPackageSearch(driver);
		packages.clickTravelBlog();
		String getExpectedURLForCheck = packages.checkBlogisDisplayed();
		String actualURLForCheck = "https://www.expedia.co.in/stories/";
		Thread.sleep(2000);
		assertEquals(getExpectedURLForCheck, actualURLForCheck);

	}

	@Test(priority = 1)
	public void testDownloadApp() throws InterruptedException {

		packages = new ExpediaPackageSearch(driver);

		packages.getExpediaMobileApp();

		String actualResultforMobileAppDownload = packages.getVerifyText();

		assertTrue(actualResultforMobileAppDownload.contains("Scan the QR code"));

	}

	@Test(priority = 4)
	public void testSocialMediaHandle() throws InterruptedException {

		driver.navigate().back();

		packages = new ExpediaPackageSearch(driver);

		packages.clickTravelBlogForSocials();
		packages.checkSocialMediaHandle();

		String expectedResult = driver.getCurrentUrl();
		String parentwindowid = driver.getWindowHandle();
		String childwindowid = "";

		for (String handleid : driver.getWindowHandles()) {
			if (!handleid.equals(parentwindowid)) {
				childwindowid = handleid;
			}
		}
		driver.switchTo().window(childwindowid);

		String expectedResultForTwitterHandle = driver.getCurrentUrl();

		String actualResultForTwitter = "https://twitter.com/ExpediaUK";

		System.out.println("Result 1 " + expectedResult);

		System.out.println("Result 2 " + expectedResultForTwitterHandle);

		assertEquals(expectedResultForTwitterHandle, actualResultForTwitter);

	}

	@AfterClass
	public void destroy() {
		BrowserConfig.close(driver);
	}

	@AfterMethod
	public void afterMethod(ITestResult itr) throws Exception {
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
