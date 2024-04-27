package com.expedia.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.expedia.base.TestBase;

public class FlightResultPage extends TestBase {
	WebDriver driver;
	WebDriverWait wait;
	public FlightResultPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	@FindBy(xpath = "//ul[@data-test-id='listings']//li[2]//div//button//span")
	WebElement firstFlight;
	@FindBy(xpath = "//ul[@data-test-id='listings']//li[3]//div//button//span")
	WebElement secondFlight;
	@FindBy(xpath = "//ul[@data-test-id='listings']//li[4]//div//button//span")
	WebElement thirdFlight;
	@FindBy(css = "fieldset>form>div>div:nth-child(2)>div>fieldset>div:nth-child(3)>div>div>input")
	WebElement DirectCheckBox;
	@FindBy(css = "fieldset>form>div>div:nth-child(3)>div>fieldset>div:nth-child(3)>div>div>input")
	WebElement Airlines;
	@FindBy(id = "sort-filter-dropdown-SORT")
	WebElement sorter;

	public String flightData(WebElement e) {

		String text = wait.until(ExpectedConditions.visibilityOf(e)).getText();
		return text;
	}

	public void clickDirectCheckBox() {

		DirectCheckBox.click();
	}

	public void clickAirlines() {
		Airlines.click();
	}

	public String resultOfOneWayFlight() {
		return flightData(firstFlight);
	}

	public void selectSortLowToHigh() {
		Select select = new Select(wait.until(ExpectedConditions.visibilityOf(sorter)));
		select.selectByValue("PRICE_INCREASING");
	}

	public void selectPopular() {
		Select select = new Select(wait.until(ExpectedConditions.visibilityOf(sorter)));
		select.selectByValue("Popular");
	}

	public int getPriceOfFlight(String data) {
		String price = data.split("Priced at ₹")[1];
		price = price.split(" ")[0];
		price = price.replaceAll(",", "");
		return Integer.parseInt(price);
	}

	public String getDirectFlights() {
		clickDirectCheckBox();
		PageFactory.initElements(driver, this);
		return flightData(firstFlight);
	}

	public String getIndiGoAirlinesFlights() {
		clickAirlines();
		PageFactory.initElements(driver, this);
		return flightData(firstFlight);
	}

	public int[] sortFlights(String condition) throws InterruptedException {
		if (condition.equals("low to high")) {
			selectSortLowToHigh();
		} else {
			selectPopular();
		}
		PageFactory.initElements(driver, this);
		int[] flightsPrices = { getPriceOfFlight(flightData(firstFlight)), getPriceOfFlight(flightData(secondFlight)),
				getPriceOfFlight(flightData(thirdFlight)) };
		return flightsPrices;
	}
}
//fieldset>form>div>div:nth-child(5)>div>fieldset>legend>h4
