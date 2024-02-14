package com.common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

/*
 *   This class is used to create web driver objects. It creates Chrome or firefox 
 *   drivers based on the input given to it.
 */

public class BrowserDriver {

	public static WebDriver driver = null;

	public WebDriver getDriver(TelusDataProperties telusDataProperties) {

		String browser = telusDataProperties.getBrowser();

		try {

			/*WebDriverManager is used here which avoids the usage of ChromeDriver.exe
			 * and FirefoxDriver.exe and the version compatability 
			 * issues can be avoided
			 * 
			 */
			
			if (browser.contains("Chrome")) {
				ChromeOptions chromeOptions = new ChromeOptions();
				WebDriverManager.chromedriver().setup();
			//	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\driver\\chromedriver.exe");
				//driver = new ChromeDriver();
				driver = new ChromeDriver(chromeOptions);

			} else {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			return driver;

		} catch (Exception e) {
			e.printStackTrace();
			return driver;
		}
	}
}
