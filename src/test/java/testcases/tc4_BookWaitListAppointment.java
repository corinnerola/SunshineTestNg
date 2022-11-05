package testcases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

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

public class tc4_BookWaitListAppointment extends SchedulerUtils{
	
	static WebDriver driver;
	static WebDriverWait wait;
	
	Faker faker = new Faker();
	
	@BeforeTest
	public static void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://staging-admin.eyebooknow.com");
	}
	

	@Test
	public void loginToStellest () {
		//login
		Login.verifyLoginToAdminPage(driver); 																		//call method to login		
	}
	
	@Test
	public void bookWaitListAppointment() {
		
		driver.findElement(addApptBtn).click();
		driver.findElement(apptFirstNameText).sendKeys(faker.funnyName().toString());
		driver.findElement(apptLastNameText).sendKeys(faker.funnyName().toString());
		driver.findElement(apptPhoneText).sendKeys("555555555");
		driver.findElement(apptServiceDrp).click();
		driver.findElement(apptServiceList).click();
		driver.findElement(apptWaitListChkBx).click();
		driver.findElement(apptBookBtn).click();
		
		
		
	}


}
