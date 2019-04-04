package com.training.sanity.tests;

import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.training.pom.CytcPom_041_Member_PL;
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

public class CYTC_041_Member_PL {

	private static WebDriver driver;
	private String baseUrl;
	private CytcPom_041_Member_PL CytcPom_041;
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
		CytcPom_041 = new CytcPom_041_Member_PL(driver); 
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
	public void Validate_Member_Granted_Loan() throws Exception {
		System.out.println("Bank application page is displayed");
		
		CytcPom_041.sendUserName("admin");
		System.out.println("Admin Login Name is entered");
		
		CytcPom_041.sendPassword("123456");
		System.out.println("Admin Password is entered");
		
		Thread.sleep(1000);
		takeScreenshot();
		CytcPom_041.clickLoginBtn();
		System.out.println("Submited the details and it intitiating to home page");
		
		Thread.sleep(500);
		CytcPom_041.sendMemberUserName("Shona");
		takeScreenshot();
		System.out.println("Member home page is opened");
		
		Thread.sleep(2000);
		CytcPom_041.moveToElementGrantLoanBtn();
		takeScreenshot();
		System.out.println("Grant Loan Button is clicked");
		
		Thread.sleep(1000);
		CytcPom_041.sendAmount("100000");
		System.out.println("Amount is entered");
		
		Thread.sleep(500);
		CytcPom_041.sendDescription("Home Loan");
		System.out.println("Description of the loan is entered");
		
		Thread.sleep(500);
		takeScreenshot();
		CytcPom_041.clickSubmitBtn();
		System.out.println("Submited the details of loan");
		
		Thread.sleep(1000);
		takeScreenshot();
		CytcPom_041.clickSubmitLoanConfirmationBtn();
		System.out.println("You are about to grant the following loan and details,Click on the details of loan");
		
		Alert alert = driver.switchTo().alert();
		Thread.sleep(1000);
		System.out.println(alert.getText());
		alert.accept();
		
		Thread.sleep(500);
		CytcPom_041.moveToElementViewLoanBtn();
		takeScreenshot();
		System.out.println("view Loan Button is clicked");
		
		Thread.sleep(1000);
		System.out.println("Details of the loan granted is displaying");
		
		Thread.sleep(500);
		CytcPom_041.moveToElementLogoutBtn();
		System.out.println("Logout Button is clicked Button is clicked");
		
		Alert alert1 = driver.switchTo().alert();
		Thread.sleep(1000);
		System.out.println(alert1.getText());
		alert1.accept();
		
		Thread.sleep(1000);
		takeScreenshot();
		System.out.println("Login page is displaying");
		
		CytcPom_041.sendMemberUserName1("Shona");
		System.out.println("Member Login Name is entered");
		
		CytcPom_041.sendMemberPassword("Shona3623");
		System.out.println("Member Password is entered");
		
		Thread.sleep(1000);
		takeScreenshot();
		CytcPom_041.clickMemberLoginBtn();
		System.out.println("Submited the details and it intitiating to home page");
		
		Thread.sleep(500);
		CytcPom_041.clickMemberAccountBtn();
		takeScreenshot();
		System.out.println("Account information is displaying");
		
		Thread.sleep(1000);
		CytcPom_041.clickLoansBtn();
		takeScreenshot();
		System.out.println("Loans granted by admin is displaying");
		
		Thread.sleep(1000);
		CytcPom_041.clickViewBtn();
		takeScreenshot();
		System.out.println("View details of the loan is displaying");
		
		Thread.sleep(1000);
		CytcPom_041.sendRepayAmount("500");
		System.out.println("Repay Amount is entered and is displaying");
		
		takeScreenshot();
		Thread.sleep(1000);
		CytcPom_041.clickRepayBtn();
		System.out.println("Repay button isclicked and pop up messgae is displaying");
		
		Alert alert2 = driver.switchTo().alert();
		Thread.sleep(1000);
		System.out.println(alert2.getText());
		alert2.accept();
		
		Thread.sleep(1000);
		Alert alert3 = driver.switchTo().alert();
		Thread.sleep(1000);
		System.out.println(alert3.getText());
		alert3.accept();
		
		Thread.sleep(1000);
		takeScreenshot();
	}
	public static void takeScreenshot() throws Exception {
		String timeStamp;
		File screenShotName;
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//The below method will save the screen shot in d drive with name "screenshot.png"
		timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()); 
		screenShotName = new File("C:\\IBM_Selenium_WD\\Screenshots\\CYTC_041"+timeStamp+".png");
		FileUtils.copyFile(scrFile, screenShotName);
	}

}
