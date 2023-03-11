package Apollo_Hospital.PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Apollo_Hospital.AbstactClass.Abstractthings;

public class MedicineandEssentials extends Abstractthings{

	
	public WebDriver driver;
	
	public MedicineandEssentials(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(xpath="//ul[@class='OurServices_serviceList__3Mr2P']/li[2]")
	 WebElement Medicines;
	
	
	@FindBy(css=".HotSeller_addToCart__kX_jE button")
   List	<WebElement> AddcartBtn;
	
	
	@FindBy(css=".icon-ic_cart")
	WebElement CartBtn;
	
	@FindBy(css=".MedicineProductCard_cartTopRow__kUIC5 h2")
	WebElement productname;
	
	@FindBy(css=".Header_logoWrapper__m0fhl h1 a")
	WebElement Logo;
	
	@FindBy(css=".Header_cartContainer__1ggeD span")
	WebElement maincart;
	
	public void medicine() throws InterruptedException {
		elementtoClickable(By.xpath("//ul[@class='OurServices_serviceList__3Mr2P']/li[2]"));
		Medicines.click();
		scroll("window.scrollBy(0,600)");
		threadsleep(2000);
		AddcartBtn.get(0).click();
		CartBtn.click();
		elementtoClickable(By.cssSelector(".MedicineProductCard_cartTopRow__kUIC5 h2"));
		String Text=productname.getText();
        System.out.println(Text);
        Logo.click();
        driver.navigate().back();
        driver.navigate().back();
	  maincart.click();
        
        
        
	}
	
}
