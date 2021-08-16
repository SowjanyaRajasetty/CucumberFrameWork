package com.mycompany.glue.runnables;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class AppiumBase {
	static String path=System.getProperty("user.dir");
	public static String APKFilePath=path+"\\src\\main\\resources\\APK\\ApiDemos-debug.apk";
	
	public static AndroidDriver<AndroidElement> setCapability() throws MalformedURLException
	{
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "SowjanyaPx2");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
		cap.setCapability(MobileCapabilityType.APP, APKFilePath);		
		AndroidDriver<AndroidElement> driver=new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);	
	return driver;

}
}
