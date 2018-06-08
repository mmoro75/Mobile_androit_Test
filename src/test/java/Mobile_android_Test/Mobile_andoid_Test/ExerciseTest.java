package Mobile_android_Test.Mobile_andoid_Test;



import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.TouchAction;
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
	public void NoAccountTest() throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By
				.id("identifierNext")));    // wait until an element is displayed on the page 
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_BACK);		
		driver.findElementById("com.raaga.android:id/skip_login_btn").click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(resource-id(\"com.raaga.android:id/music_home_raaga_live\"));");
		driver.findElementById("com.raaga.android:id/music_home_raaga_live").click();
	}
			
	
	
	@Test 
	public void ToggleTest() throws Exception {


		driver.findElementByXPath("xpath for options").click();	
		driver.findElementByXPath("xpath for settings").click();
		driver.findElementByXPath("xpath for notifications").click();

		Point point = driver.findElementById("elementid").getLocation(); // in this situation we point to position 0.0 for the web element 

		// Point.x gives the horizontal coordinate 
		// Point.y gives the vertical coordinates 

		TouchAction t= new TouchAction(driver);

		t.tap(point.x+20,point.y+30).perform();  // you give some initial coordinate to see whether ths cursor is pointed and toggled on	

		t.tap(point.x+100,point.y+30).perform();  // to toggle off once again give some coordinates (notice y doesn't change as the change happens horizontally vertically remains the same)

	}

	
	public void EnterAccountTest() throws Exception {

	}

	public void CreateAccountTest() throws Exception {

	}
	
	
	
	
	public void SelectSongTest() throws Exception {
		
		
		// Scroll down to Trading now menu and tap

		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(resource-id(\"trading now UI Automator\"));");

		TouchAction t = new TouchAction(driver);
		AndroidElement abc = driver.findElementById("trading song list id");
		t.tap(abc).perform();

		// print list of songs all having same class

		List <AndroidElement> xyz = driver.findElementsByClassName("songs class name");

		// the loop goes into the list and print the text corresponding to the
		// index ( song might be in a different position each time)

		for (int i = 0; i < xyz.size(); i++) {

			if (xyz.get(i).getText().contains("son name we want")) {

				// when the condition matches in the if loop perform a click

				t.longPress(xyz.get(i)).perform();
				Thread.sleep(5000); // to let the pop up open

				// once pop up opens click play all option

				driver.findElementByAndroidUIAutomator("uiautomator for play all ").click();

				System.out.println("song Successfully played");

			}

		}

	}

	@After 
	public void tearDown(){
		driver.quit();
	}

	
	
	
	

}
