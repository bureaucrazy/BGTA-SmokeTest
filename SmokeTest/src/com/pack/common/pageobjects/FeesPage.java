package com.pack.common.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FeesPage {
	private By saveButton = By.name("save"); // .xpath("//*[@id='topButtonRow']/input[1]");
	private By editButton = By.name("edit"); // .xpath("//*[@id='topButtonRow']/input[3]");
	private By amountTextbox = By.id("00N4100000FRu7P"); // .xpath("//*[@id='00N4100000FRu7P']");
	private By feeName = By.cssSelector("#Name_ileinner");
	private By feeTitle = By.className("pageDescription"); // .xpath("//*[@id='bodyCell']/div[1]/div[1]/div[1]/h2");
	private By permitLink = By.cssSelector("#CF00N4100000FRuHI_ileinner a");
	private By cartLink = By.cssSelector("#CF00N4100000FRuNW_ileinner a");
	
	private static final String feeAmount = "42.00";
	private static final String newFee = "New Fee";

	protected Helper helper;
	protected WebDriver driver;
	public FeesPage(WebDriver driver) { 
		this.driver = driver;
		helper = new Helper(driver);
		}


//	public void waitForElement(By element) {
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.presenceOfElementLocated(element));
//		System.out.println("Waiting on " + element);
//	}

	public void getCartTitle() {
		helper.waitForElement(cartLink);
		String title = driver.findElement(cartLink).getText();
		System.err.println("Cart title: " + title);
	}
	
	public void getFeeName() {
		String name = driver.findElement(feeName).getText();
		System.err.println("Fee name: " + name);
	}
	
	public String getFeeTitle(){
		String title = driver.findElement(feeTitle).getText();
		System.out.println("Fee title: " + title);
		return title;
	}
	
	public boolean verifyFeeTitle() {
		helper.waitForElement(editButton);
		return !getFeeTitle().contains(newFee);
	}

	public PermitsPage createNewPermitFee() {
		fillAmountTextbox(feeAmount);
		clickSaveButton();
		getFeeName();
		getCartTitle();
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
	
	public void clickPermitLink() {
		helper.doThisOn(permitLink, "click");
//		waitForElement(permitLink);
//		WebElement permitLnk = driver.findElement(permitLink);
//		if(permitLnk.isDisplayed())
//			permitLnk.click();
	}

}
