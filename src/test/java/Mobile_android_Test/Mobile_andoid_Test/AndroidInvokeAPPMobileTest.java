package Mobile_android_Test.Mobile_andoid_Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class AndroidInvokeAPPMobileTest {
	
	
	
	private AndroidDriver<AndroidElement> driver; 
	File appDir = new File("\\Users\\u6017127\\Java_workspace\\Mobile_andoid_Test\\src\\main\\java\\");
	File App = new File(appDir,"ApiDemos-debug.apk");
	
	
	
	@Before 
	
	public void setUp() throws MalformedURLException  {
		
		/* if you know tha package and the activity for a specific app you can invoke it 
		 * 
		 * even without apk to do that yoc can download from playstore apk info
		 * 
		 * (always pick up main activity to invoke the app
		 * 
		 * to do these settings on a real mobile the app has to be already installed we are just invoking the app
		 */
	
		
		DesiredCapabilities cap = new DesiredCapabilities(); 
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME,MobilePlatform.ANDROID );
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "MORO");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,"25");
		cap.setCapability("appPackage", "find package name");
		cap.setCapability("AppActivity", "find activity");
	    driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap); 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}

	
	@Test 
	public void test1() throws Exception {
		
	}
			

	
	@After 
	public void tearDown(){
		driver.quit();
	}

	
	
	
}
