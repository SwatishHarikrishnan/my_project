package automateOfficeWork;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.tools.ant.types.CommandlineJava.SysProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MapListCombo {

	public static void main(String[] args) {
	
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.get("https://erail.in/trains-between-stations/chennai-beach-jn-MSB/mumbai-central-BCT");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	driver.findElement(By.id("chkSelectFromOnly")).click();
	driver.findElement(By.id("chkSelectFromOnly")).click();

	List<WebElement> findElements = driver.findElements(By.xpath("//td[@class][2]"));
	List<WebElement> trainnumber = driver.findElements(By.xpath("//td[@class][1]"));
	
	List<String> listoftreainnames = new ArrayList<String>();
	List<String> listoftreainnumber = new ArrayList<String>();
	
	for(WebElement name : findElements)
	{
		String text = name.getText();
		listoftreainnames.add(text);
	}
	
	for(WebElement id : trainnumber)
	{
		String text = id.getText();
		listoftreainnumber.add(text);
	}
	
	Map<String, String> map = new HashMap<String, String>();
	//int size = listoftreainnames.size();
	//int size2 = listoftreainnumber.size();
	
	for(int i=0;i<listoftreainnames.size();i++)
	{
		map.put(listoftreainnames.get(i), listoftreainnumber.get(i));
	}
	System.out.println(map);
	
	
}
}