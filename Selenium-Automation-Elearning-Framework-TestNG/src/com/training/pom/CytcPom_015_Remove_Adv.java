package com.training.pom;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CytcPom_015_Remove_Adv {
	private static WebDriver driver; 

	public CytcPom_015_Remove_Adv (WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="cyclosUsername")   //Login name text box
	private WebElement userName; 

	@FindBy(id="cyclosPassword")   //Password text box
	private WebElement password;

	@FindBy(xpath="//td[@colspan='2']//input[@value='Submit']")   //Login button
	private WebElement loginBtn; 

	@FindBy(id="memberUsername")    //Enter Member user name
	private WebElement memberusrnm;

	//Click on Manage advertisement submit button
	@FindBy(xpath="//tr[4]//td[1]//fieldset[1]//table[1]//tbody[1]//tr[1]//td[2]//input[1]")
	private WebElement manageadvBtn;

	@FindBy(xpath="//img[@title='Remove']")  //Click on remove advertisement button
	private WebElement removeicon;

	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}

	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}

	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}

	public void sendMemberUserName(String memberusrnm) {
		this.memberusrnm.clear(); 
		this.memberusrnm.sendKeys(memberusrnm); 
	}

	public void moveToElementManageAdvrtntBtn() throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(manageadvBtn).perform();
		takeScreenshot();
		Thread.sleep(2000);
		this.manageadvBtn.click(); 
	}

	public void moveToElementRemoveIcon() throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(removeicon).perform();
		takeScreenshot();
		Thread.sleep(2000);
		this.removeicon.click(); 
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