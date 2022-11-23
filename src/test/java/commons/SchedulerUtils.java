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
	
	public String apptFirstNameVal = faker.funnyName().name().toString();
	public String apptLastNameVal = faker.funnyName().name().toString();
	public By createdApptNonWaitlistSpan = By.xpath("//div[@class='cal-appttooltip__body-right']/p[1]");	
	public By createdAppt = By.xpath("//div[@class='cal-queue']//div[@class='cal-queue__item'][last()]/div[@class='cal-queue__details']/span[1]");
	public By apptFirstNameText = By.xpath("//button[text()='Book']/parent::div[@class='cal-newappt__group']/parent::div[@class='cal-newappt']/div/following-sibling::div/div[contains (@class, 'cal-newappt__input')]/label[text()='First Name']/parent::div/div/input[@type='text']");
	
	By addApptBtn = By.xpath("//button[@id='menu-add-appointment']");
	By apptLastNameText = By.xpath("//button[text()='Book']/parent::div[@class='cal-newappt__group']/parent::div[@class='cal-newappt']/div/following-sibling::div/div[contains (@class, 'cal-newappt__input')]/label[text()='Last Name']/parent::div/div/input[@type='text']");
	By apptPhoneText = By.xpath("//button[text()='Book']/parent::div[@class='cal-newappt__group']/parent::div[@class='cal-newappt']/div/following-sibling::div[2]/div[contains (@class, 'cal-newappt__input')]/label[text()='Phone']/parent::div/div/input[@type='phone']");
	By appEmailTextBy = By.xpath("//button[text()='Book']/parent::div[@class='cal-newappt__group']/parent::div[@class='cal-newappt']/div/following-sibling::div[2]/div[contains (@class, 'cal-newappt__input')]/label[text()='Email']/parent::div/div/input[@type='text']");
	By apptServiceDrp = By.xpath("//div[@id='cal-newappt-appttype']");
	By apptSelectSunglasses = By.xpath("//li[text()='Sunglasses']/ancestor::div[@id='menu-']/div/following-sibling::div[contains(@class, \"MuiMenu-paper\")]/ul[@role='listbox']");
	By apptWaitListChkBx = By.xpath("//button[text()='Book']/parent::div[@class='cal-newappt__group']/parent::div[@class='cal-newappt']/div/following-sibling::div[contains (@class, 'group--waitlist')]/label[@class='MuiFormControlLabel-root']/span[contains (@class, 'MuiCheckbox')]/span/input[@type='checkbox']");
	By apptBookBtn = By.xpath("//button[text()='Book']/parent::div[@class='cal-newappt__group']/parent::div[@class='cal-newappt']/div/following-sibling::div[contains (@class, 'group--waitlist')]/label[@class='MuiFormControlLabel-root']/span[contains (@class, 'MuiCheckbox')]/span/input[@type='checkbox']/ancestor::div[contains(@class, 'waitlist')]/following-sibling::div[@class='cal-newappt__group']/button[@class='cal-newappt__book']");

	By selectTimeDrp = By.xpath("//label[text()='Time']/following-sibling::div/div[contains(@class,'MuiSelect-selectMenu')]");
	By selecttime = By.xpath("//ul[contains(@class,'MuiMenu-list')]/li[text()='10:00 PM']");
	By createdApptNonWaitlistBtn = By.xpath("//span[text()='10:00 pm']/ancestor::div[contains(@class,'MuiGrid-container')]/following-sibling::div//div[@class='cal-appt-cont'][last()]");
	
	public SchedulerUtils (WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickAddApttBtn() {
		 driver.findElement(addApptBtn).click();
	}
	
	public void inputFName() {
		driver.findElement(apptFirstNameText).sendKeys(apptFirstNameVal);
	}
	
	public void inputLName() {
		driver.findElement(apptLastNameText).sendKeys(apptLastNameVal);
	}
	
	public void inputPhoneNumber() {
		driver.findElement(apptPhoneText).sendKeys("555555555");
	}
	
	public void inputEmail() {
		driver.findElement(apptPhoneText).sendKeys("caryll.rola@ext.essilor.com");
	}
	
	public void clickBookBtn() {
		driver.findElement(apptBookBtn).click();
	
	}
	public void clickService() {
		driver.findElement(apptServiceDrp).click();
	}
	
	public void clickSunglasses() {
		driver.findElement(apptSelectSunglasses).click();
	}
	
	public void selectWaitlist() {
		driver.findElement(apptWaitListChkBx).click();
	}
	
	public void clickTimeDropdown() {
		driver.findElement(selectTimeDrp).click();
	}
	
	public By selectTime() {
		driver.findElement(selecttime).sendKeys(Keys.chord(Keys.END));
		driver.findElement(selecttime).click();
		return selecttime;
	}
	
	public void clickCreatedAppt() {
		driver.findElement(createdApptNonWaitlistBtn).click();
	}

	
}
