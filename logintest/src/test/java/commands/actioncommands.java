package commands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import initbrowser.launchbrow;

public class actioncommands {
	
	WebDriver driver;
	
	public actioncommands()
	{
		driver = launchbrow.driver;
	}
	
	public void navitate(String url)
	{
			driver.get(url);
		}
		
	
	public void click(By locator)
	{
		
		driver.findElement(locator);
		
		
	}
	
	public void sendtxt(By locator, String txt)
	{
		
			driver.findElement(locator).sendKeys(txt);


		
	}
}
