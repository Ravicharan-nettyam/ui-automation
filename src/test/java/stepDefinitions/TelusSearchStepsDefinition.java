package stepDefinitions;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.support.PageFactory;

import com.common.BrowserDriver;
import com.common.CommonMethods;
import com.common.TelusDataProperties;
import com.pageFactory.Home;
import org.openqa.selenium.TakesScreenshot;

/*
 * Step definitions class which is used to implement the steps defined in feature file
 */

public class TelusSearchStepsDefinition {

	public static WebDriver driver;
	public static BrowserDriver browserDriver = new BrowserDriver();
	public static String searchText;

	public static TelusDataProperties telusDataProperties = new TelusDataProperties();;

	static Home homePage = PageFactory.initElements(driver, Home.class);

	CommonMethods commonMethods;

	@Before()
	public void launchBrowser() {

		System.out.println("**Initializing the properties required for Test Suite Execution***");
		try {

			driver = browserDriver.getDriver(telusDataProperties);
			commonMethods = new CommonMethods(driver, telusDataProperties);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Given("^Launch the Telus.com application$")
	public void telusHomePage() {
		driver.get(telusDataProperties.getHomeUrl());

	}

	@When("^Click the Search bar$")
	public void searchButton() {
		try {
			driver.findElement(By.xpath("//div[@id='cookiesNotice-desktop']//a[text()='I acknowledge']")).click();
			Thread.sleep(3000);
			driver.findElement(By.cssSelector("#skip-button")).click();
			Thread.sleep(3000);

		} catch (Exception e) {
			e.getLocalizedMessage();
		}
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.cssSelector("button#search-button > svg"))).click().build()
				.perform();
		// action.moveToElement(homePage.getSearchButton()).click().build().perform();

	}

	@When("^Enter \"([^\"]*)\" in search field$")
	public void enterSearchField(String search) {
		driver.findElement(By.xpath("//input[@placeholder='Search TELUS.com']")).sendKeys("Internet");
		// homePage.getSearchTextField().sendKeys(search);;
	}

	@When("^Select 3rd option from drop-down list$")
	public void selectOption() {

		try {

			WebElement element = driver
					.findElement(By.xpath("(//li[@data-test='searchResultItem']//a[contains(text(),'Internet')])[2]"));

			// WebElement element = homePage.getSelectedOption();

			searchText = commonMethods.getJavaScriptExecutorText(element);

			element = commonMethods.getJavaScriptExecutor(element);
			element.click();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Then("^Comparison of text in search field with heading of results Page$")
	public void getSelectedList() {

		String searchResult = driver.findElement(By.xpath("//div[@role='heading']/div")).getText();

		if (!searchResult.contains(searchText)) {
			Assert.assertFalse(true);

		}

	}

	@Then("^Check minimum six hyperlinks are present in search page$")
	public void getAllHyperlinks() {

		List<WebElement> listOfPages = driver
				.findElements(By.xpath("//a[contains(@href,'https://www.telus.com/en/support/article/')]"));
		if (listOfPages.size() < 6) {
			Assert.assertFalse(true);
		}

	

	}
	
	
	
	@Then("^Click the relevant Hyperlink Page to explore further$")
	public void getSelectedHyperlinkPage() {



		driver.findElement(By.xpath("//a//h2[text()='Internet speed test']")).click();

	}

	@After()
	public void afterSuite(io.cucumber.java.Scenario scenario) throws IOException {
		// testCase_Id=testData.getTestCase_Id();
		if (!(scenario.isFailed())) {

			System.out.println("\n#########testcase was passed successfully#########\n");

		} else {
			System.out.println("\n#########testcase was failed#########\n");
			File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotFile, new File("Screenshots\\-" + commonMethods.GetTimeStampValue() + ".png"));
		}
		driver.quit();
	}

}
