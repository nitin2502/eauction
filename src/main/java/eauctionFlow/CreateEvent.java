package eauctionFlow ;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateEvent {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Use WebDriverManager to set up ChromeDriver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Navigate to the login page
        driver.get("https://eauctions.mahamining.com/login"); 
    }

    @Test(priority=1)
    public void testLogin() throws InterruptedException {
        // Locate the username field and input a username
        WebElement usernameField = driver.findElement(By.xpath("//input[@placeholder='User Name ']")); 
        usernameField.sendKeys("akpatil");

        // Locate the password field and input a password
        WebElement passwordField = driver.findElement(By.xpath("//input[@placeholder='Password']")); 
        passwordField.sendKeys("Akpatil@123");

        // Click the login button
        WebElement loginButton = driver.findElement(By.xpath("/html/body/app-root/app-web-layout/div/div/div/app-login/div[3]/div[2]/form/div[3]/button")); 
        loginButton.click();
        Thread.sleep(3000);

    }
    @Test(priority=2)
       public void createEvent() throws InterruptedException
       {
    	   //Click the create event button 
    	   WebElement CreateeventButton = driver.findElement(By.xpath("//button[@color='primary'][1]")); 
    	   CreateeventButton.click();
    	// Locate the Event Title field and enter a title
    	 
           WebElement eventTitle = driver.findElement(By.xpath("//input[@formcontrolname='eventTitle']"));
           eventTitle.sendKeys("Event 26/154");
           Thread.sleep(3000);
           // Upload the Event Document
           WebElement uploadDocument = driver.findElement(By.xpath("//button[@color='accent'][1]"));
           uploadDocument.click();
            Thread.sleep(7000);
           
           // Locate the Event Description field and enter a description
           WebElement eventDescription = driver.findElement(By.xpath("//textarea[@placeholder='Enter Event Description.'][1]"));
           eventDescription.sendKeys("This is a test description for the events.");

           // Click on the Create Event button
           WebElement createEventButton = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/mat-dialog-container/div/div/app-create-event/mat-dialog-content/form/div[2]/button[2]"));
           createEventButton.click();
           Thread.sleep(2000);
           driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/mat-dialog-container/div/div/app-success-dialog/mat-dialog-content/div/div[2]/div/button/span[2]")).click();
           
       }
    
     @AfterClass
    public void tearDown() throws InterruptedException {
        // Close the browser
        if (driver != null) {
        	Thread.sleep(3000);
            driver.quit();
        }
    }
}
