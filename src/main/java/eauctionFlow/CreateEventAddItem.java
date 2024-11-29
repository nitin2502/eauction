package eauctionFlow;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.UUID; // Import for generating random strings
public class CreateEventAddItem {
    WebDriver driver;
    @BeforeClass
    public void setUp() {
        // Use WebDriverManager to set up ChromeDriver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Navigate to the login page
        driver.get("https:eauction.shauryatechnosoft.com/login"); 
    }

    @Test(priority=1)
    public void testLogin() throws InterruptedException {
        // Locate the username field and input a username
        WebElement usernameField = driver.findElement(By.xpath("//input[@placeholder='User Name ']")); 
        usernameField.sendKeys("krunal");

        // Locate the password field and input a password
        WebElement passwordField = driver.findElement(By.xpath("//input[@placeholder='Password']")); 
        passwordField.sendKeys("Krunal@123");

        // Click the login button
        WebElement loginButton = driver.findElement(By.xpath("/html/body/app-root/app-web-layout/div/div/div/app-login/div[3]/div[2]/form/div[3]/button")); 
        loginButton.click();
        Thread.sleep(3000);
    }

    @Test(priority=2)
    public void createEvent() throws InterruptedException {
        // Click the create event button 
        WebElement CreateeventButton = driver.findElement(By.xpath("//button[@color='primary'][1]")); 
        CreateeventButton.click();
        
        // Generate a random event title
        String randomEventTitle = generateRandomEventTitle();

        // Locate the Event Title field and enter the random event title
        WebElement eventTitle = driver.findElement(By.xpath("//input[@formcontrolname='eventTitle']"));
        eventTitle.sendKeys(randomEventTitle);
        Thread.sleep(3000);
        
        // Upload the Event Document
        WebElement uploadDocument = driver.findElement(By.xpath("//button[@color='accent'][1]"));
        uploadDocument.click();
        Thread.sleep(7000);

        // Locate the Event Description field and enter a description
        WebElement eventDescription = driver.findElement(By.xpath("//textarea[@placeholder='Enter Event Description.'][1]"));
        eventDescription.sendKeys("This is a test description for the events.");

        // Click on the Create Event button
        WebElement createEventButton = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/mat-dialog-container/div/div/app-create-event/mat-dialog-content/form/mat-dialog-actions/button[2]"));
        createEventButton.click();
        Thread.sleep(2000);
        
        // Close the success dialog
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/mat-dialog-container/div/div/app-success-dialog/mat-dialog-content/div/div[2]/div/button/span[2]")).click();
    }

    @Test(priority=3)
    public void createEventAddItem() throws InterruptedException {
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("//*[@id=\"content\"]/div/app-event-list-for-seller-approver/div/div[3]/table/tbody/tr[1]/td[8]/div/button")).click();
    	Thread.sleep(2000);
        // Fill in Item Details
        driver.findElement(By.xpath("//input[@formcontrolname='itemName']")).sendKeys("Sand");
        driver.findElement(By.xpath("//mat-select[@formcontrolname='itemTypeId']")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("mat-option-40")).click();
        driver.findElement(By.xpath("//input[@formcontrolname='quantity']")).sendKeys("10");
        Thread.sleep(2000);
        
        driver.findElement(By.xpath("//mat-select[@tabiindex='0']")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("mat-option-92")).click();
        // Select Location
        driver.findElement(By.xpath("//mat-select[@formcontrolname='districtId']")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("mat-select-18")).click();
        driver.findElement(By.xpath("//mat-select[@formcontrolname='talukaId']")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("mat-select-value-21")).click();
        
        driver.findElement(By.xpath("//mat-select[@formcontrolname='villageId']")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("mat-select-22")).click();
        
        driver.findElement(By.xpath("//input[@formcontrolname='surveyNo]")).sendKeys("10/140A");
        driver.findElement(By.xpath("//input[@formcontrolname='area']")).sendKeys("10.36R");
   
        // Fill in Fees and Charges
        driver.findElement(By.name("processingFee")).sendKeys("1947");
        driver.findElement(By.name("minBidPrice")).sendKeys("5000");
        driver.findElement(By.name("applicationFee")).sendKeys("100");

        // Check GST Option
        driver.findElement(By.id("gstApplicableYes")).click();

        // Fill in Bidding Methodologies
        driver.findElement(By.name("bidIncrement")).sendKeys("500");
        driver.findElement(By.name("bidExtensionCriteria")).sendKeys("2");
        driver.findElement(By.name("bidExtensionTiming")).sendKeys("10");
        driver.findElement(By.name("numberOfBidExtensionsAllowed")).sendKeys("5");

        // Add Document
        WebElement uploadInput = driver.findElement(By.id("documentUpload"));
        uploadInput.sendKeys("path_to_document"); 
        driver.findElement(By.id("addDocumentButton")).click();

        // Fill Item Description
        driver.findElement(By.name("itemDescription")).sendKeys("Sample description for the item.");

        // Save the Item
        driver.findElement(By.id("saveButton")).click();

        // Verify Success
        WebElement successMessage = driver.findElement(By.id("successMessage"));
        Assert.assertTrue(successMessage.isDisplayed(), "Item creation failed!");
    }

    // Method to generate a random event title
    public String generateRandomEventTitle() {
        return "Event_" + UUID.randomUUID().toString().substring(0, 8); // Random event title of 8 characters
    }

  //  @AfterClass
    public void tearDown() throws InterruptedException {
        // Close the browser
        if (driver != null) {
            Thread.sleep(3000);
            driver.quit();
        }
    }
}
