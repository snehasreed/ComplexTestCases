package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CytcPom_012_member {
	private WebDriver driver; 

	public CytcPom_012_member(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="cyclosUsername")   //Login Name Text Box
	private WebElement userName; 

	@FindBy(id="cyclosPassword")   //Password text box
	private WebElement password;

	@FindBy(xpath="//td[@colspan='2']//input[@value='Submit']")   //Login Button
	private WebElement loginBtn;

	@FindBy(xpath="//span[contains(text(),'Logout')]")   //Logout Button
	private WebElement logoutBtn;

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

	public void clickLogoutBtn() {
		this.logoutBtn.click(); 
	}
}
