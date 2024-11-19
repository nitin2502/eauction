package eauctionFlow;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class sellerregistrationandarpprover extends Login {
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
    public void sellerregistration() throws Exception  {
     super.subadminlogin();
		
    }
}
