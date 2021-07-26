package com.webapp;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class WebApp {

	public static void main(String[] args) throws Throwable
	{
		DesiredCapabilities dc = new DesiredCapabilities();
		// Common DC (Android or IOS)
//		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi");		
//		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "appium");
//		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
//		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7");
//		dc.setCapability(MobileCapabilityType.UDID, "d6c768cf9804");
//		dc.setCapability(MobileCapabilityType.NO_RESET, true);
		
		dc.setCapability("deviceName", "Redmi");		
		dc.setCapability("automationName", "appium");
		dc.setCapability("platformName", "Android");
		dc.setCapability("platformVersion", "7");
		dc.setCapability("UDID", "d6c768cf9804");
		dc.setCapability("noReset", true);

		//LAunch browser
		dc.setCapability("browserName", "Chrome");

		// Appium Server Port No.
		URL url = new URL("http://localhost:4723/wd/hub");

		AndroidDriver driver = new AndroidDriver(url, dc);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.facebook.com");
		
		driver.findElement(By.xpath("//input[@id='m_login_email']")).sendKeys("TYSS");
		
		driver.findElement(By.xpath("//input[@id='m_login_password']")).sendKeys("12345");
		
		driver.findElement(By.xpath("//button[@name='login']")).click();
		
		
		
	}
}
