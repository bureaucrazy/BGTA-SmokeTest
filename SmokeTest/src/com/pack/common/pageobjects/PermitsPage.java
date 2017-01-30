package com.pack.common.pageobjects;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PermitsPage {
	private By newButton = By.name("new");
	private By saveButton = By.name("save");
	private By typePicklist = By.id("00N4100000FRuI6");
	private By statusPicklist = By.id("00N4100000FRuI1");
	private By applicantLink = By.id("CF00N4100000FRuHj_lkwgt");
	private By applicantTextbox = By.id("CF00N4100000FRuHj");
	private By numberTextbox = By.id("Name");
	private By permitTitle = By.className("pageDescription");
	private By recentFirstPermitLink = By.cssSelector(".dataRow.even.first .dataCell a");			
	private By viewGoButton = By.name("go");
	private By allTabsLink = By.xpath("//*[@id='AllTab_Tab']/a");
	
	private static final String sequenceNumber = "System Number";
	private static final String permitType = "Building";
	private static final String permitStatus = "Pending";
	
	// Fees panel
	private By newFeeButton = By.name("new00N4100000FRuHI");

	// Deposits panel
	private By newDepositButton = By.name("new00N4100000FSvG7");
	
	protected Helper helper;
	protected WebDriver driver;
	public PermitsPage(WebDriver driver) { 
		this.driver = driver;
		helper = new Helper(driver);
		}


//	public void waitForElement(By element) {
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.presenceOfElementLocated(element));
//		System.out.println("Waiting on " + element);
//	}

	public String getPermitTitle(){
		String title = driver.findElement(permitTitle).getText();
		System.err.println("Permit title: " + title);
		return title;
	}
	
	public boolean verifyPermitTitle() {
		helper.waitForElement(allTabsLink);
		return getPermitTitle().isEmpty() ? false : true;
	}

	public void createNewPermit(String contactName) {
		clickNewButton();
		Select typeSelect = new Select(driver.findElement(typePicklist));
		typeSelect.selectByValue(permitType);
		Select statusSelect = new Select(driver.findElement(statusPicklist));
		statusSelect.selectByValue(permitStatus);
		
		// This selects the applicant using the Lookup window
		LookupPage lookupPage = goToApplicantLookup();
		helper.switchToWindow("Search");		
		lookupPage.selectPermitFirstResult(contactName);
		helper.switchToWindow("Salesforce");
		
		// This selects the applicant using the textbox
//		fillApplicantTextbox(contactName);		

		fillNumberTextbox(sequenceNumber);
		clickSaveButton();
	}
	
//	public void switchToWindow(String windowName) {
//        WebDriver popup = driver;
//        Set<String> windowIterator = driver.getWindowHandles();
//
//        System.err.println("No of windows :  " + windowIterator.size());
//      
//        for (String s : windowIterator) {
//            String windowHandle = s;
//            popup = driver.switchTo().window(windowHandle);
//            System.out.println("Window Title : " + popup.getTitle());
//            System.out.println("Window Url : " + popup.getCurrentUrl());
//      
//            if (popup.getTitle().contains(windowName)) {
//                System.out.println("Selected Window Title : " + popup.getTitle());
//                driver = popup;
//                break;
//            }
//        }
//    }
//	
	public PermitsPage openPermit() {
		clickRecentFirstPermit();
		return new PermitsPage(driver);
	}
	
	public FeesPage goToNewFee() {
		clickNewFeeButton();
		return new FeesPage(driver);
	}
	
	public DepositsPage goToNewDeposit() {
		clickNewDepositButton();
		return new DepositsPage(driver);
	}

	public LookupPage goToApplicantLookup() {
		clickApplicantLink();
		return new LookupPage(driver);
	}
		
	public void fillApplicantTextbox(String contactName) {
		helper.doThisOn(applicantTextbox, "sendKeys", contactName);
//		waitForElement(applicantTextbox);
//		WebElement applicantTextbx = driver.findElement(applicantTextbox);
//		if(applicantTextbx.isDisplayed())
//			applicantTextbx.sendKeys(contactName);	
	}
	
	public void clickApplicantLink() {
		helper.doThisOn(applicantLink, "click");
//		waitForElement(applicantLink);
//		WebElement applicantLnk = driver.findElement(applicantLink);
//		if(applicantLnk.isDisplayed())
//			applicantLnk.click();		
	}
	
	public void clickGoButton() {
		helper.doThisOn(viewGoButton, "click");
//		waitForElement(viewGoButton);
//		WebElement viewGoButtn = driver.findElement(viewGoButton);
//		if(viewGoButtn.isDisplayed())
//			viewGoButtn.click();
	}
	
	public void clickRecentFirstPermit() {
		helper.doThisOn(recentFirstPermitLink, "click");
//		waitForElement(recentFirstPermitLink);
//		WebElement recentFirstPermitLnk = driver.findElement(recentFirstPermitLink);
//		if(recentFirstPermitLnk.isDisplayed())
//			recentFirstPermitLnk.click();		
	}
	
	public void clickNewButton() {
		helper.doThisOn(newButton, "click");
//		waitForElement(newButton);
//		WebElement newButtn = driver.findElement(newButton);
//		if(newButtn.isDisplayed())
//			newButtn.click();
	}

	public void clickSaveButton() {
		helper.doThisOn(saveButton, "click");		
//		waitForElement(saveButton);
//		WebElement saveButtn = driver.findElement(saveButton);
//		if(saveButtn.isDisplayed())
//			saveButtn.click();
	}

	public void fillNumberTextbox(String numberText) {
		helper.waitForElement(numberTextbox);
		WebElement numberTextbx = driver.findElement(numberTextbox);
		if(numberTextbx.isDisplayed())
			if(numberTextbx.getAttribute("value").isEmpty())
				numberTextbx.sendKeys(numberText);
	}
	
	public void clickNewFeeButton() {
		helper.doThisOn(newFeeButton, "click");
//		waitForElement(newFeeButton);
//		WebElement newFeeButtn = driver.findElement(newFeeButton);
//		if(newFeeButtn.isDisplayed())
//			newFeeButtn.click();		
	}

	public void clickNewDepositButton() {
		helper.doThisOn(newDepositButton, "click");
//		waitForElement(newDepositButton);
//		WebElement newDepositButtn = driver.findElement(newDepositButton);
//		if(newDepositButtn.isDisplayed())
//			newDepositButtn.click();		
	}
}
