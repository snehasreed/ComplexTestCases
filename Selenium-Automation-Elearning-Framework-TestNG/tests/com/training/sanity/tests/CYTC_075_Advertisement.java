package com.training.sanity.tests;

import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.training.dataproviders.LoginDataProviders;
import com.training.pom.CytcPom_075_Advertisement;
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

public class CYTC_075_Advertisement {

	private static WebDriver driver;
	private String baseUrl;
	private CytcPom_075_Advertisement CytcPom_075;
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
		CytcPom_075 = new CytcPom_075_Advertisement(driver); 
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
	public void Validate_Login(String userName, String password, String title, String adcategory, String price, String publicationdate, String expirydate, String description) throws Exception {
		System.out.println("Bank application page is displayed");

		CytcPom_075.sendUserName(userName);
		System.out.println("Login Name is entered");

		CytcPom_075.sendPassword(password);
		System.out.println("Password is entered");
		
		Thread.sleep(1000);
		takeScreenshot();
		CytcPom_075.clickLoginBtn();
		System.out.println("Submited the details and it intitiating to home page");
		
		Thread.sleep(1000);
		takeScreenshot();
		System.out.println("Member Home page is displaying");
		
		Thread.sleep(1000);
		CytcPom_075.clickPersonalTab();
		takeScreenshot();
		System.out.println("Personal tab is displaying");
		
		Thread.sleep(1000);
		CytcPom_075.clickAdvertisementLink();
		takeScreenshot();
		System.out.println("Advertisement list is displaying");
		
		Thread.sleep(1000);
		CytcPom_075.clickNewButtonLink();
		takeScreenshot();
		System.out.println("New advertisement is displaying");
		
		CytcPom_075.sendTitle(title);
		System.out.println("Title is entered");
		
		CytcPom_075.clickCategory();
		System.out.println("Selet category");
		
		Select drpdwntype = new Select(driver.findElement(By.name("ad(category)")));
		drpdwntype.selectByVisibleText(adcategory);
		
		CytcPom_075.sendPrice(price);
		System.out.println("Price is entered");
		
		CytcPom_075.sendPublicationdate(publicationdate);
		System.out.println("Publication date is entered");
		
		CytcPom_075.sendExpirydate(expirydate);
		System.out.println("Expiry date is entered");
		
		CytcPom_075.clickSource();
		CytcPom_075.sendDescription(description);
		System.out.println("Description is entered");
		
		Thread.sleep(1000);
		takeScreenshot();
		CytcPom_075.clickSaveButtonLink();
		
		Alert alert = driver.switchTo().alert();
		Thread.sleep(1000);
		System.out.println(alert.getText());
		alert.accept();
		
	}

	public static void takeScreenshot() throws Exception {
		String timeStamp;
		File screenShotName;
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//The below method will save the screen shot in d drive with name "screenshot.png"
		timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()); 
		screenShotName = new File("C:\\IBM_Selenium_WD\\Screenshots\\Cytc_075_excel"+timeStamp+".png");
		FileUtils.copyFile(scrFile, screenShotName);
	}
}
