package yahoo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.Listeners;

import atu.testng.reports.ATUReports;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;

@Listeners({ATUReportsListener.class,ConfigurationListener.class,MethodListener.class})
public class Home 
{
    WebDriver driver;
    
    {
    	System.setProperty("atu.reporter.config", "d:\\may_wk\\atu.properties");
    }
    public Home(WebDriver d)
    {
    	driver=d;
    }
	public void open()
	{
		driver.manage().window().maximize();
		driver.get("http://www.yahoomail.com");
	}
	public void login() throws Exception
	{
		open();
		Thread.sleep(5000);
		driver.findElement(By.name("username")).sendKeys("venkat123456a");
		driver.findElement(By.name("signin")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("passwd")).sendKeys("mqq987654");
		driver.findElement(By.name("signin")).click();
		Thread.sleep(5000);
	}
	public void validate_links() throws Exception
	{
		open();
		Thread.sleep(5000);
		String exp[]={"About Mail","Features","Get the App","Help"};
		
		WebElement ul=driver.findElement(By.xpath("//ul[@class='Fl(end) Mend(10px) Lts(-0.31em) Tren(os) Whs(nw) My(6px)']"));
		List<WebElement> lst=ul.findElements(By.xpath("li/a/b"));
		
		Reporter.log("Test Name :      Home");
		for(int i=0;i<exp.length;i++)
		{
			if(exp[i].matches(lst.get(i).getText()))
			 ATUReports.add("Link is matching "+exp[i],LogAs.PASSED,new CaptureScreen(ScreenshotOf.DESKTOP));	
			else
				 ATUReports.add("Link NOT matching "+exp[i],LogAs.FAILED,new CaptureScreen(ScreenshotOf.DESKTOP));			    	
		}
		
	}
	public void createacc() throws Exception
	{
		open();
		new Actions(driver).moveToElement(driver.findElement(By.id("login-signup"))).click().perform();
		Thread.sleep(5000);
		try
		{
			if(driver.findElement(By.name("firstName")).isDisplayed())
			{
				Reporter.log("<font color='green'><b>Reg page is displayed</b></font>");
				//enter firstname, lastname....etc
			}
		}
		catch(Exception e)
		{
			Reporter.log("<font color='red'><b>reg page not dispalyed</b></font>");
		}
	}
}
