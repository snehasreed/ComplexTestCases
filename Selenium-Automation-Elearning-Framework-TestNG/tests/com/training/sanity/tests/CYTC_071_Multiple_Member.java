package com.training.sanity.tests;

import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.training.dataproviders.LoginDataProviders;
import com.training.pom.CytcPom_071_Multiple_Members;
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

public class CYTC_071_Multiple_Member {

	private static WebDriver driver;
	private String baseUrl;
	private CytcPom_071_Multiple_Members CytcPom_071;
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
		CytcPom_071 = new CytcPom_071_Multiple_Members(driver); 
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
	public void Validate_Login(String userName, String memberusrnm, String amount, String transaction, String description) throws Exception {
		System.out.println("Bank application page is displayed");

		CytcPom_071.sendUserName(userName);
		System.out.println("Login Name is entered");

		CytcPom_071.sendPassword("123456");
		System.out.println("Password is entered");
		
		Thread.sleep(1000);
		takeScreenshot();
		CytcPom_071.clickLoginBtn();
		System.out.println("Submited the details and it intitiating to home page");

		Thread.sleep(1000);
		CytcPom_071.sendMemberUserName(memberusrnm);
		takeScreenshot();
		CytcPom_071.clickMemberSelection();
		System.out.println("Member home page is opened");

		Thread.sleep(1000);
		takeScreenshot();
		CytcPom_071.moveToElementPaymentSystemBtn();
		System.out.println("Payment System to member Button is clicked");

		takeScreenshot();
		Thread.sleep(1000);
		CytcPom_071.sendAmount(amount);
		System.out.println("Amount for member is entered");

		Thread.sleep(1000);
		CytcPom_071.clickTransactiontype();
		System.out.println("transaction type for member is selected");
		
		Select drpdwntype = new Select(driver.findElement(By.name("type")));
		drpdwntype.selectByVisibleText(transaction);

		Thread.sleep(1000);
		CytcPom_071.sendDescription(description);
		System.out.println("Description for member is entered");

		Thread.sleep(1000);
		takeScreenshot();
		CytcPom_071.clickSubmitButton();
		System.out.println("Submited the details of payment");

		Thread.sleep(1000);
		takeScreenshot();
		CytcPom_071.clickSubmitPayment();
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
		screenShotName = new File("C:\\IBM_Selenium_WD\\Screenshots\\CYTC_071_excel"+timeStamp+".png");
		FileUtils.copyFile(scrFile, screenShotName);
	}
}
