package commons;

import java.security.spec.DSAGenParameterSpec;
import java.text.SimpleDateFormat;
import java.time.Duration;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v101.systeminfo.model.VideoDecodeAcceleratorCapability;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;

public class RegFormUtils {
	

	WebDriver driver;
	WebDriverWait wait;
	

	
	// GENERATE NAMES, NUMBERS AND DATES
	Faker faker = new Faker();
	public String refnumberVal = faker.number().digits(7);
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	public String randomDOB = sdf.format(faker.date().birthday(0, 17));
	
	
	// DIGITAL PRESCRIPTION
	public float sphValR = faker.number().numberBetween(-9, 0);
	public float sphValL = faker.number().numberBetween(-9, 0);
	public float cylValR =  faker.number().numberBetween(-4, 0);
	public float cylValL =  faker.number().numberBetween(-4, 0);
	public float axisValR = faker.number().numberBetween(0, 180);
	public float axisValL = faker.number().numberBetween(0, 180);
	public float pdValR = faker.number().numberBetween(10, 40);
	public float pdValL = faker.number().numberBetween(10, 40);
	public float htValR = faker.number().numberBetween(10, 40);
	public float htValL = faker.number().numberBetween(10, 40);
	

	// COMMON XPATHS IN CUSTOMER DETAILS 

	public By stellestBtn = By.xpath("//li/parent::ul[@class='admin-menu__items']/li/following-sibling::li[5]/button[@id='menu-add-stellest']");
	By cFirstNameText = By.xpath("//div[@class='MuiFormControl-root gender row-end']/preceding-sibling::div[7]/label[text()='Customer First Name']/following-sibling::div/input[@id='firstName']");
	By cLastNameText = By.xpath("//div[@class='MuiFormControl-root gender row-end']/preceding-sibling::div[6]/label[text()='Customer Last Name']/following-sibling::div/input[@id='lastName']");
	By cDOB = By.xpath("//div[@class='inputs']/div/following-sibling::div[contains (@class,'date-picker')]/div/input[@id='dob-picker']");
	By pNameText = By.xpath("//div[@class='MuiFormControl-root gender row-end']/preceding-sibling::div[3]/label/following-sibling::div/input[@id='guardian']");
	By pEmailText = By.xpath("//div[@class='MuiFormControl-root gender row-end']/preceding-sibling::div[2]/label/following-sibling::div/input[@id='email']");
	By pPhoneText = By.xpath("//div[@class='MuiFormControl-root gender row-end']/preceding-sibling::div[1]/label/following-sibling::div/input[@id='phone']");
	
	//COMMON XPATHS IN NEW ORDER
	By refNumberText = By.xpath("//ancestor::div[@id='stellest-form']/div/div[@class='eyebooknow-brand']/following-sibling::button[contains(@class,\"back-btn\")]/parent::div/following-sibling::div/div/following-sibling::div[contains(@class,\"patient-details-edit\")]/following-sibling::div[contains(@class,\"medical-details\")]/div[@class=\"left-col\"]/div[contains(@class,\"cs-comments\")]/preceding-sibling::div[contains (@class,\"product-picker\")]/following-sibling::div[2]/div[contains (@class,\"MuiInputBase-root\")]/input[@id='order-ref']");
	By sphRightText = By.xpath("//ancestor::div[@id='stellest-form']/div/div[@class='eyebooknow-brand']/following-sibling::button[contains(@class,\"back-btn\")]/parent::div/following-sibling::div/div/following-sibling::div[contains(@class,\"patient-details-edit\")]/following-sibling::div[contains(@class,\"medical-details\")]/div[@class=\"right-col\"]/div/div[@class='fields']/div[1]/div/div/input[@id='sphere-right']");
	By cylRightText = By.xpath("//ancestor::div[@id='stellest-form']/div/div[@class='eyebooknow-brand']/following-sibling::button[contains(@class,\"back-btn\")]/parent::div/following-sibling::div/div/following-sibling::div[contains(@class,\"patient-details-edit\")]/following-sibling::div[contains(@class,\"medical-details\")]/div[@class=\"right-col\"]/div/div[@class='fields']/div[1]/div/div/input[@id='cylinder-right']");
	By axisRightText = By.xpath("//ancestor::div[@id='stellest-form']/div/div[@class='eyebooknow-brand']/following-sibling::button[contains(@class,\"back-btn\")]/parent::div/following-sibling::div/div/following-sibling::div[contains(@class,\"patient-details-edit\")]/following-sibling::div[contains(@class,\"medical-details\")]/div[@class=\"right-col\"]/div/div[@class='fields']/div[1]/div/div/input[@id='axis-right']");
	By pdRightText = By.xpath("//ancestor::div[@id='stellest-form']/div/div[@class='eyebooknow-brand']/following-sibling::button[contains(@class,\"back-btn\")]/parent::div/following-sibling::div/div/following-sibling::div[contains(@class,\"patient-details-edit\")]/following-sibling::div[contains(@class,\"medical-details\")]/div[@class=\"right-col\"]/div/div[@class='fields']/div[1]/div/div/input[@id='pd-right']");
	By htRightText = By.xpath("//ancestor::div[@id='stellest-form']/div/div[@class='eyebooknow-brand']/following-sibling::button[contains(@class,\"back-btn\")]/parent::div/following-sibling::div/div/following-sibling::div[contains(@class,\"patient-details-edit\")]/following-sibling::div[contains(@class,\"medical-details\")]/div[@class=\"right-col\"]/div/div[@class='fields']/div[1]/div/div/input[@id='ht-right']");
	By sphLeftText = By.xpath("//ancestor::div[@id='stellest-form']/div/div[@class='eyebooknow-brand']/following-sibling::button[contains(@class,\"back-btn\")]/parent::div/following-sibling::div/div/following-sibling::div[contains(@class,\"patient-details-edit\")]/following-sibling::div[contains(@class,\"medical-details\")]/div[@class=\"right-col\"]/div/div[@class='fields']/div[2]/div/div/input[@id='sphere-left']");
	By cylLeftText = By.xpath("//ancestor::div[@id='stellest-form']/div/div[@class='eyebooknow-brand']/following-sibling::button[contains(@class,\"back-btn\")]/parent::div/following-sibling::div/div/following-sibling::div[contains(@class,\"patient-details-edit\")]/following-sibling::div[contains(@class,\"medical-details\")]/div[@class=\"right-col\"]/div/div[@class='fields']/div[2]/div/div/input[@id='cylinder-left']");
	By axisLeftText = By.xpath("//ancestor::div[@id='stellest-form']/div/div[@class='eyebooknow-brand']/following-sibling::button[contains(@class,\"back-btn\")]/parent::div/following-sibling::div/div/following-sibling::div[contains(@class,\"patient-details-edit\")]/following-sibling::div[contains(@class,\"medical-details\")]/div[@class=\"right-col\"]/div/div[@class='fields']/div[2]/div/div/input[@id='axis-left']");
	By pdLeftText = By.xpath("//ancestor::div[@id='stellest-form']/div/div[@class='eyebooknow-brand']/following-sibling::button[contains(@class,\"back-btn\")]/parent::div/following-sibling::div/div/following-sibling::div[contains(@class,\"patient-details-edit\")]/following-sibling::div[contains(@class,\"medical-details\")]/div[@class=\"right-col\"]/div/div[@class='fields']/div[2]/div/div/input[@id='pdL-left']");
	By htLeftText = By.xpath("//ancestor::div[@id='stellest-form']/div/div[@class='eyebooknow-brand']/following-sibling::button[contains(@class,\"back-btn\")]/parent::div/following-sibling::div/div/following-sibling::div[contains(@class,\"patient-details-edit\")]/following-sibling::div[contains(@class,\"medical-details\")]/div[@class=\"right-col\"]/div/div[@class='fields']/div[2]/div/div/input[@id='ht-left']");
	By submitBtn = By.xpath("//ancestor::div[@id='stellest-form']/div/div[@class='eyebooknow-brand']/following-sibling::button[contains(@class,\"back-btn\")]/parent::div/following-sibling::div/div/following-sibling::div[contains(@class,\"patient-details-edit\")]/following-sibling::div[contains(@class,\"medical-details\")]/following-sibling::div[@class='add-patient-container']/button[text()='Submit']");
	By closeBtn = By.xpath("//div[@class='success-container']/p/following-sibling::button[text()='Close']");
	By mediumDrp = By.xpath("//div[contains (@class, 'medical-details')]/h2[contains (text(), 'New Order')]/following-sibling::div[@class='left-col']/div[2]/div/div[contains (@id, 'order-submission-medium')]");
	By uploadPhotoList = By.xpath("//ul[@role='listbox']/li/following-sibling::li[contains (text(), 'Upload')]");
	public By fileUpload = By.xpath("//div[@class='prescription-upload__workspace']/div[contains (text(), 'Photo Upload')]/following-sibling::div[contains (@class, 'workspace-surface')]/section[@class= 'dropzone']/input");
	By saveFileBtn = By.xpath("//div[@class='prescription-upload__workspace']/following-sibling::div[contains (@class, 'upload__controls')]/button[@id='prescription-upload__save']");
	By finishBtn = By.xpath("//div[contains (@class, 'MuiDialog-paperScrollPaper')]/div[@class='close-btn-container']/following-sibling::div[@id = 'simple-dialog-title']/following-sibling::div/following-sibling::div[contains (@class, 'MuiDialogActions')]/button[text()='FINISH']");
	//COMMON XPATHS IN ORDERS PAGE
	By viewOrderDetailsBtn = By.xpath("//tr[@index='0']/td[@value='[object Object]']/button[contains (text(), 'View Data')]");
	By viewOrderDetails = By.xpath("//div[contains (@class,'MuiAccordion-root')]");
	
	public RegFormUtils (WebDriver driver) {
		this.driver = driver;
	}

	
	public RegFormUtils enterCustomerDetails() {
		
		// fill registration form
		driver.findElement(cFirstNameText).sendKeys(faker.pokemon().name().toString());
		driver.findElement(cLastNameText).sendKeys(faker.superhero().name().toString());
		driver.findElement(cDOB).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		driver.findElement(cDOB).sendKeys(randomDOB);
		driver.findElement(pNameText).sendKeys(faker.superhero().name());
		driver.findElement(pEmailText).sendKeys("caryll.rola@ext.essilor.com");
		driver.findElement(pPhoneText).sendKeys("555555555");
		
		return this;
	}
	
	public RegFormUtils clickStellestBtn() {
		driver.findElement(stellestBtn).click();
		return this;
	}
	
	public WebElement inputRefNo() {
		return driver.findElement(refNumberText);
	}
	
	public WebElement inputSphR(){
		return driver.findElement(sphRightText);				
	}
	
	public WebElement inputSphL(){
		return driver.findElement(sphLeftText);		
	}
	
	public WebElement inputCylR() {
		return driver.findElement(cylRightText);	
	}
	
	public WebElement inputCylL() {
		return driver.findElement(cylLeftText);
	}
	
	public WebElement inputAxisR() {
		return driver.findElement(axisRightText);
	}
	
	public WebElement inputAxisL() {
		return driver.findElement(axisLeftText);
	}
	
	public WebElement inputPdR () {
		return driver.findElement(pdRightText);
	}
	
	public WebElement inputPdL () {
		return driver.findElement(pdLeftText);
	}
	
	public WebElement inputHtR() {
		return driver.findElement(htRightText);
	}
	
	public WebElement inputHtL() {
		return driver.findElement(htLeftText);		
	}
	
	public RegFormUtils clickSubmitBtn() {
		driver.findElement(submitBtn).click();
		return this;
	}
	
	public RegFormUtils clickCloseBtn() {
		driver.findElement(closeBtn).click();
		return this;
	}
	
	public RegFormUtils clickViewOrderDetails() {
		driver.findElement(viewOrderDetailsBtn).click();
		return this;
	}
	
	public RegFormUtils clickOrderDetailsDrp() {
		driver.findElement(viewOrderDetails).click();	
		return this;
	}
	
	public RegFormUtils clickMediumDrp() {
		driver.findElement(mediumDrp).click();
		return this;
	}
	
	public RegFormUtils clickUploadPhotoList() {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(uploadPhotoList));
		driver.findElement(uploadPhotoList).click();
		return this;
	}
	public RegFormUtils clickSaveFleBtn() {
		driver.findElement(saveFileBtn).click();
		return this;
	}
	
	public RegFormUtils clickFinishBtn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(finishBtn));
		driver.findElement(finishBtn).click();
		return this;
	}
	
}

	