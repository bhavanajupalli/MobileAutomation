package com.cyient.cloud;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.util.Assert;

import com.google.common.annotations.VisibleForTesting;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class MiniProjectInvalid {

	public static void main(String[] args) throws MalformedURLException {

		DesiredCapabilities caps = new DesiredCapabilities();

		caps.setCapability("browserstack.user", "ashabhavana_2ynPvp");
		caps.setCapability("browserstack.key", "zPiJzssez8euyXwk1M9B");

		caps.setCapability("app", "bs://416234829d7248da018434c6ab440bfd537e4291");

		caps.setCapability("device", "Google Nexus 6");
		caps.setCapability("os_version", "6.0");

		caps.setCapability("project", "First Java Project");
		caps.setCapability("build", "Java Android");
		caps.setCapability("name", "first_test");

		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(
				new URL("http://hub.browserstack.com/wd/hub"), caps);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		// Invalid Credential
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement el = wait.until(ExpectedConditions.elementToBeClickable(By.id("org.coursera.android:id/login")));
		el.click();

		driver.findElement(By.id("org.coursera.android:id/email")).sendKeys("asha@gmail.com");
		driver.findElementByXPath("//*[@text='Password (Required)']").sendKeys("asha123");

		if (driver.isKeyboardShown()) {
			driver.hideKeyboard();
		}

		driver.findElementById("org.coursera.android:id/create_account");
		String actalValue = driver.switchTo().alert().getText();
		System.out.println(actalValue);
		driver.switchTo().alert().accept();

		driver.quit();

	}

}
