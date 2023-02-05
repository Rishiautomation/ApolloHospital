package Apollo_Hospital.PageObject;

import org.openqa.selenium.WebDriver;

import Apollo_Hospital.AbstactClass.Abstractthings;

public class LandingPage extends Abstractthings{
	
	public WebDriver driver;
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		
	}
	
	public void goTo() {
		driver.manage().window().maximize();
		driver.get("https://www.apollohospitals.com/");
		
	}
	
	public getHospital doactions() {
		
		System.out.println(driver.getTitle());
		getHospital hospital=new getHospital(driver);
		return hospital;
	}
	
	
	
}