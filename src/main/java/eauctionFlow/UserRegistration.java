package eauctionFlow;

import org.openqa.selenium.WebDriver;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
public class UserRegistration {
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
	    public void LoginSubadmin() throws Exception  {
	   
	    	WebElement usernameField = driver.findElement(By.xpath("//input[@placeholder='User Name ']")); 
	        usernameField.sendKeys("SubAdmin");

	        // Locate the password field and input a password
	        WebElement passwordField = driver.findElement(By.xpath("//input[@placeholder='Password']")); 
	        passwordField.sendKeys("Subadmin@123");

	        // Click the login button
	        WebElement loginButton = driver.findElement(By.xpath("/html/body/app-root/app-web-layout/div/div/div/app-login/div[3]/div[2]/form/div[3]/button")); // Update locator as needed
	        loginButton.click();
	    }
	    @Test(priority=1)
	    public void SellerRegister() throws InterruptedException {
	    	//Click on The Master ///change
	    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	     WebElement m=  driver.findElement(By.xpath("//nav[@id='sidebar']/div[2]/ul/li[2]/a/span[1]"));
	     Actions a=new Actions(driver);
	     a.moveToElement(m).perform();
	     driver.findElement(By.xpath("//*[@id=\"sidebar\"]/div[2]/ul/li[2]/a/span[1]")).click();
	     //Click on the User Registration
	     driver.findElement(By.xpath("//ul[@id='subMenus1']/li[1]/a")).click();
	   //Click on The User
	        Thread.sleep(2000);
	     driver.findElement(By.cssSelector("div[class='col-md-auto ms-md-auto d-flex gap-1 col-auto'] button")).click();
	     //Click on the Event Category
	     Thread.sleep(2000);
	     driver.findElement(By.xpath("//div[@class='col-md-3'][1]/mat-form-field/div[1]/div/div/div[2]/label/mat-label")).click();
	    //click on the mahakhanij category
	     Thread.sleep(2000);
	     driver.findElement(By.xpath("//span[@class='mdc-list-item__primary-text'][normalize-space()='Mahakhanij eAuction']")).click();
	    //Click on the User type
	    // Thread.sleep(5000);
	  //  driver.findElement(By.xpath("//div[@class='col-md-3'][2]/mat-form-field/div[1]/div/div/div[2]/label/mat-label")).click();
	    //Click on the Role
	     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	     driver.findElement(By.xpath("//div[@class='col-md-3'][3]/mat-form-field/div[1]/div/div/div[2]/label/mat-label")).click();
	    //Click on the Seller
	     Thread.sleep(5000);
	     driver.findElement(By.cssSelector("mat-option[id='mat-option-79']")).click();
	    //Enter Name In the Field
	     Thread.sleep(5000);
	     driver.findElement(By.xpath("//div[@class='col-md-3'][5]/mat-form-field/div[1]/div/div[2]/input")).sendKeys("Virat Kohli");
	     //Enter Mobile no In the Field
	     Thread.sleep(2000);
	     driver.findElement(By.xpath("//div[@class='col-md-3'][6]/mat-form-field/div[1]/div/div[2]/input")).sendKeys("6859478567");
	     //Enter User name In the Field
	     driver.findElement(By.xpath("//div[@class='col-md-3'][7]/mat-form-field/div[1]/div/div[2]/input")).sendKeys("virat7");
	     //Enter email Address In the Field
	     driver.findElement(By.xpath("//div[@class='col-md-3'][8]/mat-form-field/div[1]/div/div[2]/input")).sendKeys("virat@gmail.com");
	     //Enter Address
	     driver.findElement(By.xpath("//div[@class='col-md-12']/mat-form-field/div[1]/div/div[2]/textarea")).sendKeys("Delhi india 123456");
	     //Click on the Submit button
	     driver.findElement(By.xpath("//button[@class='btn-gradient mdc-button mdc-button--outlined mat-mdc-outlined-button mat-unthemed mat-mdc-button-base']")).click();
	     //Click on the OK message
	     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
	     driver.findElement(By.xpath("//button[@class='btn-gradient text-uppercase mdc-button mdc-button--raised mat-mdc-raised-button mat-unthemed mat-mdc-button-base ng-star-inserted']/span[2]")).click();
	    }
	    @Test(priority=2)
	    public void approverregister() throws Exception {
	    	//Click on The User
	        Thread.sleep(2000);
	     driver.findElement(By.cssSelector("div[class='col-md-auto ms-md-auto d-flex gap-1 col-auto'] button")).click();
	     //Click on the Event Category
	     Thread.sleep(2000);
	     driver.findElement(By.xpath("//div[@class='col-md-3'][1]/mat-form-field/div[1]/div/div/div[2]/label/mat-label")).click();
	    //click on the mahakhanij category
	     Thread.sleep(2000);
	     driver.findElement(By.xpath("//span[@class='mdc-list-item__primary-text'][normalize-space()='Mahakhanij eAuction']")).click();
	    //Click on the User type
	    // Thread.sleep(5000);
	  //  driver.findElement(By.xpath("//div[@class='col-md-3'][2]/mat-form-field/div[1]/div/div/div[2]/label/mat-label")).click();
	    //Click on the Role
	     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	     driver.findElement(By.xpath("//div[@class='col-md-3'][3]/mat-form-field/div[1]/div/div/div[2]/label/mat-label")).click();
	    //Click on the Approver
	     Thread.sleep(5000);
	     driver.findElement(By.xpath("//div[@class='cdk-overlay-connected-position-bounding-box']/div/div/mat-option[1]/span")).click();
	    //Enter Name In the Field
	     Thread.sleep(5000);
	     driver.findElement(By.xpath("//div[@class='col-md-3'][5]/mat-form-field/div[1]/div/div[2]/input")).sendKeys("Rohit Sharma");
	     //Enter Mobile no In the Field
	     Thread.sleep(2000);
	     driver.findElement(By.xpath("//div[@class='col-md-3'][6]/mat-form-field/div[1]/div/div[2]/input")).sendKeys("7859478567");
	     //Enter User name In the Field
	     driver.findElement(By.xpath("//div[@class='col-md-3'][7]/mat-form-field/div[1]/div/div[2]/input")).sendKeys("Rohit6");
	     //Enter email Address In the Field
	     driver.findElement(By.xpath("//div[@class='col-md-3'][8]/mat-form-field/div[1]/div/div[2]/input")).sendKeys("rohit1@gmail.com");
	     //Enter Address
	     driver.findElement(By.xpath("//div[@class='col-md-12']/mat-form-field/div[1]/div/div[2]/textarea")).sendKeys("Mumbai maharashtra");
	     //Click on the Submit button
	     driver.findElement(By.xpath("//button[@class='btn-gradient mdc-button mdc-button--outlined mat-mdc-outlined-button mat-unthemed mat-mdc-button-base']")).click();
	     //Click on the OK message
	     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
	     driver.findElement(By.xpath("//button[@class='btn-gradient text-uppercase mdc-button mdc-button--raised mat-mdc-raised-button mat-unthemed mat-mdc-button-base ng-star-inserted']/span[2]")).click();
	    }
	}

