package pac.practice;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class InstallApp {

	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities dc = new DesiredCapabilities();
		// Common DC (Android or IOS)
		dc.setCapability("deviceName", "Android Emulator");		
		dc.setCapability("automationName", "appium");
		dc.setCapability("platformName", "Android");
		dc.setCapability("platformVersion", "8.1.0");
		dc.setCapability("UDID", "emulator-5554");

		//Install app in Phone IOS and Android	
		//	dc.setCapability("app", "D:\\APPIUM_Stuff\\APK\\Touch Screen Test_v1.7.14_apkpure.com.apk");


		dc.setCapability("appPackage", "io.appium.android.apis");
		dc.setCapability("appActivity", "ApiDemos");

		// Appium Server Port No.
		URL url = new URL("http://localhost:4723/wd/hub");

		AndroidDriver driver = new AndroidDriver(url, dc);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		System.out.println("App Status = "+driver.isAppInstalled("io.appium.android.apis"));//True

		//Unistall App
		driver.removeApp("io.appium.android.apis");

		System.out.println("App Status = "+driver.isAppInstalled("io.appium.android.apis"));//False



	}

}
