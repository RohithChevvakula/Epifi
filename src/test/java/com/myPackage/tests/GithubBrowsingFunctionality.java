package com.myPackage.tests;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class GithubBrowsingFunctionality {
	
@Test	
public void met() throws InterruptedException {
	AppiumDriverLocalService appiumService = AppiumDriverLocalService.buildDefaultService();
	appiumService.start();
	
	DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UIAutomator2");
	desiredCapabilities.setCapability("platformName", "Android");
	desiredCapabilities.setCapability("appPackage", "com.android.example.github");
	desiredCapabilities.setCapability("appActivity", "com.android.example.github.MainActivity");
	desiredCapabilities.setCapability("noReset",true);
		
	AndroidDriver driver = new AndroidDriver(appiumService,desiredCapabilities);
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	driver.findElementById("com.android.example.github:id/input").click();
	driver.findElementById("com.android.example.github:id/input").sendKeys("RohithChevvakula/Epifi");
	driver.pressKeyCode(AndroidKeyCode.KEYCODE_ENTER);
	driver.findElementByXPath("//*[@resource-id='com.android.example.github:id/repo_list']/*[@class='android.widget.FrameLayout']").click();
	driver.findElementByXPath("//*[@resource-id='com.android.example.github:id/contributor_list']/*[1]").click();
	Thread.sleep(3000);
	driver.quit();
	appiumService.stop();
	}

}
