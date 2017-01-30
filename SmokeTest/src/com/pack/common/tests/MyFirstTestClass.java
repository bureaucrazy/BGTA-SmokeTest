package com.pack.common.tests;

import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.pack.base.BaseSetup;
import com.pack.common.pageobjects.ContactsPage;
import com.pack.common.pageobjects.DepositsPage;
import com.pack.common.pageobjects.FeesPage;
import com.pack.common.pageobjects.HomePage;
import com.pack.common.pageobjects.LogInPage;
import com.pack.common.pageobjects.PermitsPage;

public class MyFirstTestClass extends BaseSetup {
	private WebDriver driver;
	private LogInPage logInPage;
	private HomePage homePage;
	private ContactsPage contactsPage;
	private PermitsPage permitsPage;
	private FeesPage feesPage;
	private DepositsPage depositsPage;
	
	Date date = new Date();
	private String contactName = date.toString();
	
	@BeforeClass
	public void setUp() { driver = getDriver(); }
		
	@Parameters({"username","password"})
	@Test
	public void verifySignInFunction(String username, String password) {
		System.out.println("Login functionality details...");
		logInPage = new LogInPage(driver);
		Assert.assertTrue(logInPage.verifyLogInPageTitle(), "Sign In page title doesn't match");		

		homePage = logInPage.logInAsValidUser(username, password);
		Assert.assertTrue(homePage.verifyHomePageTitle(), "Sign In failed");
		
		System.out.println("Going home");
		homePage.goHome();
	}
	
	@Test (dependsOnMethods = { "verifySignInFunction" })
	public void verifyNewContactFunction() {
		System.out.println("Create Contact functionality details...");
		contactsPage = homePage.goToContact();
		contactsPage.createNewContact(contactName);
		
		Assert.assertTrue(contactsPage.verifyContactTitle(contactName), "Contact Name doesn't match");

		System.out.println("Going home");
		homePage.goHome();
	}

	@Test (dependsOnMethods = { "verifyNewContactFunction" })
	public void verifyNewPermitFunction() {
		System.out.println("Create Permit functionality details...");
		permitsPage = homePage.goToPermit();
		permitsPage.createNewPermit(contactName);

		Assert.assertTrue(permitsPage.verifyPermitTitle(), "Permit Name doesn't exist");

		System.out.println("Going home");
		homePage.goHome();
	}
	
	@Test (dependsOnMethods = { "verifyNewPermitFunction" })
	public void verifyNewPermitFeeFunction() {
		System.out.println("Opening an existing Permit");
		permitsPage = homePage.goToPermit();
		permitsPage.openPermit();
		
		System.out.println("Create Permit Fee functionality details...");
		feesPage = permitsPage.goToNewFee();
		feesPage.createNewPermitFee();

		// At this point back at Permit, so it returns Permit title. Fix
		Assert.assertTrue(feesPage.verifyFeeTitle(), "Fee Name doesn't exist");		

		System.out.println("Going home");
		homePage.goHome();
	}
	
	@Test (dependsOnMethods = { "verifyNewPermitFeeFunction" })
	public void verifyNewPermitDepositFunction() {
		System.out.println("Opening an existing Permit");
		permitsPage = homePage.goToPermit();
		permitsPage.openPermit();

		System.out.println("Create Permit Deposit functionality details...");
		depositsPage = permitsPage.goToNewDeposit();
		depositsPage.createNewPermitDeposit();

		// At this point back at Permit, so it returns Permit title. Fix
		Assert.assertTrue(depositsPage.verifyDepositTitle(), "Deposit Name doesn't exist");		

		System.out.println("Going home");
		homePage.goHome();
	}
	
	
	@AfterClass
	public void verifyLogOutFunction() {
		System.out.println("Sign Out functionality details...");
		homePage.logOut();
	}
}
