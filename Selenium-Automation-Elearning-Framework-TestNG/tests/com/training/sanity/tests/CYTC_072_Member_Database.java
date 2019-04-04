package com.training.sanity.tests;

import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.training.dataproviders.LoginDataProviders;
import com.training.pom.CytcPom_072_Member_Database;
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

public class CYTC_072_Member_Database {

	private static WebDriver driver;
	private String baseUrl;
	private CytcPom_072_Member_Database CytcPom_072;
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
		CytcPom_072 = new CytcPom_072_Member_Database(driver); 
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
	public void Validate_Login(String adminuserName, String memberusrnm, String amount, String transaction, String description) throws Exception {
		System.out.println("Bank application page is displayed");

		CytcPom_072.sendUserName(adminuserName);
		System.out.println("Login Name is entered");

		CytcPom_072.sendPassword("123456");
		System.out.println("Password is entered");
		
		Thread.sleep(1000);
		takeScreenshot();
		CytcPom_072.clickLoginBtn();
		System.out.println("Submited the details and it intitiating to home page");

		Thread.sleep(1000);
		CytcPom_072.sendMemberUserName(memberusrnm);
		takeScreenshot();
		System.out.println("Member home page is opened");

		Thread.sleep(1000);
		takeScreenshot();
		CytcPom_072.moveToElementPaymentSystemBtn();
		System.out.println("Payment System to member Button is clicked");

		takeScreenshot();
		Thread.sleep(1000);
		CytcPom_072.sendAmount(amount);
		System.out.println("Amount for member is entered");

		Thread.sleep(1000);
		CytcPom_072.clickTransactiontype();
		System.out.println("transaction type for member is selected");
		
		Select drpdwntype = new Select(driver.findElement(By.name("type")));
		drpdwntype.selectByVisibleText(transaction);

		Thread.sleep(1000);
		CytcPom_072.sendDescription(description);
		System.out.println("Description for member is entered");

		Thread.sleep(1000);
		takeScreenshot();
		CytcPom_072.clickSubmitButton();
		System.out.println("Submited the details of payment");

		Thread.sleep(1000);
		takeScreenshot();
		CytcPom_072.clickSubmitPayment();
		System.out.println("You are about to perform the following payment is displaying");

		Thread.sleep(1000);
		takeScreenshot();
		System.out.println("The payment has been performed is displaying");

	}
	
	@Test(dataProvider = "db-inputs", dataProviderClass = LoginDataProviders.class)
	public void loginDBTest(String userName, String password) throws Exception {
		
		System.out.println("Bank application page is displayed");

		CytcPom_072.sendMemberLoginUserName(userName);
		System.out.println("Login Name is entered");

		CytcPom_072.sendMemberPassword(password);
		System.out.println("Password is entered");
		
		Thread.sleep(1000);
		takeScreenshot();
		CytcPom_072.clickMemberLoginBtn();
		System.out.println("Submited the details and it intitiating to home page");
		
		Thread.sleep(1000);
		CytcPom_072.clickAcountBtn();
		takeScreenshot();
		System.out.println("Account is clicked");
		
		Thread.sleep(1000);
		CytcPom_072.clickAcountnfoBtn();
		takeScreenshot();
		System.out.println("Account Info is clicked");
		
		Thread.sleep(1000);
		CytcPom_072.clickView();
		System.out.println("View details is clicked");
		
		takeScreenshot();
		System.out.println("member payment details are opened");
		
	}

	public static void takeScreenshot() throws Exception {
		String timeStamp;
		File screenShotName;
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//The below method will save the screen shot in d drive with name "screenshot.png"
		timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()); 
		screenShotName = new File("C:\\IBM_Selenium_WD\\Screenshots\\CYTC_072_excel"+timeStamp+".png");
		FileUtils.copyFile(scrFile, screenShotName);
	}
}
