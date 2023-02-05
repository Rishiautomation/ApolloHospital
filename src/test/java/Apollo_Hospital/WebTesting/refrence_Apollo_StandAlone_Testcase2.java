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
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Apollo_Hospital.PageObject.*;
import Apollo_Hospital_BaseTest.BaseTest;

import org.apache.commons.io.FileUtils;
import io.github.bonigarcia.wdm.WebDriverManager;

public class refrence_Apollo_StandAlone_Testcase2 extends BaseTest{

    
	
	@Test(dataProvider="getdata")
	public void goToPage(String Hospitalname,String TechnologyName) throws InterruptedException, IOException {
		
	      getHospital hospital=landingpage.doactions();
	       hospital.findhospital();
	       List<WebElement> Names = hospital.DisplayHospitalname();
	       HospitalDetails hospitaldetails=hospital.FindgivenHospitalName(Hospitalname);
	       hospitaldetails.getdetails();
	       HealthInformationTab healthinformation = hospitaldetails.goToHomePage();
	       healthinformation.Health();
	       healthinformation.FindTechnology(TechnologyName);
	       
	}
	
	@Test(dependsOnMethods= {"goToPage"})
	public void Verifications() {
		
	getHospital	hospital=landingpage.doactions();		
		       String verifying = hospital.verifypageTitle();
		   Assert.assertTrue(verifying.equalsIgnoreCase("Multispeciality Hospitals in India | Apollo Hospitals for all Your Healthcare Needs - Apollo Hospitals"));
		
	}
	
	@DataProvider(name="getdata")
	public Object[][] Data() {
		
		return new Object[][] {{"Hospitals In Bhubaneshwar","CyberKnife"}};
	}
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	