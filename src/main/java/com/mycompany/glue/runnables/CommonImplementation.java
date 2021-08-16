package com.mycompany.glue.runnables;

import java.util.Collections;
import java.util.HashMap;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class CommonImplementation {

	public static WebDriver driver;
	 	
	@Before
		public static WebDriver launchChrome() 
		{
//			 System.setProperty("webdriver.chrome.driver","C:\\Users\\User\\eclipse-workspace\\Selenium_Cucumber_MavenProject\\Drivers\\chromedriver.exe");
//			 RemoteWebDriver driver = null;
			 ChromeOptions options = new ChromeOptions();
			 options.addArguments("chrome.switches","--disable-extensions","--test-type");
			 System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
			 options.addArguments("chrome.switches", "--test-type",
			 "--start-maximized", "--ignore-certificate-errors");
			 options.setExperimentalOption("useAutomationExtension", false);
			 options.addArguments("disable-infobars");
			 options.addArguments("--start-maximized");
			 options.setExperimentalOption("useAutomationExtension", false);
			 options.setExperimentalOption("excludeSwitches",Collections.singletonList("enable-automation"));
			 options.addArguments("--safebrowsing-disable-extension-blacklist","--safebrowsing-disable-download-protection");
			 HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
			 chromePrefs.put("download.prompt_for_download", true);
			 options.setExperimentalOption("prefs", chromePrefs);
//			 DesiredCapabilities cap = DesiredCapabilities.chrome();
//			 cap.setCapability(ChromeOptions.CAPABILITY, options);
			 DesiredCapabilities capability = DesiredCapabilities.chrome();
			 capability.setCapability(ChromeOptions.CAPABILITY, options);
			 capability.setBrowserName(BrowserType.CHROME);
			 capability.setPlatform(Platform.WINDOWS);
			 try{
//			 driver =new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capability);
			 driver=new ChromeDriver(capability);
			 }
			 catch(Exception e){
			 e.printStackTrace();
			 }
			 return driver;
			 }
	
	 @After
	  public void quitDriver() {
	    driver.quit();
	  }

}
