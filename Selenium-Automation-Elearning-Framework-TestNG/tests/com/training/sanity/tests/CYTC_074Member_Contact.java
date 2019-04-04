package com.training.sanity.tests;

import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.training.dataproviders.LoginDataProviders;
import com.training.pom.CytcPom_074_Member_Contact;
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

public class CYTC_074Member_Contact {

	private static WebDriver driver;
	private String baseUrl;
	private CytcPom_074_Member_Contact CytcPom_074;
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
		CytcPom_074 = new CytcPom_074_Member_Contact(driver); 
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
	public void Validate_Login(String userName, String password, String memberusrnm, String amount, String description) throws Exception {
		System.out.println("Bank application page is displayed");

		CytcPom_074.sendUserName(userName);
		System.out.println("Login Name is entered");

		CytcPom_074.sendPassword(password);
		System.out.println("Password is entered");
		
		Thread.sleep(1000);
		takeScreenshot();
		CytcPom_074.clickLoginBtn();
		System.out.println("Submited the details and it intitiating to home page");
		
		Thread.sleep(1000);
		takeScreenshot();
		System.out.println("Member Home page is displaying");
		
		Thread.sleep(1000);
		CytcPom_074.clickPersonalTab();
		takeScreenshot();
		System.out.println("Personal tab is displaying");
		
		Thread.sleep(1000);
		CytcPom_074.clickContactsLink();
		takeScreenshot();
		System.out.println("Contacts list is displaying");
		
		Thread.sleep(1000);
		CytcPom_074.sendMemberUserName(memberusrnm);
		CytcPom_074.clickMemberSelection();
		takeScreenshot();
		System.out.println("Member home page is opened");
		
		CytcPom_074.clickContactSubmit();
		System.out.println("Submit the button to enter in the contacts list");
		
		Alert alert = driver.switchTo().alert();
		Thread.sleep(1000);
		System.out.println(alert.getText());
		alert.accept();
		
		Thread.sleep(1000);
		takeScreenshot();
		System.out.println("Contact is added to the contact list");
		
		CytcPom_074.clickAddedContact();
		takeScreenshot();
		System.out.println("Click on added contact from the contacts list");
		
		Thread.sleep(1000);
		CytcPom_074.moveToElementMakePayment();
		takeScreenshot();
		System.out.println("Make Payment is submited and Payment to member page is displaying");
		
		Thread.sleep(1000);
		CytcPom_074.sendAmount(amount);
		System.out.println("Amount for member is entered");
		
		Thread.sleep(1000);
		CytcPom_074.sendDescription(description);
		System.out.println("Description for member is entered");

		Thread.sleep(1000);
		takeScreenshot();
		CytcPom_074.clickSubmitButton();
		System.out.println("Submited the details of payment");

		Thread.sleep(1000);
		takeScreenshot();
		CytcPom_074.clickSubmitPayment();
		System.out.println("You are about to perform the following payment is displaying");

		Thread.sleep(1000);
		takeScreenshot();
		System.out.println("The payment has been performed is displaying");
		
		CytcPom_074.clickLogout();
		System.out.println("Logout Button is clicked");
		
		Alert alert1 = driver.switchTo().alert();
		Thread.sleep(1000);
		System.out.println(alert1.getText());
		alert1.accept();
		
		Thread.sleep(1000);
		takeScreenshot();
		System.out.println("Login page is displaying");
		
		CytcPom_074.sendUserName(userName);
		System.out.println("Login Name is entered");

		CytcPom_074.sendPassword(password);
		System.out.println("Password is entered");
		
		Thread.sleep(1000);
		takeScreenshot();
		CytcPom_074.clickLoginBtn();
		System.out.println("Submited the details and it intitiating to home page");
		
		Thread.sleep(1000);
		CytcPom_074.clickAccount();
		takeScreenshot();
		System.out.println("Account tab is displaying");
		
		Thread.sleep(1000);
		CytcPom_074.clickAccountInfo();
		takeScreenshot();
		System.out.println("Account Information is displaying");
		
		Thread.sleep(1000);
		CytcPom_074.clickView();
		takeScreenshot();
		System.out.println("Transaction details is displaying");
		
		Thread.sleep(1000);
		CytcPom_074.clickBack();
		takeScreenshot();
		System.out.println("Back Button is clicked");
		
	}

	public static void takeScreenshot() throws Exception {
		String timeStamp;
		File screenShotName;
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//The below method will save the screen shot in d drive with name "screenshot.png"
		timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()); 
		screenShotName = new File("C:\\IBM_Selenium_WD\\Screenshots\\Cytc_074_excel"+timeStamp+".png");
		FileUtils.copyFile(scrFile, screenShotName);
	}
}