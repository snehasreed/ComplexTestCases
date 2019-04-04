package com.training.pom;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class CytcPom_075_Advertisement {
		private WebDriver driver; 

		public CytcPom_075_Advertisement (WebDriver driver) {
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
		
		@FindBy(xpath="//span[contains(text(),'Advertisements')]")  //click on advertisement
		private WebElement advertisement;
		
		@FindBy(xpath="//input[@value='Submit']")  //click on insert new button
		private WebElement newButton;
		
		@FindBy(xpath="//input[@name='ad(title)']")   //Title is entered
		private WebElement title;
		
		@FindBy(xpath="//select[@name='ad(category)']") 
		private WebElement category;
		
		@FindBy(xpath="//input[@name='ad(price)']")
		private WebElement price;
		
		@FindBy(xpath="//input[@name='ad(publicationPeriod).begin']")
		private WebElement publicationdate;
		
		@FindBy(xpath="//input[@name='ad(publicationPeriod).end']")
		private WebElement expirydate;
		
		@FindBy(xpath="//a[@title='Source']")
		private WebElement source;
		
		@FindBy(xpath="//textarea[@class='cke_source cke_enable_context_menu']")
		private WebElement description;
		
		@FindBy(xpath="//input[@value='Submit']")  //click on save button
		private WebElement saveButton;
		
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
		
		public void clickAdvertisementLink() {
			this.advertisement.click();
		}
		
		public void clickNewButtonLink() {
			this.newButton.click();
		}
		
		public void sendTitle(String title) {
			this.title.clear(); 
			this.title.sendKeys(title); 
		}
		
		public void clickCategory() {
			this.category.click();
		}
		
		public void sendPrice(String price) {
			this.price.clear(); 
			this.price.sendKeys(price); 
		}
		
		public void sendPublicationdate(String publicationdate) {
			this.publicationdate.clear(); 
			this.publicationdate.sendKeys(publicationdate); 
		}
		
		public void sendExpirydate(String expirydate) {
			this.expirydate.clear(); 
			this.expirydate.sendKeys(expirydate); 
		}
		
		public void clickSource() {
			this.source.click();
		}
		
		public void sendDescription(String description) {
			this.description.clear();
			this.description.sendKeys(description);
		}
		
		public void clickSaveButtonLink() {
			this.saveButton.click();
		}
		
	}
