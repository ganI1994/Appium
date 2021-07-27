package com.webapp;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Landing_PAge
{

	AndroidDriver driver;

	@AndroidFindBy(xpath ="//android.widget.TextView[@resource-id='android:id/text1']")
	private MobileElement countryDD;

	@AndroidFindBy(id ="com.androidsample.generalstore:id/nameField")
	private MobileElement nametxtbox;

	@AndroidFindBy(id="com.androidsample.generalstore:id/radioMale")
	private MobileElement maleradiobtn;

	@FindBy(id="com.androidsample.generalstore:id/radioFemale")
	private MobileElement femaleradiobtn;

	@FindBy(xpath="//android.widget.Button[@resource-id='com.androidsample.generalstore:id/btnLetsShop']")
	private MobileElement loginbtn;

	public MobileElement getCountryDD() {
		return countryDD;
	}

	public MobileElement getNametxtbox() {
		return nametxtbox;
	}

	public MobileElement getMaleradiobtn() {
		return maleradiobtn;
	}

	public MobileElement getFemaleradiobtn() {
		return femaleradiobtn;
	}

	public MobileElement getLoginbtn() {
		return loginbtn;
	}


	public  Landing_PAge (AndroidDriver driver) 
	{
		this.driver= driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public void logintoApp()
	{
		getNametxtbox().sendKeys("qwert");
		getFemaleradiobtn().click();
		getLoginbtn().click();
	}
	public void logintoApp(String name)
	{
		nametxtbox.sendKeys(name);
		femaleradiobtn.click();
		loginbtn.click();
	}


}
