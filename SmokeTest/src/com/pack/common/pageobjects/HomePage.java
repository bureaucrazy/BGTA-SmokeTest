package com.pack.common.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	private By myAccountPicklist = By.id("userNavButton");
	private By myAccountSetupLink = By.xpath("//*[@id='userNav-menuItems']/a[2]");
	private By myAccountLogoutLink = By.xpath("//*[@id='userNav-menuItems']/a[4]");
	private By allTabsLink = By.xpath("//*[@id='AllTab_Tab']/a");
	private By allTabsAccountLink = By.xpath("//*[@id='bodyCell']/div[3]/div[2]/table/tbody/tr[1]/td[1]/a");
	private By allTabsAppLauncherLink = By.xpath("//*[@id='bodyCell']/div[3]/div[2]/table/tbody/tr[3]/td[1]/a");
	private By allTabsContactsLink = By.xpath("//*[@id='bodyCell']/div[3]/div[2]/table/tbody/tr[19]/td[1]/a");
	private By allTabsPermitsLink = By.xpath("//*[@id='bodyCell']/div[3]/div[2]/table/tbody/tr[16]/td[2]/a");
	private By appLauncherBGPermitsAndInspectionsLink = By.xpath("//*[@id='LGMPermitsandInspections']");
	private By appLauncherLicensingLink = By.id("Licensing");
	private By homeTab = By.xpath("//*[@id='home_Tab']/a");
	
	protected Helper helper;
	protected WebDriver driver;
	public HomePage(WebDriver driver) { 
		this.driver = driver;
		helper = new Helper(driver);
		}


//	public void waitForElement(By element) {
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.presenceOfElementLocated(element));
//		System.out.println("Waiting on " + element);
//	}

	public String getPageTitle(){
		String title = driver.getTitle();
		System.out.println("Home Page title: " + title);
		return title;
	}
	
	public boolean verifyHomePageTitle() {
		helper.waitForElement(allTabsLink);

		String expectedPageTitle = "Salesforce";
		return getPageTitle().contains(expectedPageTitle);
	}

	public void logOut() {
		clickMyAccountPicklist();
		clickMyAccountLogoutLink();
	}
	
	public ContactsPage goToContact() {
		clickAllTabsLink();
		
//		Temporary code to dismiss Checklist Admin alert
//		Helper helper = new Helper(driver);
		if (helper.isAlertPresent()) driver.switchTo().alert().accept();
		
		clickAllTabsContactsLink();
		return new ContactsPage(driver);
	}
	
	public PermitsPage goToPermit() {
		clickAllTabsLink();
		clickAllTabsPermitsLink();
		return new PermitsPage(driver);
	}
	
	public HomePage goHome() {
		clickHomeTab();
		return new HomePage(driver);
	}
	
	public void clickHomeTab() {
		helper.doThisOn(homeTab, "click");
//		waitForElement(homeTab);
//		WebElement homeTb = driver.findElement(homeTab);
//		if(homeTb.isDisplayed())
//			homeTb.click();
	}
	
	public void clickMyAccountPicklist() {
		helper.doThisOn(myAccountPicklist, "click");
//		waitForElement(myAccountPicklist);
//		WebElement myAccountPicklst = driver.findElement(myAccountPicklist);
//		if(myAccountPicklst.isDisplayed())
//			myAccountPicklst.click();
	}

	public void clickMyAccountSetupLink() {
		helper.doThisOn(myAccountSetupLink, "click");
//		waitForElement(myAccountSetupLink);
//		WebElement myAccountSetupLnk = driver.findElement(myAccountSetupLink);
//		if(myAccountSetupLnk.isDisplayed())
//			myAccountSetupLnk.click();
	}
	
	public void clickMyAccountLogoutLink() {
		helper.doThisOn(myAccountLogoutLink, "click");
//		waitForElement(myAccountLogoutLink);
//		WebElement myAccountLogoutLnk = driver.findElement(myAccountLogoutLink);
//		if(myAccountLogoutLnk.isDisplayed())
//			myAccountLogoutLnk.click();
	}

	public void clickAllTabsLink() {
		helper.doThisOn(allTabsLink, "click");
//		waitForElement(allTabsLink);
//		WebElement allTabsLnk = driver.findElement(allTabsLink);
//		if(allTabsLnk.isDisplayed())
//			allTabsLnk.click();
	}
	
	public void clickAllTabsAccountLink(){
		helper.doThisOn(allTabsAccountLink, "click");
//		waitForElement(allTabsAccountLink);
//		WebElement allTabsAccountLnk = driver.findElement(allTabsAccountLink);
//		if(allTabsAccountLnk.isDisplayed())
//			allTabsAccountLnk.click();
	}
	
	public void clickAllTabsAppLauncherLink(){
		helper.doThisOn(allTabsAppLauncherLink, "click");
//		waitForElement(allTabsAppLauncherLink);
//		WebElement allTabsAppLauncherLnk = driver.findElement(allTabsAppLauncherLink);
//		if(allTabsAppLauncherLnk.isDisplayed())
//			allTabsAppLauncherLnk.click();
	}
	
	public void clickAllTabsContactsLink(){
		helper.doThisOn(allTabsContactsLink, "click");
//		waitForElement(allTabsContactsLink);
//		WebElement allTabsContactsLnk = driver.findElement(allTabsContactsLink);
//		if(allTabsContactsLnk.isDisplayed())
//			allTabsContactsLnk.click();
	}
	
	public void clickAllTabsPermitsLink(){
		helper.doThisOn(allTabsPermitsLink, "click");
//		waitForElement(allTabsPermitsLink);
//		WebElement allTabsPermitsLnk = driver.findElement(allTabsPermitsLink);
//		if(allTabsPermitsLnk.isDisplayed())
//			allTabsPermitsLnk.click();
	}
	
	public void clickAppLauncherBGPermitsAndInspectionsLink(){
		helper.doThisOn(appLauncherBGPermitsAndInspectionsLink, "click");
//		waitForElement(appLauncherBGPermitsAndInspectionsLink);
//		WebElement appLauncherBGPermitsAndInspectionsLnk = driver.findElement(appLauncherBGPermitsAndInspectionsLink);
//		if(appLauncherBGPermitsAndInspectionsLnk.isDisplayed())
//			appLauncherBGPermitsAndInspectionsLnk.click();
	}
	
	public void clickAppLauncherLicensingLink(){
		helper.doThisOn(appLauncherLicensingLink, "click");
//		waitForElement(appLauncherLicensingLink);
//		WebElement appLauncherLicensingLnk = driver.findElement(appLauncherLicensingLink);
//		if(appLauncherLicensingLnk.isDisplayed())
//			appLauncherLicensingLnk.click();
	}
	
}
