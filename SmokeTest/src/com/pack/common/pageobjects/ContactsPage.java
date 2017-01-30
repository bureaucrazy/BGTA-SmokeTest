package com.pack.common.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactsPage {
	private By newButton = By.name("new"); // .xpath("//*[@id='hotlist']/table/tbody/tr/td[2]/input");
	private By lastNameTextbox = By.id("name_lastcon2");
	private By saveButton = By.xpath("//*[@id='topButtonRow']/input[1]");
	private By contactTitle = By.className("pageDescription");
	private By allTabsLink = By.xpath("//*[@id='AllTab_Tab']/a");
	
	protected Helper helper;
	protected WebDriver driver;
	public ContactsPage(WebDriver driver) { 
		this.driver = driver;
		helper = new Helper(driver);
		}
	
//	public void waitForElement(By element) {
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.presenceOfElementLocated(element));
//		System.out.println("Waiting on " + element);
//	}

	public String getContactTitle(){
		String title = driver.findElement(contactTitle).getText();
		System.err.println("Contact title: " + title);
		return title;
	}
	
	public boolean verifyContactTitle(String contactLastName) {
		helper.waitForElement(allTabsLink);		
		return getContactTitle().contains(contactLastName);
	}

	public void createNewContact(String contactLastName) {
		clickNewButton();
		fillLastNameTextbox(contactLastName);
		clickSaveButton();
	}
	
	
	public void clickNewButton() {
		helper.doThisOn(newButton, "click");
//		waitForElement(newButton);
//		WebElement newButtn = driver.findElement(newButton);
//		if(newButtn.isDisplayed())
//			newButtn.click();
	}
	
	public void fillLastNameTextbox(String contactLastName) {
		helper.doThisOn(lastNameTextbox, "sendKeys", contactLastName);
//		waitForElement(lastNameTextbox);
//		WebElement lastNameTextbx = driver.findElement(lastNameTextbox);
//		if(lastNameTextbx.isDisplayed())
//			lastNameTextbx.sendKeys(contactLastName);
	}

	public void clickSaveButton() {
		helper.doThisOn(saveButton, "click");
//		waitForElement(saveButton);
//		WebElement saveButtn = driver.findElement(saveButton);
//		if(saveButtn.isDisplayed())
//			saveButtn.click();
	}
}
