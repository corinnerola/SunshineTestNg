package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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

	@BeforeTest
	public void setup() {

		DriverSetup ds = new DriverSetup();
		driver = ds.setupDriver();
		wait = ds.setupDriverWait(driver);
		driver.get("https://staging-admin.eyebooknow.com");
	}

	@Test(priority = 1)
	public void loginToStellest() {
		// login
		Login login = new Login(driver);
		login.verifyLoginToAdminPage(); // call method to login
	}

	@Test(priority = 2)
	public void inputApptDetails() throws InterruptedException {

		SchedulerUtils sUtils = new SchedulerUtils(driver);

		Thread.sleep(5000);
		sUtils.clickAddApttBtn();
		wait.until(ExpectedConditions.presenceOfElementLocated(sUtils.apptFirstNameText));

		sUtils.inputFName();
		sUtils.inputLName();
		sUtils.inputPhoneNumber();
		sUtils.inputEmail();
		sUtils.clickService();
		sUtils.clickSunglasses();
		sUtils.selectWaitlist();

		sUtils.clickBookBtn();

		
		driver.navigate().refresh();
		SoftAssert softAssertion = new SoftAssert();
		softAssertion.assertEquals(driver.findElement(sUtils.createdAppt).getText(),
				sUtils.apptFirstNameVal + " " + sUtils.apptLastNameVal); // success booking
		softAssertion.assertAll();
		System.out.print("Appointment for " + sUtils.apptFirstNameVal + " " + sUtils.apptLastNameVal
				+ " is successfully created \n");

	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}

}
