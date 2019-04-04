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

	public class CytcPom_043_View_Message {
		private static WebDriver driver; 

		public CytcPom_043_View_Message (WebDriver driver) {
			this.driver = driver; 
			PageFactory.initElements(driver, this);
		}

		@FindBy(id="cyclosUsername")  //Member Login Name text box
		private WebElement memberuserName; 

		@FindBy(id="cyclosPassword")  //Member Password text box
		private WebElement memberpassword;

		@FindBy(xpath="//td[@colspan='2']//input[@value='Submit']")  //Login button
		private WebElement memberloginBtn;
		
		@FindBy(xpath="//span[contains(text(),'Personal')]")  //Personal Information
		private WebElement memberpersonal; 

		@FindBy(xpath="//span[contains(text(),'Messages')]")  //Member message Button
		private WebElement membermessageBtn;
		
		@FindBy(id="newButton")  //Send message submit Button
		private WebElement sendnwmsgBtn;
		
		//To select send to option
		@FindBy(xpath="//select[@id='sendToSelect']//option[@value='ADMIN']")
		private WebElement sendto;
		
		//To select category option
		@FindBy(xpath="//select[@id='categorySelect']//option[@value='3']")
		private WebElement category;
		
		@FindBy(xpath="//input[@name='message(subject)']")  //Enter Subject of the message
		private WebElement subject;
		
		//@FindBy(xpath="//iframe[@title='Rich text editor, bodyText']") 
		//Enter Body of the message
		@FindBy(xpath="//span[@id='cke_28_label']") 
		private WebElement body;
		
		//Enter text in the body
		@FindBy(xpath="//textarea[@class='cke_source cke_enable_context_menu']")
		private WebElement text;
		
		@FindBy(xpath="//input[@value='Submit']")  //Submit Button
		private WebElement submit;
		
		@FindBy(xpath="//span[contains(text(),'Logout')]")   //Logout Button
		private WebElement logoutBtn;
		
		@FindBy(id="cyclosUsername")  //Admin Login Name is entered
		private WebElement userName; 

		@FindBy(id="cyclosPassword")  //Admin Password is entered
		private WebElement password;

		@FindBy(xpath="//td[@colspan='2']//input[@value='Submit']")   //Login Button
		private WebElement loginBtn;
		
		@FindBy(xpath="//span[@class='menuText'][contains(text(),'Messages')]")  //Admin message option
		private WebElement adminmessage;
		
		@FindBy(xpath="//span[@class='subMenuText'][contains(text(),'Messages')]")  //Message from message option
		private WebElement adminmessageBtn;
		
		//to view message
		@FindBy(xpath="//body[@class='main']//tr//tr[2]//td[3]//table[1]//tbody[1]//tr[1]//td[2]//a[1]")
		private WebElement viewmessage;
		
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
		
		public void clickMemberPersonalBtn() {
			this.memberpersonal.click(); 
		}

		public void clickMemberMessageBtn() {
			this.membermessageBtn.click(); 
		}
		
		public void clickSendNewMessageBtn() {
			this.sendnwmsgBtn.click(); 
		}
		
		public void Sendto() {
			this.sendto.click();
		}
		
		public void Category() {
			this.category.click();
		}
		
		public void sendSubject(String subject) {
			this.subject.clear();
			this.subject.sendKeys(subject);
		}
		
		public void clickBody() {
			this.body.click();
		}
		
		public void sendText(String text) {
			this.text.clear();
			this.text.sendKeys(text);
		}
		
		public void Submit() {
			this.submit.click();
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
		
		public void clickAdminMessage() {
			this.adminmessage.click(); 
		}
		
		public void clickAdminMessageBtn() {
			this.adminmessageBtn.click(); 
		}
		
		public void moveToElementViewMessage() throws Exception {
			Actions action = new Actions(driver);
			action.moveToElement(viewmessage).build().perform();
			Thread.sleep(1000);
			this.viewmessage.click(); 
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
