package com.expedia.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.expedia.base.TestBase;

public class CarsSearchPage extends TestBase {
	WebDriver driver;
	WebDriverWait wait;
	public CarsSearchPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(50));
	}

	
	@FindBy(linkText = "Cars")
	private WebElement carsTab;

	@FindBy(xpath = "//button[@name='EGDSDateRange-date-selector-trigger']")
	private WebElement pickupDateInput;

	@FindBy(xpath = "//button[@name='EGDSDateRange-date-selector-trigger']")
	private WebElement dropoffDateInput;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement searchButton;

	// Pickup Location
	@FindBy(css = "button[aria-label='Pick-up']")
	WebElement pickUpSearch;

	@FindBy(xpath = "//*[@id='pick_up_location']")
	WebElement enterPickupLocation;

	@FindBy(xpath = "//*[@id='pick_up_location-menu']/section/div/div[2]/div/ul/li[1]/div/div/button")
	WebElement selectPickupLocation;

	// Dropoff Location
	@FindBy(xpath = "//*[@id=\"car_search_form\"]/div/div[2]/div/div/div[2]/div[1]/button")
	WebElement dropoffSearch;

	@FindBy(xpath = "//*[@id=\"drop_off_location\"]")
	WebElement enterDropoffLocation;

	@FindBy(xpath = "//*[@id=\"drop_off_location-menu\"]/section/div/div[2]/div/ul/li[1]/div/div/button")
	WebElement selectDropOffLocation;

	// Date
	@FindBy(xpath = "//*[@id='car_search_form']/div/div[3]/div/div/div/div/button")
	WebElement dateButton;

	@FindBy(xpath = "//*[@id='car_search_form']/div/div[3]/div/section/div[2]/div/div/div[3]/div/div[2]/table/tbody/tr[3]/td[3]/div/div[2]")
	WebElement selectLeavingDate;

	@FindBy(xpath = "//*[@id='car_search_form']/div/div[3]/div/section/div[2]/div/div/div[3]/div/div[2]/table/tbody/tr[5]/td[5]/div/div[2]")
	WebElement selectReturnDate;
	
	
	@FindBy(xpath = "//button[normalize-space()='Done']")
	WebElement doneButton;

	// Time
	@FindBy(id = "pick_up_time")
	WebElement selectPickupTimeBtn;

	@FindBy(id = "drop_off_time")
	WebElement selectDropoffTimeBtn;
	
	@FindBy(xpath="//*[@id=\"ct-search-results\"]/div[2]/ct-availability-list-header/div/div/ct-results-summary/div/strong")
	WebElement resultQuantity;


	public void clickCarsTab() {
		carsTab.click();
	}

	public void preRequisite() {
		clickCarsTab();
	}

	// For selecting Pick Up Location
	public void clickPickUpSearch() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(7));
		wait.until(ExpectedConditions.elementToBeClickable(pickUpSearch));
		pickUpSearch.click();
	}

	public void inputPickupLocation(String pickupLocation) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.elementToBeClickable(enterPickupLocation));
		enterPickupLocation.sendKeys(pickupLocation);
	}

	public void selectPickupLocation() {
		selectPickupLocation.click();
	}

	// For selecting Drop off Location
	public void clickDropoffSearch() {
		dropoffSearch.click();
	}

	public void inputDropoffLocation(String pickupLocation) {
		enterDropoffLocation.sendKeys(pickupLocation);
	}

	public void selectDropoffLocation() {
		selectDropOffLocation.click();
	}

	public void clickSearch() {
//		searchButton.click();
		driver.get(prop.getProperty("site.filter.url"));
	}

	// Date Selection
	public void selectDate() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement dateBtn =wait.until(ExpectedConditions.elementToBeClickable(dateButton));
		dateBtn.click();
		WebElement leavedateBtn =wait.until(ExpectedConditions.elementToBeClickable(selectLeavingDate));
		leavedateBtn.click();
//		selectLeavingDate.click();
		selectReturnDate.click();
		doneButton.click();

	}

	// Time Selection
	public void selectPickupTime(String time) throws InterruptedException {
		selectPickupTimeBtn.click();
		Select dropdown = new Select(selectPickupTimeBtn);
		Thread.sleep(5000);
		dropdown.selectByValue(time);
	}

	public void selectDropoffTime(String time) throws InterruptedException {
		selectDropoffTimeBtn.click();
		Select dropdown = new Select(selectDropoffTimeBtn);
		Thread.sleep(5000);
		dropdown.selectByValue(time);
	}
	


}
