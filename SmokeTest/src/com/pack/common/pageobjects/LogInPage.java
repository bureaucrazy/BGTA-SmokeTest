package com.pack.common.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogInPage {
	private By usernameTextbox = By.id("username");
	private By passwordTextbox = By.id("password");
	private By loginButton = By.id("Login");

	protected Helper helper;
	protected WebDriver driver;
	public LogInPage(WebDriver driver) { 
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
		System.out.println("Login Page title: " + title);
		return title;
	}
	
	public boolean verifyLogInPageTitle() {
		String expectedPageTitle="Login | Salesforce";
		return getPageTitle().contains(expectedPageTitle);
	}

	public HomePage logInAsValidUser(String name, String pass) {
		fillLoginDetails(name, pass);
		clickLoginButton();
		return new HomePage(driver);
	}		

	public void fillLoginDetails(String name, String pass) {
		helper.doThisOn(usernameTextbox, "sendKeys", name);
//		waitForElement(usernameTextbox);
//		WebElement usernameTextbx = driver.findElement(usernameTextbox);
//		if(usernameTextbx.isDisplayed())
//			usernameTextbx.sendKeys(name);
		
		helper.doThisOn(passwordTextbox, "sendKeys", pass);
//		waitForElement(passwordTextbox);
//		WebElement passwordTextbx = driver.findElement(passwordTextbox);
//		if(passwordTextbx.isDisplayed())
//			passwordTextbx.sendKeys(pass);
	}
	
	public void clickLoginButton() {
		helper.doThisOn(loginButton, "click");
//		waitForElement(loginButton);
//		WebElement loginButtn = driver.findElement(loginButton);
//		if(loginButtn.isDisplayed())
//			loginButtn.click();
	}

}
