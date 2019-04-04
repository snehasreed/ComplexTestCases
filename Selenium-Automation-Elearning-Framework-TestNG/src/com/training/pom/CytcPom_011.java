package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CytcPom_011 {
	private WebDriver driver; 

	public CytcPom_011(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="cyclosUsername")  //login name Text box
	private WebElement userName; 

	@FindBy(id="cyclosPassword")   //Password Text box
	private WebElement password;

	@FindBy(xpath="//td[@colspan='2']//input[@value='Submit']") //Login Button
	private WebElement loginBtn; 

	@FindBy(xpath="//span[contains(text(),'Personal')]")  //To click on Personal Info
	private WebElement personalBtn;

	@FindBy(xpath="//span[contains(text(),'Change Password')]")  //Click on change Password
	private WebElement changePWBtn;

	@FindBy(name="oldPassword")   //Enter Current Password Text Box
	private WebElement currentPW;

	@FindBy(name="newPassword")   //New Password Text Box
	private WebElement newPW;

	@FindBy(name="newPasswordConfirmation")   //Confirmation of New Password text box
	private WebElement confirmnewPW;

	@FindBy(xpath="//input[@value='Submit']")  //Submit button
	private WebElement submitBtn;

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

	public void clickPersonalBtn() {
		this.personalBtn.click(); 
	}

	public void clickhangePWBtn() {
		this.changePWBtn.click(); 
	}

	public void sendCurrentPW(String currentPW) {
		this.currentPW.clear();
		this.currentPW.sendKeys(currentPW);
	}

	public void sendNewPW(String newPW) {
		this.newPW.clear();
		this.newPW.sendKeys(newPW);
	} 

	public void sendConfirmnewPW(String confirmnewPW) {
		this.confirmnewPW.clear();
		this.confirmnewPW.sendKeys(confirmnewPW);
	} 

	public void clickSubmitBtn() {
		this.submitBtn.click(); 
	}
}
