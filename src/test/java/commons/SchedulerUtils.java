package commons;

import java.time.Duration;

import javax.sound.midi.VoiceStatus;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;

public class SchedulerUtils {
	
	WebDriver driver;
	WebDriverWait wait;
	Faker faker = new Faker();
	
	
	public String custApptFNameTextVal = faker.rickAndMorty().character().toString(); // TC3 USES THIS
	public String custApptLNameTextVal = faker.rickAndMorty().character().toString(); //TC3 USES THIS
	public String apptFirstNameVal = faker.funnyName().name().toString(); // TC4 TC5 USES THIS
	public String apptLastNameVal = faker.funnyName().name().toString(); // TC4 TC5 USES THIS
	public By createdApptNonWaitlistSpan = By.xpath("//div[@class='cal-appttooltip__body-right']/p[1]");	
	public By createdAppt = By.xpath("//div[@class='cal-queue']//div[@class='cal-queue__item'][last()]/div[@class='cal-queue__details']/span[1]");
	public By apptFirstNameText = By.xpath("//button[text()='Book']/parent::div[@class='cal-newappt__group']/parent::div[@class='cal-newappt']/div/following-sibling::div/div[contains (@class, 'cal-newappt__input')]/label[text()='First Name']/parent::div/div/input[@type='text']");
	
	By addApptBtn = By.xpath("//button[@id='menu-add-appointment']");
	By apptLastNameText = By.xpath("//button[text()='Book']/parent::div[@class='cal-newappt__group']/parent::div[@class='cal-newappt']/div/following-sibling::div/div[contains (@class, 'cal-newappt__input')]/label[text()='Last Name']/parent::div/div/input[@type='text']");
	By apptPhoneText = By.xpath("//button[text()='Book']/parent::div[@class='cal-newappt__group']/parent::div[@class='cal-newappt']/div/following-sibling::div[2]/div[contains (@class, 'cal-newappt__input')]/label[text()='Phone']/parent::div/div/input[@type='phone']");
	By appEmailTextBy = By.xpath("//button[text()='Book']/parent::div[@class='cal-newappt__group']/parent::div[@class='cal-newappt']/div/following-sibling::div[2]/div[contains (@class, 'cal-newappt__input')]/label[text()='Email']/parent::div/div/input[@type='text']");
	By apptServiceDrp = By.xpath("//div[@id='cal-newappt-appttype']");
	By apptSelectSunglasses = By.xpath("//ancestor::div[@id='menu-']/div/following-sibling::div[contains(@class,\"MuiMenu-paper\")]/ul[@role='listbox']/li[text()='Sunglasses']");
	By apptWaitListChkBx = By.xpath("//button[text()='Book']/parent::div[@class='cal-newappt__group']/parent::div[@class='cal-newappt']/div/following-sibling::div[contains (@class, 'group--waitlist')]/label[@class='MuiFormControlLabel-root']/span[contains (@class, 'MuiCheckbox')]/span/input[@type='checkbox']");
	By apptBookBtn = By.xpath("//button[text()='Book']/parent::div[@class='cal-newappt__group']/parent::div[@class='cal-newappt']/div/following-sibling::div[contains (@class, 'group--waitlist')]/label[@class='MuiFormControlLabel-root']/span[contains (@class, 'MuiCheckbox')]/span/input[@type='checkbox']/ancestor::div[contains(@class, 'waitlist')]/following-sibling::div[@class='cal-newappt__group']/button[@class='cal-newappt__book']");

	By selectTimeDrp = By.xpath("//label[text()='Time']/following-sibling::div/div[contains(@class,'MuiSelect-selectMenu')]");
	By selecttime = By.xpath("//ul[contains(@class,'MuiMenu-list')]/li[text()='10:00 PM']");
	By createdApptNonWaitlistBtn = By.xpath("//span[text()='10:00 pm']/ancestor::div[contains(@class,'MuiGrid-container')]/following-sibling::div//div[@class='cal-appt-cont'][last()]");
	
	
	By notificationsBtn = By.xpath("//button[@id='menu-notifications']");
	public By newApptMessageArray = By.xpath("//th[text()='Message']/ancestor::thead/following-sibling::tbody/tr[1]/td[@class='notifications__message']");
	public By newApptNameArray = By.xpath("//th[text()='Message']/ancestor::thead/following-sibling::tbody/tr[1]/td[@class='notifications__author']");
	public By scheduleVisitBtn = By.xpath("//ancestor::div[@class='App']//p[contains(text(), 'prioritizing')]/preceding-sibling::span[contains(text(), 'Essilor')]/parent::div[@class='footer footer--mobile-hidden']/parent::section/preceding-sibling::section[@class='loc-info__content']/h1[contains (text(),'Home')]/following-sibling::div[@class='loc-info__shape']/div/h2[contains(text(),'Optics')]/following-sibling::a[contains(text(),'Address')]/following-sibling::a[contains(text(),'5555')]/following-sibling::div/div/following-sibling::p[contains(text(),'today')]/parent::div/parent::div/following-sibling::div[@class='loc-info-actions']/div/button[contains(text(),'Schedule')]");
	By appointmentsBtn 	= By.xpath("//ancestor::div[@class='page']//h1[contains (text(),'Resource')]/following-sibling::h2[contains (text(),'visit')]//following-sibling::h2[contains(text(),'Optics')]/following-sibling::p[contains(text(),'preference')]/following-sibling::div[@class='resource__types']/div/button[text()=\"First Available\"]/parent::div[@class='resource__first-avail']/following-sibling::button[text()='Appointments']");
	By visitReasonDrp = By.xpath("//ancestor::section[@class='booking__content']//h1[contains (text(),'Resource')]/following-sibling::h2[contains (text(),'visit')]//following-sibling::h2[contains(text(),'Optics')]/following-sibling::div/h4[text()='What is the reason for your visit?']/following-sibling::div/div/div/div[@id='booking-servicetype-appttype']");
	By sunglassesReasonBy = By.xpath("//ancestor::section[@class='booking__content']//h1[contains (text(),'Resource')]/following-sibling::h2[contains (text(),'visit')]//following-sibling::h2[contains(text(),'Optics')]/following-sibling::div/h4[text()='What is the reason for your visit?']/following-sibling::div/div/div/div[@id='booking-servicetype-appttype']/ancestor::div[@id='root']/following-sibling::div[@id='menu-']//ul[@role='listbox']/li[text()='Sunglasses']");
	By bookingNextBtn = By.xpath("//ancestor::div[@id='root']//h1[contains (text(),'Resource')]/following-sibling::h2[contains (text(),'visit')]//following-sibling::h2[contains(text(),'Optics')]/following-sibling::div/h4[text()='What is the reason for your visit?']/following-sibling::div/div/div/div[@id='booking-servicetype-appttype']/parent::div/parent::div/parent::div/following-sibling::h4[text() ='When would you like to be seen?']/parent::div/div/following-sibling::div/div[@class='booking__calendar']/following-sibling::div[@class='booking__next']");
	public By slotBtn = By.xpath("//ancestor::div[@id='root']//h1[contains (text(),'Resource')]/following-sibling::h2[contains (text(),'visit')]//following-sibling::h2[contains(text(),'Optics')]/following-sibling::div/h4[text()='What is the reason for your visit?']/following-sibling::div/div/div/div[@id='booking-servicetype-appttype']/parent::div/parent::div/parent::div/following-sibling::h4[text() ='When would you like to be seen?']/parent::div/div/following-sibling::div/div[@class='booking__calendar']/parent::div/following-sibling::div[@class='booking__slots']/button[1]");
	public By custApptFNameText = By.xpath("//ancestor::div[@id='root']//h1[contains (text(),'Exam Type')]/following-sibling::h2[contains (text(),'visit')]//following-sibling::h2[contains(text(),'Optics')]/following-sibling::form[@class='personal-info__form']/div[@class='personal-info__row']/div[@class='personal-info__input-cont']//label[text()='FIRST NAME']/parent::div//input[@type='text']");
	public By custApptLNameText = By.xpath("//ancestor::div[@id='root']//h1[contains (text(),'Exam Type')]/following-sibling::h2[contains (text(),'visit')]//following-sibling::h2[contains(text(),'Optics')]/following-sibling::form[@class='personal-info__form']/div[@class='personal-info__row']/div[@class='personal-info__input-cont']//label[text()='FIRST NAME']/parent::div/parent::div[@class='personal-info__input-cont']/following-sibling::div//label[text()='LAST NAME']/parent::div//input[@type='text']");
	By custPhoneText = By.xpath("//ancestor::div[@id='root']//h1[contains (text(),'Exam Type')]/following-sibling::h2[contains (text(),'visit')]//following-sibling::h2[contains(text(),'Optics')]/following-sibling::form[@class='personal-info__form']/div[@class='personal-info__row']/div[@class='personal-info__input-cont']//label[text()='FIRST NAME']/parent::div/parent::div[@class='personal-info__input-cont']/following-sibling::div//label[text()='LAST NAME']/parent::div/ancestor::div[@class='personal-info__row']/following-sibling::div/div[@class='personal-info__input-cont']//label[text()='PHONE NUMBER']/parent::div//input[@type='tel']");
	By custEmailText = By.xpath("//ancestor::div[@id='root']//h1[contains (text(),'Exam Type')]/following-sibling::h2[contains (text(),'visit')]//following-sibling::h2[contains(text(),'Optics')]/following-sibling::form[@class='personal-info__form']/div[@class='personal-info__row']/div[@class='personal-info__input-cont']//label[text()='FIRST NAME']/parent::div/parent::div[@class='personal-info__input-cont']/following-sibling::div//label[text()='LAST NAME']/parent::div/ancestor::div[@class='personal-info__row']/following-sibling::div/div[@class='personal-info__input-cont']//label[text()='PHONE NUMBER']/ancestor::div[@class='personal-info__input-cont']/following-sibling::div//label[text()='EMAIL (Optional)']/parent::div//input[@type='email']");
	By reviewDetailsBtn = By.xpath("//ancestor::div[@id='root']//h1[contains (text(),'Exam Type')]/following-sibling::h2[contains (text(),'visit')]//following-sibling::h2[contains(text(),'Optics')]/following-sibling::form[@class='personal-info__form']/div[@class='personal-info__row']/div[@class='personal-info__input-cont']//label[text()='FIRST NAME']/parent::div/parent::div[@class='personal-info__input-cont']/following-sibling::div//label[text()='LAST NAME']/parent::div/ancestor::div[@class='personal-info__row']/following-sibling::div/div[@class='personal-info__input-cont']//label[text()='PHONE NUMBER']/ancestor::div[@class='personal-info__input-cont']/following-sibling::div//label[text()='EMAIL (Optional)']/ancestor::div[@class='personal-info__row']/following-sibling::div/button[text()='REVIEW DETAILS']");
	By confirmApptBtn = By.xpath("//button[@class='details__confirm']");
	By surveyQ1ChkBx = By.xpath("//span[text()='Night Driving']/preceding-sibling::span/span[@class='MuiIconButton-label']");
	By surveyQ2ChkBx = By.xpath("//span[text()='Yes']/preceding-sibling::span/span[@class='MuiIconButton-label']");
	By surveyQ3ChkBx = By.xpath("//span[text()='All the time']/preceding-sibling::span/span[@class='MuiIconButton-label']");
	By surveyQ4ChkBx = By.xpath("//span[text()='Less than 40']/preceding-sibling::span/span[@class='MuiIconButton-label']");
	By surveyQ5 = By.xpath("//li[@value='4']/textarea");
	By surveySubmitBtn = By.xpath("//button[text()='Submit']");
	By surveyCloseBtn = By.xpath("//button[text()='Close']");
	String surveyQ5Val = faker.rickAndMorty().quote().toString();

	
	
	public SchedulerUtils (WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickScheduleVisitBtn() {
		driver.findElement(scheduleVisitBtn).click();
	}
	
	public void clickAppointmentsBtn() {
		driver.findElement(appointmentsBtn).click();
	}
	
	public void clickVisitReasonDrp() {
		driver.findElement(visitReasonDrp).click();
	} 
	
	public void selectSunglasses() {
		driver.findElement(sunglassesReasonBy).click();
	}
	
	public void clickNextBtn() {
		driver.findElement(bookingNextBtn).click();
	}
	
	public void clickSlotBtn() {
		driver.findElement(slotBtn).click();
	}
	
	
	public void inputCustApptDetails() {
		driver.findElement(custPhoneText).sendKeys("555555555");
		driver.findElement(custEmailText).sendKeys("caryll.rola@ext.essilor.com");
		driver.findElement(reviewDetailsBtn).click();
		driver.findElement(confirmApptBtn).click();
	}
	
	public void survey() {
		driver.findElement(surveyQ1ChkBx).click();
		driver.findElement(surveyQ2ChkBx).click();
		driver.findElement(surveyQ3ChkBx).click();
		driver.findElement(surveyQ4ChkBx).click();
		driver.findElement(surveyQ5).sendKeys(surveyQ5Val);
		driver.findElement(surveySubmitBtn).click();
		driver.findElement(surveyCloseBtn).click();
	}
	
	public void clickNotifications() {
		driver.findElement(notificationsBtn).click();
	}
	
	
	// FOR TC4 TC5
	public void clickAddApttBtn() {
		 driver.findElement(addApptBtn).click();
	}
	
	public void inputFName() {
		driver.findElement(apptFirstNameText).sendKeys(apptFirstNameVal);
	}
	
	public void inputLName() {
		driver.findElement(apptLastNameText).sendKeys(apptLastNameVal);
	}
	
	// TC4
	public void inputWaitlistAppDetails() {
		driver.findElement(apptPhoneText).sendKeys("555555555");
		driver.findElement(apptPhoneText).sendKeys("caryll.rola@ext.essilor.com");
		driver.findElement(apptServiceDrp).click();
		driver.findElement(apptSelectSunglasses).click();
		driver.findElement(apptWaitListChkBx).click();
	}
	
	public void clickBookBtn() {
		driver.findElement(apptBookBtn).click();
	
	}

	
	// TC5
	public void inputNonWaitlistApptDetails() {
		
		driver.findElement(apptPhoneText).sendKeys("555555555");
		driver.findElement(apptPhoneText).sendKeys("caryll.rola@ext.essilor.com");
		driver.findElement(apptServiceDrp).click();
		driver.findElement(apptSelectSunglasses).click();
		driver.findElement(selectTimeDrp).click();
		driver.findElement(selecttime).sendKeys(Keys.chord(Keys.END));
		driver.findElement(selecttime).click();
	}

	
	public void clickCreatedAppt() {
		driver.findElement(createdApptNonWaitlistBtn).click();
	}

	
}
