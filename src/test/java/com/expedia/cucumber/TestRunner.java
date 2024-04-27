package com.expedia.cucumber;


import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;

import com.expedia.extentreport.ReportGen;
import com.expedia.extentreport.TestListener;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = { "src\\test\\java\\com\\expedia\\cucumber\\FlightSearch.feature", "src\\test\\java\\com\\expedia\\cucumber\\expediafeedback.feature","src\\test\\java\\com\\expedia\\cucumber\\expediasupport.feature"}, glue = {
		"com.expedia.cucumber" },plugin = { "me.jvt.cucumber.report.PrettyReports:target/cucumber"})
public class TestRunner extends AbstractTestNGCucumberTests {
	  @After
	    public void ReportDown(Scenario senario) throws IOException {
	        ReportGen.scenarioReportAfterTest(senario);
	    }
}
