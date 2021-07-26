package com.drivermethods;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class App_Switch {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

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

		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("shruthi");
	    
	    driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
	    
	    driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	    
	    driver.findElementByXPath("//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productAddCart']").click();
	    
	    driver.findElement(By.xpath("//android.widget.ImageButton[@resource-id='com.androidsample.generalstore:id/appbar_btn_cart']")).click();
	    
	    driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
	    
	    Thread.sleep(4000);
	    
	    
	    Set<String> windows = driver.getContextHandles();
	    
	    for(String window: windows) 
	    {
	    	System.out.println("Active Applications : "+ window);
	    }
	    
	    Thread.sleep(1000);
	    
	    driver.context("WEBVIEW_com.androidsample.generalstore");
	    
	    
	    driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Tyss");
	    

	}

}
