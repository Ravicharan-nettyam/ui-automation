package com.common;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
 * All the common methods required for the Web driver can be written here.
 */

public class CommonMethods {
	
	public static String output = "";
	static WebDriver driver;
	public String exception = "";
	TelusDataProperties telusDataProperties=null;

	public CommonMethods(WebDriver driver, TelusDataProperties telusDataProperties) {
		this.driver = driver;
		this.telusDataProperties=telusDataProperties;
	}
	
	public  String GetTimeStampValue()throws IOException{
	    Calendar cal = Calendar.getInstance();       
	    Date time=cal.getTime();
	    String timestamp=time.toString();
	    String systime=timestamp.replace(":", "-");
	    return systime;
	}

	public  WebElement getJavaScriptExecutor(WebElement element)throws IOException{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement webElement =(WebElement) js.executeScript("return arguments[0]", element);
		
	    return webElement;
	}
	
	
	public  String getJavaScriptExecutorText(WebElement element)throws IOException{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String search =(String) js.executeScript("return arguments[0].innerHTML", element);
		
	    return search;
	}
	
	
}
