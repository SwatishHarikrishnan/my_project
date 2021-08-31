package automateOfficeWork;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.tools.ant.types.CommandlineJava.SysProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.browser.Browser.GetVersionResponse;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.inject.spi.DisableCircularProxiesOption;

import io.cucumber.messages.internal.com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File;
import io.github.bonigarcia.wdm.WebDriverManager;
public class App {	
public int retdisteleValue(int number)
{
	int []a= {3,2,1,5,6,4};
	Arrays.sort(a);
	List<Integer> list = new ArrayList<Integer>();
	if((number<=a.length)&&(number>0))	{
	for(int i=0;i<a.length;i++){
		list.add(a[i]);}
	return list.get(list.size()-number);}
	else
		return -1;
}
	
public static void main(String[] args) throws IOException
{
	App obj = new App();
	int retdisteleValue = obj.retdisteleValue(2);
	if(retdisteleValue==-1)
		System.out.println("The given input execeeds index value present in the array or given value is negative");
	else
	System.out.println("The distincet element present is : " +retdisteleValue);
}}