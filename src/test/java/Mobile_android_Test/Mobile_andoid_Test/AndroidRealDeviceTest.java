package Mobile_android_Test.Mobile_andoid_Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

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
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android device");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,"100");
		cap.setCapability(MobileCapabilityType.APP, App.getAbsolutePath());
	    driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap); 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
		
		
	}

	
	@Test 
	public void test1() throws Exception {
		
	}
			
	
	
	
	
	
	
	
	
	
	

}
