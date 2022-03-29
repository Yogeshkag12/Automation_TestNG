import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test {
	 WebDriver driver;
	
	@BeforeTest
	public void openBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		}

	@org.testng.annotations.Test
	public void openapplication() {
		driver.get("http://www.google.com");
		driver.manage().window().maximize();
	}
	@org.testng.annotations.Test
	public void searchResult() {
		driver.findElement(By.name("q")).sendKeys("Hello");
	}
	@org.testng.annotations.Test
	public void verifyTitlet() {
		Assert.assertEquals(driver.getTitle(),"Google");
	}

	@AfterTest
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}
}
