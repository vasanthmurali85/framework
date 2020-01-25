package initbrowser;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

public class launchbrow {
  
	public static WebDriver driver;
	public ExtentReports report1;
	public ExtentTest logger1;
	
	@BeforeSuite
	public void bf()
	{
		ExtentHtmlReporter extent1 = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/reports/reporting.html"));
		extent1.config().setDocumentTitle("Automation report");//This sets the document title
		extent1.config().setReportName("Functional report");//This is report title
		extent1.config().setTheme(Theme.DARK); //This is theme.
		
		
		report1 = new ExtentReports();
		report1.attachReporter(extent1);
		
		report1.setSystemInfo("Hostname", "localhost");
		report1.setSystemInfo("OS", "Windows");
		report1.setSystemInfo("Testername", "Brother Mark");
	}
	


	
  @BeforeClass
  public void beforeClass() {
	  
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @AfterClass
  public void afterClass() {
	  driver.close();
	  driver.quit();
	  
  }
  
  @AfterMethod
  public void af1(ITestResult result) throws IOException
  {
	  if (result.getStatus() == ITestResult.FAILURE)
	  {
		  
	  }
	  report1.flush();
  }

}
