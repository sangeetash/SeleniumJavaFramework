package util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import config.PropertiesFile;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ExcelDataProvider {
	

		private static WebDriver driver = null;
		public static String browserName = null;

		@BeforeTest
		public void setUpTest() {			
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				
		}
	@Test(dataProvider = "testData1")
	public void test1(String userName, String password) {
		System.out.println("username:"+userName+"\n password:"+password);
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.name("txtUsername")).sendKeys(userName);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@DataProvider(name = "testData1")
	public Object[][] getData() {
		
		Object[][] data = testData(System.getProperty("user.dir"), "Sheet1");
		return data;
		
	}
	public static Object[][] testData(String excelPath, String sheetname) {
		
		ExcelUtils util = new ExcelUtils(excelPath, sheetname);
		
		int rowCount = util.getRowCount();
		int colCount = util.getColumnCount();
		Object[][] dataObject = new Object[rowCount-1][colCount];
		
		for(int i = 1; i <rowCount;i++) {
			for(int j=0; j<colCount;j++) {
				String cellData = util.getCellDataString(i, j);
				dataObject[i-1][j] = cellData;
			}
		}
		return dataObject;
	}

}
