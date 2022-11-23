package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
import net.bytebuddy.build.Plugin.Factory.UsingReflection.Priority;

public class tc3_BookApptUsingCustomerURL {

	WebDriver driver;
	WebDriverWait wait;
	Faker faker = new Faker();

	String custApptFNameTextVal = faker.rickAndMorty().character().toString(); // TC3 USES THIS
	String custApptLNameTextVal = faker.rickAndMorty().character().toString(); //TC3 USES THIS

	@BeforeTest
	public void setup() {

		DriverSetup ds = new DriverSetup();
		driver = ds.setupDriver();
		wait = ds.setupDriverWait(driver);
		driver.get("https://staging.eyebooknow.com/STGMYAUTO1");
	}

	@Test(priority = 1)
	public void submitCustomerAppt() throws InterruptedException {
		
		SchedulerUtils sUtils = new SchedulerUtils(driver);

		wait.until(ExpectedConditions.visibilityOfElementLocated(sUtils.scheduleVisitBtn));
		sUtils.clickScheduleVisitBtn();
		sUtils.clickAppointmentsBtn();
		sUtils.clickVisitReasonDrp();
		sUtils.selectSunglasses();


		if (driver.findElement(sUtils.slotBtn).isDisplayed()) {
			sUtils.clickSlotBtn();
		} else {
			sUtils.clickNextBtn();
			sUtils.clickSlotBtn();
		}
		
		
		driver.findElement(sUtils.custApptFNameText).sendKeys(custApptFNameTextVal);
		driver.findElement(sUtils.custApptLNameText).sendKeys(custApptLNameTextVal);
		sUtils.inputCustApptDetails();


		sUtils.survey();

	}

	@Test(priority = 2)
	public void verifyAppt() throws InterruptedException {

		driver.get("https://staging-admin.eyebooknow.com");

		Login login = new Login(driver);
		login.verifyLoginToAdminPage(); // call method to login
		
		SchedulerUtils sUtils = new SchedulerUtils(driver);
		
		sUtils.clickNotifications();
		
		SoftAssert softAssertion = new SoftAssert();
		softAssertion.assertEquals(driver.findElement(sUtils.newApptMessageArray).getText(),
				"New Appointment - Sunglasses"); // assert message
		
		softAssertion.assertEquals(driver.findElement(sUtils.newApptNameArray).getText(), 
				custApptFNameTextVal + " " + custApptLNameTextVal); // success booking
		
		softAssertion.assertAll();
		System.out.print("Appointment for " + sUtils.custApptFNameTextVal + " " + sUtils.custApptLNameTextVal
				+ " is successfully created \n");
		
	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}

}
