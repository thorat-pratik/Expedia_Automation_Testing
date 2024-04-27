package com.expedia.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.expedia.base.TestBase;

public class TestUtil extends TestBase {

	public static String captureScreenshot(WebDriver driver, String testmethod, String status) throws IOException {

		String filepath = System.getProperty("user.dir")+"/screenshots" + "/" + status + "_screenshots/" + testmethod + "_"
				+ System.currentTimeMillis() + ".png";

		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		File destination = new File(filepath);

		FileUtils.copyFile(source, destination);

		return filepath;

	}
}
