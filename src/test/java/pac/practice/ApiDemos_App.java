package pac.practice;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ApiDemos_App {

	public static void main(String[] args) throws Exception {
		DesiredCapabilities dc = new DesiredCapabilities();
		// Common DC (Android or IOS)
		dc.setCapability("deviceName", "Android Emulator");		
		dc.setCapability("automationName", "appium");
		dc.setCapability("platformName", "Android");
		dc.setCapability("platformVersion", "8.1.0");
		dc.setCapability("UDID", "emulator-5554");
		//DC for Android 
		dc.setCapability("appPackage", "io.appium.android.apis");
		dc.setCapability("appActivity", "ApiDemos");
		boolean value = checkIfAppiumServerIsRunnning();
		System.out.println("Appium Server running ="+value);
		// Appium Server Port No.
		URL url = new URL("http://localhost:4723/wd/hub");
		
		AndroidDriver driver = new AndroidDriver(url, dc);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
//		driver.findElementByAccessibilityId("Views").click();
//		
//		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Controls']")).click();
//		
//		driver.findElementByAccessibilityId("2. Dark Theme").click();
//		
//		driver.findElementById("io.appium.android.apis:id/edit").sendKeys("SDET17");
//		
//		driver.findElementByAccessibilityId("Checkbox 1").click();
//		
//		driver.findElement(By.id("io.appium.android.apis:id/radio2")).click();
		
	//	List <WebElement>options = driver.findElementsByClassName("android.widget.TextView");
		
		List <WebElement>options=driver.findElementsByXPath("//android.widget.TextView[@resource-id='android:id/text1']");
		for (int i = 1; i < options.size(); i++)
		{
			System.out.println(options.get(i).getText());
		}
		
		

	}

	public static boolean checkIfAppiumServerIsRunnning() throws Exception {
	    boolean isAppiumServerRunning = false;
	    ServerSocket socket;
	    try {
	        socket = new ServerSocket(4723);
	        socket.close();
	    } catch (IOException e) {
	    	System.out.println("1");
	        isAppiumServerRunning = true;
	    } finally {
	        socket = null;
	    }
	    return isAppiumServerRunning;
	}

}
