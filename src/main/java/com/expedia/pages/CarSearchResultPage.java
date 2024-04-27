package com.expedia.pages;



import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.expedia.base.TestBase;

public class CarSearchResultPage extends TestBase{
	WebDriver driver;
	WebDriverWait wait;
	public CarSearchResultPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(50));
	}
	

	
	
	@FindBy(id="ct-search-results")
	WebElement results;
	
	@FindBy(xpath="//*[@id=\"ct-search-results\"]/div[2]/ct-availability-list-header/div/div/ct-results-summary/div/strong")
	WebElement resultCountLabel;
	
	
	// Filters
	@FindBy(xpath="//*[@id=\"ct-filter\"]/div/div[3]/div/ct-availability-list-filter-group/div/div[2]/div[2]/ul/li[1]/div/label")
	WebElement pickupLocFilter;
	
	@FindBy(xpath="//*[@id=\"ct-filter\"]/div/div[4]/div/ct-availability-list-filter-group/div/div[2]/div[2]/ul/li[2]/div/label")
	WebElement fuelPolicyFilter;
	
	@FindBy(xpath="//*[@id=\"ct-filter\"]/div/div[7]/div/ct-availability-list-filter-group/div/div[2]/div[2]/ul/li[2]/div/label")
	WebElement customerRating;
	
	@FindBy(xpath="//*[@id=\"ct-filter\"]/div/div[10]/div/ct-availability-list-filter-group/div/div[2]/div[2]/ul/li[2]/span")
	WebElement passengers;
	
	@FindBy(xpath="//*[@id=\"ct-availability-list\"]/div[2]")
	WebElement firstResult;
	
	@FindBy(xpath="//*[@id=\"ct-availability-list\"]/div[1]/ct-vehicle-block/div/div/div/div/div/div/div/div/div[2]/div[4]/div/ct-vehicle-block-price/div/div/div/ct-vehicle-block-price-total-amount/div/div")
	WebElement firstResultPrice;
	
	@FindBy(xpath="//*[@id=\"ct-search-results\"]/div[2]/ct-availability-list-header/div/div/ct-availability-list-sorting/div/div/div[2]/button[2]")
	WebElement sortLowToHighBtn;
	
	
	@FindBy(xpath="//*[@id='ct-container']/div/div[3]/div[2]/ct-availability-list-carousel/ct-horizontal-scroll/div/div[1]/div/div/div/div/div[2]/ct-availability-list-carousel-item/div/div/div[3]")
	WebElement economyBtn;
	
	@FindBy(xpath="//*[@id='ct-availability-list']/div[1]/ct-vehicle-block/div/div/div/div/div/div/div/div/div[1]/div[1]/div/ct-vehicle-block-group/strong")
	WebElement carTypeTitle;
	
	public int getResultCount() {
		WebElement resultcount =wait.until(ExpectedConditions.elementToBeClickable(resultCountLabel));
		System.out.println(resultcount.getText()+" Cars Available");
		return Integer.valueOf(resultcount.getText());
	}
	
	public void applyPickupLocFilterInTerminal() {
		wait.until(ExpectedConditions.visibilityOf(pickupLocFilter));
		pickupLocFilter.click();
	}
	
	public void applyFuelPolicyFilterFullToFull() {
		wait.until(ExpectedConditions.visibilityOf(fuelPolicyFilter));
		fuelPolicyFilter.click();
	}
	
	public void applyCustomerRatingFilterGood() {
		wait.until(ExpectedConditions.visibilityOf(customerRating));
		customerRating.click();
	}
	
	public void applyPassengersFilterFive() {
		wait.until(ExpectedConditions.visibilityOf(passengers));
		passengers.click();
	}
	
	public void getFirstResult() {
		wait.until(ExpectedConditions.visibilityOf(firstResult));
		System.out.println(firstResult.getText());
	}
	
	public int getPrice() {
		wait.until(ExpectedConditions.visibilityOf(firstResultPrice));
//		System.out.println(firstResultPrice.getText());
		String price=firstResultPrice.getText().replaceAll("[^0-9]", "");
		return Integer.parseInt(price);
	}
	
	public void applySortPriceLowToHigh() {

		wait.until(ExpectedConditions.visibilityOf(sortLowToHighBtn));
		sortLowToHighBtn.click();
	}
	
	public void clickEconomy() {
		wait.until(ExpectedConditions.elementToBeClickable(economyBtn));
		economyBtn.click();
	}
	
	public String getCarTypeOfFirstResult() {

		wait.until(ExpectedConditions.visibilityOf(carTypeTitle));
		return carTypeTitle.getText();
	}
}
