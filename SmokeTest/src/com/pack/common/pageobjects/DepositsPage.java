package com.pack.common.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DepositsPage {
	private By saveButton = By.name("save");
	private By editButton = By.name("edit");
	private By nameTextbox = By.id("Name");
	private By amountTextbox = By.id("00N4100000FSvG3");
	private By depositName = By.cssSelector("#Name_ileinner");
	private By depositTitle = By.className("pageDescription");
	private By permitLink = By.cssSelector("#CF00N4100000FSvG7_ileinner a");
		
	private static final String depositAmount = "42.00";
	private static final String newDeposit = "New Deposit";
	private static final String sequenceNumber = "System Number";

	protected Helper helper;
	protected WebDriver driver;
	public DepositsPage(WebDriver driver) { 
		this.driver = driver;
		helper = new Helper(driver);
		}


//	public void waitForElement(By element) {
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.presenceOfElementLocated(element));
//		System.out.println("Waiting on " + element);
//	}

	public void getDepositName() {
		String name = driver.findElement(depositName).getText();
		System.err.println("Deposit name: " + name);
	}
	
	public String getDepositTitle(){
		String title = driver.findElement(depositTitle).getText();
		System.out.println("Deposit title: " + title);
		return title;
	}
	
	public boolean verifyDepositTitle() {
		helper.waitForElement(editButton);
		return !getDepositTitle().contains(newDeposit);
	}

	public PermitsPage createNewPermitDeposit() {
		driver.findElement(amountTextbox).sendKeys(depositAmount);
		driver.findElement(saveButton).click();
		getDepositName();
		clickPermitLink();
		return new PermitsPage(driver);
	}
	
	public void clickSaveButton() {
		helper.doThisOn(saveButton, "click");
//		waitForElement(saveButton);
//		WebElement saveButtn = driver.findElement(saveButton);
//		if(saveButtn.isDisplayed())
//			saveButtn.click();
	}

	public void fillAmountTextbox(String amountText) {
		helper.waitForElement(amountTextbox);
		WebElement amountTextbx = driver.findElement(amountTextbox);
		if(amountTextbx.isDisplayed())
			if(amountTextbx.getAttribute("value").isEmpty())
				amountTextbx.sendKeys(amountText);
	}
	
	public void fillDepositNumberTextbox() {
		helper.waitForElement(nameTextbox);
		WebElement nameTextbx = driver.findElement(nameTextbox);
		if(nameTextbx.isDisplayed())
			if(nameTextbx.getAttribute("value").isEmpty())
				nameTextbx.sendKeys(sequenceNumber);
	}
	
	public void clickPermitLink() {
		helper.doThisOn(permitLink, "click");
//		waitForElement(permitLink);
//		WebElement permitLnk = driver.findElement(permitLink);
//		if(permitLnk.isDisplayed())
//			permitLnk.click();
	}
}
