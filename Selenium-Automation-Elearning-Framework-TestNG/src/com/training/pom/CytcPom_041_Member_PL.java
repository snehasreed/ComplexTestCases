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

public class CytcPom_041_Member_PL {
	private static WebDriver driver; 

	public CytcPom_041_Member_PL (WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="cyclosUsername")  //Login Name text box
	private WebElement userName; 

	@FindBy(id="cyclosPassword")  //Password text box
	private WebElement password;

	@FindBy(xpath="//td[@colspan='2']//input[@value='Submit']")  //Login button
	private WebElement loginBtn; 

	@FindBy(id="memberUsername")  //Enter Member user name
	private WebElement memberusrnm;

	@FindBy(xpath="//tr[8]//td[1]//fieldset[1]//table[1]//tbody[1]//tr[1]//td[4]//input[1]")
	private WebElement grantloanBtn;

	@FindBy(xpath="//input[@name='loan(amount)']")  //Insert Amount
	private WebElement insrtamt;

	@FindBy(xpath="//textarea[@name='loan(description)']")  //Enter Description of the loan
	private WebElement description;

	@FindBy(xpath="//input[@value='Submit']")  //Submit button
	private WebElement submitBtn;

	@FindBy(xpath="//input[@value='Submit']")  //Confirmation of loan submit button
	private WebElement submitloancnfrmBtn;

	//Click on view loan submit button
	@FindBy(xpath="//tr[8]//td[1]//fieldset[1]//table[1]//tbody[1]//tr[1]//td[2]//input[1]")  
	private WebElement viewloanBtn;

	@FindBy(xpath="//span[contains(text(),'Logout')]")   //Logout Button
	private WebElement logoutBtn;

	@FindBy(id="cyclosUsername")  //Login Name text box
	private WebElement memberuserName; 

	@FindBy(id="cyclosPassword")  //Password text box
	private WebElement memberpassword;

	@FindBy(xpath="//td[@colspan='2']//input[@value='Submit']")  //Login button
	private WebElement memberloginBtn; 

	@FindBy(xpath="//span[@class='menuText'][contains(text(),'Account')]")  //Account Information
	private WebElement memberaccount; 

	@FindBy(xpath="//span[contains(text(),'Loans')]")  //Loans Button
	private WebElement loansBtn;

	@FindBy(xpath="//img[@title='View']")  //View Button
	private WebElement viewBtn;

	@FindBy(xpath="//input[@id='amountText']")  //Insert Amount to Repay
	private WebElement repayamount;

	@FindBy(xpath="//input[@value='Repay']")  //Repay Button
	private WebElement repayBtn;

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

	public void moveToElementGrantLoanBtn() throws Exception {
		Thread.sleep(500);
		Actions action = new Actions(driver);
		action.moveToElement(grantloanBtn).perform();
		takeScreenshot();
		Thread.sleep(2000);
		this.grantloanBtn.click(); 
	}

	public void sendAmount(String insrtamt) {
		this.insrtamt.clear();
		this.insrtamt.sendKeys(insrtamt);
	} 

	public void sendDescription(String description) {
		this.description.clear();
		this.description.sendKeys(description);
	} 

	public void clickSubmitBtn() {
		this.submitBtn.click(); 
	}

	public void clickSubmitLoanConfirmationBtn() {
		this.submitloancnfrmBtn.click(); 
	}

	public void moveToElementViewLoanBtn() throws Exception {
		Thread.sleep(500);
		Actions action = new Actions(driver);
		action.moveToElement(viewloanBtn).perform();
		takeScreenshot();
		Thread.sleep(2000);
		this.viewloanBtn.click(); 
	}

	public void moveToElementLogoutBtn() {
		this.logoutBtn.click(); 
	}

	public void sendMemberUserName1(String memberuserName) {
		this.memberuserName.clear();
		this.memberuserName.sendKeys(memberuserName);
	}

	public void sendMemberPassword(String memberpassword) {
		this.memberpassword.clear(); 
		this.memberpassword.sendKeys(memberpassword); 
	}

	public void clickMemberLoginBtn() {
		this.memberloginBtn.click(); 
	}

	public void clickMemberAccountBtn() {
		this.memberaccount.click(); 
	}

	public void clickLoansBtn() {
		this.loansBtn.click(); 
	}

	public void clickViewBtn() {
		this.viewBtn.click(); 
	}

	public void sendRepayAmount(String repayamount) {
		this.repayamount.clear();
		this.repayamount.sendKeys(repayamount);
	} 

	public void clickRepayBtn() {
		this.repayBtn.click(); 
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

