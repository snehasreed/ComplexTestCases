package com.training.pom;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class CytcPom_074_Member_Contact {
		private WebDriver driver; 

		public CytcPom_074_Member_Contact (WebDriver driver) {
			this.driver = driver; 
			PageFactory.initElements(driver, this);
		}

		@FindBy(id="cyclosUsername")   //Login Name Text Box
		private WebElement userName;

		@FindBy(id="cyclosPassword")   //Password Text Box
		private WebElement password;

		@FindBy(xpath="//td[@colspan='2']//input[@value='Submit']")   //Login Button
		private WebElement loginBtn;
		
		@FindBy(xpath="//span[contains(text(),'Personal')]")  //click on personal tab
		private WebElement personaltab;
		
		@FindBy(xpath="//span[contains(text(),'Contacts')]")  //click on contacts
		private WebElement contacts;
		
		@FindBy(id="memberUsername")  //Enter Member user name
		private WebElement memberusrnm;
		
		@FindBy(xpath="//div[@id='membersByUsername']//li[@index='0']") //to select the member from options
		private WebElement selectmember;
		
		@FindBy(xpath="//input[@value='Submit']")
		private WebElement contactsubmit;
		
		@FindBy(xpath="//td[@class='tdContentTableLists innerBorder']//td[1]//a[1]")
		private WebElement addedcontact;
		
		@FindBy(xpath="//tr[1]//td[2]//input[1]")
		private WebElement makepayment;
		
		@FindBy(xpath="//input[@id='amount']")   //Enter Amount for member
		private WebElement amount;
		
		@FindBy(xpath="//textarea[@id='description']")   //Enter Description for member
		private WebElement description;

		@FindBy(id="submitButton")   //Click on submit button
		private WebElement submitButton;

		@FindBy(xpath="//input[@value='Submit']")   //click on submit button
		private WebElement submitpayment;
		
		@FindBy(xpath="//span[contains(text(),'Logout')]")
		private WebElement logout;
		
		@FindBy(xpath="//span[@class='menuText'][contains(text(),'Account')]")  //click on account
		private WebElement account;
		
		@FindBy(xpath="//span[contains(text(),'Account Information')]")  //Account info is clicked
		private WebElement accountinfo;
		
		@FindBy(xpath="//tr[2]//td[5]//img[1]")
		private WebElement view;
		
		@FindBy(xpath="//input[@id='backButton']")
		private WebElement back;

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
		
		public void clickPersonalTab() {
			this.personaltab.click();
		}
		
		public void clickContactsLink() {
			this.contacts.click();
		}
		
		public void sendMemberUserName(String memberusrnm) {
			this.memberusrnm.clear(); 
			this.memberusrnm.sendKeys(memberusrnm);
		}
		
		public void clickMemberSelection() {
			this.selectmember.click();
		}
		
		public void clickContactSubmit() {
			this.contactsubmit.click();
		}
		
		public void clickAddedContact() {
			this.addedcontact.click();
		}
		
		public void moveToElementMakePayment() {
			Actions action = new Actions(driver);
			action.moveToElement(makepayment).perform();
			this.makepayment.click();
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
		
		public void clickLogout() {
			this.logout.click(); 
		}
		
		public void clickAccount() {
			this.account.click();
		}
		
		public void clickAccountInfo() {
			this.accountinfo.click();
		}
		
		public void clickView() {
			this.view.click();
		}
		
		public void clickBack() {
			this.back.click();
		}
		
	}

