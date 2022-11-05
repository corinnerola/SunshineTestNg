package commons;

import org.openqa.selenium.By;


public class SchedulerUtils {
	
	public  By addApptBtn = By.xpath("//div[@class='cal-queue__item']/parent::div[contains (@class,'mobile__queue')]/ancestor::section[@class='scheduler']/preceding-sibling::section[@class='menu']/div/div[@class='admin-menu__menu']/div/following-sibling::div/ul[@class='admin-menu__items']/li[4]/button[@id='menu-add-appointment']");
	public  By apptFirstNameText = By.xpath("//button[text()='Book']/parent::div[@class='cal-newappt__group']/parent::div[@class='cal-newappt']/div/following-sibling::div/div[contains (@class, 'cal-newappt__input')]");
	public  By apptLastNameText = By.xpath("//button[text()='Book']/parent::div[@class='cal-newappt__group']/parent::div[@class='cal-newappt']/div/following-sibling::div/div[contains (@class, 'cal-newappt__input')]/following-sibling::div[contains (@class, 'cal-newappt__input')]");
	public  By apptPhoneText = By.xpath("//button[text()='Book']/parent::div[@class='cal-newappt__group']/parent::div[@class='cal-newappt']/div/following-sibling::div[2]/div[contains (@class, 'cal-newappt__input')]");
	public  By apptServiceDrp = By.xpath("//button[text()='Book']/parent::div[@class='cal-newappt__group']/parent::div[@class='cal-newappt']/div/following-sibling::div[2]/div/label[text()='Email']/parent::div");
	public  By apptWaitListChkBx = By.xpath("//button[text()='Book']/parent::div[@class='cal-newappt__group']/parent::div[@class='cal-newappt']/div/following-sibling::div[contains (@class, 'group--waitlist')]/label[@class='MuiFormControlLabel-root']/span[contains (@class, 'MuiCheckbox')]");
	public  By apptBookBtn = By.xpath("//h2[text()='New Appointment Details']/ancestor::div[@class='cal-newappt']/div/div/label[text()='First Name']/parent::div/parent::div[@class='cal-newappt__group']/following-sibling::div/div/label[text()='Service']/parent::div[contains (@class, 'newappt__ctrl')]/parent::div/following-sibling::div[3]/button[text()='Book']");
	public  By apptServiceList = By.xpath("//div[contains (@class, 'MuiPopover-paper')]/ul[@role='listbox']/li[text()='Sunglasses']");


	

}
