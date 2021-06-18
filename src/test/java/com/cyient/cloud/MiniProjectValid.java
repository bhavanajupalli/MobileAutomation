package com.cyient.cloud;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class MiniProjectValid {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
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

		driver.findElementById("org.coursera.android:id/createAccount").click();
		driver.findElementById("org.coursera.android:id/full_name").sendKeys("asha");
		driver.findElementById("org.coursera.android:id/email").sendKeys("asha12@gmail.com");
		driver.findElementById("org.coursera.android:id/password").sendKeys("asha@123");

		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement el = wait
				.until(ExpectedConditions.elementToBeClickable(By.id("org.coursera.android:id/create_account")));
		el.click();

		driver.findElementById("org.coursera.android:id/check_box_1").click();
		driver.findElementById("org.coursera.android:id/check_box_2").click();
		driver.findElementById("org.coursera.android:id/continue_button").click();
		Thread.sleep(1000);
		driver.findElementById("org.coursera.android:id/find_course").click();
		driver.findElementById("org.coursera.android:id/find_course").click();

		// Horizontal Scroll
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(By.linkText("Learning How to Learn: Powerful mental "));
		js.executeScript("arguments[0].scrollIntoView();", Element);

		Thread.sleep(3000);

		// scroll to till end.
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		driver.quit();
	}

}
