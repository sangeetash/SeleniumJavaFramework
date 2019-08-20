package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.GoogleSearchPage;
import pages.GoogleSearchPageObject;

public class GoogleSearchTestByTestNG2 {

	private static WebDriver driver = null;

	@BeforeTest
	public void setUpTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@Test
	public void googleSearchTest3() throws InterruptedException {

		// Open Google.com
		driver.get("http://google.com");

		// initialize GoogleSearchPageObject
		GoogleSearchPageObject googleSearchPageObject = new GoogleSearchPageObject(driver);
		// Enter text in search box
		googleSearchPageObject.setTextInSearchBox("ISTQB exams");

		Thread.sleep(1000);
		// Click on search button
		googleSearchPageObject.clickOnSearchButton();

	}
	@Test
	public void googleSearchTest2() throws InterruptedException {

		// Open Google.com
		driver.get("http://google.com");

		// initialize GoogleSearchPageObject
		GoogleSearchPageObject googleSearchPageObject = new GoogleSearchPageObject(driver);
		// Enter text in search box
		googleSearchPageObject.setTextInSearchBox("abcd");

		Thread.sleep(1000);
		// Click on search button
		googleSearchPageObject.clickOnSearchButton();

	}

	@AfterTest
	public void tearDownTest() {
		driver.close();
		System.out.println("*************Test completed successfully.************");

	}
}
