package Mobile_android_Test.Mobile_andoid_Test;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.functions.ExpectedCondition;
import io.appium.java_client.remote.MobileCapabilityType;

public class Mobile_browser_automation_test {
	
	
	private AndroidDriver<AndroidElement> driver;
	WebDriver driver1 = new FirefoxDriver();  // create wedriver for firefox
	
     public int FindFramenumber(WebDriver driver, By by){   // method to handle dynamic frames anf get framenumber //
		 
    	 int i;
    	 int framecount = driver1.findElements(By.tagName("iframe")).size();
    	 
    	 for (i=0; i<framecount; i++) {
    	 
    	   driver1.switchTo().frame(i);
    	   
    	/* to validate if the element is present once switched in frame mode 
    	 * isDisplayd cannot be used in this case as validates only if it is in visible or not
    	 */
    	   
    	   int count = driver1.findElements(by).size();   // if the object is present the count switch to 1 meaning the element is present   
    	   
    	   if(count>1){
    		   
    		  driver.findElement(by).click(); 
    		  break;
    	   }
    	   else {
    		    System.out.println("Element not present continue looping");
    	     }
    	   }
    	 driver.switchTo().defaultContent();  // get back from normal view Mandatory step 
    	 return i;
    	 } 
	 
	
	
	@Before 
	
	public void setUp() throws MalformedURLException  {
		
		DesiredCapabilities cap = new DesiredCapabilities(); 
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "MORO");
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");    /// to invoke mobile chrome
		
	    driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap); 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://google.com");   // get url you want to open
		
	}
	
	/* to run the web browser test cases we use Selenium ( Appium is derived from Selenium )
	 * we just have to run the code to invoke the mobile browser on mobile then the rest will be Selenium
	 * the capabilities are set accordingly
	 * 1) we are targeting the browser so we do not need apk 
	 * 2) set capability to invoke the Browser
	 * 3) use driver.get() method to get to desired url 
	 */
	
	@Test 
	public void WebTest() throws Exception {
		
	/* to find element once you get the element on the web page 	
	 * for the native app you can use the UI autometor viewew get the screenshots
	 * for chrome you can use developer option (i.e inspect) from a PC browser or 
	 * go to options > more tools > developer tools and select Remote Devices now chrome
	 * will check remote devices connected to the machine and will be displayed 
	 * now you can open url from chromebrowser basically control remote device from the browser
	 * and the screen will be mirrored in web in Mobile view and now you can get the element by 
	 * Clicking inspect
	 * 
	 * !!When opening url if starts with m.urlname than means the page is mobile version if not it 
	 * means it will be the same on mobile and browser!! 
	 */
		
	
	// WRITE A TEST //	
	
		
	/* scroll in chromebrowse 
	 * 
	 * there are 2 steps you need to use 
	 * javascript executor and give some coordinates
	 * then run some validations like asserts to see if the element you want to access is accessible
	 * 
	 */
		
	JavascriptExecutor jse = (JavascriptExecutor) driver;
	    jse.executeScript("windowscrollBy(0.480)", "");
	    
	 // Assert example 
	 Assert.assertTrue(driver.findElementByXPath("\\").getAttribute("Class").contains("Heather"));
		
	}
			
	
	
	@Test
	public void FramesTest() throws Exception { 
	 
		driver1.get("http//:www.google.com");
		
	/* click I am not a robot  by trying to use xpath.click it won't work as we are dealing with frames
	 * to get frame id we do need to switch to html and then we will be able to get frame id for the checkbox
	 * but frame ids randomly changes in real time
	 * we wrinte a method to handle frame and use it for the test
	 */
	
		int number =FindFramenumber(driver1,By.xpath("I am not a robot checkbox xpath") );
		driver1.switchTo().frame(number);
		driver1.findElement(By.xpath("I am not a robot xpath")).click();;	
	
	/* click verify -- now you are sitting on a frame of the first checkbox to get into the next frame  
	 * you need to exit the first frame and switch to the verify frame
	 * 
	 * get back to normal web page and get into next frame
	 */
	
		driver1.switchTo().defaultContent();  // not needed if you have a situation parent/child frames 
		
		int number1 =FindFramenumber(driver1,By.xpath("verify xpath") );
		driver1.switchTo().frame(number1);
		driver1.findElement(By.xpath("verify xpath")).click();
		
		
	// if you find a frame sitting another one Parent/child what you have to do is not to switch back do default content	
		
	
	}
	
	@Test
	public void AutoSuggestingDropdownTest() throws Exception {
		
		/* deal with autosuggest dropdown menu we nee to wait to get populated with sugestions 
		 * a solution is Explicit wait 
		 */
		driver1.findElement(By.xpath("xpath")).sendKeys("mar"); //start entering initial keys  
		WebDriverWait wd = new WebDriverWait(driver1,5); //  Explicit wait just wait until the condition is done and not the full specified time wait for the element for the given time if found carry on  
		wd.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("enter xpath for webelement")));
		
		driver1.findElement(By.xpath("xpath")).click();  // find xptah of the full entry you want to select 
	}
	
	
	@Test
	public void DynamicAlertTest() throws Exception {
		
		/* if there is any object on page that might or not might appear  (i.e bet365 pop up for 0 balance)
		 * the easiest way is with try catch mechanism 
		 */
		
		try {
			
			// code to handle the pop up if pop up is not there move to catch block
			
		}
		
		catch (Exception e) {
			
			System.out.println("balance is more than 0");
			
			// take screen shot usually used to see why is failing 
			
		}
		
		
		// after the try catch the script continue as normal 
		
	}

	
	@After 
	public void tearDown(){
		driver.quit();
	}

	
	
	

}
