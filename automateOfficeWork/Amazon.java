package automateOfficeWork;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;

public class Amazon extends BaseClass {
	
	@BeforeTest
	public void passfilename()
	{
		filename="AmazonLogin";
		url="https://www.amazon.in/ap/signin?_encoding=UTF8&openid.assoc_handle=inflex&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Faction%3Dsign-out%26ie%3DUTF8%26path%3D%252Fgp%252Fhomepage.html%253F_encoding%253DUTF8%26ref_%3Dnav_em_signout_0_1_1_32%26ref_%3Dnavm_em_signin%26ref_%3Dnavm_em_signin%26signIn%3D1%26useRedirectOnSuccess%3D1";
	}
	
	@Test(dataProvider = "readexcelinput")
	public void amazonorder(String username, String Password) throws InterruptedException, IOException
	{
		//1)Sending username for my amazon login
		driver.findElement(By.id("ap_email")).sendKeys(username);
		driver.findElement(By.id("continue")).click();
		
		//2)Sending password for my amazon login
		driver.findElement(By.id("ap_password")).sendKeys("ap_password");
		driver.findElement(By.id("signInSubmit")).click();
		
		
	}
	}
