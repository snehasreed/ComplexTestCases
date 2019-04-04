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

public class CytcPom_013 {
	private static WebDriver driver; 

	public CytcPom_013 (WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="cyclosUsername")  //Login name text box
	private WebElement userName; 

	@FindBy(id="cyclosPassword")  //Password text box
	private WebElement password;

	@FindBy(xpath="//td[@colspan='2']//input[@value='Submit']")  //Login button
	private WebElement loginBtn; 

	@FindBy(id="memberUsername")  //Member Username
	private WebElement memberusrnm;

	//Click on Manage login password submit button
	@FindBy(xpath="//body[@class='main']//tr//tr[2]//td[1]//fieldset[1]//table[1]//tbody[1]//tr[1]//td[4]//input[1]")
	private WebElement managelgnpwBtn;

	@FindBy(name="newPassword")  //New Password text box
	private WebElement newPW;

	@FindBy(name="newPasswordConfirmation")  //Confirmation of new password text box
	private WebElement confirmnewPW;

	@FindBy(xpath="//table[@class='defaultTable']//input[@value='true']")  //Click on check box
	private WebElement checkbox;

	@FindBy(xpath="//input[@id='resetAndSendButton']")  //Click on reset and send email submit button
	private WebElement rstpwsndemail; 

	@FindBy(xpath="//input[@id='backButton']")  //Click on back submit button
	private WebElement backBtn; 

	//Click on allow user to login now submit button
	@FindBy(xpath="//body[@class='main']//tr//tr[2]//td[1]//fieldset[1]//table[1]//tbody[1]//tr[1]//td[2]//input[1]")
	private WebElement alwusr2lgnnwBtn;

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

	public void moveToElementManageLgnPwBtn() throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(managelgnpwBtn).perform();
		takeScreenshot();
		Thread.sleep(3000);
		this.managelgnpwBtn.click(); 
	}

	public void sendNewPW(String newPW) {
		this.newPW.clear();
		this.newPW.sendKeys(newPW);
	} 

	public void sendConfirmnewPW(String confirmnewPW) {
		this.confirmnewPW.clear();
		this.confirmnewPW.sendKeys(confirmnewPW);
	} 

	public void clickCheckBox() {
		this.checkbox.click(); 
	}

	public void clickResetPwSendEmail() throws Exception {
		Thread.sleep(500);
		this.rstpwsndemail.click(); 
	}

	public void clickBackBtn() throws Exception {
		Thread.sleep(500);
		takeScreenshot();
		this.backBtn.click(); 
	}

	public void moveToElementAllowUsertoLgnNwBtn() throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(alwusr2lgnnwBtn).perform();
		takeScreenshot();
		Thread.sleep(3000);
		this.alwusr2lgnnwBtn.click(); 
	}

	public static void takeScreenshot() throws Exception {
		String timeStamp;
		File screenShotName;
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//The below method will save the screen shot in d drive with name "screenshot.png"
		timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()); 
		screenShotName = new File("C:\\IBM_Selenium_WD\\Screenshots\\CYTC_013"+timeStamp+".png");
		FileUtils.copyFile(scrFile, screenShotName);
	}

}
