package eauctionFlow;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BidderRegistration{
	private WebDriver driver;

	@BeforeClass
	public void setUp() throws InterruptedException {
		// Set up ChromeDriver using WebDriverManager
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		driver = new ChromeDriver(options);
		driver.manage().deleteAllCookies();
		Thread.sleep(3000);
		// Navigate to the Bidder Registration page
		driver.get("https://eauctions.mahamining.com/login");

		WebElement bidderregistration = driver.findElement(By.xpath("/html/body/app-root/app-web-layout/div/div/div/app-login/div[3]/div[2]/form/div[2]/button[1]")); 
		bidderregistration.click();
	}

	@Test
	public void testBidderRegistration() throws InterruptedException {
		// Fill in PAN Number and click Search
		Thread.sleep(2000);
		WebElement panInput = driver.findElement(By.xpath("//input[@maxlength='10']")); 
		panInput.sendKeys("CJCPG4756Q");
		WebElement searchButton = driver.findElement(By.xpath("//button[@type='submit'][1]")); 
		searchButton.click();
		Thread.sleep(2000); // Wait for search results

		// Select Bidder Type as Individual
		WebElement individualRadio = driver.findElement(By.id("mat-radio-1-input")); 
		individualRadio.click();

		// Fill in Personal Details
		driver.findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys("Nitin Ghorpade"); 
		driver.findElement(By.xpath("//input[@formcontrolname='mobile']")).sendKeys("9876543210"); 

		driver.findElement(By.xpath("//*[@id=\"mat-select-0\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"mat-option-2\"]/span")).click();
		driver.findElement(By.xpath("//*[@id=\"mat-select-2\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"mat-option-82\"]")).click();
		driver.findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys("nitin@example.com");
		driver.findElement(By.xpath("//textarea[@formcontrolname='address']")).sendKeys("123 Main Street");
		driver.findElement(By.xpath("//input[@formcontrolname='pinCode']")).sendKeys("411001"); 

		// Fill in Document Details
		driver.findElement(By.xpath("//input[@formcontrolname='aadharNo']")).sendKeys("658930259658");
		driver.findElement(By.xpath("//input[@formcontrolname='gstNo']")).sendKeys("22ABCDE1234F1Z5"); 

		// Upload Documents
		//WebElement gstUploadInput = 
		driver.findElement(By.xpath("/html/body/app-root/app-web-layout/div[1]/div/div/app-bidder-registration/mat-dialog-content/div/div[4]/div[2]/form/div[3]/table/tbody/tr[1]/td[3]/span/button/span[2]/label/span")).sendKeys("Z:\\SLMCERRor\\730.png\\");
		Thread.sleep(3000); 
		//gstUploadInput.click();
		Thread.sleep(8000); 
		
		// Click Submit
		driver.findElement(By.xpath("/html/body/app-root/app-web-layout/div[1]/div/div/app-bidder-registration/mat-dialog-content/div/div[4]/div[2]/form/div[4]/button[1]")).submit();
		Thread.sleep(3000); 
		// Validate the success message
		WebElement successMessage = driver.findElement(By.id("successMessage")); 
		assert successMessage.getText().contains("Registration successful");
	}

	@AfterClass
	public void tearDown() throws InterruptedException {
		// Close the browser
		if (driver != null) {
			Thread.sleep(5000); 
			driver.quit();
		}
	}
}
