package com.drivermethods;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class ToastMsg {

	public static void main(String[] args) throws Throwable {

		DesiredCapabilities dc = new DesiredCapabilities();
		// Common DC (Android or IOS)
		dc.setCapability("deviceName", "Redmi");		
		dc.setCapability("automationName", "appium");
		dc.setCapability("platformName", "Android");
		dc.setCapability("platformVersion", "7");
		dc.setCapability("UDID", "d6c768cf9804");
		//DC for Android 
		dc.setCapability("appPackage", "com.androidsample.generalstore");
		dc.setCapability("appActivity", ".SplashActivity");

		// Appium Server Port No.
		URL url = new URL("http://localhost:4723/wd/hub");

		AndroidDriver		driver = new AndroidDriver(url, dc);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

		String toastmsg=driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name");
		
		System.out.println(toastmsg);
	}


}


