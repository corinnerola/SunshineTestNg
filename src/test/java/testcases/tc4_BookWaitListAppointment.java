package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import commons.DriverSetup;
import commons.Login;
import commons.SchedulerUtils;
import io.github.bonigarcia.wdm.WebDriverManager;

/* 
 * +----------------------------------------------------------------------------+
 * | AUTOMATION TEST CASE FOR:													|
 * |																			|
 * | Scenario 4: Book a waitlist appointment using eyebooknow admin page 		|
 * +----------------------------------------------------------------------------+
 */

public class tc4_BookWaitListAppointment {

	WebDriver driver;
	WebDriverWait wait;
	Faker faker = new Faker();


	@BeforeTest
	public void setup() {

		DriverSetup ds = new DriverSetup();
		driver = ds.setupDriver();
		wait = ds.setupDriverWait(driver);
		driver.get("https://staging-admin.eyebooknow.com");
	}

	@Test
	public void loginToStellest() {
		// login
		Login login = new Login(driver);
		login.verifyLoginToAdminPage(); // call method to login
	}

	@Test
	public void inputApptDetails() throws InterruptedException {
		
		SchedulerUtils sUtils = new SchedulerUtils(driver); 
		
		Thread.sleep(10000);
		sUtils.clickAddApttBtn();
		
		driver.findElement(sUtils.apptFirstNameText).sendKeys(faker.funnyName().toString());
		driver.findElement(sUtils.apptLastNameText).sendKeys(faker.funnyName().toString());
		driver.findElement(sUtils.apptPhoneText).sendKeys("555555555");
		driver.findElement(sUtils.apptServiceDrp).click();
		driver.findElement(sUtils.apptServiceList).click();
		driver.findElement(sUtils.apptWaitListChkBx).click();
		
		sUtils.clickBookBtn();
		
	}

}
