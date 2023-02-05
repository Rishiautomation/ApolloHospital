package Apollo_Hospital_BaseTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Apollo_Hospital.PageObject.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public LandingPage landingpage;
 public WebDriver driver;
	public WebDriver initiliazeBrowser() {
		
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options=new ChromeOptions();
		options.addArguments("disable-notifications");
		WebDriver driver=new ChromeDriver(options);
		
		return driver;
		
		
	}
	@BeforeMethod(alwaysRun=true)
	public LandingPage LaunchApplication() {
		driver=initiliazeBrowser();
		landingpage=new LandingPage(driver);
		landingpage.goTo();
		return landingpage;
		}
	
	@AfterMethod(alwaysRun=true)
	public void teardown()
	{
		driver.close();
	}
	
}
