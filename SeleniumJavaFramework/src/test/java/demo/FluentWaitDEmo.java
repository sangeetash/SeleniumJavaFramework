package demo;

import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.formula.functions.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.GoogleSearchPageObject;

public class FluentWaitDEmo {
	public static void main(String[] args) {
		try {
			googleSearch();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void googleSearch() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		//Open Google.com
		driver.get("http://google.com");
		
		//initialize GoogleSearchPageObject
		GoogleSearchPageObject googleSearchPageObject = new GoogleSearchPageObject(driver);
		//Enter text in search box
		googleSearchPageObject.setTextInSearchBox("abcd");

		
		WebDriverWait wait1 = new WebDriverWait(driver, 5);
		wait1.until(ExpectedConditions.elementToBeClickable(By.name("btnK")));

		//Click on search button
		googleSearchPageObject.clickOnSearchButton();
		
//		driver.findElement(By.linkText("ABCD - NIMH Data Archive - NIH"));
		
		// Waiting 30 seconds for an element to be present on the page, checking
		// for its presence once every 5 seconds.
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
		    .withTimeout(30, TimeUnit.SECONDS)
		    .pollingEvery(5, TimeUnit.SECONDS)
		    .ignoring(NoSuchElementException.class);

		WebElement foo = wait.until(new Function<WebDriver, WebElement>() 
		{
		  public WebElement apply(WebDriver driver) {
		  return driver.findElement(By.l);
		}
		});
		
		driver.close();
	}
}
