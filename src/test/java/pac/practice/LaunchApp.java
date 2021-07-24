package pac.practice;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;

public class LaunchApp {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {


		DesiredCapabilities dc = new DesiredCapabilities();
		// Common DC (Android or IOS)
		dc.setCapability("deviceName", "Android Emulator");		
		dc.setCapability("automationName", "appium");
		dc.setCapability("platformName", "Android");
		dc.setCapability("platformVersion", "8.1.0");
		dc.setCapability("UDID", "emulator-5554");
		//DC for Android 
		dc.setCapability("appPackage", "com.android.calculator2");
		dc.setCapability("appActivity", ".Calculator");

		// Appium Server Port No.
		URL url = new URL("http://localhost:4723/wd/hub");

		AndroidDriver driver = new AndroidDriver(url, dc);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


		MobileElement seven = (MobileElement) driver.findElement(By.id("com.android.calculator2:id/digit_7"));

		driver.tap(1, seven, 500);	
		
		WebElement plus=	driver.findElementByAccessibilityId("plus");
		
		driver.tap(1, plus, 300);

		AndroidElement three=(AndroidElement) driver.findElement(By.id("com.android.calculator2:id/digit_3"));
		
		driver.tap(1, three, 500);
		
		WebElement equals = driver.findElement(By.xpath("//android.widget.Button[@content-desc='equals']"));
		
		driver.tap(1, equals, 500);
	
		String result=driver.findElement(By.id("com.android.calculator2:id/result")).getText();
		Thread.sleep(1000);
		System.out.println(result);



	}




}
