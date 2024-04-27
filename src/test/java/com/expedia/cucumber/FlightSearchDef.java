package com.expedia.cucumber;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.expedia.Config.DataConifg;
import com.expedia.base.TestBase;
import com.expedia.extentreport.ReportGen;
import com.expedia.pages.ExpediaHomePage;
import com.expedia.pages.FlightResultPage;
import com.expedia.pages.FlightSearchPage;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FlightSearchDef extends TestBase {
    WebDriver driver;
    String resultText = "";

    @Before
    public void init() {
        driver = initialization("chrome");
        
       
    }
    @After
    public void close() throws IOException {
        if (driver != null) {
            driver.quit();
        }
    }


    @Given("the user is in Expedia search page")
    public void the_user_is_in_Expedia_search_page() throws InterruptedException {
        ExpediaHomePage home = new ExpediaHomePage(driver);
        home.preRequisite();
    }

    @When("the user enters trip details")
    public void the_user_enters_trip_details() throws InterruptedException {
        FlightSearchPage oneWaysearchPage = new FlightSearchPage(driver);
        FlightResultPage resultPage = oneWaysearchPage.roundTripFlight(DataConifg.ORIGIN, DataConifg.DESTINATION,
                DataConifg.DEPAETURE_DATE, DataConifg.ARRIVAL_DATE);
        resultText = resultPage.resultOfOneWayFlight();
    }

    @Then("the result page should be displayed")
    public void the_result_page_should_be_displayed() throws InterruptedException {
        assertTrue(resultText.contains("from " + DataConifg.ORIGIN));
        assertTrue(resultText.contains("in " + DataConifg.DESTINATION));
    }
}
