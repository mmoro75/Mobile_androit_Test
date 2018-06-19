package Mobile_android_Test.Mobile_andoid_Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;



public class AndroidMobileTest {
	
	private AndroidDriver<AndroidElement> driver; 
	File f = new File("\\Users\\u6017127\\Java_workspace\\Mobile_andoid_Test\\src\\main\\java\\");
	File fs = new File(f,"ApiDemos-debug.apk");
	
	@Before 
	
	public void setUp() throws MalformedURLException  {
		
		DesiredCapabilities cap = new DesiredCapabilities(); 
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "MORO");
		cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
		
	    driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap); 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}

	
	@Test 
	public void testWifi() throws Exception {
			
		// Locators : xpath , id , classname , androidUIautomator
		
		driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
		driver.findElementById("android:id/checkbox").click();
		// in the page we have 2 elements with same xpath no attributes we specify to click index 2 
		driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
		driver.findElementByClassName("android.widget.EditText").sendKeys("hello");
		
		// in this scenation we have 2 elements same class we find them both get the second one (remember index starts form 0) and click
		driver.findElementsByClassName("android.widget.Button").get(1).click();
		
		/* 
		  A unique option in Appium is to use Android UI Automator the syntax is as below
		  driver.findElementByAndroidUIAutomator("attribute=("value")"); 
	    	an example could be:
	    	driver.findElementByAndroidUIAutomator("text=(\"Views\")").click();
	    	
	    	with Android UI you could also validate properties 
	    	
	    	i.e validate clickable feature for all options
	    	the syntax is:
	    	driver.findElementByAndroidUIAutomator("new UISelector().property(value)");
	    	an example is below where you print all the clickable property usind UI selector and Size 
	    	
	    	System.out.println(driver.findElementByAndroidUIAutomator("new UISelector().clickable(true)").size());
	    	
	    	*/
		
	}
		
	    @Test 
		public void testGestures() throws Exception {
			
	    	// using UI Automator 
	    	driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
	    	//1) Gesture = tap 
	    	
	    	TouchAction t = new TouchAction(driver);
	    	 
	    	// once the class is imported and object defined now you can perform the actions
	    	// to execute the action .perform() has to be included to execute te action 
	    	t.tap(driver.findElementByXPath("//android.widget.TextView[@text='Expandable Lists']")).perform();
	    
	    	driver.findElementByXPath("//android.widget.TextView[@text='1. Custom Adapter']").click();
	    	
	    	// we want to press and hold the element therefore I include wait 3000 milliseconds
	    	t.press(driver.findElementByXPath("//android.widget.TextView[@text='People Names']")).waitAction(Duration.ofMillis(3000)).release().perform();
	    	assertEquals("Sample menu", driver.findElement(By.xpath("//android.widget.TextView[@text='Sample menu']")).getText());
	    	assertEquals("Sample menu", driver.findElement(By.xpath("//android.widget.TextView[@text='Sample action']")).getText());    	
		
	}
	
	
	    @Test 
		public void testSwipe() throws Exception {
	    
	    	// perform a Swipe 
	
	    	driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
	    	driver.findElementByXPath("//android.widget.TextView[@text='Date Widgets']").click();
	    	driver.findElementByXPath("//android.widget.TextView[@text='2. Inline']").click();
	    	// in this xpath we give * as tagname as the name of the class contains a special character that cannot be reconized and we only pass the value
	    	driver.findElementByXPath("//*[@content-desc='9']").click();
	    	
	    	TouchAction s = new TouchAction(driver);
	    	
	    	s.press(driver.findElementByXPath("//*[@content-desc='15']")).waitAction(Duration.ofMillis(2000)).moveTo(driver.findElementByXPath("//*[@content-desc='45']")).release().perform();
	    	
	    	
	  }	
	    	
	
	    @Test 
		public void testScroll() throws Exception {
	    
	    	//perform a scroll 
	    	
	    	driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
	    	
	    	// no longer available in appium we do need to use Android API
	    	
	    	driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));");
	    	
	    	
	    }
	    
	    
	    
	    @Test 
		public void testDragNdrop() throws Exception {
	    
	    driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();	
	    driver.findElementByXPath("//android.widget.TextView[@text='Drag and Drop']").click();	
	    
	    TouchAction d = new TouchAction(driver);
	    
	    d.longPress(driver.findElementsByClassName("android.view.View").get(0)).moveTo(driver.findElementsByClassName("android.view.View").get(2)).release().perform();
	    
	    
	    }
	    
	    
	    @Test 
		public void testKeyEvents() throws Exception {
	    	
	    // in Android code every page has got an activity and there are time when Activities have to be validated
	    
	    System.out.println(driver.currentActivity());
	    assertEquals(".ApiDemos",driver.currentActivity());
	    /* there are 3 types of views and get context gives you that  
	     * 
	     * view - Native (means you are mobile gestures view)
	     * 
	     * view - Hybrid (means is a combination between mobile app and web)
	     * 
	     * view - Webview ( entirely web application )
	     * 
	     */
	    
	    System.out.println(driver.getContext());	
	    assertEquals("NATIVE_APP",driver.getContext());
	    // there are 2 types of orientation - landscape and portrait 
	    
	    System.out.println(driver.getOrientation());
	  //  assertEquals("PORTRAIT", driver.getOrientation());
	    
	    // check if device is locked or not gives true or false 
	    
	    System.out.println(driver.isLocked());
	    assertFalse("false", driver.isLocked());
	    driver.hideKeyboard(); // to remove keyboard in case needed 
	    
	    // click on the back button to get to homepage 
	    
	    driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
	    
	    driver.pressKeyCode(AndroidKeyCode.BACK);
	   
	    // press key code method gives you the ability to operate with android key button 
	    
	    driver.pressKeyCode(AndroidKeyCode.KEYCODE_HOME);
	    	
	    }
	    
	      
	    
	    
	
	@After 
	public void tearDown(){
		driver.quit();
	}

	
	
	
	
	
}
