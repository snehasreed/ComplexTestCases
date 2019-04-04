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

	public class CytcPom_072_Member_Database {
		private static WebDriver driver; 

		public CytcPom_072_Member_Database (WebDriver driver) {
			this.driver = driver; 
			PageFactory.initElements(driver, this);
		}

		@FindBy(id="cyclosUsername")   //Login Name Text Box
		private WebElement adminuserName;

		@FindBy(id="cyclosPassword")   //Password Text Box
		private WebElement adminpassword;

		@FindBy(xpath="//td[@colspan='2']//input[@value='Submit']")   //Login Button
		private WebElement adminloginBtn;

		@FindBy(xpath="//input[@id='memberUsername']")  //Enter Member user name
		private WebElement memberusrnm;

		//Click on Payment System to member submit button
		@FindBy(xpath="//tr[5]//td[1]//fieldset[1]//table[1]//tbody[1]//tr[2]//td[2]//input[1]")
		private WebElement paymentsystemBtn;

		@FindBy(xpath="//input[@name='amount']")   //Enter Amount for member
		private WebElement amount;

		//Select transaction type for member
		@FindBy(xpath="//select[@name='type']")
		private WebElement transactiontype;

		@FindBy(xpath="//textarea[@id='description']")   //Enter Description for member
		private WebElement description;

		@FindBy(id="submitButton")   //Click on submit button
		private WebElement submitButton;

		@FindBy(xpath="//input[@value='Submit']")   //click on submit button
		private WebElement submitpayment;
		
		@FindBy(xpath="//tr[2]//td[5]//img[1]")  //view 
		private WebElement view;
		
		@FindBy(id="cyclosUsername")   //Login Name Text Box
		private WebElement userName;

		@FindBy(id="cyclosPassword")   //Password Text Box
		private WebElement password;

		@FindBy(xpath="//td[@colspan='2']//input[@value='Submit']")   //Login Button
		private WebElement loginBtn;
		
		@FindBy(xpath="//span[@class='menuText'][contains(text(),'Account')]")
		private WebElement accountbtn;
		
		@FindBy(xpath="//span[contains(text(),'Account Information')]")
		private WebElement accountInfobtn;
		
		@FindBy(xpath="//tr[2]//td[5]//img[1]")
		private WebElement view1;

		public void sendUserName(String adminuserName) {
			this.adminuserName.clear();
			this.adminuserName.sendKeys(adminuserName);
		}

		public void sendPassword(String adminpassword) {
			this.adminpassword.clear(); 
			this.adminpassword.sendKeys(adminpassword); 
		}

		public void clickLoginBtn() {
			this.adminloginBtn.click(); 
		}

		public void sendMemberUserName(String memberusrnm) {
			this.memberusrnm.clear(); 
			this.memberusrnm.sendKeys(memberusrnm);
		}
		
		public void moveToElementPaymentSystemBtn() throws Exception {
			Actions action = new Actions(driver);
			action.moveToElement(paymentsystemBtn).perform();
			takeScreenshot();
			Thread.sleep(2000);
			this.paymentsystemBtn.click(); 
		}

		public void sendAmount(String amount) {
			this.amount.clear(); 
			this.amount.sendKeys(amount); 
		}
		
		public void clickTransactiontype() {
			this.transactiontype.click();
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
		
		public void sendMemberLoginUserName(String adminuserName) {
			this.adminuserName.clear();
			this.adminuserName.sendKeys(adminuserName);
		}

		public void sendMemberPassword(String adminpassword) {
			this.adminpassword.clear(); 
			this.adminpassword.sendKeys(adminpassword); 
		}

		public void clickMemberLoginBtn() {
			this.adminloginBtn.click(); 
		}
		
		public void clickAcountBtn() {
			this.accountbtn.click(); 
		}
		
		public void clickAcountnfoBtn() {
			this.accountInfobtn.click(); 
		}
		
		public void clickView() {
			this.view1.click(); 
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

