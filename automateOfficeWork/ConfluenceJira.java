package automateOfficeWork;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;

public class ConfluenceJira extends BaseClass
{
	
	@BeforeTest
	public void passfilename()
	{
		filename="JiraTimeSheet";
		url="https://confluence.plintron.com:8443/display/EXIBS/EXIBS+Feature+References";
	}
	
	@Test(dataProvider = "readexcelinput")
	public void confluencetask(String username, String password) throws IOException, InterruptedException
	{
		//1)Entering the input for the username
		driver.findElement(By.name("os_username")).sendKeys(username);
		
		//2)Entering the input for the password
		driver.findElement(By.name("os_password")).sendKeys(password);
		
		//3)Clicking the login button
		driver.findElement(By.name("login")).click();
		
		//getting the list
		List<WebElement> nameofall = driver.findElements(By.xpath("//span[@class='plugin_pagetree_children_span plugin_pagetree_current']/following::li//a"));
		FileWriter writer = new FileWriter(new File("D:\\SWAT_DOCUMENTS\\SELF_LEARN\\imp\\DOCS\\satheesh\\Confluence.txt"));
		for(WebElement name : nameofall)
		{
			String text = name.getText();
			String attribute = name.getAttribute("href");
			String final1 = text + " : " +attribute;
			System.out.println(final1);
			writer.write(final1);
			writer.write("\r\n");
			String replaceAll = text.replaceAll(" ", "");
			if(replaceAll.equalsIgnoreCase("VeekCoin"))
			break;
		}
		writer.close();


	}

}
