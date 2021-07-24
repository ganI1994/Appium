package com.drivermethods;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class Notifications {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities dc = new DesiredCapabilities();
		// Common DC (Android or IOS)
		dc.setCapability("deviceName", "Redmi");		
		dc.setCapability("automationName", "appium");
		dc.setCapability("platformName", "Android");
		dc.setCapability("platformVersion", "7");
		dc.setCapability("UDID", "d6c768cf9804");
		//DC for Android 
		dc.setCapability("appPackage", "io.appium.android.apis");
		dc.setCapability("appActivity", "ApiDemos");

		// Appium Server Port No.
		URL url = new URL("http://localhost:4723/wd/hub");

		AndroidDriver driver = new AndroidDriver(url, dc);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElementByAccessibilityId("App").click();

		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Notification\"]")).click();

		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"IncomingMessage\"]")).click();

		driver.findElementById("io.appium.android.apis:id/notify_app").click();
		
		Thread.sleep(2000);
		
		//open notification
		driver.openNotifications();
		
		driver.findElementByAccessibilityId("API Demos").click();



	}

}
