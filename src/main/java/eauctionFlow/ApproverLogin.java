package eauctionFlow;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.cucumber.java.lu.a;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ApproverLogin {
	 WebDriver driver;

	   @BeforeTest
	    public void setUp() {
	        // Use WebDriverManager to set up ChromeDriver
	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();

	        // Navigate to the login page
	        driver.get("https://eauction.shauryatechnosoft.com/login");
	      
	    }
	   @Test(priority=1)
	    public void LoginApprover() throws Exception  {
	   
	    	WebElement usernameField = driver.findElement(By.xpath("//input[@placeholder='User Name ']")); 
	        usernameField.sendKeys("bhuvneshwar");

	        // Locate the password field and input a password
	        WebElement passwordField = driver.findElement(By.xpath("//input[@placeholder='Password']")); 
	        passwordField.sendKeys("Bhuvneshwar@123");

	        // Click the login button
	        WebElement loginButton = driver.findElement(By.xpath("/html/body/app-root/app-web-layout/div/div/div/app-login/div[3]/div[2]/form/div[3]/button")); // Update locator as needed
	        loginButton.click();
	    }    
	   @Test(priority=2)
	   public void approveevent() throws Exception {
		   //Click on the Event ID
		   Thread.sleep(5000);
		 driver.findElement(By.xpath("//tbody[@class='mdc-data-table__content']/tr[1]/td[2]/a")).click();
		 //new Tab is Open So Switch To New Tab
		 ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		 driver.switchTo().window(tabs.get(1));
		 //Click on the Approver
		 driver.findElement(By.xpath("//div[@class='text-end mt-2']/button[2]/span[2]")).click();
		 //Enter Remark
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//div[@class='ng-star-inserted']/mat-form-field/div[1]/div/div[2]/textarea")).sendKeys("Approve By The  Approver");
		 //Click on The OK
		 driver.findElement(By.xpath("//mat-dialog-actions[@class='mat-mdc-dialog-actions mdc-dialog__actions mat-mdc-dialog-actions-align-end']/button[2]/span[2]")).click();
	   }
	   @Test(priority=3)
	   public void publishevent() throws Exception {
		   Thread.sleep(5000);
		   WebElement m=  driver.findElement(By.xpath("//nav[@id=\"sidebar\"]/div[2]/ul/li[1]/a/span[1]"));
		     Actions a=new Actions(driver);
		     a.moveToElement(m).perform();
	   }
}
