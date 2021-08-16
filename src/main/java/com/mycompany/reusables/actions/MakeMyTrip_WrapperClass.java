package com.mycompany.reusables.actions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class MakeMyTrip_WrapperClass {
	
	HashMap<String,String> ObjRepo=new HashMap<String,String>();
	String gfile_name="";
	static String path=System.getProperty("user.dir");
	public static String OR1FilePath=path+"\\src\\main\\resources\\Properties\\MakeMyTrip.properties";
	
	public void clickButton(WebDriver driver,String element )
	{
		try {
			validatePresenceOfElement(driver,element);
			waitForClickable(driver, element);
			scrollToElement(driver, getBy(getField(element,OR1FilePath)));
			Actions action=new Actions(driver);
			action.moveToElement(driver.findElement(getBy(getField(element, OR1FilePath)))).click().perform();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void highLightElement(WebDriver driver,String element)
	{
		WebElement highlightedElement=driver.findElement(getBy(getField(element, OR1FilePath)));
		JavascriptExecutor je=(JavascriptExecutor)driver;
		je.executeScript("arguments[0].setAttribute('style','background: pink; border:2px solid red;');", highlightedElement);
	}
	public void scrollToElement(WebDriver driver,By by)
	{
		try {
			WebElement element=driver.findElement(by);
			JavascriptExecutor je=(JavascriptExecutor)driver;
			je.executeScript("arguments[0].scrollIntoView(true);", element);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void waitForVisible(WebDriver driver,String element)
	{
		validatePresenceOfElement(driver,element);
	}
	
	public void waitForClickable(WebDriver driver,String element)
	{
		try {
			By by=getBy(getField(element,OR1FilePath));
			
			WebDriverWait wait=new WebDriverWait(driver,60);
			wait.until(ExpectedConditions.elementToBeClickable(by));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Boolean validatePresenceOfElement(WebDriver driver, String element)
	{
		boolean presenceFlag=false;
		try {
			WebDriverWait wait=new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(getBy(getField(element,OR1FilePath))));
			presenceFlag=true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return presenceFlag;
	}
	
	public String getField(String field,String filepath)
	{
		FileInputStream fileInputStreamObj=null;
		
		if(ObjRepo==null || gfile_name!=filepath)
		{
		try {
			ObjRepo=new HashMap<String,String>();
			Properties propertyvalue=new Properties();
			fileInputStreamObj= new FileInputStream(filepath);
			propertyvalue.load(fileInputStreamObj);
			ObjRepo.putAll(propertyvalue.entrySet().stream().collect(Collectors.toMap(k ->k.getKey().toString(), v -> v.getValue().toString())));
			gfile_name=filepath;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if(fileInputStreamObj!=null)
			{
				try {
					fileInputStreamObj.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				
		}
		}
		return ObjRepo.get(field);
	}
	
	public By getBy(String locator)
	{
		String[] parts=locator.split(">",2);
		By by=null;
		
		switch(parts[0].trim())
		{
		case "xpath":
			by=By.xpath(parts[1]);
			break;
			
		case "cssSelector":
			by=By.cssSelector(parts[1]);
			break;
		}
		
		return by;		
	}
	
	
	public WebElement fluentWait(WebDriver driver,By by) {
		Wait<WebDriver> wait1 = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(1, TimeUnit.SECONDS).ignoring(ElementNotVisibleException.class)
				.ignoring(TimeoutException.class).ignoring(StaleElementReferenceException.class)
				.ignoring(Exception.class);
		WebElement element = wait1.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(by);
			}
		});
		return element;
	}
	
	public WebElement fluentWait(WebDriver driver,String fieldName) {
		By by=getBy(getField(fieldName, OR1FilePath));
		Wait<WebDriver> wait1 = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(1, TimeUnit.SECONDS).ignoring(ElementNotVisibleException.class)
				.ignoring(TimeoutException.class).ignoring(StaleElementReferenceException.class)
				.ignoring(Exception.class);
		WebElement element = wait1.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(by);
			}
		});
		return element;
	}

}
