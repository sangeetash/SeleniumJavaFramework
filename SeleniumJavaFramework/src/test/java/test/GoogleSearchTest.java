package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.GoogleSearchPage;
import pages.GoogleSearchPageObject;

public class GoogleSearchTest {

	private static WebDriver driver = null;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
//		googleSearch();
		googleSearchUsingPOM();
	}

	
	private static void googleSearch() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		//Open Google.com
		driver.get("http://google.com");
		
		//Enter text in search box
		GoogleSearchPage.textbox_search(driver).sendKeys("Automation step by step");
		
//		Thread.sleep(1000);
		//Click on search button
		GoogleSearchPage.button_search(driver).sendKeys(Keys.RETURN);//click();
		
		driver.close();
		
		
	}
	
	private static void googleSearchUsingPOM() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		//Open Google.com
		driver.get("http://google.com");
		
		//initialize GoogleSearchPageObject
		GoogleSearchPageObject googleSearchPageObject = new GoogleSearchPageObject(driver);
		//Enter text in search box
		googleSearchPageObject.setTextInSearchBox("ISTQB exams");
//		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(By.name("btnK")));
//		Thread.sleep(1000);
		//Click on search button
		googleSearchPageObject.clickOnSearchButton();
		
		driver.close();
	}
}
