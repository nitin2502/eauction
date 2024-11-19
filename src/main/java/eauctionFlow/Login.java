package eauctionFlow ;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Use WebDriverManager to set up ChromeDriver
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();

        // Navigate to the login page
        driver.get("https://eauctions.mahamining.com/login"); // Replace with the actual URL of your login page
    }

    @Test
    public void testLogin() {
        // Locate the username field and input a username
        WebElement usernameField = driver.findElement(By.xpath("//input[@placeholder='User Name ']")); // Update locator as needed
        usernameField.sendKeys("akpatil");

        // Locate the password field and input a password
        WebElement passwordField = driver.findElement(By.xpath("//input[@placeholder='Password']")); // Update locator as needed
        passwordField.sendKeys("your_password");

        // Click the login button
        WebElement loginButton = driver.findElement(By.xpath("/html/body/app-root/app-web-layout/div/div/div/app-login/div[3]/div[2]/form/div[3]/button")); // Update locator as needed
        loginButton.click();

       
    }

   // @AfterClass
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}