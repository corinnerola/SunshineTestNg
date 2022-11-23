package testcases;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import commons.DriverSetup;
import commons.Login;
import commons.SchedulerUtils;

public class tc5_BookAppointment {
	
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
		sUtils.clickTimeDropdown();
		

		sUtils.selectTime();
		sUtils.clickBookBtn();
		
		driver.navigate().refresh();
		sUtils.clickCreatedAppt();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(sUtils.createdApptNonWaitlistSpan));
		SoftAssert softAssertion = new SoftAssert();
		softAssertion.assertEquals(driver.findElement(sUtils.createdApptNonWaitlistSpan).getText(),
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
