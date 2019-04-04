package com.training.sanity.tests;

import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.training.pom.CytcPom_043_View_Message;
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

public class CYTC_043_View_Message {

	private static WebDriver driver;
	private String baseUrl;
	private CytcPom_043_View_Message CytcPom_043;
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
		CytcPom_043 = new CytcPom_043_View_Message(driver); 
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
	public void Validate_View_Message() throws Exception {
		System.out.println("Bank application page is displayed");

		CytcPom_043.sendMemberUserName("Shona");
		System.out.println("Member Login Name is entered");

		CytcPom_043.sendMemberPassword("Shona3623");
		System.out.println("Member Password is entered");

		Thread.sleep(1000);
		takeScreenshot();
		CytcPom_043.clickMemberLoginBtn();
		System.out.println("Submited the details and it intitiating to home page");
		
		Thread.sleep(500);
		CytcPom_043.clickMemberPersonalBtn();
		takeScreenshot();
		System.out.println("Personal information is displaying");

		Thread.sleep(1000);
		CytcPom_043.clickMemberMessageBtn();
		takeScreenshot();
		System.out.println("Member Message button is displaying");
		
		Thread.sleep(1000);
		CytcPom_043.clickSendNewMessageBtn();
		takeScreenshot();
		System.out.println("Send New Message Button is displaying");
		
		Thread.sleep(500);
		CytcPom_043.Sendto();
		System.out.println("Send To Option is selected");
		
		Thread.sleep(500);
		CytcPom_043.Category();
		System.out.println("Category Option is selected");
		
		Thread.sleep(500);
		CytcPom_043.sendSubject("Hello");
		System.out.println("Subject of the message is entered");
		
		Thread.sleep(500);
		CytcPom_043.clickBody();
		Thread.sleep(500);
		CytcPom_043.sendText("Welcome");
		System.out.println("Body of the message is entered");
		
		Thread.sleep(1000);
		takeScreenshot();
		CytcPom_043.Submit();
		System.out.println("Submited the details");
		
		Alert alert = driver.switchTo().alert();
		Thread.sleep(1000);
		System.out.println(alert.getText());
		alert.accept();
		
		Thread.sleep(1000);
		takeScreenshot();
		
		CytcPom_043.moveToElementLogoutBtn();
		System.out.println("Logout Button is clicked Button is clicked");
		
		Alert alert1 = driver.switchTo().alert();
		Thread.sleep(1000);
		System.out.println(alert1.getText());
		alert1.accept();

		Thread.sleep(1000);
		takeScreenshot();
		System.out.println("Login page is displaying");

		CytcPom_043.sendUserName("admin");
		System.out.println("Admin Login Name is entered");

		CytcPom_043.sendPassword("123456");
		System.out.println("Admin Password is entered");

		Thread.sleep(1000);
		takeScreenshot();
		CytcPom_043.clickLoginBtn();
		System.out.println("Submited the details of admin login and it intitiating to home page");
		
		Thread.sleep(500);
		CytcPom_043.clickAdminMessage();
		takeScreenshot();
		System.out.println("Message button from menu is displaying");
		
		Thread.sleep(1000);
		CytcPom_043.clickAdminMessageBtn();
		takeScreenshot();
		System.out.println("Message button from sub-menu is displaying");
		
		Thread.sleep(1000);
		CytcPom_043.moveToElementViewMessage();
		takeScreenshot();
		System.out.println("Message is displaying");
		
	}
	public static void takeScreenshot() throws Exception {
		String timeStamp;
		File screenShotName;
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//The below method will save the screen shot in d drive with name "screenshot.png"
		timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()); 
		screenShotName = new File("C:\\IBM_Selenium_WD\\Screenshots\\CYTC_043"+timeStamp+".png");
		FileUtils.copyFile(scrFile, screenShotName);
	}

}
