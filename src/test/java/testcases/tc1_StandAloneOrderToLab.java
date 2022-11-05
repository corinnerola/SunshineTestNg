package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import commons.*;
import io.github.bonigarcia.wdm.WebDriverManager;

/* 
 * +----------------------------------------------------------------------------+
 * | AUTOMATION TEST CASE FOR:													|
 * |																			|
 * | Scenario 1: SCENARIO 1: Submit a Stellest Lenses (Standalone) Order to Lab |
 * +----------------------------------------------------------------------------+
 */

public class tc1_StandAloneOrderToLab extends RegFormUtils{

	static WebDriver driver;
	static WebDriverWait wait;
		
	@BeforeTest
	public static void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://staging-admin.eyebooknow.com");
	}

	
	@Test
	public static void loginToStellest () {
		//login
		Login.verifyLoginToStellestCare(driver); 															//call method to login		
	}
	
	
	@Test
	public static void submitStandAloneOrderToLab() throws InterruptedException {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(stellestBtn));						
		driver.findElement(stellestBtn).click();															// click stellest button
		
		CustomerDetailsInput.enterCustomerDetails(driver);													// call method for customer details input
		
		// input Digital Prescription
		driver.findElement(refNumberText).sendKeys(refnumberVal);
		driver.findElement(sphRightText).sendKeys(String.valueOf(sphValR));
		driver.findElement(cylRightText).sendKeys(String.valueOf(cylValR));
		driver.findElement(axisRightText).sendKeys(String.valueOf(axisValR));
		driver.findElement(pdRightText).sendKeys(String.valueOf(pdValR));
		driver.findElement(htRightText).sendKeys(String.valueOf(htValR));
		driver.findElement(sphLeftText).sendKeys(String.valueOf(sphValL));
		driver.findElement(cylLeftText).sendKeys(String.valueOf(cylValL));
		driver.findElement(axisLeftText).sendKeys(String.valueOf(axisValL));
		driver.findElement(pdLeftText).sendKeys(String.valueOf(pdValL));
		driver.findElement(htLeftText).sendKeys(String.valueOf(htValL));
		
		driver.findElement(submitBtn).click();																// submit order
		
		SoftAssert softAssertion = new SoftAssert();
		softAssertion.assertEquals(driver.findElement(By.xpath("//div[@class='success-container']/h2")).getText(), "Success!");					// success order checking
		softAssertion.assertAll();
		
		driver.findElement(closeBtn).click();
		Thread.sleep(2000);  
				
		driver.findElement(viewOrderDetailsBtn).click();													// click the order created to view details
		driver.findElement(viewOrderDetails).click();														// collapse area to expand details
		Thread.sleep(5000); //for viewwing purposes lol
		
		
	}
	
	@AfterTest
	public void teardown() { 
		driver.quit();
	}

}
