package com.training.sanity.tests;

import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.training.pom.CytcPom_012_Admin;
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

public class CYTC_012_Admin_Logout_Test {

	private static WebDriver driver;
	private String baseUrl;
	private CytcPom_012_Admin CytcPom_012;
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
		CytcPom_012 = new CytcPom_012_Admin(driver); 
		baseUrl = properties.getProperty("baseURL");
		// open the browser 
		driver.get(baseUrl);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.navigate().refresh();
		Thread.sleep(1000);
		driver.close();
	}

	@Test
	public void Validate_Admin_Login_Logout_Member() throws Exception {
		System.out.println("Bank application page is displayed");
		CytcPom_012.sendUserName("admin"); 
		System.out.println("Login Name is entered");
		CytcPom_012.sendPassword("123456");
		System.out.println("Password is entered");
		Thread.sleep(1000);
		takeScreenshot();
		CytcPom_012.clickLoginBtn();
		System.out.println("Submited the details and it intitiating to home page");
		Thread.sleep(2000);
		System.out.println("Welcome to the Bank");
		Thread.sleep(2000);
		takeScreenshot();
		CytcPom_012.moveToElementLogoutBtn();
		System.out.println("Logout button is clicked");
		Thread.sleep(500);
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
		screenShotName = new File("C:\\IBM_Selenium_WD\\Screenshots\\CYTC_012_Admin"+timeStamp+".png");
		FileUtils.copyFile(scrFile, screenShotName);
	}
}
