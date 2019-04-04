package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CytcPom_045_Settings {
	private WebDriver driver; 

	public CytcPom_045_Settings (WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="cyclosUsername")   //Login Name Text Box
	private WebElement userName;

	@FindBy(id="cyclosPassword")   //Password Text Box
	private WebElement password;

	@FindBy(xpath="//td[@colspan='2']//input[@value='Submit']")   //Login Button
	private WebElement loginBtn;

	@FindBy(xpath="//span[@class='menuText'][contains(text(),'Settings')]")   //Click on settings
	private WebElement settingsBtn;

	@FindBy(xpath="//span[contains(text(),'Alert Settings')]")   //Click on sub menu alert settings 
	private WebElement alertsettingsBtn;

	@FindBy(id="modifyButton")   //click on change button
	private WebElement modifyButton;

	//Given very bad reference is changed
	@FindBy(xpath="/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[3]/form[1]/table[1]/tbody[1]/tr[2]/td[1]/table[1]/tbody[1]/tr[1]/td[2]/input[1]")
	private WebElement reference;

	@FindBy(xpath="//input[@value='Submit']")   //Click on submit button
	private WebElement submitButton;

	@FindBy(xpath="//span[contains(text(),'Logout')]")   //Logout Button
	private WebElement logoutBtn;

	@FindBy(id="cyclosUsername")  //Login Name text box
	private WebElement memberuserName; 

	@FindBy(id="cyclosPassword")  //Password text box
	private WebElement memberpassword;

	@FindBy(xpath="//td[@colspan='2']//input[@value='Submit']")  //Login button
	private WebElement memberloginBtn; 

	@FindBy(id="btn")  //Password text box
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

	public void clickSettingsBtn() {
		this.settingsBtn.click(); 
	}

	public void clickAlertSettingsBtn() {
		this.alertsettingsBtn.click(); 
	}

	public void clickModifyButton() {
		this.modifyButton.click(); 
	}

	public void sendReference(String reference) {
		this.reference.clear(); 
		this.reference.sendKeys(reference); 
	}

	public void clickSubmitButton() {
		this.submitButton.click(); 
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

	public void clickBackBtn() {
		this.back.click(); 
	}
}
