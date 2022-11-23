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
import net.bytebuddy.build.Plugin.Factory.UsingReflection.Priority;

public class tc3_BookApptUsingCustomerURL {

	WebDriver driver;
	WebDriverWait wait;
	Faker faker = new Faker();

	By notificationsBtn = By.xpath("//button[@id='menu-notifications']");
	By newAppMessageArray = By.xpath("//th[text()='Message']/ancestor::thead/following-sibling::tbody/tr[1]/td[@class='notifications__message']");
	By newApptNameArrayBy = By.xpath("//th[text()='Message']/ancestor::thead/following-sibling::tbody/tr[1]/td[@class='notifications__author']");
	By scheduleVisitBtn = By.xpath(
			"//ancestor::div[@class='App']//p[contains(text(), 'prioritizing')]/preceding-sibling::span[contains(text(), 'Essilor')]/parent::div[@class='footer footer--mobile-hidden']/parent::section/preceding-sibling::section[@class='loc-info__content']/h1[contains (text(),'Home')]/following-sibling::div[@class='loc-info__shape']/div/h2[contains(text(),'Optics')]/following-sibling::a[contains(text(),'Address')]/following-sibling::a[contains(text(),'5555')]/following-sibling::div/div/following-sibling::p[contains(text(),'today')]/parent::div/parent::div/following-sibling::div[@class='loc-info-actions']/div/button[contains(text(),'Schedule')]");
	By appointmentsBtn 	= By.xpath(
			"//ancestor::div[@class='page']//h1[contains (text(),'Resource')]/following-sibling::h2[contains (text(),'visit')]//following-sibling::h2[contains(text(),'Optics')]/following-sibling::p[contains(text(),'preference')]/following-sibling::div[@class='resource__types']/div/button[text()=\"First Available\"]/parent::div[@class='resource__first-avail']/following-sibling::button[text()='Appointments']");
	By visitReasonDrp = By.xpath(
			"//ancestor::section[@class='booking__content']//h1[contains (text(),'Resource')]/following-sibling::h2[contains (text(),'visit')]//following-sibling::h2[contains(text(),'Optics')]/following-sibling::div/h4[text()='What is the reason for your visit?']/following-sibling::div/div/div/div[@id='booking-servicetype-appttype']");
	By sunglassesReasonBy = By.xpath(
			"//ancestor::section[@class='booking__content']//h1[contains (text(),'Resource')]/following-sibling::h2[contains (text(),'visit')]//following-sibling::h2[contains(text(),'Optics')]/following-sibling::div/h4[text()='What is the reason for your visit?']/following-sibling::div/div/div/div[@id='booking-servicetype-appttype']/ancestor::div[@id='root']/following-sibling::div[@id='menu-']//ul[@role='listbox']/li[text()='Sunglasses']");
	By bookingNextBtn = By.xpath(
			"//ancestor::div[@id='root']//h1[contains (text(),'Resource')]/following-sibling::h2[contains (text(),'visit')]//following-sibling::h2[contains(text(),'Optics')]/following-sibling::div/h4[text()='What is the reason for your visit?']/following-sibling::div/div/div/div[@id='booking-servicetype-appttype']/parent::div/parent::div/parent::div/following-sibling::h4[text() ='When would you like to be seen?']/parent::div/div/following-sibling::div/div[@class='booking__calendar']/following-sibling::div[@class='booking__next']");
	By slotBtn = By.xpath(
			"//ancestor::div[@id='root']//h1[contains (text(),'Resource')]/following-sibling::h2[contains (text(),'visit')]//following-sibling::h2[contains(text(),'Optics')]/following-sibling::div/h4[text()='What is the reason for your visit?']/following-sibling::div/div/div/div[@id='booking-servicetype-appttype']/parent::div/parent::div/parent::div/following-sibling::h4[text() ='When would you like to be seen?']/parent::div/div/following-sibling::div/div[@class='booking__calendar']/parent::div/following-sibling::div[@class='booking__slots']/button[1]");
	By custApptFNameText = By.xpath(
			"//ancestor::div[@id='root']//h1[contains (text(),'Exam Type')]/following-sibling::h2[contains (text(),'visit')]//following-sibling::h2[contains(text(),'Optics')]/following-sibling::form[@class='personal-info__form']/div[@class='personal-info__row']/div[@class='personal-info__input-cont']//label[text()='FIRST NAME']/parent::div//input[@type='text']");
	By custApptLNameText = By.xpath(
			"//ancestor::div[@id='root']//h1[contains (text(),'Exam Type')]/following-sibling::h2[contains (text(),'visit')]//following-sibling::h2[contains(text(),'Optics')]/following-sibling::form[@class='personal-info__form']/div[@class='personal-info__row']/div[@class='personal-info__input-cont']//label[text()='FIRST NAME']/parent::div/parent::div[@class='personal-info__input-cont']/following-sibling::div//label[text()='LAST NAME']/parent::div//input[@type='text']");
	By custPhoneText = By.xpath(
			"//ancestor::div[@id='root']//h1[contains (text(),'Exam Type')]/following-sibling::h2[contains (text(),'visit')]//following-sibling::h2[contains(text(),'Optics')]/following-sibling::form[@class='personal-info__form']/div[@class='personal-info__row']/div[@class='personal-info__input-cont']//label[text()='FIRST NAME']/parent::div/parent::div[@class='personal-info__input-cont']/following-sibling::div//label[text()='LAST NAME']/parent::div/ancestor::div[@class='personal-info__row']/following-sibling::div/div[@class='personal-info__input-cont']//label[text()='PHONE NUMBER']/parent::div//input[@type='tel']");
	By custEmailText = By.xpath(
			"//ancestor::div[@id='root']//h1[contains (text(),'Exam Type')]/following-sibling::h2[contains (text(),'visit')]//following-sibling::h2[contains(text(),'Optics')]/following-sibling::form[@class='personal-info__form']/div[@class='personal-info__row']/div[@class='personal-info__input-cont']//label[text()='FIRST NAME']/parent::div/parent::div[@class='personal-info__input-cont']/following-sibling::div//label[text()='LAST NAME']/parent::div/ancestor::div[@class='personal-info__row']/following-sibling::div/div[@class='personal-info__input-cont']//label[text()='PHONE NUMBER']/ancestor::div[@class='personal-info__input-cont']/following-sibling::div//label[text()='EMAIL (Optional)']/parent::div//input[@type='email']");
	By reviewDetailsBtn = By.xpath(
			"//ancestor::div[@id='root']//h1[contains (text(),'Exam Type')]/following-sibling::h2[contains (text(),'visit')]//following-sibling::h2[contains(text(),'Optics')]/following-sibling::form[@class='personal-info__form']/div[@class='personal-info__row']/div[@class='personal-info__input-cont']//label[text()='FIRST NAME']/parent::div/parent::div[@class='personal-info__input-cont']/following-sibling::div//label[text()='LAST NAME']/parent::div/ancestor::div[@class='personal-info__row']/following-sibling::div/div[@class='personal-info__input-cont']//label[text()='PHONE NUMBER']/ancestor::div[@class='personal-info__input-cont']/following-sibling::div//label[text()='EMAIL (Optional)']/ancestor::div[@class='personal-info__row']/following-sibling::div/button[text()='REVIEW DETAILS']");
	By confirmApptBtn = By.xpath("//button[@class='details__confirm']");
	By surveyQ1ChkBx = By
			.xpath("//span[text()='Night Driving']/preceding-sibling::span/span[@class='MuiIconButton-label']");
	By surveyQ2ChkBx = By.xpath("//span[text()='Yes']/preceding-sibling::span/span[@class='MuiIconButton-label']");
	By surveyQ3ChkBx = By
			.xpath("//span[text()='All the time']/preceding-sibling::span/span[@class='MuiIconButton-label']");
	By surveyQ4ChkBx = By
			.xpath("//span[text()='Less than 40']/preceding-sibling::span/span[@class='MuiIconButton-label']");
	By surveyQ5 = By.xpath("//li[@value='4']/textarea");
	By surveySubmitBtn = By.xpath("//button[text()='Submit']");
	By surveyCloseBtn = By.xpath("//button[text()='Close']");
	
	String surveyQ5Val = faker.rickAndMorty().quote().toString();
	String custApptFNameTextVal = faker.rickAndMorty().character().toString();
	String custApptLNameTextVal = faker.rickAndMorty().character().toString();
	

	@BeforeTest
	public void setup() {

		DriverSetup ds = new DriverSetup();
		driver = ds.setupDriver();
		wait = ds.setupDriverWait(driver);
		driver.get("https://staging.eyebooknow.com/STGMYAUTO1");
	}

	@Test(priority = 1)
	public void submitCustomerAppt() throws InterruptedException {

		wait.until(ExpectedConditions.visibilityOfElementLocated(scheduleVisitBtn));
		driver.findElement(scheduleVisitBtn).click();
		driver.findElement(appointmentsBtn).click();
		driver.findElement(visitReasonDrp).click();
		driver.findElement(sunglassesReasonBy).click();

		driver.findElement(bookingNextBtn).click();

		for (int i = 0; i <= 2; i++) {
			try {
				driver.findElement(slotBtn).click();
				break;
			} catch (Exception e) {
				driver.findElement(bookingNextBtn).click();

			}
		}

		driver.findElement(custApptFNameText).sendKeys(custApptFNameTextVal);
		driver.findElement(custApptLNameText).sendKeys(custApptLNameTextVal);
		driver.findElement(custPhoneText).sendKeys("555555555");
		driver.findElement(custEmailText).sendKeys("caryll.rola@ext.essilor.com");
		driver.findElement(reviewDetailsBtn).click();
		driver.findElement(confirmApptBtn).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(surveyQ1ChkBx));
		driver.findElement(surveyQ1ChkBx).click();
		driver.findElement(surveyQ2ChkBx).click();
		driver.findElement(surveyQ3ChkBx).click();
		driver.findElement(surveyQ4ChkBx).click();
		driver.findElement(surveyQ5).sendKeys(surveyQ5Val);
		driver.findElement(surveySubmitBtn).click();
		driver.findElement(surveyCloseBtn).click();

	}

	@Test(priority = 2)
	public void verifyAppt() throws InterruptedException {

		driver.get("https://staging-admin.eyebooknow.com");

		Login login = new Login(driver);
		login.verifyLoginToAdminPage(); // call method to login
		
		driver.findElement(notificationsBtn).click();
		
		SoftAssert softAssertion = new SoftAssert();
		softAssertion.assertEquals(driver.findElement(newAppMessageArray).getText(),
				"New Appointment - Sunglasses"); // assert message
		
		softAssertion.assertEquals(driver.findElement(newApptNameArrayBy).getText(),
				custApptFNameTextVal + " " + custApptLNameTextVal); // success booking
		
		softAssertion.assertAll();
		System.out.print("Appointment for " + custApptFNameTextVal + " " + custApptLNameTextVal
				+ " is successfully created \n");
		
	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}

}
