package com.second.testng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class testing2 {
	
	WebDriver driver1;
	
	@BeforeMethod (alwaysRun = true)
	public void bm() {
		driver1 = new ChromeDriver();
		driver1.get("http://www.magento.com");
		driver1.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver1.manage().window().maximize();
	}
	
	@AfterMethod (alwaysRun = true)
	public void am() {
		driver1.close();
		driver1.quit();
	}
	
	@DataProvider
	public Object[][] negativedata(){  //This is a double dimensional object array)
		return new Object[][] {
			{"vasanth.murali80@gmail.com", "welcome123"},
			{"vasanth.m1987@gmail.com", "welcome0987"},
			{"nghhh_2345@gmail.com" , "rojjk@12345$"},
			};
		
	}
	
	@DataProvider
	public Object[][] vasdata(){
		return new Object[][] {
			{"vassupr@gmail.com", "password1"},
			{"vasano12345@gmail.com", "welcome01"},
			{"wassuptgogo234@gmail.com" , "trialpwd123"}			
		};
	}
	
	
	
	@Test (priority = 20, expectedExceptions = NoSuchElementException.class, dataProvider = "vasdata", groups = {"Regression"})
	public void negativelogin(String email, String pwd) {
		
		//data provider means same test with different data
		
		driver1.findElement(By.xpath("//i[@class = 'fa fa-user']")).click();
		driver1.findElement(By.id("email")).sendKeys(email);
		driver1.findElement(By.id("pass")).sendKeys(pwd);
		driver1.findElement(By.xpath("//span[text() = 'Login']")).click();
		driver1.findElement(By.linkText("Log Out")).click();
		
		//String ermsg = driver1.findElement(By.xpath("//li[@class = 'error-msg']")).getText();
		//Assert.assertEquals("Invalid login or password.", ermsg);
	}
	
	@Test (priority = 10, expectedExceptions = NoSuchElementException.class, groups = {"smoke"})
	public void positivelogin() {
		
		driver1.findElement(By.xpath("//i[@class = 'fa fa-user']")).click();
		driver1.findElement(By.id("email")).sendKeys("jonnh_12345@gmail.com");
		driver1.findElement(By.id("pass")).sendKeys("vas12345");
		driver1.findElement(By.xpath("//span[text() = 'Login']")).click();
		driver1.findElement(By.linkText("Log Out")).click();
	}
	
	@Test(priority = 30, groups = "smoke", dependsOnGroups = "Regression")
	public void thirdtest() {
		driver1.get("http://www.google.com");
	}
	
	
	
	@Test(expectedExceptions = NoSuchElementException.class, dataProvider = "negativedata", groups = "Regression", dependsOnGroups = "smoke")
	public void loginagain(String passwd, String mails) {
		driver1.findElement(By.xpath("//i[@class = 'fa fa-user']")).click();
		driver1.findElement(By.id("email")).sendKeys(mails);
		
	}
	


}
