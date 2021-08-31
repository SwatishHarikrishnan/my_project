package automateOfficeWork;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;

public class JiraTimseSheet extends BaseClass  {
	
	String jiraid="EX-22768";
	String TestDescription="Test Design and Test Execution for FRR 4622.";
	String Totalhoursworkedtoday="8";	
	
	@BeforeTest
	public void passfilename()
	{
		filename="JiraTimeSheet";
		url="https://jira.plintron.com:8443/secure/Dashboard.jspa";
	}
	
	@Test(dataProvider = "readexcelinput")
	public void filltimesheet(String username, String Password) throws InterruptedException, IOException
	{
	
	//1)Entering the input for the username
	driver.findElement(By.name("os_username")).sendKeys(username);
	
	//2)Entering the input for the password
	driver.findElement(By.name("os_password")).sendKeys(Password);
	
	//3)Clicking the login button
	driver.findElement(By.name("login")).click();
	
	//4)Clicking Tempo
	driver.findElement(By.linkText("Tempo")).click();
	
	//5)Clicking Timesheet
	driver.findElement(By.linkText("Timesheets")).click();
    
	//Below code is written to make sure i dont update attendance for second time
	String text = driver.findElement(By.xpath("//div[@class='progress-bar-summary']")).getText();
	String spaceremoved = text.replaceAll(" ", "");
	String[] Split = spaceremoved.split("/");
	int workedhours = Integer.parseInt(Split[0]);
	int totalhours = Integer.parseInt(Split[1]);
	if(workedhours<totalhours)
	{
		//6)Clicking login button
		WebElement waitforloginwork = driver.findElement(By.linkText("Log Work"));
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(waitforloginwork));
		driver.findElement(By.linkText("Log Work")).click();
		
		//7)Entering the value in the issue
		driver.findElement(By.xpath("(//input[@role='combobox'])[4]")).sendKeys(jiraid);
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@role='combobox'])[4]")).sendKeys(Keys.ENTER);
		
		//8)Passing input for worked hours
		driver.findElement(By.xpath("((//label[@tmp='Work per day'])[1]/following::input)[1]")).sendKeys(Totalhoursworkedtoday);
		
		//9)Passing input for Description
		driver.findElement(By.xpath("((//label[text()='Description'])[6]/following::textarea)[1]")).sendKeys(TestDescription);
		
		//10)Selecting the value for work type
		WebElement findElement = driver.findElement(By.id("0_WorkedItem_"));
		Select select = new Select(findElement);
		select.selectByValue("ST-TestcaseExecution");
		
		//11)Clicking login button
		driver.findElement(By.xpath("//button[@accesskey='s']")).click();
	}
	else
	{
		System.out.println("Attendance already updated");
	}
	
	    //12)Below code is written to make sure i updated attendance first time properly or working hours is equal or greater than total hours
		Thread.sleep(2500);
		String text1 = driver.findElement(By.xpath("//div[@class='progress-bar-summary']")).getText();
		String spaceremoved1 = text1.replaceAll(" ", "");
		String[] Split1 = spaceremoved1.split("/");
		int workedhours1 = Integer.parseInt(Split1[0]);
		int totalhours1 = Integer.parseInt(Split1[1]);
		if(workedhours1>=totalhours1)
		{
			System.out.println("The attendance is updated successfully for 8 hours");
		}
		else
		{
			System.out.println("Something wrong after updating 8 hours of attendance");
		}
	}

}
