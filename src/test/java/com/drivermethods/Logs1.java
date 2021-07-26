package com.drivermethods;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class Logs1 {
	public static  AndroidDriver driver;
	public static void main(String[] args) throws MalformedURLException, InterruptedException 
	{

		AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();

		service.start();

		DesiredCapabilities dc = new DesiredCapabilities();
		// Common DC (Android or IOS)
		dc.setCapability("deviceName", "Redmi");		
		dc.setCapability("automationName", "appium");
		dc.setCapability("platformName", "Android");
		dc.setCapability("platformVersion", "7");
		dc.setCapability("UDID", "d6c768cf9804");

		dc.setCapability("noReset", true);
		//DC for Android 
		dc.setCapability("appPackage", "com.android.camera");
		dc.setCapability("appActivity", ".Camera");


		// Appium Server Port No.
		URL url = new URL("http://localhost:4723/wd/hub");

		driver = new AndroidDriver(url, dc);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);



		Thread.sleep(3000);

		service.stop();

	}


}
