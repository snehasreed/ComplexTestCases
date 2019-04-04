package com.training.sanity.tests;

import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.training.pom.CytcPom_015_Remove_Adv;
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

public class CYTC_015_Remove_Adv {

	private static WebDriver driver;
	private String baseUrl;
	private CytcPom_015_Remove_Adv CytcPom_015;
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
		CytcPom_015 = new CytcPom_015_Remove_Adv(driver); 
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
	public void Validate_Remove_Advertisement() throws Exception {
		System.out.println("Bank application page is displayed");
		CytcPom_015.sendUserName("admin");
		System.out.println("Admin Login Name is entered");
		CytcPom_015.sendPassword("123456");
		System.out.println("Admin Password is entered");
		Thread.sleep(1000);
		takeScreenshot();
		CytcPom_015.clickLoginBtn();
		System.out.println("Submited the details and it intitiating to home page");
		CytcPom_015.sendMemberUserName("snehasree");
		takeScreenshot();
		System.out.println("Member home page is opened");
		Thread.sleep(1000);
		CytcPom_015.moveToElementManageAdvrtntBtn();
		takeScreenshot();
		System.out.println("Manage Advertisement Button is clicked");
		Thread.sleep(1000);
		CytcPom_015.moveToElementRemoveIcon();
		System.out.println("Remove Advertisement Button is clicked");
		Alert alert = driver.switchTo().alert();
		Thread.sleep(1000);
		System.out.println(alert.getText());
		alert.accept();
		Thread.sleep(1000);
		Alert alert1 = driver.switchTo().alert();
		Thread.sleep(1000);
		System.out.println(alert1.getText());
		alert1.accept();
		takeScreenshot();
	}
	public static void takeScreenshot() throws Exception {
		String timeStamp;
		File screenShotName;
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//The below method will save the screen shot in d drive with name "screenshot.png"
		timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()); 
		screenShotName = new File("C:\\IBM_Selenium_WD\\Screenshots\\CYTC_015"+timeStamp+".png");
		FileUtils.copyFile(scrFile, screenShotName);
	}

}
