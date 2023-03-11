package Apollo_Hospital.PageObject;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Apollo_Hospital.AbstactClass.Abstractthings;

public class NewPageAppointment extends Abstractthings{

	
	public WebDriver driver;
	
	public NewPageAppointment(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	
	@FindBy(css=".OurServices_serviceList__3Mr2P li div a")
	List<WebElement> BookAppointbtn;
	
	@FindBy(css=".jss196 li a")
	List<WebElement> Cities;
	
	@FindBy(css=".jss189")
	WebElement Backbtn;
	
	
	
	public void NewPageNavigation() {
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String ParentId = it.next();
		String ChildId =it.next();
		driver.switchTo().window(ChildId);
		BookAppointbtn.get(0).click();
		VisiblityofAllElement(Cities);
		
	}
	
	public void Findcities(String givenname) {
		
		
		for(int i=0;i<Cities.size();i++) {
			
			String textcity=Cities.get(i).getText();
			System.out.println(textcity);
			if(textcity.equalsIgnoreCase(givenname)) {
				
				System.out.println("NameFound");
				Cities.get(i).click();
				break;
			}
			
		}
		
	}
	
	
   public MedicineandEssentials doctorlist() {
	   
	   WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	   wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".MuiGrid-grid-lg-6")));
	   List<WebElement> doctorname=driver.findElements(By.cssSelector(".MuiGrid-grid-lg-6"));
	   System.out.println(doctorname.size());
	   try {
		   
		   
		   for(int i=0;i<=10;i++) {
			   
			   System.out.println(doctorname.get(i).getText());
		   }
		   
	   }
	   catch(Exception e) {
		   
		   e.printStackTrace();
	   }
	   
	  
	   Backbtn.click();
	   Backbtn.click();
	   
	   //abb aage next class mein
	   return new MedicineandEssentials(driver);
	   
   }
   
   
   
}
