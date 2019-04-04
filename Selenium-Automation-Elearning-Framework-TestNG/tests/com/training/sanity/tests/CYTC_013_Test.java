package com.training.sanity.tests;

import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.training.pom.CytcPom_013;
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

public class CYTC_013_Test {

	private static WebDriver driver;
	private String baseUrl;
	private CytcPom_013 CytcPom_013;
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
		CytcPom_013 = new CytcPom_013(driver); 
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
	public void Validate_AllowUserToChangeMemberLoginPassword() throws Exception {
		System.out.println("Bank application page is displayed");
		CytcPom_013.sendUserName("admin");
		System.out.println("Admin Login Name is entered");
		CytcPom_013.sendPassword("123456");
		System.out.println("Admin Password is entered");
		Thread.sleep(1000);
		takeScreenshot();
		CytcPom_013.clickLoginBtn();
		System.out.println("Submited the details and it intitiating to home page");
		CytcPom_013.sendMemberUserName("snehasree");
		takeScreenshot();
		System.out.println("Member home page is opened");
		Thread.sleep(1000);
		CytcPom_013.moveToElementManageLgnPwBtn();
		takeScreenshot();
		System.out.println("Manage login Button is clicked");
		Thread.sleep(1000);
		CytcPom_013.sendNewPW("123456");
		System.out.println("New Password is entered");
		CytcPom_013.sendConfirmnewPW("123456");
		System.out.println("Confirmation of new password is entered");
		CytcPom_013.clickCheckBox();
		System.out.println("Check Box is selected");
		takeScreenshot();
		Thread.sleep(1000);
		CytcPom_013.clickResetPwSendEmail();
		System.out.println("Submit button is clicked");
		Thread.sleep(1000);
		Alert alert = driver.switchTo().alert();
		Thread.sleep(1000);
		System.out.println(alert.getText());
		alert.accept();
		Thread.sleep(1000);
		Alert alert1 = driver.switchTo().alert();
		Thread.sleep(1000);
		System.out.println(alert1.getText());
		alert1.accept();
		CytcPom_013.clickBackBtn();
		System.out.println("Back Button is selected");
		Thread.sleep(1000);
		CytcPom_013.moveToElementAllowUsertoLgnNwBtn();
		System.out.println("Allow User to Login Now Button is selected");
		Thread.sleep(1000);
		Alert alert2 = driver.switchTo().alert();
		Thread.sleep(1000);
		System.out.println(alert2.getText());
		alert2.accept();
		takeScreenshot();
	}
	public static void takeScreenshot() throws Exception {
		String timeStamp;
		File screenShotName;
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//The below method will save the screen shot in d drive with name "screenshot.png"
		timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()); 
		screenShotName = new File("C:\\IBM_Selenium_WD\\Screenshots\\CYTC_013"+timeStamp+".png");
		FileUtils.copyFile(scrFile, screenShotName);
	}

}

