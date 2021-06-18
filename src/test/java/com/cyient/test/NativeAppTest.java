package com.cyient.test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class NativeAppTest {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub

		DesiredCapabilities cap=new DesiredCapabilities();
	       
        cap.setCapability("platformName", "Android");
        cap.setCapability("deviceName", "honor");
        cap.setCapability("app", "C:\\Users\\Bhavana\\eclipse-workspace\\MobileAutomation\\src\\test\\resources\\appiumAPK\\org.coursera.android_2021-04-30.apk");
        
        AndroidDriver<WebElement>  driver=new AndroidDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), cap);
        //driver.findElementByXPath("//*[@text='Dismiss']").click();
        //driver.findElementByXPath("//*[@text='']").click();
        
        
		
	}

}
