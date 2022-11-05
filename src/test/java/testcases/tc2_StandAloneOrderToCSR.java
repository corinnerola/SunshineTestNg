package testcases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import commons.CustomerDetailsInput;
import commons.DriverSetup;
import commons.Login;
import commons.RegFormUtils;
import io.github.bonigarcia.wdm.WebDriverManager;

/* 
 * +----------------------------------------------------------------------------+
 * | AUTOMATION TEST CASE FOR:													|
 * |																			|
 * | Scenario 2: SCENARIO 2: Submit a Stellest Lenses (Standalone) Order to CSR |
 * +----------------------------------------------------------------------------+
 */

public class tc2_StandAloneOrderToCSR extends RegFormUtils{
	
	WebDriver driver;
	WebDriverWait wait;
	public String fileToUpload = "C:\\Users\\caryll.rola\\Downloads\\download.jpg";
	
	
	@BeforeTest
	public  void setup() {
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
//		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.manage().window().maximize();
//		driver.get("https://staging-admin.eyebooknow.com");
		
		DriverSetup ds = new DriverSetup();
		
		driver = ds.setupDriver();
		wait = ds.setupDriverWait(driver);
		
	}


	@Test
	public void loginToStellest () {
		//login
		Login.verifyLoginToStellestCare(driver); 																		//call method to login		
	}
	
	@Test
	public void submitStandAloneOrderToCSR() throws InterruptedException {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(stellestBtn));						
		driver.findElement(stellestBtn).click();														// click stellest button
		
		CustomerDetailsInput.enterCustomerDetails(driver);												// call ethod to enter customer details
		
		driver.findElement(refNumberText).sendKeys(refnumberVal);
		driver.findElement(mediumDrp).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(uploadPhotoList));
		driver.findElement(uploadPhotoList).click();
		
		driver.findElement(fileUpload).sendKeys(fileToUpload);
		
		driver.findElement(saveFileBtn).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(finishBtn));
		driver.findElement(finishBtn).click();
		driver.findElement(submitBtn).click();
		
		driver.findElement(closeBtn).click();
		Thread.sleep(2000);  
				
		driver.findElement(viewOrderDetailsBtn).click();												// click the order created to view details												// collapse area to expand details
		Thread.sleep(5000); //for viewwing purposes lol
		
	}
	
	@AfterTest
	public void teardown() { 
		driver.quit();
	}
	

}
