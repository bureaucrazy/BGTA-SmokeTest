package com.pack.common.pageobjects;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Helper {
	protected WebDriver driver;
	public Helper(WebDriver driver) { this.driver = driver; }

	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		}
		catch (NoAlertPresentException e) {
			return false;
		}
	}

	public void waitForElement(By element) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(element));
		System.out.println("Waiting on " + element);
	}

	public void doThisOn(By element, Object...params) {
		// params index
		// 0 : function as string
		// 1 : value to pass
		waitForElement(element);
		WebElement elemnt = driver.findElement(element);
		if(elemnt.isDisplayed())
			if(params.length > 0) {
				if(params[0].toString() == "sendKeys") { elemnt.sendKeys(params[1].toString()); }
				else { elemnt.click(); }
			} else { elemnt.click(); }
			
	}

	public void switchToWindow(String windowName) {
        WebDriver popup = driver;
        Set<String> windowIterator = driver.getWindowHandles();

        System.err.println("No of windows :  " + windowIterator.size());
      
        for (String s : windowIterator) {
            String windowHandle = s;
            popup = driver.switchTo().window(windowHandle);
            System.out.println("Window Title : " + popup.getTitle());
            System.out.println("Window Url : " + popup.getCurrentUrl());
      
            if (popup.getTitle().contains(windowName)) {
                System.out.println("Selected Window Title : " + popup.getTitle());
                driver = popup;
                break;
            }
        }
    }
	
	
}
