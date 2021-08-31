package automateOfficeWork;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;
public class Attendancesheetfill extends BaseClass {
	
	@BeforeTest
	public void passfilename()
	{
		filename="Login";
		url="https://forms.office.com/Pages/ResponsePage.aspx?id=759XbQnD4kG5UKTHwvBDbiO9IMyxIvFOqNv-nfyU5KlUNFE5SzFKOTRUMlFXNjI0SU9SSlpOVjJWNi4u";
	}
	
	@Test(dataProvider = "readexcelinput")
	public void filltimesheet(String Email_Id, String Password, String Emp_Id) throws InterruptedException, IOException
	{
		//1)Entering the office mail ID and clicking Next to proceed to next page
		driver.navigate().refresh();
		Thread.sleep(2000);
		driver.findElement(By.name("loginfmt")).sendKeys(Email_Id);
		driver.findElement(By.xpath("//input[@value='Next']")).click();
		
		//2)Entering the password of office mail ID and clicking Next to proceed to next page
		Thread.sleep(2000);
		driver.findElement(By.name("passwd")).sendKeys(Password);
		WebElement waitforsignin = driver.findElement(By.xpath("//input[@value='Sign in']"));
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(waitforsignin));
		driver.findElement(By.xpath("//input[@value='Sign in']")).click();
		
		//3)Clicking yes to reduce number of times logging in
		driver.findElement(By.xpath("//input[@value='Yes']")).click();

		//4)Entering the employee code
		driver.findElement(By.xpath("//input[@placeholder='The value must be a number']")).sendKeys(Emp_Id);
		
		//5)Selecting the option whether working today or not
		driver.findElement(By.xpath("//div[@id='SelectId_0_placeholder']")).click();
		driver.findElement(By.xpath("//div[@aria-label='WFH']")).click();
		
		//6)Punching for back date or not
		//driver.findElement(By.xpath("(//label[@class='office-form-question-choice-row office-form-question-choice-text-row'])[2]")).click();
		
		//7)email responses needed or not
		driver.findElement(By.xpath("//span[@class='office-form-email-receipt-checkbox-description']")).click();
		
		//8)Finally clicking submit to proceed
		driver.findElement(By.xpath("//div[text()='Submit']")).click();
		
	}

}
