package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{

	
	//https://www.freecrm/index.html

	//Page Factory - OR
	@FindBy(name = "username" )
	WebElement username;
	
	
	@FindBy(name = "password" )
	WebElement password;
	
	
	@FindBy( xpath ="//input[@value='Login']")
	WebElement loginBtn	;
	
	
	@FindBy( xpath ="//a[contains(text(),'Sign Up')]")
	WebElement signUpBtn	;
	
	@FindBy(xpath = "//a[@class='navbar-brand']//img[@class='img-responsive']")
	WebElement crmLogo;
	
	///initilazing the page objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
		
	}
	//aCTIONS:
	public String validateLoginPagetitle() {
		return driver.getTitle();
	}
	
	public boolean validateCRMImage () {
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String un , String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
	
	return new HomePage();
	
	
	
	
}

}












