package eauctionFlow ;

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

public class Login {

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

    @Test
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

        Thread.sleep(2000);

		
    }
    @Test
    public void SubAdminLogin() throws InterruptedException {
        // Locate the username field and input a username
        WebElement usernameField = driver.findElement(By.xpath("//input[@placeholder='User Name ']")); 
        usernameField.sendKeys("SubAdmin");

        // Locate the password field and input a password
        WebElement passwordField = driver.findElement(By.xpath("//input[@placeholder='Password']")); 
        passwordField.sendKeys("Subadmin@123");

        // Click the login button
        WebElement loginButton = driver.findElement(By.xpath("/html/body/app-root/app-web-layout/div/div/div/app-login/div[3]/div[2]/form/div[3]/button")); // Update locator as needed
        loginButton.click();

        Thread.sleep(2000);

		
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
