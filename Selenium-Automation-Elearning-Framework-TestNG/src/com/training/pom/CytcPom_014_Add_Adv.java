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
import org.openqa.selenium.support.ui.Select;

public class CytcPom_014_Add_Adv {
	private static WebDriver driver; 

	public CytcPom_014_Add_Adv (WebDriver driver) {
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

	//Click on Manage Advertisement submit button
	@FindBy(xpath="//tr[4]//td[1]//fieldset[1]//table[1]//tbody[1]//tr[1]//td[2]//input[1]")
	private WebElement manageadvBtn;

	@FindBy(id="newButton")  //Click on insert new advertisement submit button
	private WebElement insrtnwadv;

	@FindBy(name="ad(title)")  //Enter title of advertisement
	private WebElement title;

	//Enter category of advertisement
	@FindBy(xpath="//select[@name='ad(category)']//option[@value='1']")
	private WebElement category;

	@FindBy(xpath="//input[@name='ad(price)']")  //Enter price of advertisement
	private WebElement price;

	@FindBy(xpath="//input[@id='notExpirableCheck']")   //Click on check box of not expirable
	private WebElement notexpchk; 

	@FindBy(xpath="//span[contains(text(),'Source')]")   //Click on source of description 
	private WebElement source;

	//Enter description of the advertisement
	@FindBy(xpath="//textarea[@class='cke_source cke_enable_context_menu']")
	private WebElement dscptntxt; 

	@FindBy(xpath="//input[@id='saveButton']")  //Click on Submit button
	private WebElement saveBtn; 

	@FindBy(xpath="//input[@id='backButton']")   //click on back button
	private WebElement backBtn; 

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

	public void moveToElementManageAdvrtntBtn() throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(manageadvBtn).perform();
		takeScreenshot();
		Thread.sleep(2000);
		this.manageadvBtn.click(); 
	}

	public void clickInsertNewAdv() {
		this.insrtnwadv.click(); 
	} 

	public void sendTitle(String title) {
		this.title.clear();
		this.title.sendKeys(title);
	} 

	public void Category() {
		this.category.click();
	}

	public void sendPrice(String price) {
		this.price.clear();
		this.price.sendKeys(price);
	} 

	public void NotExpirableCheck() {
		this.notexpchk.click(); 
	}

	public void Source() {
		this.source.click(); 
	}

	public void moveToElementDescriptionText(String dscptntxt) {
		this.dscptntxt.clear();
		this.dscptntxt.sendKeys(dscptntxt);
	} 

	public void moveToElementSaveButton() throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(saveBtn).perform();
		takeScreenshot();
		Thread.sleep(500);
		this.saveBtn.click(); 
	}

	public void moveToElementclickBackBtn() throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(backBtn).perform();
		takeScreenshot();
		Thread.sleep(500);
		this.backBtn.click(); 
	}

	public static void takeScreenshot() throws Exception {
		String timeStamp;
		File screenShotName;
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//The below method will save the screen shot in d drive with name "screenshot.png"
		timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()); 
		screenShotName = new File("C:\\IBM_Selenium_WD\\Screenshots\\CYTC_014"+timeStamp+".png");
		FileUtils.copyFile(scrFile, screenShotName);
	}

}


