package com.training.sanity.tests;

import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.training.pom.CytcPom_044_View_Member_Payment;
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

public class CYTC_044_View_Member_Payment {

	private static WebDriver driver;
	private String baseUrl;
	private CytcPom_044_View_Member_Payment CytcPom_044;
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
		CytcPom_044 = new CytcPom_044_View_Member_Payment(driver); 
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
	public void Validate_View_Member_Payment() throws Exception {
		System.out.println("Bank application page is displayed");

		CytcPom_044.sendUserName("admin"); 
		System.out.println("Login Name is entered");

		CytcPom_044.sendPassword("123456");
		System.out.println("Password is entered");

		Thread.sleep(1000);
		takeScreenshot();
		CytcPom_044.clickLoginBtn();
		System.out.println("Submited the details and it intitiating to home page");

		Thread.sleep(500);
		CytcPom_044.clickAccountBtn();
		takeScreenshot();
		System.out.println("Account information is displaying");

		Thread.sleep(500);
		CytcPom_044.clickMemberPayment();
		takeScreenshot();
		System.out.println("Member Payment details are displaying");

		Thread.sleep(500);
		CytcPom_044.sendRecipientName("Shona");
		System.out.println("Recepient name is eneterd and displaying");

		Thread.sleep(500);
		CytcPom_044.sendAmount("5000");
		System.out.println("Amount is eneterd and displaying");

		Thread.sleep(500);
		CytcPom_044.clickTransactionType();
		System.out.println("Transaction type is selected and displaying");

		Thread.sleep(500);
		CytcPom_044.sendDescription("Welcome");
		System.out.println("Description is selected and displaying");

		Thread.sleep(500);
		takeScreenshot();
		CytcPom_044.clickSubmitButton();
		System.out.println("Submited the details of payment");

		Thread.sleep(1000);
		takeScreenshot();
		CytcPom_044.clickSubmitPayment();
		System.out.println("You are about to perform the following payment is displaying");

		Thread.sleep(1000);
		takeScreenshot();
		System.out.println("The payment has been performed is displaying");

		Thread.sleep(500);
		CytcPom_044.moveToElementLogoutBtn();
		System.out.println("Logout Button is clicked");

		Alert alert = driver.switchTo().alert();
		Thread.sleep(1000);
		System.out.println(alert.getText());
		alert.accept();

		Thread.sleep(1000);
		takeScreenshot();
		System.out.println("Login page is displaying");

		CytcPom_044.sendMemberUserName1("Shona");
		System.out.println("Member Login Name is entered");

		CytcPom_044.sendMemberPassword("Shona3623");
		System.out.println("Member Password is entered");

		Thread.sleep(1000);
		takeScreenshot();
		CytcPom_044.clickMemberLoginBtn();
		System.out.println("Submited the details and it intitiating to home page");

		Thread.sleep(1000);
		takeScreenshot();
		System.out.println("Member Home page is displaying");

		Thread.sleep(500);
		CytcPom_044.clickMemberAccountBtn();
		takeScreenshot();
		System.out.println("Member Account is displaying");

		Thread.sleep(500);
		CytcPom_044.clickMemberAccountInfo();
		takeScreenshot();
		System.out.println("Member Account information is displaying");

	}

	public static void takeScreenshot() throws Exception {
		String timeStamp;
		File screenShotName;
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//The below method will save the screen shot in d drive with name "screenshot.png"
		timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()); 
		screenShotName = new File("C:\\IBM_Selenium_WD\\Screenshots\\CYTC_044"+timeStamp+".png");
		FileUtils.copyFile(scrFile, screenShotName);
	}
}


