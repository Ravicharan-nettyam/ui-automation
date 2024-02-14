/**
 * 
 */
package com.common;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.util.Properties;

/*
 * This class is used to initialize the property values which are required for the application
 */

public class TelusDataProperties {
	
	private String browser;
	private String homeUrl;
	
	
	public TelusDataProperties() {
		getPropertyData();
	}
	
	
	public void getPropertyData() {
		
		Properties properties = new Properties();

		
		try {
			
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir") 
					+ "/src/test/java/telusInformation.properties");
			properties.load(fis);
			
			try {
				//**For setting properties from other system - Jenkins

				browser = properties.getProperty("browser");
	
				homeUrl= properties.getProperty("homeUrl");
				
			
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

	
	public String getBrowser() {
		return browser;
	}
	
	public String getHomeUrl() {
		return homeUrl;
	}

}