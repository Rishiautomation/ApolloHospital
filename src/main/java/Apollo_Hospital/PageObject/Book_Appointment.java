package Apollo_Hospital.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Apollo_Hospital.AbstactClass.Abstractthings;

public class Book_Appointment extends Abstractthings{

    public WebDriver driver;
	
	
	public Book_Appointment(WebDriver driver) {
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(css=".hero-catg-col:nth-child(1)")
	WebElement Bookappointment;
	
	
	
	public void doctorAppointment() throws InterruptedException {
		
		
		scroll("window.scrollBy(0,600)");
		threadsleep(100);
		Bookappointment.click();
		
		
		
		
	}
	
	public NewPageAppointment apoint() {
		
		return new NewPageAppointment(driver);
	}
	
	
	
}
