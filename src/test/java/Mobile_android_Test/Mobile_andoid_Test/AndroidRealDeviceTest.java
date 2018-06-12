package Mobile_android_Test.Mobile_andoid_Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class AndroidRealDeviceTest {
	
	
	
	private AndroidDriver<AndroidElement> driver; 
	File appDir = new File("\\Users\\u6017127\\Java_workspace\\Mobile_andoid_Test\\src\\main\\java\\");
	File App = new File(appDir,"ApiDemos-debug.apk");
	
	@Before 
	
	public void setUp() throws MalformedURLException  {
		
	    /* 
	     * to check is a device is connected to the machine go to C:\Users\u6017127\AppData\Local\Android\Sdk\tools\bin
	     * 
	     * in a command prompt and type command "abd devices " to see connected devices 
	     * 
	     * now connect real device with usb and connect 
	     * 
	     */
		
		DesiredCapabilities cap = new DesiredCapabilities(); 
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME,MobilePlatform.ANDROID );
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android device");  // this is cap to targer real device "Android Device"
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,"100");
		cap.setCapability(MobileCapabilityType.APP, App.getAbsolutePath());
	    driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap); 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
		
		
	}

	
	/* search on google remote debugging android devices 
	 * https://developers.google.com/web/tools/chrome-devtools/remote-debugging/
	 *step by step how to connect and make your device recognisable   
	 *
	 */
	
	@Test 
	public void SrollOnRealMobileTest() throws Exception {
		
		/* usually real devices screen size is different so when running scrolling tests be extra carefull about this challenge
		 * for example for the script we did before now view is no longer visible in the inital screen for real device
		 * but if we switch between emulator and real we have to maintain the consistency we use the following line of code to scroll once 
		 * without focusing on any on any object
		 */
		
		Dimension size = driver.manage().window().getSize();
		int x = size.getWidth() / 2;
		int starty = (int) (size.getHeight() * 0.60); 
		int endy = (int) (size.getHeight() * 0.10);
	   // driver.swipe(x, starty, x, endy, 2000);
		
		TouchAction ta = new TouchAction(driver);
		ta.press(starty, x).waitAction().moveTo(endy, x * 2).release().perform();
		
	
		
	}
			
	
	
	
	
	
	@After 
	public void tearDown(){
		driver.quit();
	}

	
	
	
	
	

}
