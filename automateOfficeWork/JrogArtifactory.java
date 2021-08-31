package automateOfficeWork;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JrogArtifactory {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://192.168.111.85:8081/artifactory/webapp/#/home");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		ChromeOptions options= new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		driver.findElement(By.linkText("Log In")).click();
		driver.findElement(By.name("user")).sendKeys("swat3656");
		driver.findElement(By.name("password")).sendKeys("Saec@@12345");
		driver.findElement(By.id("login")).click();
		WebDriverWait wait = new WebDriverWait(driver, 40);
		
		//wait.until(ExpectedConditions.visibilityOf(artifactelement));
		Thread.sleep(15000);
		Actions action = new Actions(driver);
		WebElement artifactelement = driver.findElement(By.xpath("//i[@class='icon icon-artifacts-new']"));
		action.click(artifactelement).perform();
		
		//WebElement WAITFOREXIBS = driver.findElement(By.xpath("//span[text()='EXIBS']"));
		//WebDriverWait wait = new WebDriverWait(driver, 40);
		//wait.until(ExpectedConditions.visibilityOf(WAITFOREXIBS));
		driver.findElement(By.xpath("//a[@class='tree-browser-tab active']")).click();
		Thread.sleep(40000);
		driver.findElement(By.xpath("//a[@class='tree-browser-tab']")).click();
		WebElement EXIBSTOFIND = driver.findElement(By.xpath("//input[@type='search']"));
		EXIBSTOFIND.sendKeys("EXIBS");
		Thread.sleep(3000);
		EXIBSTOFIND.sendKeys(Keys.ENTER);
		
		for(int i=0;i<=1000;i++)
		{
		List<WebElement> findElements = driver.findElements(By.xpath("//span[contains(text(),'V_')]"));
		List<String> storingallinlist = new ArrayList<String>();
		for(WebElement names : findElements)
		{
			String text = names.getText();
			System.out.println(text);
			storingallinlist.add(text);
			if(text.equals("V_V_5.1.1.0_R0-15-12-20_11_47AM"))
			{
				System.out.println("We completed scrolling from first to end");
				break;
			}
			//WebElement scrollpath = driver.findElement(By.xpath("//div[@style='transform: translate(0px, 0px); right: 0px; height: 393.333px;']"));
			//WebElement scrollpath = driver.findElement(By.xpath("(//div[@class='scroll-faker'])[1]"));
//			action.moveToElement(scrollpath).click().perform();
//			for(int j=1;j<10;i++)
//			{
//			action.sendKeys(Keys.DOWN);
//			}
			//JavascriptExecutor js = (JavascriptExecutor) driver;
			//js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		}
	}

}
}