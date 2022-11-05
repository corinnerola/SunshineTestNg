package commons;

import java.text.SimpleDateFormat;
import org.openqa.selenium.By;

import com.github.javafaker.Faker;

public class RegFormUtils {
	
	
	// GENERATE NAMES, NUMBERS AND DATES
	static Faker faker = new Faker();
	public static String refnumberVal = faker.number().digits(7);
	
	
	// DIGITAL PRESCRIPTION
	public static float sphValR = faker.number().numberBetween(-9, 0);
	public static float sphValL = faker.number().numberBetween(-9, 0);
	public static float cylValR =  faker.number().numberBetween(-4, 0);
	public static float cylValL =  faker.number().numberBetween(-4, 0);
	public static float axisValR = faker.number().numberBetween(0, 180);
	public static float axisValL = faker.number().numberBetween(0, 180);
	public static float pdValR = faker.number().numberBetween(10, 40);
	public static float pdValL = faker.number().numberBetween(10, 40);
	public static float htValR = faker.number().numberBetween(10, 40);
	public static float htValL = faker.number().numberBetween(10, 40);
	

	// COMMON XPATHS IN CUSTOMER DETAILS
    public static By emailInputText = By.xpath("//parent::div/div[@class='login']/section/following-sibling::section/div/h1/following-sibling::h3[@class='login-norm__subtitle']/following-sibling::form/div/div/fieldset/preceding-sibling::input[@type='text']");
	public static By passwordInputText = By.xpath("//ancestor::div/div[@class='login']/section/following-sibling::section/div/h1/following-sibling::h3[@class='login-norm__subtitle']/following-sibling::form/div/following-sibling::div/div/div/fieldset/preceding-sibling::input[@type='password']");
	public static By loginBtn = By.xpath("//ancestor::div/div[@class='login']/section/following-sibling::section/div/h1/following-sibling::h3[@class='login-norm__subtitle']/following-sibling::form/div/following-sibling::button[@class='login-norm__login']");
	public static By stellestBtn = By.xpath("//li/parent::ul[@class='admin-menu__items']/li/following-sibling::li[5]/button[@id='menu-add-stellest']");
	public static By cFirstNameText = By.xpath("//div[@class='MuiFormControl-root gender row-end']/preceding-sibling::div[7]/label[text()='Customer First Name']/following-sibling::div/input[@id='firstName']");
	public static By cLastNameText = By.xpath("//div[@class='MuiFormControl-root gender row-end']/preceding-sibling::div[6]/label[text()='Customer Last Name']/following-sibling::div/input[@id='lastName']");
	public static By cDOB = By.xpath("//div[@class='inputs']/div/following-sibling::div[contains (@class,'date-picker')]/div/input[@id='dob-picker']");
	public static By pNameText = By.xpath("//div[@class='MuiFormControl-root gender row-end']/preceding-sibling::div[3]/label/following-sibling::div/input[@id='guardian']");
	public static By pEmailText = By.xpath("//div[@class='MuiFormControl-root gender row-end']/preceding-sibling::div[2]/label/following-sibling::div/input[@id='email']");
	public static By pPhoneText = By.xpath("//div[@class='MuiFormControl-root gender row-end']/preceding-sibling::div[1]/label/following-sibling::div/input[@id='phone']");
	
	//COMMON XPATHS IN NEW ORDER
	public static By refNumberText = By.xpath("//ancestor::div[@id='stellest-form']/div/div[@class='eyebooknow-brand']/following-sibling::button[contains(@class,\"back-btn\")]/parent::div/following-sibling::div/div/following-sibling::div[contains(@class,\"patient-details-edit\")]/following-sibling::div[contains(@class,\"medical-details\")]/div[@class=\"left-col\"]/div[contains(@class,\"cs-comments\")]/preceding-sibling::div[contains (@class,\"product-picker\")]/following-sibling::div[2]/div[contains (@class,\"MuiInputBase-root\")]/input[@id='order-ref']");
	public static By sphRightText = By.xpath("//ancestor::div[@id='stellest-form']/div/div[@class='eyebooknow-brand']/following-sibling::button[contains(@class,\"back-btn\")]/parent::div/following-sibling::div/div/following-sibling::div[contains(@class,\"patient-details-edit\")]/following-sibling::div[contains(@class,\"medical-details\")]/div[@class=\"right-col\"]/div/div[@class='fields']/div[1]/div/div/input[@id='sphere-right']");
	public static By cylRightText = By.xpath("//ancestor::div[@id='stellest-form']/div/div[@class='eyebooknow-brand']/following-sibling::button[contains(@class,\"back-btn\")]/parent::div/following-sibling::div/div/following-sibling::div[contains(@class,\"patient-details-edit\")]/following-sibling::div[contains(@class,\"medical-details\")]/div[@class=\"right-col\"]/div/div[@class='fields']/div[1]/div/div/input[@id='cylinder-right']");
	public static By axisRightText = By.xpath("//ancestor::div[@id='stellest-form']/div/div[@class='eyebooknow-brand']/following-sibling::button[contains(@class,\"back-btn\")]/parent::div/following-sibling::div/div/following-sibling::div[contains(@class,\"patient-details-edit\")]/following-sibling::div[contains(@class,\"medical-details\")]/div[@class=\"right-col\"]/div/div[@class='fields']/div[1]/div/div/input[@id='axis-right']");
	public static By pdRightText = By.xpath("//ancestor::div[@id='stellest-form']/div/div[@class='eyebooknow-brand']/following-sibling::button[contains(@class,\"back-btn\")]/parent::div/following-sibling::div/div/following-sibling::div[contains(@class,\"patient-details-edit\")]/following-sibling::div[contains(@class,\"medical-details\")]/div[@class=\"right-col\"]/div/div[@class='fields']/div[1]/div/div/input[@id='pd-right']");
	public static By htRightText = By.xpath("//ancestor::div[@id='stellest-form']/div/div[@class='eyebooknow-brand']/following-sibling::button[contains(@class,\"back-btn\")]/parent::div/following-sibling::div/div/following-sibling::div[contains(@class,\"patient-details-edit\")]/following-sibling::div[contains(@class,\"medical-details\")]/div[@class=\"right-col\"]/div/div[@class='fields']/div[1]/div/div/input[@id='ht-right']");
	public static By sphLeftText = By.xpath("//ancestor::div[@id='stellest-form']/div/div[@class='eyebooknow-brand']/following-sibling::button[contains(@class,\"back-btn\")]/parent::div/following-sibling::div/div/following-sibling::div[contains(@class,\"patient-details-edit\")]/following-sibling::div[contains(@class,\"medical-details\")]/div[@class=\"right-col\"]/div/div[@class='fields']/div[2]/div/div/input[@id='sphere-left']");
	public static By cylLeftText = By.xpath("//ancestor::div[@id='stellest-form']/div/div[@class='eyebooknow-brand']/following-sibling::button[contains(@class,\"back-btn\")]/parent::div/following-sibling::div/div/following-sibling::div[contains(@class,\"patient-details-edit\")]/following-sibling::div[contains(@class,\"medical-details\")]/div[@class=\"right-col\"]/div/div[@class='fields']/div[2]/div/div/input[@id='cylinder-left']");
	public static By axisLeftText = By.xpath("//ancestor::div[@id='stellest-form']/div/div[@class='eyebooknow-brand']/following-sibling::button[contains(@class,\"back-btn\")]/parent::div/following-sibling::div/div/following-sibling::div[contains(@class,\"patient-details-edit\")]/following-sibling::div[contains(@class,\"medical-details\")]/div[@class=\"right-col\"]/div/div[@class='fields']/div[2]/div/div/input[@id='axis-left']");
	public static By pdLeftText = By.xpath("//ancestor::div[@id='stellest-form']/div/div[@class='eyebooknow-brand']/following-sibling::button[contains(@class,\"back-btn\")]/parent::div/following-sibling::div/div/following-sibling::div[contains(@class,\"patient-details-edit\")]/following-sibling::div[contains(@class,\"medical-details\")]/div[@class=\"right-col\"]/div/div[@class='fields']/div[2]/div/div/input[@id='pdL-left']");
	public static By htLeftText = By.xpath("//ancestor::div[@id='stellest-form']/div/div[@class='eyebooknow-brand']/following-sibling::button[contains(@class,\"back-btn\")]/parent::div/following-sibling::div/div/following-sibling::div[contains(@class,\"patient-details-edit\")]/following-sibling::div[contains(@class,\"medical-details\")]/div[@class=\"right-col\"]/div/div[@class='fields']/div[2]/div/div/input[@id='ht-left']");
	public static By submitBtn = By.xpath("//ancestor::div[@id='stellest-form']/div/div[@class='eyebooknow-brand']/following-sibling::button[contains(@class,\"back-btn\")]/parent::div/following-sibling::div/div/following-sibling::div[contains(@class,\"patient-details-edit\")]/following-sibling::div[contains(@class,\"medical-details\")]/following-sibling::div[@class='add-patient-container']/button[text()='Submit']");
	public static By closeBtn = By.xpath("//div[@class='success-container']/p/following-sibling::button[text()='Close']");
	public static By mediumDrp = By.xpath("//div[contains (@class, 'medical-details')]/h2[contains (text(), 'New Order')]/following-sibling::div[@class='left-col']/div[2]/div/div[contains (@id, 'order-submission-medium')]");
	public static By uploadPhotoList = By.xpath("//ul[@role='listbox']/li/following-sibling::li[contains (text(), 'Upload')]");
	public static By fileUpload = By.xpath("//div[@class='prescription-upload__workspace']/div[contains (text(), 'Photo Upload')]/following-sibling::div[contains (@class, 'workspace-surface')]/section[@class= 'dropzone']/input");
	public static By saveFileBtn = By.xpath("//div[@class='prescription-upload__workspace']/following-sibling::div[contains (@class, 'upload__controls')]/button[@id='prescription-upload__save']");
	public static By finishBtn = By.xpath("//div[contains (@class, 'MuiDialog-paperScrollPaper')]/div[@class='close-btn-container']/following-sibling::div[@id = 'simple-dialog-title']/following-sibling::div/following-sibling::div[contains (@class, 'MuiDialogActions')]/button[text()='FINISH']");
	//COMMON XPATHS IN ORDERS PAGE
	public static By viewOrderDetailsBtn = By.xpath("//tr[@index='0']/td[@value='[object Object]']/button[contains (text(), 'View Data')]");
	public static By viewOrderDetails = By.xpath("//div[contains (@class,'MuiAccordion-root')]");
	


	

}

	