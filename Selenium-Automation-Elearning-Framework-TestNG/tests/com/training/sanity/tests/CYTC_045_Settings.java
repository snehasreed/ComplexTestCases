package com.training.sanity.tests;

import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.training.pom.CytcPom_045_Settings;
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

public class CYTC_045_Settings {

	private static WebDriver driver;
	private String baseUrl;
	private CytcPom_045_Settings CytcPom_045;
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
		CytcPom_045 = new CytcPom_045_Settings(driver); 
		baseUrl = properties.getProperty("baseURL");
		// open the browser 
		driver.get(baseUrl);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.close();
	}

	@Test
	public void Validate_Settings_of_Member() throws Exception {
		System.out.println("Bank application page is displayed");

		CytcPom_045.sendUserName("admin"); 
		System.out.println("Login Name is entered");

		CytcPom_045.sendPassword("123456");
		System.out.println("Password is entered");

		Thread.sleep(1000);
		takeScreenshot();
		CytcPom_045.clickLoginBtn();
		System.out.println("Submited the details and it intitiating to home page");

		Thread.sleep(500);
		CytcPom_045.clickSettingsBtn();
		takeScreenshot();
		System.out.println("Setting details are displaying");

		Thread.sleep(500);
		CytcPom_045.clickAlertSettingsBtn();
		takeScreenshot();
		System.out.println("Alert Setting details are displaying");

		Thread.sleep(500);
		CytcPom_045.clickModifyButton();
		takeScreenshot();
		System.out.println("Fields are now editable");

		CytcPom_045.sendReference("2");
		System.out.println("Reference is changed ");

		Thread.sleep(500);
		takeScreenshot();
		CytcPom_045.clickSubmitButton();
		System.out.println("Submited the details");

		Alert alert = driver.switchTo().alert();
		Thread.sleep(1000);
		System.out.println(alert.getText());
		alert.accept();

		Thread.sleep(1000);
		takeScreenshot();
		System.out.println("Alert settings page is displaying");

		Thread.sleep(500);
		CytcPom_045.moveToElementLogoutBtn();
		System.out.println("Logout Button is clicked");

		Alert alert1 = driver.switchTo().alert();
		Thread.sleep(1000);
		System.out.println(alert1.getText());
		alert1.accept();

		Thread.sleep(1000);
		takeScreenshot();
		System.out.println("Login page is displaying");

	}

	@Test(invocationCount = 3)

	public void testCount() throws Exception {

		CytcPom_045.sendMemberUserName1("snehasree");
		System.out.println("Member Login Name is entered");

		CytcPom_045.sendMemberPassword("123457");
		System.out.println("Member Password is entered");

		Thread.sleep(1000);
		takeScreenshot();
		CytcPom_045.clickMemberLoginBtn();
		System.out.println("Submited the details and it intitiating to home page");

		Thread.sleep(1000);
		takeScreenshot();
		CytcPom_045.clickBackBtn();

	}

	public static void takeScreenshot() throws Exception {
		String timeStamp;
		File screenShotName;
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//The below method will save the screen shot in d drive with name "screenshot.png"
		timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()); 
		screenShotName = new File("C:\\IBM_Selenium_WD\\Screenshots\\CYTC_045"+timeStamp+".png");
		FileUtils.copyFile(scrFile, screenShotName);
	}
}
