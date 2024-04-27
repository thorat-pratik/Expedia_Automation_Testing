package com.expedia.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.expedia.base.TestBase;

public class CustomerServicePage extends TestBase{
	WebDriver driver;
	@FindBy(xpath="//*[@id=\"contextual-banner\"]/div/div[1]/button")
	WebElement cancelTripBtn;
	WebDriverWait wait;
	public CustomerServicePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(50));
	}
	
	public String isCancelTripVisible() {
		wait=new WebDriverWait(driver,Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOf(cancelTripBtn));
		return cancelTripBtn.getText();
	}
}
