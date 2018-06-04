package Mobile_android_Test.Mobile_andoid_Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class ExerciseTest {
	
	
	
	private AndroidDriver<AndroidElement> driver; 
	File appDir = new File("\\Users\\u6017127\\Java_workspace\\Mobile_andoid_Test\\src\\main\\java\\");
	File App = new File(appDir,"Raaga.apk");
	
	@Before 
	
	public void setUp() throws MalformedURLException  {
		
	 
		DesiredCapabilities cap = new DesiredCapabilities(); 
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME,MobilePlatform.ANDROID );
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "MORO");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,"100");
		cap.setCapability(MobileCapabilityType.APP, App.getAbsolutePath());
	    driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap); 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    	
		
	}

	
	@Test 
	public void test1() throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By
		        .id("identifierNext")));    // wait until an element is displayed on the page 
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_BACK);		
		driver.findElementById("com.raaga.android:id/skip_login_btn").click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(resource-id(\"com.raaga.android:id/music_home_raaga_live\"));");
		driver.findElementById("com.raaga.android:id/music_home_raaga_live").click();
	}
			
	
	
	
	
	
	
	
	
	
	

}
