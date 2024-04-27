package com.expedia.utilities;
import org.openqa.selenium.WebDriver;

import com.expedia.base.TestBase;


public class BrowserConfig extends TestBase {
	public BrowserConfig(){
		super();
	}
	public static void goTo(String url,WebDriver driver) {
		driver.get(url);
	}
	public static void close(WebDriver driver) {
		driver.close();
	}	
	public static WebDriver Driver(WebDriver driver) {
		return driver;
	}
	
	
	
	
	
}
