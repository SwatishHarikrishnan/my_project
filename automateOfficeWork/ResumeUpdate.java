package automateOfficeWork;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;
public class ResumeUpdate extends BaseClass {
		
	@BeforeTest
	public void passfilename()
	{
		filename="ResumeUpdate";
		url="https://www.naukri.com/";
	}
	
		@Test(dataProvider = "readexcelinput")
		public void resumeupdate(String Email_Id, String Password, String resumename, String resumeownername) throws InterruptedException, IOException
		{
		//1) click login option in home page
		WebDriverWait wait = new WebDriverWait(driver, 15);
		WebElement loginwait = driver.findElement(By.xpath("//div[text()='Login']"));
		wait.until(ExpectedConditions.elementToBeClickable(loginwait)).click();
		
		//2) Send username for naukri 
		driver.findElement(By.xpath("//input[@placeholder='Enter your active Email ID / Username']")).sendKeys(Email_Id);
		
		//3) Send password for naukri 
		driver.findElement(By.xpath("//input[@placeholder='Enter your password']")).sendKeys(Password);
		
		//4) Click Login button
		driver.findElement(By.xpath("//button[@class='btn-primary loginButton']")).click();
		
		//4.1)Handling random popup
		try {
			driver.findElement(By.xpath("//div[@class=\"crossIcon chatBot chatBot-ic-cross\"]")).click();
		} catch (Exception e) {
			System.out.println("The random notification is not appeared");
		}
		
		//5)Moving my cursor to my naukri 
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		WebElement naukrieditprofile = driver.findElement(By.xpath("//div[text()='My Naukri']"));
		action.moveToElement(naukrieditprofile).perform();
		
		//6)Click Edit profile
		 WebElement editprofile = driver.findElement(By.xpath("//a[text()='Edit Profile']"));
	     wait.until(ExpectedConditions.elementToBeClickable(editprofile)).click();
		
		// 7)Uploading my resume file
		WebElement uploadElement = driver.findElement(By.xpath("//input[@id='attachCV']"));
		uploadElement.sendKeys("D:\\SWAT_DOCUMENTS\\IMPORTANT\\RESUME\\"+resumeownername+".pdf");
		
		// 8)Verifying whether resume is uploaded successfully or not 
	     WebElement isDisplayed = driver.findElement(By.xpath("//p[text()='Resume has been successfully uploaded.']"));
	     wait.until(ExpectedConditions.visibilityOf(isDisplayed));
	     if(isDisplayed.getText().contains("Resume has been successfully uploaded"))
	     {
	    	 File source = driver.getScreenshotAs(OutputType.FILE);
	 		 File target = new File("D:\\SWAT_DOCUMENTS\\SELF_LEARN\\imp\\softwares\\eclipse_64bit\\Selenium\\src\\test\\resources\\"+resumename+".png");
	 		 FileUtils.copyFile(source, target);
	    	 System.out.println("Resume has been uploaded successfully");
//	    	 String name = driver.findElement(By.xpath("//span[@class='fullname']")).getText();
//	    	 if(name.contains("Satheesh"))
//	    	 {
//	    	 Set<String> windowHandles = driver.getWindowHandles();
//	    	 List<String> listofwin = new ArrayList<String>(windowHandles);
//	    	 String currenthandle=driver.getWindowHandle();
//	    	 for(String eachandeverywin : listofwin)
//	    	 {
//	    		 if(!currenthandle.equals(eachandeverywin))
//	    		 {
//	    		 driver.switchTo().window(eachandeverywin);
//	    		 driver.close();
//	    		 }
//	    	 }	    	 
//	     }
	     }
	     else
	     {
	    	 System.out.println("Resume is not uploaded , please check");
	     }
	}
}
