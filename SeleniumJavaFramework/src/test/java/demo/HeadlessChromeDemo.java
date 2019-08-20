package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.GoogleSearchPage;

public class HeadlessChromeDemo {
	
	public static void main(String []arg) {
		test();
	}

	public static void test() {
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		WebDriver driver = new ChromeDriver(options);

		// Open Google.com
		driver.get("http://google.com");
		
		System.out.println("Page title "+driver.getTitle());

		// Enter text in search box
		GoogleSearchPage.textbox_search(driver).sendKeys("Automation step by step");
		WebDriverWait wait1 = new WebDriverWait(driver, 5);
		wait1.until(ExpectedConditions.elementToBeClickable(By.name("btnK")));

		// Thread.sleep(1000);
		// Click on search button
		GoogleSearchPage.button_search(driver).sendKeys(Keys.RETURN);// click();

		driver.close();
	}

}
