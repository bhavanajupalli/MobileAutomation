package com.cyient.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class WebAppTest {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		//DesiredCapabilities 
		DesiredCapabilities cap=new DesiredCapabilities();
	       
        cap.setCapability("platformName", "Android");
        cap.setCapability("deviceName", "redmi");
        cap.setCapability("browserName", "chrome");
        cap.setCapability("chromedriverExecutable", "F:\\Company\\chromedriver.exe");
        
        AndroidDriver<WebElement>  driver=new AndroidDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), cap);
        
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        
        driver.get("https://magento.com/");
        driver.findElementByXPath("//span[contains(text(),'Sign in')]").click();
        driver.findElementByXPath("//input[@id='email']").sendKeys("balaji0017@gmail.com");
        driver.findElementByXPath("//input[@id='pass']").sendKeys("balaji@12345");//input[@id='email']
 
        Thread.sleep(1000);
        if(driver.isKeyboardShown())
        {
        	driver.hideKeyboard();
        }
        
        driver.findElementByXPath("//*[text()='continue']/..").click();
        WebDriverWait wait=new WebDriverWait(driver, 90);
     //   wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(""));
        
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
          
        driver.quit();
	}

}
