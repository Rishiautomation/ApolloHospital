package Apollo_Hospital.AbstactClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ExtentReport {

	public static ExtentReports getReportObject() {
		String path = System.getProperty("user.dir")+"\\reports\\"+"index.html";// this is used to create HTML report 
		ExtentSparkReporter reporter= new ExtentSparkReporter(path);
		reporter.config().setReportName("Hospital Testing Report");
		reporter.config().setDocumentTitle("Test Results");
		
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Rishikesh Singh");
		return extent;
		
	}
	
}
