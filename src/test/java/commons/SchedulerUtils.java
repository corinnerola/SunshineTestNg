package commons;

import java.time.Duration;

import javax.sound.midi.VoiceStatus;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;

public class SchedulerUtils {
	
	WebDriver driver;
	WebDriverWait wait;
	
	By addApptBtn = By.xpath("//button[@id='menu-add-appointment']");
	public By apptFirstNameText = By.xpath("//button[text()='Book']/parent::div[@class='cal-newappt__group']/parent::div[@class='cal-newappt']/div/following-sibling::div/div[contains (@class, 'cal-newappt__input')]");
	public By apptLastNameText = By.xpath("//button[text()='Book']/parent::div[@class='cal-newappt__group']/parent::div[@class='cal-newappt']/div/following-sibling::div/div[contains (@class, 'cal-newappt__input')]/following-sibling::div[contains (@class, 'cal-newappt__input')]");
	public By apptPhoneText = By.xpath("//button[text()='Book']/parent::div[@class='cal-newappt__group']/parent::div[@class='cal-newappt']/div/following-sibling::div[2]/div[contains (@class, 'cal-newappt__input')]");
	public By apptServiceDrp = By.xpath("//button[text()='Book']/parent::div[@class='cal-newappt__group']/parent::div[@class='cal-newappt']/div/following-sibling::div[2]/div/label[text()='Email']/parent::div");
	public By apptWaitListChkBx = By.xpath("//button[text()='Book']/parent::div[@class='cal-newappt__group']/parent::div[@class='cal-newappt']/div/following-sibling::div[contains (@class, 'group--waitlist')]/label[@class='MuiFormControlLabel-root']/span[contains (@class, 'MuiCheckbox')]");
	public By apptBookBtn = By.xpath("//h2[text()='New Appointment Details']/ancestor::div[@class='cal-newappt']/div/div/label[text()='First Name']/parent::div/parent::div[@class='cal-newappt__group']/following-sibling::div/div/label[text()='Service']/parent::div[contains (@class, 'newappt__ctrl')]/parent::div/following-sibling::div[3]/button[text()='Book']");
	public By apptServiceList = By.xpath("//div[contains (@class, 'MuiPopover-paper')]/ul[@role='listbox']/li[text()='Sunglasses']");

	public SchedulerUtils (WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickAddApttBtn() {
		driver.findElement(addApptBtn).click();
		
	}
	
	public void clickBookBtn() {
		driver.findElement(apptBookBtn).click();
	
	}
}
