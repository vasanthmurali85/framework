package adminlogin;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;

import initbrowser.launchbrow;
import pageobjects.webelements;
import commands.actioncommands;

public class logintest extends launchbrow{
	
  @Test (priority = 10, groups = "smoke")
  public void f() throws IOException {	  
	  //This is the change made.
	  logger1 = report1.createTest("This is to verify login");
	  actioncommands acom1 = new actioncommands();
	  
	  logger1.info("navigating to url");
	  acom1.navitate("http://gcrit.com/build3/admin/");
	  acom1.sendtxt(webelements.txtusername, "admin");
	  acom1.sendtxt(webelements.txtpassword, "admins@123");
	  acom1.click(webelements.buttonlogin);	
	  logger1.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
	  logger1.addScreenCaptureFromPath("screenshot.png");
	  
  }
}
