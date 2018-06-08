package Mobile_android_Test.Mobile_andoid_Test;


	

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;



	public class Hybrid_apps_Test  {
		
		private AndroidDriver<AndroidElement> driver; 
		File f = new File("\\Users\\u6017127\\Java_workspace\\Mobile_andoid_Test\\src\\main\\java\\");
		File fs = new File(f,"ApiDemos-debug.apk");  //*** find hybrid app*** 
		
		@Before 
		
		public void setUp() throws MalformedURLException  {
			
			DesiredCapabilities cap = new DesiredCapabilities(); 
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "MORO");
			cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
			
		    driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap); 
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
		}

		
		@Test 
		public void HybridSwitchTest() throws Exception {
			
			/// code to get to to web browser part
			
			System.out.println(driver.getContext());  /// see where you are  
			
			
			Set<String> s= driver.getContextHandles(); // to know how many views the app supports it can be either Native or Web
			
			// string stores the value 
					
			
			for (String handle : s) {
				
				System.out.println(handle);   // the loop will print all the condition the app handles in this case NATIVE and WEB print the name first to perform the switch
			}
			
			
			// ***** to enable WebViwe debugging, call the status method setWebContentDebuggingEnabled on the WebView Class. (otherwise the switch won't happen even if the code is correct *****
			
			// switch and write code for web part
			
			driver.context("WEBVIEW_com.example.testapp") ; //to switch to the Web (see result of the printout for the previous loop 
			
			driver.findElement(By.name("name")).sendKeys("entert your txt");
			
			
		}
				
	
		
		
		@After 
		public void tearDown(){
			driver.quit();
		}

		

}
