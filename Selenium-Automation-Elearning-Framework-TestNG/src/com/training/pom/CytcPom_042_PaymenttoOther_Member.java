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

	public class CytcPom_042_PaymenttoOther_Member {
		private static WebDriver driver; 

		public CytcPom_042_PaymenttoOther_Member (WebDriver driver) {
			this.driver = driver; 
			PageFactory.initElements(driver, this);
		}

		@FindBy(id="cyclosUsername")  //Member Login Name text box
		private WebElement memberuserName; 

		@FindBy(id="cyclosPassword")  //Member Password text box
		private WebElement memberpassword;

		@FindBy(xpath="//td[@colspan='2']//input[@value='Submit']")  //Login button
		private WebElement memberloginBtn;

		@FindBy(xpath="//span[@class='menuText'][contains(text(),'Account')]")  //Account Information
		private WebElement memberaccount;
		
		@FindBy(xpath="//span[contains(text(),'Member Payment')]")  //Member payment link is clicked
		private WebElement memberpayment;
		
		@FindBy(id="memberUsername")   //Enter login recipient name to make payment 
		private WebElement recipientname;

		@FindBy(id="amount")   //Enter amount of payment
		private WebElement amount;

		@FindBy(id="description")   //Enter description of the payment
		private WebElement description;

		@FindBy(id="submitButton")   //Click on submit button
		private WebElement submitButton;

		@FindBy(xpath="//input[@value='Submit']")   //click on submit button
		private WebElement submitpayment;

		@FindBy(xpath="//span[contains(text(),'Logout')]")   //Logout Button
		private WebElement logoutBtn;
		
		@FindBy(id="cyclosUsername")   //Login Name Text Box
		private WebElement userName;

		@FindBy(id="cyclosPassword")   //Password Text Box
		private WebElement password;

		@FindBy(xpath="//td[@colspan='2']//input[@value='Submit']")   //Login Button
		private WebElement loginBtn;
		
		@FindBy(xpath="//input[@id='memberUsername']") //Member username is entered
		private WebElement memberlogin;
		
		//Click on Account information of member 
		@FindBy(xpath="//tr[5]//td[1]//fieldset[1]//table[1]//tbody[1]//tr[1]//td[2]//input[1]")
		private WebElement accountinfoBtn;
		
		public void sendMemberUserName(String memberuserName) {
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
		
		public void clickMemberPaymentBtn() {
			this.memberpayment.click(); 
		}
		
		public void sendRecipientName(String recipientname) {
			this.recipientname.clear();
			this.recipientname.sendKeys(recipientname);
		}

		public void sendAmount(String amount) {
			this.amount.clear();
			this.amount.sendKeys(amount);
		}

		public void sendDescription(String description) {
			this.description.clear();
			this.description.sendKeys(description);
		}

		public void clickSubmitButton() {
			this.submitButton.click(); 
		}

		public void clickSubmitPayment() {
			this.submitpayment.click(); 
		}

		public void moveToElementLogoutBtn() {
			this.logoutBtn.click(); 
		}
		
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
		
		public void sendMemberLogin(String memberlogin) {
			this.memberlogin.clear(); 
			this.memberlogin.sendKeys(memberlogin); 
		}
		
		public void moveToElementAccountInfoBtn() throws Exception {
			Thread.sleep(500);
			Actions action = new Actions(driver);
			action.moveToElement(accountinfoBtn).perform();
			takeScreenshot();
			Thread.sleep(2000);
			this.accountinfoBtn.click(); 
		}
	
	public static void takeScreenshot() throws Exception {
		String timeStamp;
		File screenShotName;
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//The below method will save the screen shot in d drive with name "screenshot.png"
		timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()); 
		screenShotName = new File("C:\\IBM_Selenium_WD\\Screenshots\\CYTC_042"+timeStamp+".png");
		FileUtils.copyFile(scrFile, screenShotName);
	}
	
	}
