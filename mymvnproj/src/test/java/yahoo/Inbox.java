package yahoo;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;

import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;

@Listeners({ATUReportsListener.class,ConfigurationListener.class,MethodListener.class})
public class Inbox 
{
  WebDriver driver;
  {
  	System.setProperty("atu.reporter.config", "d:\\may_wk\\atu.properties");
  }
   
  public Inbox(WebDriver d)
  {
	  driver=d;
  }
  public void deletemail()
  {
	  List<WebElement> lst=driver.findElements(By.xpath("//input[@name='mid']"));
	  lst.get(8).click();
	  driver.findElement(By.id("top_delete")).click();
  }
}