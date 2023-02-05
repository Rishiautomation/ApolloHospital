package Apollo_Hospital.WebTesting;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.io.FileUtils;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Apollo_StandAlone_Testcase {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();

		ChromeOptions option = new ChromeOptions();
		option.addArguments("disable-notifications");// it will disable the notifications popup.
		WebDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https://www.apollohospitals.com/");
		driver.getTitle();
		String name = "Hospitals In Bhubaneshwar";
		// @TestCase 1
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("menu-item-29960")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Actions actions=new Actions(driver);
		getHospital(driver, name, js);
		HospitalNameExtract(driver, js);
		Health(driver,actions,js);

	}

	public static void getHospital(WebDriver driver, String name, JavascriptExecutor js) throws InterruptedException {

		List<WebElement> Hospitals = driver.findElements(By.xpath("//ul[@id='menu-hospitals-lhs-menu-new']//li"));

		for (int i = 0; i < Hospitals.size(); i++) {

			String ReturnValue = Hospitals.get(i).getText();

			System.out.println(ReturnValue);

			if (ReturnValue.equalsIgnoreCase(name)) {

				// js.executeScript("window.scrollBy(0,6700)");
				System.out.println("valuefound");
				driver.findElements(By.xpath("//ul[@id='menu-hospitals-lhs-menu-new']//li")).get(i).click();
				js.executeScript("window.scrollBy(0,500)");
				break;

			}
		}

	}

	// testcase 2
	public static void HospitalNameExtract(WebDriver driver, JavascriptExecutor js)
			throws IOException, InterruptedException {

		WebElement details = driver.findElement(By.cssSelector(".hsptl-col-txt"));

		String Text = details.getText();

		System.out.println(Text);

		Thread.sleep(2000);

		File file = details.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("Screenshots/testcase.png"));

		js.executeScript("window.scrollBy(0,-900)");

		driver.navigate().back();

		driver.findElement(By.xpath("//a[@class='apollo-logo']")).click();
		

	}

	public static void Health(WebDriver driver,Actions actions,JavascriptExecutor js) throws InterruptedException, IOException {

		
		String healthname="CyberKnife";
		 WebElement health=driver.findElement(By.id("menu-item-27773"));
		 actions.moveToElement(health).build().perform();//hover on the health information.
		 
		   WebElement Procedure=driver.findElement(By.id("menu-item-27778"));
		   WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		   actions.moveToElement(Procedure).build().perform();
		WebElement HealthTechnology=driver.findElement(By.id("menu-item-27782"));
		   actions.moveToElement(HealthTechnology).click().build().perform();
		   js.executeScript("window.scrollBy(0,200)"); 
		  List <WebElement> Technology=driver.findElements(By.cssSelector(".topic-title a"));
		   
		   for(int i=0;i<Technology.size();i++) {
			   
			    String[]  Tech=Technology.get(i).getText().split("®");
			     String Actual= Tech[0];
			    System.out.println(Actual);
			   
			    
			    
			    if(Actual.equalsIgnoreCase(healthname)) {
			         wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".topic-title a")));
			           driver.findElements(By.cssSelector(".topic-title a")).get(i).click();
			           
			           js.executeScript("window.scrollBy(0,350)");
			           Thread.sleep(2000);
			           WebElement returntech=driver.findElement(By.cssSelector(".page-cntn-area"));
			           File screenshot = returntech.getScreenshotAs(OutputType.FILE);
			           FileUtils.copyFile(screenshot, new File("Screenshots/testcase1.png"));
			           break;
			    }
			    
			    
		   }
		   driver.close();
		   
	}

}
