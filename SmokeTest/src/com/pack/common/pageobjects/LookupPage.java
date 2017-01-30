package com.pack.common.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LookupPage {
	private By searchTextbox = By.id("lksrch");
	private By goButton = By.name("go");
	private By clearSearchLink = By.cssSelector(".clearResults a");
	private By firstResultLink = By.cssSelector(".dataRow.even.first a");
	private By lookupTitle = By.cssSelector(".content h1");
	
	private By searchFrame = By.id("searchFrame");
	private By resultsFrame = By.id("resultsFrame");

	private static final String title = "Lookup";

	protected Helper helper;
	protected WebDriver driver;
	public LookupPage(WebDriver driver) { 
		this.driver = driver;
		helper = new Helper(driver);
		}

	
//	public void waitForElement(By element) {
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.presenceOfElementLocated(element));
//		System.out.println("Waiting on " + element);
//	}

	public String getLookupTitle(){
		String title = driver.findElement(lookupTitle).getText();
		System.out.println("Lookup title: " + title);
		return title;
	}

	public boolean verifyLookupTitle() {
		helper.waitForElement(goButton);
		return getLookupTitle().contains(title);
	}

	public void selectPermitFirstResult(String contactName) {
		fillSearchTextbox(contactName);
		clickGoButton();
		clickFirstResultLink();
	}

	public void switchToSearchFrame() {
		driver.switchTo().defaultContent();
		WebElement searchFrme = driver.findElement(searchFrame);
		if(searchFrme.isDisplayed())
			driver.switchTo().frame(searchFrme);
	}
	
	public void switchToResultsFrame() {
		driver.switchTo().defaultContent();
		WebElement resultsFrme = driver.findElement(resultsFrame);
		if(resultsFrme.isDisplayed())
			driver.switchTo().frame(resultsFrme);		
	}
	
	public void fillSearchTextbox(String searchText) {
		switchToSearchFrame();
		helper.waitForElement(searchTextbox);
		WebElement searchTextbx = driver.findElement(searchTextbox);
		if(searchTextbx.isDisplayed())
			if(searchTextbx.getAttribute("value").isEmpty())
				searchTextbx.sendKeys(searchText);
	}
	
	public void clickGoButton() {
		switchToSearchFrame();
		helper.doThisOn(goButton, "click");
//		waitForElement(goButton);
//		WebElement goButtn = driver.findElement(goButton);
//		if(goButtn.isDisplayed())
//			goButtn.click();
	}

	public void clickFirstResultLink() {
		switchToResultsFrame();
		helper.doThisOn(firstResultLink, "click");
//		waitForElement(firstResultLink);
//		WebElement firstResultLnk = driver.findElement(firstResultLink);
//		if(firstResultLnk.isDisplayed())
//			firstResultLnk.click();		
	}
	
	public void clickClearSearchLink() {
		switchToResultsFrame();
		helper.doThisOn(clearSearchLink, "click");
//		waitForElement(clearSearchLink);
//		WebElement clearSearchLnk = driver.findElement(clearSearchLink);
//		if(clearSearchLnk.isDisplayed())
//			clearSearchLnk.click();		
	}

}
