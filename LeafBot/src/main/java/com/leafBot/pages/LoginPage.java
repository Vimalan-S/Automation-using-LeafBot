package com.leafBot.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.leafBot.testng.api.base.ProjectSpecificMethods;

import io.cucumber.java.en.Given;


public class LoginPage extends ProjectSpecificMethods{
	
	public LoginPage(RemoteWebDriver driver, ExtentTest node){
		this.driver = driver;
		this.node = node;
			
	}
	 
	
	
	public LoginPage enterUserName(String data) {	
		//step1: locate the element
		WebElement ele = locateElement("id", "username");
		
		//step2: interact with the web element
		clearAndType(ele, data);
		
		return this;
	}	

	
	public LoginPage enterPassword(String data) {
		clearAndType(locateElement("xpath", "//input[@id='password']"), data);
		return this;
	}	
	
	
	public HomePage clickLogin() {
		click(locateElement("class","decorativeSubmit"));
		return new HomePage(driver, node);		
	}
	
	public LoginPage clickLogInForFailer() {
		click(locateElement("class","decorativeSubmit"));
		return this;		
	}
	
	public LoginPage verifyErrorMsg(String data) {
		verifyPartialText(locateElement("id","errordiv"), data);
		return this;
	}
	
	
}
