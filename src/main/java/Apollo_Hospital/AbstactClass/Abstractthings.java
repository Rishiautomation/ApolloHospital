package Apollo_Hospital.AbstactClass;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Abstractthings {

	public WebDriver driver;
	public Abstractthings(WebDriver driver){
		
		this.driver=driver;
	}
	
	
	
	public void waitimplicit(int Time) {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Time));
	}
	
	public void scroll(String scrollvalue) {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(scrollvalue);
	}
	
	public void threadsleep(int sec) throws InterruptedException {
		
		Thread.sleep(sec);
	}
	
	public void ElementScreenshot(WebElement ElementtoTake,String Path) throws IOException {
		
		File file = ElementtoTake.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File(Path));
	}
	
	public void ActionsHover(WebElement Element) {
		
		Actions actions=new Actions(driver);
		actions.moveToElement(Element).build().perform();//hover on element.
	}
	
	public void ActionClick(WebElement Element) {
		
		Actions actions=new Actions(driver);
		actions.moveToElement(Element).click().build().perform();
	}
	
	public void elementtoClickable(By Findby) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(Findby));
		
	}
	
	public String verifypageTitle() {
		
		
		   String pageTitle=driver.getTitle();
		  return pageTitle;  
		
		
	}
}
