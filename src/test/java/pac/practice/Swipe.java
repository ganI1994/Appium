package pac.practice;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class Swipe {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities dc = new DesiredCapabilities();
		// Common DC (Android or IOS)
		dc.setCapability("deviceName", "Redmi");		
		dc.setCapability("automationName", "appium");
		dc.setCapability("platformName", "Android");
		dc.setCapability("platformVersion", "7");
		dc.setCapability("UDID", "d6c768cf9804");
		//DC for Android 
		dc.setCapability("appPackage", "jp.rallwell.siriuth.touchscreentest");
		dc.setCapability("appActivity", ".TouchScreenTestActivity");

		// Appium Server Port No.
		URL url = new URL("http://localhost:4723/wd/hub");

		AndroidDriver driver = new AndroidDriver(url, dc);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//		// Vertical swipe
		//		driver.swipe(500, 377, 500, 1500, 500);
		//		
		//		//Horizontal swipe
		//		driver.swipe(100, 850, 900, 850, 1000);
		//		
		//		//Inclined Swipe
		//		driver.swipe(100, 1400, 750, 530, 1000);
		//		
		Dimension size = driver.manage().window().getSize();

		int ht = size.getHeight();

		int wd= size.getWidth();

		System.out.println("Height or length of Phone is = "+ ht);

		System.out.println("Width  of Phone is = "+ wd);
		//Height or length of Phone is = 1920
		//		Width  of Phone is = 1080

		//
		//				int starty= ht/
		//
		//				int endy=	

		//Vertical Swipe
		driver.swipe( wd/2, (int) (ht*0.25), wd/2, (int) (ht*0.80), 1000);

		// Horizontal swipe
		driver.swipe((int)(wd*.20), ht/2, (int ) (wd*.80),ht/2, 1000);


	}

}
