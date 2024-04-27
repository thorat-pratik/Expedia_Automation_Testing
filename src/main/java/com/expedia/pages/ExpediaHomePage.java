package com.expedia.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.expedia.base.TestBase;

public class ExpediaHomePage extends TestBase {
	WebDriver driver;
	@FindBy(linkText = "Flights")
	private WebElement fightTab;
	@FindBy(xpath="//button[@title='More travel']")
	private WebElement moreTravel;
	@FindBy(css="a.uitk-header-brand-logo")
	private WebElement expediaLogo; 
	public ExpediaHomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void clickFlightTab() {
		fightTab.click();
	}
	

	public void preRequisite() {
		clickFlightTab();
	}
//	Expedia Home page for Packages

	@FindBy(linkText = "Packages")
	private WebElement packagetab;

	public void clickPackageTab() {
		packagetab.click();
	}

	public void flightPreRequisite() {
		clickPackageTab();
	}
	public void clickMoreTravel() {
		moreTravel.click();
	}
	public String getOptionText(String text) {
		//return driver.findElement(By.xpath("//a[@aria-label='" + text + "']")).getAttribute("href");
		return driver.findElement(By.xpath("//a[@aria-label='" + text + "']")).getTagName();
	}
	public String moreTravelOptions(String optionText) {
		clickMoreTravel();
		String option=getOptionText(optionText) ;
		return option;
	}

}