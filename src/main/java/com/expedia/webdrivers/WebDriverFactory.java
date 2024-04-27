package com.expedia.webdrivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class WebDriverFactory {

	public static final String CHROME = "chrome";
	public static final String FIREFOX = "firefox";
	public static final String EDGE = "edge";

	public static WebDriver getInstance(String browserName) {
		WebDriver driver;

		if (browserName.equals(CHROME)) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			driver = new ChromeDriver();

		} else if (browserName.equals(FIREFOX)) {
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("-private");
			driver = new FirefoxDriver();
		} else if (browserName.equals(EDGE)) {
			EdgeOptions options = new EdgeOptions();
			options.addArguments("--inprivate");
			driver = new EdgeDriver();
		} else {
			throw new IllegalArgumentException("Unsupport Browser");
		}

		return driver;

	}
}
