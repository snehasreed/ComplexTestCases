package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CytcPom_044_View_Member_Payment {
	private WebDriver driver; 

	public CytcPom_044_View_Member_Payment (WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="cyclosUsername")   //Login Name Text Box
	private WebElement userName;

	@FindBy(id="cyclosPassword")   //Password Text Box
	private WebElement password;

	@FindBy(xpath="//td[@colspan='2']//input[@value='Submit']")   //Login Button
	private WebElement loginBtn;

	@FindBy(xpath="//span[@class='menuText'][contains(text(),'Accounts')]")   //Click on account 
	private WebElement accountBtn;

	@FindBy(xpath="//span[contains(text(),'Member Payment')]")   //Click on sub menu member payment 
	private WebElement memberpayment;

	@FindBy(id="memberUsername")   //Enter login recipient name to make payment 
	private WebElement recipientname;

	@FindBy(id="amount")   //Enter amount of payment
	private WebElement amount;

	@FindBy(xpath="//select[@name='type']//option[@value='14']")   //Select valid transaction type
	private WebElement transactiontype;

	@FindBy(id="description")   //Enter description of the payment
	private WebElement description;

	@FindBy(id="submitButton")   //Click on submit button
	private WebElement submitButton;

	@FindBy(xpath="//input[@value='Submit']")   //click on submit button
	private WebElement submitpayment;

	@FindBy(xpath="//span[contains(text(),'Logout')]")   //Logout Button
	private WebElement logoutBtn;

	@FindBy(id="cyclosUsername")  //Login Name text box
	private WebElement memberuserName; 

	@FindBy(id="cyclosPassword")  //Password text box
	private WebElement memberpassword;

	@FindBy(xpath="//td[@colspan='2']//input[@value='Submit']")  //Login button
	private WebElement memberloginBtn; 

	@FindBy(xpath="//span[@class='menuText'][contains(text(),'Account')]")   //Click on member account 
	private WebElement memberaccountBtn;

	@FindBy(xpath="//span[contains(text(),'Account Information')]")   //Click on sub menu member account info 
	private WebElement memberaccountinfo;

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

	public void clickAccountBtn() {
		this.accountBtn.click(); 
	}

	public void clickMemberPayment() {
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

	public void clickTransactionType() {
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
		this.memberaccountBtn.click(); 
	}

	public void clickMemberAccountInfo() {
		this.memberaccountinfo.click(); 
	}

}

