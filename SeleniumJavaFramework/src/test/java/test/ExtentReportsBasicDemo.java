package test;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.GoogleSearchPage;

public class ExtentReportsBasicDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		// start reporters
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent_basic.html");

		// create ExtentReports and attach reporter(s)
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		// creates a toggle for the given test, adds all log events under it
		ExtentTest test1 = extent.createTest("GoogleSearchTest one",
				"This is to validate google search functionality.");

		test1.log(Status.INFO, "Starting test execution");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		// log(Status, details)
		test1.log(Status.INFO, "Navigating to the google website)");

		// Open Google.com
		driver.get("http://google.com");

		test1.pass("Navigationg successful.");
		// Enter text in search box
		GoogleSearchPage.textbox_search(driver).sendKeys("Automation step by step");
		test1.pass("Search text entered successfully.");
		Thread.sleep(1000);
		// Click on search button
		GoogleSearchPage.button_search(driver).sendKeys(Keys.RETURN);// click();
		test1.pass("Search button click done.");

		driver.close();
		test1.log(Status.INFO, "Test cmpleted successully.");
		extent.flush();

	}

}
