package com.mycompany.glue.runnables;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mycompany.reusables.actions.MakeMyTrip_WrapperClass;
import com.mycompany.reusables.actions.ReusableFunctions;

import io.cucumber.core.cli.Main;

public class Implementation_MakeMytrip {
	
	MakeMyTrip_WrapperClass wc1=new MakeMyTrip_WrapperClass();
	ReusableFunctions rf=new ReusableFunctions();
	WebDriver driver=ReusableFunctions.driver;
	
	@Given("^Guest user Opens the online flight Booking application$")
	public void guest_user_opens_the_online_flight_booking_application() {
	    // Write code here that turns the phrase above into concrete actions
		
//	    throw new io.cucumber.java.PendingException();
		System.out.println("hi");
	}
	

	@When("^the user chooses the \"(.*)\" and \"(.*)\"$")
	public void the_user_chooses_the_from_and_to(String from, String to) {
	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
		System.out.println("from:" +from);
		System.out.println("to:" +to);
	}
	
	@Given("^\"(.*)\" logins into the online flight Booking application$")
	public void Login_MMT(String UserType)
	{
//		if(wc1.validatePresenceOfElement(driver, "MMT_HomepgLoginBtn1"))
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		wc1.clickButton(driver, "MMT_HomepgLoginBtn1");
		/*
		 * if(wc1.validatePresenceOfElement(driver, "MMT_UserName"))
		 * wc1.fluentWait(driver, "MMT_UserName");
		 */
		HashMap<String, String> testData=rf.getUserCredentials(UserType);
		String userName=testData.get("UserName");
		String password=testData.get("Password");
		driver.findElement(wc1.getBy(wc1.getField("MMT_UserName", wc1.OR1FilePath))).sendKeys(userName);
		wc1.clickButton(driver, "MMT_LoginPg_ContinueBtn");
		driver.findElement(wc1.getBy(wc1.getField("MMT_Password", wc1.OR1FilePath))).sendKeys(password);
		wc1.clickButton(driver, "MMT_LoginSubmitBtn");
		
	}
	@Given("^user launches the MMT application$")
	public void launchMMT()
	{ 
		
//		driver=new ChromeDriver();
//		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/");
//		driver.get("https://www.selenium.dev/downloads/");
//		driver.findElement(By.xpath("//*[text()='Latest stable version ']/a"));
		wc1.fluentWait(driver, wc1.getBy(wc1.getField("MMT_HmPg", wc1.OR1FilePath)));
		
	}
	
	

}
