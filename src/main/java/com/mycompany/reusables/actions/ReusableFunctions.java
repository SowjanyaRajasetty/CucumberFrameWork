package com.mycompany.reusables.actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.mycompany.glue.runnables.CommonImplementation;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class ReusableFunctions {
	
	String path=System.getProperty("user.dir");
//	public static WebDriver driver=launchChrome();
	public static WebDriver driver;
	
	 public ReusableFunctions()
	 {
		 this.driver=CommonImplementation.driver;
	 }
	

	  public static WebDriver launchChrome() {
//	  System.setProperty("webdriver.chrome.driver",  "C:\\Users\\User\\eclipse-workspace\\Selenium_Cucumber_MavenProject\\Drivers\\chromedriver.exe" );
	  // RemoteWebDriver driver = null;
	  ChromeOptions options = new ChromeOptions();
	  options.addArguments("chrome.switches","--disable-extensions","--test-type");
	  System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+  "\\Drivers\\chromedriver.exe"); 
	  options.addArguments("chrome.switches",  "--test-type", "--start-maximized", "--ignore-certificate-errors");
	  options.setExperimentalOption("useAutomationExtension", false);
	  options.addArguments("disable-infobars");
	  options.addArguments("--start-maximized");
	  options.setExperimentalOption("useAutomationExtension", false);
	  options.setExperimentalOption("excludeSwitches",Collections.singletonList("enable-automation"));
	  options.addArguments("--safebrowsing-disable-extension-blacklist", "--safebrowsing-disable-download-protection"); HashMap<String, Object>
	  chromePrefs = new HashMap<String, Object>();
	  chromePrefs.put("download.prompt_for_download", true);
	  options.setExperimentalOption("prefs", chromePrefs); 
	  DesiredCapabilities cap = DesiredCapabilities.chrome();
	  cap.setCapability(ChromeOptions.CAPABILITY, options);
	  DesiredCapabilities capability = DesiredCapabilities.chrome();
	  capability.setCapability(ChromeOptions.CAPABILITY, options);
	  capability.setBrowserName(BrowserType.CHROME);
	  capability.setPlatform(Platform.WINDOWS); 
	  try{ 
		  // driver =new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capability);
	  driver=new ChromeDriver(capability); 
	  } catch(Exception e){
	  e.printStackTrace(); 
	  } 
	  return driver; 
	  }
	 
	
public HashMap<String, String> getUserCredentials(String User)
{
	String xlsFilePath=path+"\\src\\main\\resources\\TestData\\UserList.xlsx";
	String sheetName="User";	
	HashMap<String, String> testData;
	testData=getTestData(xlsFilePath, sheetName, User);
	return testData;
	
}

	public HashMap<String, String> getTestData(String xlsFilePath, String sheetName, String User) {
		
		  HashMap<String, String> testData = new HashMap<String, String>(); File
		  xlFile= null; 
		  FileInputStream fileInput=null; 
		  XSSFWorkbook wb= null; 
		  try{
		  xlFile= new File(xlsFilePath);
		  fileInput=new FileInputStream(xlFile); 
		  wb=new XSSFWorkbook(fileInput); 
		  XSSFSheet sheet=wb.getSheet(sheetName);
		  
		  Row headerRow = sheet.getRow(0);
		  
		  for (int i = 1; i <= sheet.getLastRowNum(); i++) 
		  { 
		  Row currentRow =  sheet.getRow(i);
		  if(currentRow.getCell(0).getStringCellValue().equals(User)) {
			  for (int j = 0; j < currentRow.getLastCellNum(); j++) 
			  { 
			  Cell currentCell =currentRow.getCell(j); 
			  System.out.println(currentCell);
			  testData.put(headerRow.getCell(j).getStringCellValue(), currentCell!=null? currentCell.getStringCellValue():null); 
			  } 
			  break; 
			  }
		  } 
		  } catch (IOException e)
		  {
			  e.printStackTrace(); 
			  } 
		  finally 
		  { 
			  try {		  
//		  ((Closeable) wb).close(); 
		  fileInput.close(); 
		  } 
			  catch (IOException e) {
				  e.printStackTrace();
		  } 
			  } 
		  return testData;
	 
}
}
