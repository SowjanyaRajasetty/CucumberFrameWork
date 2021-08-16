package com.mycompany.module.test;

import java.io.File;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.mycompany.reusables.actions.ReusableFunctions;

import io.cucumber.java.After;

//import io.cucumber.java.After;

public class SeleniumTest {

	private static ChromeDriverService service;
	  private WebDriver driver=ReusableFunctions.driver;
	  static String path=System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe";
	 
	/*
	 * @BeforeClass public static void createAndStartService() throws IOException {
	 * service = new ChromeDriverService.Builder() .usingDriverExecutable(new
	 * File(path)) .usingAnyFreePort() .build(); service.start(); }
	 * 
	 * @AfterClass public static void stopService() { service.stop(); }
	 * 
	 * @Before public void createDriver() { driver = new
	 * RemoteWebDriver(service.getUrl(), new ChromeOptions()); }
	 */

	/*
	 * @After public void quitDriver() { driver.quit(); }
	 */
}
