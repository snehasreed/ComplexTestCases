package com.training.sanity.tests;

import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.training.pom.CytcPom_011;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class CYTC_011_Test {

	private static WebDriver driver;
	private String baseUrl;
	private CytcPom_011 CytcPom_011;
	private Properties properties;

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/error.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void set() throws IOException {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		CytcPom_011 = new CytcPom_011(driver); 
		baseUrl = properties.getProperty("baseURL");
		// open the browser 
		driver.get(baseUrl);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(5000);
		driver.close();
	}

	@Test
	public void Validate_Passwords_are_not_Equal() throws Exception {
		System.out.println("Bank application page is displayed");
		CytcPom_011.sendUserName("admin");
		System.out.println("Admin Login Name is entered");
		CytcPom_011.sendPassword("123456");
		System.out.println("Admin Password is entered");
		Thread.sleep(1000);
		takeScreenshot();
		CytcPom_011.clickLoginBtn();
		System.out.println("Submited the details and it intitiating to home page");
		CytcPom_011.clickPersonalBtn();
		takeScreenshot();
		System.out.println("Personal Info button is clicked");
		Thread.sleep(1000);
		CytcPom_011.clickhangePWBtn();
		takeScreenshot();
		System.out.println("Change Password is initiated");
		Thread.sleep(1000);
		CytcPom_011.sendCurrentPW("123456");
		System.out.println("Current Password is entered");
		CytcPom_011.sendNewPW("987654");
		System.out.println("New Password is entered");
		CytcPom_011.sendConfirmnewPW("654657");
		System.out.println("Confirmation of new password is entered");
		takeScreenshot();
		Thread.sleep(1000);
		CytcPom_011.clickSubmitBtn();
		System.out.println("Submit button is clicked");
		Thread.sleep(1000);
		Alert alert = driver.switchTo().alert();
		Thread.sleep(1000);
		System.out.println(driver.switchTo().alert().getText());
		alert.accept();
		takeScreenshot();
	}
	public static void takeScreenshot() throws Exception {
		String timeStamp;
		File screenShotName;
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//The below method will save the screen shot in d drive with name "screenshot.png"
		timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()); 
		screenShotName = new File("C:\\IBM_Selenium_WD\\Screenshots\\CYTC_011"+timeStamp+".png");
		FileUtils.copyFile(scrFile, screenShotName);
	}

}
