package test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearchTest_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			googleSearch();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	private static void googleSearch() throws Exception {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		//Open Google.com
		driver.get("http://tinyupload.com/");
		
		//Enter text in search box
		driver.findElement(By.name("uploaded_file")).click();
		
		Runtime.getRuntime().exec("C:\\sangs-work\\Fileupload.exe");
		Thread.sleep(3000);
		
	//	driver.close();
		
		
	}
}
