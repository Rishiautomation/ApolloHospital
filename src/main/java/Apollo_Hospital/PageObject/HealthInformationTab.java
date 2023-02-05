package Apollo_Hospital.PageObject;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Apollo_Hospital.AbstactClass.Abstractthings;

public class HealthInformationTab extends Abstractthings{
     
	public WebDriver driver;
	
	public HealthInformationTab(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
		}
	
	@FindBy(id="menu-item-27773")
	WebElement health;
	
	@FindBy(id="menu-item-27778")
	WebElement Procedure;
	
	
	@FindBy(id="menu-item-27782")
	WebElement HealthTechnology;
	
	@FindBy(css=".topic-title a")
	List<WebElement> Technology;
	
	@FindBy(css=".page-cntn-area")
	 WebElement returntech;
	
	
	
	
	public void Health() {
		ActionsHover(health);//hover on health information
		waitimplicit(10);
		ActionsHover(Procedure);
		ActionClick(HealthTechnology);
		scroll("window.scrollBy(0,200)");
	}
	
	public void FindTechnology(String TechnologyName ) throws InterruptedException, IOException {
		
		 for(int i=0;i<Technology.size();i++) {
			   
			    String[]  Tech=Technology.get(i).getText().split("®");
			     String Actual= Tech[0];
			    System.out.println(Actual);
			   
			    
			    
			    if(Actual.equalsIgnoreCase(TechnologyName)) {
			            elementtoClickable(By.cssSelector(".topic-title a"));
			           driver.findElements(By.cssSelector(".topic-title a")).get(i).click();
			           
			           scroll("window.scrollBy(0,350)");
			           threadsleep(2000);
			           
			           ElementScreenshot(returntech,"Screenshots/testcase1.png");
			           break;
			    }
		
	}
	
	}	
}
