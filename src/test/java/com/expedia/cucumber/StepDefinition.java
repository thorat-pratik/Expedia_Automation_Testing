package com.expedia.cucumber;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.expedia.base.TestBase;
import com.expedia.extentreport.ReportGen;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition extends TestBase {
    
    WebDriver driver;
    
    @Before
    public void init() {
        // Initialize WebDriver
        driver = initialization("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.expedia.co.in");
    }
    
    @After
    public void close() throws IOException {
        // Close WebDriver
        if (driver != null) {
            driver.quit();
        }
     
    }

  
    
    @Given("the user is on the homepage")
    public void the_user_is_on_the_homepage() {
        // No additional action needed, as the homepage is already loaded in the @Before method
    }

    @When("the user clicks on the {string} link")
    public void the_user_clicks_on_the_link(String linkText) {
        // Click on the specified link
        driver.findElement(By.xpath("//a[contains(text(), '" + linkText + "')]")).click();
    }

    @Then("the {string} button should be displayed")
    public void the_button_should_be_displayed(String expectedURL) throws InterruptedException {
        // Pause for a moment to ensure the page is loaded
        Thread.sleep(3000);
        
        // Get the current URL and assert it matches the expected URL
        String actualURL = driver.getCurrentUrl();
        assertEquals(actualURL, expectedURL);
    }
    @Given("I am on the Expedia.co.in feedback website")
	public void i_am_on_the_expedia_co_in_feedback_website() {
	    // Write code here that turns the phrase above into concrete actions
	    driver.navigate().to("https://www.expedia.co.in/p/support/feedback");
	}

	@When("I click on the {string} link")
	public void i_click_on_the_link(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    driver.findElement(By.xpath("//*[@id='headerFeedback']/div[4]/div[3]/a")).click();
	    
	}



	@When("I filled the details")
	public void i_filled_the_details() {
	    // Write code here that turns the phrase above into concrete actions
//	    Overall satisfaction with page * = 5 star
		driver.findElement(By.xpath("//*[@id='survey']/fieldset[1]/div/div[5]/label")).click();
//		How likely are you to recommend Expedia to a friend or colleague? = 8 
		driver.findElement(By.xpath("//*[@id='survey']/fieldset[2]/div/div[9]/label")).click();
		
//		Topic
//		topic id for click
		
		WebElement topic = driver.findElement(By.id("topic"));
		topic.click();
		
//		select compliment
		
		 driver.findElement(By.xpath("//*[@id='topic']/option[2]")).click();
		 
//		Please include anything else you'd like us to know *
		driver.findElement(By.xpath("//*[@id='verbatim']")).sendKeys("Thank you for the opportunity to provide feedback. Overall, my experience with Expedia.co.in has been positive. The website interface is user-friendly, and I appreciate the wide range of options available for booking flights, hotels, and packages.");
//	email address
		driver.findElement(By.xpath("//*[@id='email_address']")).sendKeys("email@demo.com");
		 
		 
	}

	@When("click on submit button")
	public void click_on_submit_button() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	    driver.findElement(By.id("submit-button")).click();
	    
	    Thread.sleep(5000);
	    
	}

	@Then("I should see a confirmation message that my feedback has been submitted successfully")
	public void i_should_see_a_confirmation_message_that_my_feedback_has_been_submitted_successfully() {
	    // Write code here that turns the phrase above into concrete actions
	    
//		String expectedResult = 
		
		WebElement thankYouText = driver.findElement(By.xpath("//*[@id='thank-you']/p[2]"));
		
		
		
		String actualResultForFeedback = "Thank you for your feedback."; 
		
		
		String expectedResultForFeedback = thankYouText.getText(); 
		
		assertTrue(expectedResultForFeedback.contains("Thank"));
		
	}

}
