package Apollo_Hospital.PageObject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Apollo_Hospital.AbstactClass.Abstractthings;


public class HospitalDetails extends Abstractthings{

	public WebDriver driver;
	public HospitalDetails(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css=".hsptl-col-txt")
	
	WebElement details;
	
	@FindBy(xpath="//a[@class='apollo-logo']")
	WebElement logo;
	
	public void getdetails() throws InterruptedException, IOException {
		
		String Text=details.getText();
		System.out.println(Text); 
		threadsleep(2000);
		ElementScreenshot(details,"Screenshots/testcase.png");
		scroll("window.scrollBy(0,-900)");
		driver.navigate().back();
		
		
	}
	
	
	public HealthInformationTab goToHomePage() {
		
		logo.click();
		return new HealthInformationTab(driver);
	}
	
	
}
