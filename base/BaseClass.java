package base;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ReadExcelDynamicInput;

public class BaseClass {

	public String filename,url;
	public ChromeDriver driver;
	
	@DataProvider
	public String[][] readexcelinput() throws IOException
	{
		return ReadExcelDynamicInput.Excelinput(filename);
	}
	
	@BeforeMethod
	public void precondition()
	{
	WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
	driver.get(url);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void postcondition()
	{
		driver.quit();
	}

}
