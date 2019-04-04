package com.training.sanity.tests;

import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.training.pom.CytcPom_014_Add_Adv;
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

public class CYTC_014_Add_Adv {

	private static WebDriver driver;
	private String baseUrl;
	private CytcPom_014_Add_Adv CytcPom_014;
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
		CytcPom_014 = new CytcPom_014_Add_Adv(driver); 
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
	public void Validate_Add_Advertisement() throws Exception {
		System.out.println("Bank application page is displayed");
		CytcPom_014.sendUserName("admin");
		System.out.println("Admin Login Name is entered");
		CytcPom_014.sendPassword("123456");
		System.out.println("Admin Password is entered");
		Thread.sleep(1000);
		takeScreenshot();
		CytcPom_014.clickLoginBtn();
		System.out.println("Submited the details and it intitiating to home page");
		CytcPom_014.sendMemberUserName("snehasree");
		takeScreenshot();
		System.out.println("Member home page is opened");
		Thread.sleep(1000);
		CytcPom_014.moveToElementManageAdvrtntBtn();
		takeScreenshot();
		System.out.println("Manage Advertisement Button is clicked");
		Thread.sleep(1000);
		CytcPom_014.clickInsertNewAdv();
		System.out.println("Insert New Advertisement Button is clicked");
		CytcPom_014.sendTitle("new offer");
		System.out.println("Title name is entered");
		Thread.sleep(500);
		CytcPom_014.Category();
		System.out.println("Category is selected");
		Thread.sleep(500);
		CytcPom_014.sendPrice("7");
		System.out.println("Price is entered");
		Thread.sleep(500);
		CytcPom_014.NotExpirableCheck();
		System.out.println("Check point is clicked");
		Thread.sleep(500);
		CytcPom_014.Source();
		Thread.sleep(500);
		CytcPom_014.moveToElementDescriptionText("New Offer for Member");
		System.out.println("Description is entered");
		Thread.sleep(1000);
		takeScreenshot();
		CytcPom_014.moveToElementSaveButton();
		System.out.println("Submit button is clicked");
		Alert alert = driver.switchTo().alert();
		Thread.sleep(1000);
		System.out.println(alert.getText());
		alert.accept();
		Thread.sleep(500);
		CytcPom_014.moveToElementclickBackBtn();
		System.out.println("Back button is clicked");
		takeScreenshot();
	}
	public static void takeScreenshot() throws Exception {
		String timeStamp;
		File screenShotName;
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//The below method will save the screen shot in d drive with name "screenshot.png"
		timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()); 
		screenShotName = new File("C:\\IBM_Selenium_WD\\Screenshots\\CYTC_014"+timeStamp+".png");
		FileUtils.copyFile(scrFile, screenShotName);
	}

}
