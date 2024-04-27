package com.expedia.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.expedia.base.TestBase;

public class FlightSearchPage extends TestBase {
	WebDriver driver;
	WebDriverWait wait;
	
	public FlightSearchPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	// @FindBy(xpath="//*[@id=\"search_form_product_selector_flights\"]/div/div[1]/div/ul/li[2]")
	@FindBy(linkText = "One-way")
	private WebElement oneWayButton;
	@FindBy(css = "button[aria-label='Leaving from']")
	private WebElement fromButton;
	@FindBy(id = "origin_select")
	private WebElement from;
	@FindBy(css = "button[aria-label='Going to']")
	private WebElement toButton;
	@FindBy(id = "destination_select")
	private WebElement to;
	@FindBy(css = "button[data-testid='uitk-date-selector-input1-default']")
	private WebElement dateButton;
	@FindBy(css = ".uitk-action-list.no-bullet>li:nth-child(1)")
	private WebElement firstSuggestion;
	@FindBy(id = "search_button")
	private WebElement searchButto;

	public void clickOnewaay() {
		wait.until(ExpectedConditions.elementToBeClickable(oneWayButton)).click();
	}

	public void sendOrigin(String origin) {
		fromButton.click();
		wait.until(ExpectedConditions.visibilityOf(from));
		from.sendKeys(origin);
		wait.until(ExpectedConditions.visibilityOf(firstSuggestion)).click();
	}

	public void sendDestination(String destination) {
		toButton.click();
		wait.until(ExpectedConditions.visibilityOf(to));
		to.sendKeys(destination);
		wait.until(ExpectedConditions.visibilityOf(firstSuggestion)).click();
	}

	public void selectDateOneWay(String Date) {
		String[] datevalues = Date.split(" ");
		dateButton.click();
		String month1 = datevalues[1] + " " + datevalues[2];
		String day1 = datevalues[0];
		String text1 = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(
						By.cssSelector(".uitk-calendar.uitk-calendar-day-selection-circle>div:nth-child(1)>span"))))
				.getText();
		// System.out.println(text1);
		while (!month1.equals(text1)) {
			if (text1.equalsIgnoreCase(month1)) {
				// System.out.println("...."+text1);
				break;
			} else {
				driver.findElement(By.xpath(
						"//*[@id=\"FlightSearchForm_ONE_WAY\"]/div/div[2]/div/section/div[2]/div/div/div[2]/button"))
						.click();
			}
		}
		WebElement divElement = wait.until(ExpectedConditions
				.elementToBeClickable(driver.findElement(By.xpath("//div[contains(text(),'" + day1 + "')]"))));
		divElement.click();
		driver.findElement(By.cssSelector("button[data-stid='apply-date-selector']")).click();

	}

	public void selectDateRoundTrip(String Date1, String Date2) {
		String[] datevalues = Date1.split(" ");
		dateButton.click();
		String month1 = datevalues[1] + " " + datevalues[2];
		String day1 = datevalues[0];
		String text1 = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(
						By.cssSelector(".uitk-calendar.uitk-calendar-day-selection-circle>div:nth-child(1)>span"))))
				.getText();
		System.out.println(text1 + "text1");
		while (!month1.equals(text1)) {
			if (text1.equalsIgnoreCase(month1)) {
				// System.out.println("...."+text1);
				break;
			} else {
				driver.findElement(By.xpath(
						"//*[@id=\"FlightSearchForm_ROUND_TRIP\"]/div/div[2]/div/section/div[2]/div/div/div[2]/button"))
						.click();
			}
		}
		WebElement divElement = wait.until(ExpectedConditions
				.elementToBeClickable(driver.findElement(By.xpath("//div[contains(text(),'" + day1 + "')]"))));
		divElement.click();
		String[] datevalues2 = Date2.split(" ");
		String month2 = datevalues2[1] + " " + datevalues2[2];
		String day2 = datevalues2[0];
		String text2 = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(
						By.cssSelector(".uitk-calendar.uitk-calendar-day-selection-circle>div:nth-child(1)>span"))))
				.getText();
		System.out.println(text2 + "text2 " + month2 + " " + !month2.equals(text2));
		while (!month2.equals(text2)) {
			if (text2.equalsIgnoreCase(month2)) {
				// System.out.println("...."+text1);
				break;
			} else {
				driver.findElement(By.xpath(
						"//*[@id=\"FlightSearchForm_ROUND_TRIP\"]/div/div[2]/div/section/div[2]/div/div/div[2]/button"))
						.click();
			}
		}
		WebElement divElement2 = wait.until(ExpectedConditions
				.elementToBeClickable(driver.findElement(By.xpath("//div[contains(text(),'" + day2 + "')]"))));
		divElement2.click();

		driver.findElement(By.cssSelector("button[data-stid='apply-date-selector']")).click();

	}

	public void clickSearchButton() {
		wait.until(ExpectedConditions.elementToBeClickable(searchButto)).click();
	}

	public FlightResultPage oneWayFlight(String from, String to, String Date) {
		clickOnewaay();
		sendOrigin(from);
		sendDestination(to);
		selectDateOneWay(Date);
		clickSearchButton();
		return new FlightResultPage( driver);
	}

	public FlightResultPage roundTripFlight(String from, String to, String Date1, String Date2) {
		sendOrigin(from);
		sendDestination(to);
		selectDateRoundTrip(Date1, Date2);
		clickSearchButton();
		return new FlightResultPage( driver);
	}

}