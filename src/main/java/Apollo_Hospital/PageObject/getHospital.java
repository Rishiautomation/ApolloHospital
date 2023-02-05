package Apollo_Hospital.PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Apollo_Hospital.AbstactClass.Abstractthings;

public class getHospital extends Abstractthings {

	 public WebDriver driver;
	
	public getHospital(WebDriver driver){
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="menu-item-29960")
	WebElement Hospital;
	
	@FindBy(xpath="//ul[@id='menu-hospitals-lhs-menu-new']//li")
	List <WebElement> HospitalName;
	
	
	
	
	public void findhospital() {
		
		Hospital.click();
		
	}
	
	public List<WebElement> DisplayHospitalname() {
		
		return HospitalName;
	}
		
	public HospitalDetails FindgivenHospitalName(String name) {
		
		for (int i = 0; i < HospitalName.size(); i++) {

			String ReturnValue = HospitalName.get(i).getText();

			System.out.println(ReturnValue);

			if (ReturnValue.equalsIgnoreCase(name)) {

				// js.executeScript("window.scrollBy(0,6700)");
				System.out.println("valuefound");
				driver.findElements(By.xpath("//ul[@id='menu-hospitals-lhs-menu-new']//li")).get(i).click();
				scroll("window.scrollBy(0,500)");
				break;

			}
			
		}
		
		return new HospitalDetails(driver);
		
	}
	
	
	
	
		
		
	
	
}
