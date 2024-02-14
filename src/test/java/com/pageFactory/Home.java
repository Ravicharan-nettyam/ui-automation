package com.pageFactory;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/*
 * Page Factory class for Telus Home Page
 */

public class Home {
	
	public Home(WebDriver driver) {
		 PageFactory.initElements(driver, this);
		 }
		
		//Telus home page search button
		@FindBy(css ="button#search-button > svg")
		private WebElement searchButton;
		public WebElement getSearchButton() {
			return searchButton;
		}
		
		//Search text field
		@FindBy(xpath ="//input[@placeholder='Search TELUS.com']")
		private WebElement searchTextField;
		public WebElement getSearchTextField() {
			return searchTextField;
		}
		
		//select 3rd option
		@FindBy(xpath ="//li[@data-test='searchResultItem']//a[contains(text(),'Internet')])[2]")
		private WebElement selectField;
		public WebElement getSelectedOption() {
			return selectField;
		}
		
		@FindBy(xpath ="//div[@role='heading']/div")
		private WebElement verifyField;
		public WebElement verifySearchField() {
			return verifyField;
		}

		
		
//		@FindBy(xpath ="//a[contains(@href,'https://www.telus.com/en/support/article/')]")
//		private ArrayList<WebElement> searchList;
//		public ArrayList<WebElement> getSearchList() {
//			return searchList;
//		}

}
