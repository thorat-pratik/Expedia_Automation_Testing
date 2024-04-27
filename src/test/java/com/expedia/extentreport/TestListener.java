package com.expedia.extentreport;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
	@Override
	public void onTestSkipped(ITestResult itr) {
		WebDriver driver = (WebDriver) itr.getTestContext().getAttribute("WebDriver");
		try {
			ReportGen.finishReportAfterTest(itr, driver);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
