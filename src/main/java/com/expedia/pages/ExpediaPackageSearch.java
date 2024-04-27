package com.expedia.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.expedia.base.TestBase;

public class ExpediaPackageSearch extends TestBase {
	WebDriver driver;
	WebDriverWait wait;
	public ExpediaPackageSearch(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(50));
	}

//	xpath for Leaving from City
	@FindBy(xpath = "//*[@id='package-search-form']/div/div[1]/div/div[1]/div/div/div[2]/div[1]/button")
	WebElement leavingFromcity;
//	xpath for select Leaving city
	@FindBy(xpath = "//*[@id='origin_select']")
//	xpath for SelectOriginCity from suggestion
	WebElement selectOriginCity;
//	
	@FindBy(xpath = "//*[@id='origin_select-menu']/section/div/div[2]/div/ul/li[1]/div/div/button")
	WebElement entercityforLeaving;

	@FindBy(xpath = "//*[@id='package-search-form\']/div/div[1]/div/div[2]/div/div/div[2]/div[1]/button")
	WebElement goingToCity;

	@FindBy(css = "#destination_select")
	WebElement selectGoingToCity;

	@FindBy(xpath = "//*[@id='destination_select-menu']/section/div/div[2]/div/ul/li[1]/div/div/button")
	WebElement enteredGoingToCity;

	@FindBy(xpath = "//*[@id='package-search-form']/div/div[2]/div/div/div/div/button")
	WebElement selectDates;

	@FindBy(xpath = "//*[@id='package-search-form\']/div/div[2]/div/section/div[2]/div/div/div[3]/div/div[2]/table/tbody/tr[4]/td[5]/div/div[2]")
	WebElement selectLeavingDate;

	@FindBy(xpath = "//*[@id='package-search-form']/div/div[2]/div/section/div[2]/div/div/div[3]/div/div[2]/table/tbody/tr[5]/td[5]/div/div[2]")
	WebElement selectReturnDate;
	@FindBy(xpath = "//*[@id='package-search-form']/div/div[2]/div/section/footer/div/button")
	WebElement doneButton;
//	xpath for Search Button
	@FindBy(xpath = "//*[@id='search_button']")
	WebElement searchButton;

//	Second Page

	@FindBy(xpath = "//*[@id=\"poi-15.57881,73.73935:6074902-xm9\"]")
	WebElement anjunaBeachLocation;

	@FindBy(xpath = "//body/div[@id='app-shopping-pwa']/div[@id='app-layer-manager']/div[@id='app-layer-base']/div/main[@class='white-canvas']/div[@class='uitk-spacing uitk-spacing-margin-medium-inline-six']/div[@class='main-region']/div[@class='constrain-width']/div[@class='uitk-layout-flex uitk-layout-flex-flex-direction-row-reverse']/div[@class='uitk-layout-flex-item uitk-layout-flex-item-flex-grow-1']/section[@data-stid='search-results__main']/div[@class='uitk-spacing uitk-spacing-margin-small-inline-three uitk-spacing-margin-medium-inline-unset']/div[@class='uitk-spacing search-results-listing uitk-spacing-padding-small-block-three uitk-spacing-padding-medium-blockstart-one uitk-spacing-padding-large-blockstart-three']/div[@class='uitk-layout-grid uitk-layout-grid-has-auto-columns uitk-layout-grid-has-columns uitk-layout-grid-has-space uitk-layout-grid-display-grid']/div[@class='uitk-layout-grid-item uitk-layout-grid-item-has-column-start']/div[@data-stid='section-results']/div[@data-stid='property-listing-results']/div[1]/div[1]/div[1]/a[1]")
	WebElement fullyRefundableProperty;

	@FindBy(xpath = "//*[@id='app-layer-base']/div/main/div/div/div/div/div[2]/section[2]/div/div[3]/div/div[2]/div[1]/div[3]/div[2]/div/a")
	WebElement hotel;

// Second Test case Locators

//	selector for region button
	@FindBy(xpath = "//button[normalize-space()='English']")
	WebElement regionButton;

//	Selector for choose region
	@FindBy(xpath = "//select[@id='site-selector']")
	WebElement regionSelector;

// Selector for United States
	@FindBy(xpath = "//*[@id='site-selector']/option[40]")
	WebElement UnitedStatesSelector;

// Save Settings Button
	@FindBy(xpath = "/html/body/div[1]/div[1]/div[2]/section/div[5]/button")
//	@FindBy(linkText = "Save")
//	@FindBy(xpath = "//*[@id='app-layer-disp-settings-picker']/section/div[5]/button")
	WebElement saveSettingButton;
//	
	@FindBy(linkText = "Cruises")
	private WebElement cruisesTab;

//	 Selctor for cruise destination

	@FindBy(xpath = "//button[@aria-label='Going to,']")
	WebElement cruiseGoingTo;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[5]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/button[1]")
	WebElement goingToForCruise;

	@FindBy(xpath = "//*[@id='destination_form_field']")
	WebElement enterGoingToCityForCruise;
//	 Selec going to from SUggestion 
	@FindBy(xpath = "//*[@id='destination_form_field-menu']/section/div/div[2]/div/ul/li[2]/div/div/button")
	WebElement enteredGoingToCityForCruise;

//	 Search Button
	@FindBy(id = "search_button")
	WebElement searchButtonForCruise;

	@FindBy(id = "undefined-error")
	WebElement goingToErrorMessage;

// Ocean View Button
	@FindBy(id = "SuperCategory-oceanview-16j")
	WebElement selectOceanView;

//	 Selected Cruise
	@FindBy(xpath = "//*[@id='app-layer-base']/div/div[2]/div/div[1]/div[3]/div[2]/div[3]/div[2]/div[1]/a")
	WebElement selectedCruise;

// Fourth Test case Locators	 

// Selector for Travel Blog
	@FindBy(xpath = "//*[@id='app-layer-base']/div[1]/div[2]/div[2]/footer/div/div/ul[1]/li[3]/ul/li[8]/div/a")
	WebElement travelBlog;
// Selector to Select India

	@FindBy(linkText = "India")
	WebElement indiaText;
	@FindBy(xpath = "//*[@id='ag-main']/div[2]/a")
	WebElement articleList;

	@FindBy(xpath = "//*[@id='app-layer-base']/div[1]/div[2]/div[1]/div[6]/div[12]/div/div/div/div[1]/div[2]")
	WebElement downloadAppText;

	String downloadAppTextResult = "";

	@FindBy(linkText = "Get the app")
	WebElement getAppText;

	@FindBy(xpath = "//*[@id='site-navigation']/div[2]/a[3]")
	WebElement socialHandleForTwitter;

//	 String articleText;

// 5 -  Selectors for Social Media Handle

	public void clickSelectLeavingFrom() {
		leavingFromcity.click();
		selectOriginCity.click();
		selectOriginCity.sendKeys("Mumbai");
		entercityforLeaving.click();
	}

	public void clickLeavingToCity() {
		goingToCity.click();
		selectGoingToCity.click();
		selectGoingToCity.sendKeys("Goa");
		enteredGoingToCity.click();
	}

	public void selectDatesOfTravelling() throws InterruptedException {
		selectDates.click();
		selectLeavingDate.click();
		selectReturnDate.click();
		doneButton.click();
	}

	public void clickSearchButton() throws InterruptedException {
		searchButton.click();
	}

	public void clickFullyRefundaleProperty() throws InterruptedException {

	}

	public void clickHotel() {
		hotel.click();
	}

	public String getUrlForHotel() {
		String hotelName = hotel.getText();
		return hotelName;
	}

// Second Test Case - For cruise
	public void clickRegionButton() throws InterruptedException {
		regionButton.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("site-selector")));
		regionSelector.click();
		UnitedStatesSelector.click();
		Thread.sleep(2000);

//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[1]/div[2]/section/div[5]/button")));
		saveSettingButton.click();

	}

	public void clickCruiseTab() throws InterruptedException {
		cruisesTab.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='cruise_search_form']/div/div/div[1]/div/div/div[2]/div[1]/button"))).click();

	}

//	Till here 
	public void enterGoingTo() {

		enterGoingToCityForCruise.click();
		enterGoingToCityForCruise.sendKeys("");
//		enteredGoingToCityForCruise.click();
	}

	public void searchCruise() throws InterruptedException {
		searchButtonForCruise.click();
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='app-layer-base']/div/div[2]/div/div[1]/div[3]/div[2]/div[3]/div[2]/div[1]/a")));

//		selectOceanView.click();
		Thread.sleep(2000);
	}

	public String getErrorMessageForGoingTo() {
		String errorMessageforGointTo = goingToErrorMessage.getText();
		return errorMessageforGointTo;
	}

//	Third Test case  

	public void clickTravelBlog() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(travelBlog)).click();

//		articleList.click();

	}

	public String checkBlogisDisplayed() {
		String currentURL = driver.getCurrentUrl();
		return currentURL;
	}

	public void getExpediaMobileApp() throws InterruptedException {
//		Thread.sleep(3000);
//		getAppText.click();
	}

	public String getVerifyText() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id=\"app-layer-base\"]/div[1]/div[2]/div[1]/div[6]/div[12]/div/div/div/div[1]/div[2]")));
		String result = downloadAppText.getText();
//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("marquee-title")));

		return result;

	}

	public void clickTravelBlogForSocials() {
//		travelBlog.click();
		driver.navigate().to("https://twitter.com/ExpediaUK");
	}

	public void checkSocialMediaHandle() {
//		socialHandleForTwitter.click();
	}

}
