package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportsbasicdemo {
	
	public static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String projectpath = System.getProperty("user.dir"); //this gets current project working dir.
		ExtentHtmlReporter extent1 = new ExtentHtmlReporter(projectpath + "/reports/extent.html");
		ExtentReports report1 = new ExtentReports();
		report1.attachReporter(extent1);
		ExtentTest test1 = report1.createTest("google search test","this is a test to verify google");
		
				
		
		
		driver = new ChromeDriver();
		
		test1.log(Status.INFO, "Starting Test Case");
		driver.get("https://www.google.com");
		
		test1.pass("Successfullu navigted to google.com");
		
		driver.findElement(By.name("q")).sendKeys("selenium");
		test1.pass("entered text");
		
		driver.close();
		driver.quit();
		test1.pass("CLosed browser successfully");
		
		test1.info("Completed");
		
		report1.flush();
		
	}

}
