package com.training.sanity.tests;

import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.training.dataproviders.LoginDataProviders;
import com.training.pom.CytcPom_073_Multiple_Contacts;
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
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class CYTC_073_Multiple_Contacts {

	private static WebDriver driver;
	private String baseUrl;
	private CytcPom_073_Multiple_Contacts CytcPom_073;
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
		CytcPom_073 = new CytcPom_073_Multiple_Contacts(driver); 
		baseUrl = properties.getProperty("baseURL");
		// open the browser 
		driver.get(baseUrl);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.close();
	}

	@Test(dataProvider = "excel-inputs", dataProviderClass = LoginDataProviders.class)
	public void Validate_Login(String userName, String password, String memberusrnm, String amount, String contact, String description) throws Exception {
		System.out.println("Bank application page is displayed");

		CytcPom_073.sendUserName(userName);
		System.out.println("Login Name is entered");

		CytcPom_073.sendPassword(password);
		System.out.println("Password is entered");
		
		Thread.sleep(1000);
		takeScreenshot();
		CytcPom_073.clickLoginBtn();
		System.out.println("Submited the details and it intitiating to home page");
		
		Thread.sleep(1000);
		takeScreenshot();
		System.out.println("Member Home page is displaying");
		
		Thread.sleep(1000);
		CytcPom_073.clickPersonalTab();
		takeScreenshot();
		System.out.println("Personal tab is displaying");
		
		Thread.sleep(1000);
		CytcPom_073.clickContactsLink();
		takeScreenshot();
		System.out.println("Contacts list is displaying");
		
		Thread.sleep(1000);
		CytcPom_073.sendMemberUserName(memberusrnm);
		CytcPom_073.clickMemberSelection();
		takeScreenshot();
		System.out.println("Member home page is opened");
		
		CytcPom_073.clickContactSubmit();
		System.out.println("Submit the button to enter in the contacts list");
		
		Alert alert = driver.switchTo().alert();
		Thread.sleep(1000);
		System.out.println(alert.getText());
		alert.accept();
		
		Thread.sleep(1000);
		takeScreenshot();
		System.out.println("Contact is added to the contact list");
		
		CytcPom_073.clickAddedContact();
		takeScreenshot();
		System.out.println("Click on added contact from the contacts list");
		
		Thread.sleep(1000);
		CytcPom_073.moveToElementMakePayment();
		takeScreenshot();
		System.out.println("Make Payment is submited and Payment to member page is displaying");
		
		Thread.sleep(1000);
		CytcPom_073.sendAmount(amount);
		System.out.println("Amount for member is entered");
		
		Thread.sleep(1000);
		CytcPom_073.sendDescription(description);
		System.out.println("Description for member is entered");

		Thread.sleep(1000);
		takeScreenshot();
		CytcPom_073.clickSubmitButton();
		System.out.println("Submited the details of payment");

		Thread.sleep(1000);
		takeScreenshot();
		CytcPom_073.clickSubmitPayment();
		System.out.println("You are about to perform the following payment is displaying");

		Thread.sleep(1000);
		takeScreenshot();
		System.out.println("The payment has been performed is displaying");
		
	}

	public static void takeScreenshot() throws Exception {
		String timeStamp;
		File screenShotName;
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//The below method will save the screen shot in d drive with name "screenshot.png"
		timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()); 
		screenShotName = new File("C:\\IBM_Selenium_WD\\Screenshots\\CYTC_073_excel"+timeStamp+".png");
		FileUtils.copyFile(scrFile, screenShotName);
	}
}

