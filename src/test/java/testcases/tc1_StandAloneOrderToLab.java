package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import commons.*;

/* 
 * +----------------------------------------------------------------------------+
 * | AUTOMATION TEST CASE FOR:													|
 * |																			|
 * | Scenario 1: SCENARIO 1: Submit a Stellest Lenses (Standalone) Order to Lab |
 * +----------------------------------------------------------------------------+
 */

public class tc1_StandAloneOrderToLab  {


	WebDriver driver;
	WebDriverWait wait;

	@BeforeTest
	public void setup() {

		DriverSetup ds = new DriverSetup();
		driver = ds.setupDriver();
		wait = ds.setupDriverWait(driver);
		driver.get("https://staging-admin.eyebooknow.com");
	}

	@Test
	public void loginToStellest() {
		// login
		Login login = new Login(driver);
		login.verifyLoginToStellestCare(); // call method to login
	}

	@Test
	public void submitStandAloneOrderToLab() throws InterruptedException {

		RegFormUtils rfUtils = new RegFormUtils(driver);

		wait.until(ExpectedConditions.visibilityOfElementLocated(rfUtils.stellestBtn));
		rfUtils.clickStellestBtn(); // click stellest button

		rfUtils.enterCustomerDetails(); // call method for customer details input
		rfUtils.inputRefNo().sendKeys(rfUtils.refnumberVal);
		
		// input Digital Prescription
		rfUtils.inputSphR().sendKeys(Float.toString(rfUtils.sphValR));
		rfUtils.inputSphL().sendKeys(Float.toString(rfUtils.sphValL));
		rfUtils.inputCylR().sendKeys(Float.toString(rfUtils.cylValR));
		rfUtils.inputCylL().sendKeys(Float.toString	(rfUtils.cylValL));
		rfUtils.inputAxisR().sendKeys(Float.toString(rfUtils.axisValR));
		rfUtils.inputAxisL().sendKeys(Float.toString(rfUtils.axisValL));
		rfUtils.inputPdR().sendKeys(Float.toString(rfUtils.pdValR));
		rfUtils.inputPdL().sendKeys(Float.toString(rfUtils.pdValL));
		rfUtils.inputHtR().sendKeys(Float.toString(rfUtils.htValR));
		rfUtils.inputHtL().sendKeys(Float.toString(rfUtils.htValL));

		rfUtils.clickSubmitBtn(); // submit order

		SoftAssert softAssertion = new SoftAssert();
		softAssertion.assertEquals(driver.findElement(By.xpath("//div[@class='success-container']/h2")).getText(),
				"Success!"); // success order checking
		softAssertion.assertAll();

		rfUtils.clickCloseBtn();
		
		
		rfUtils.clickViewOrderDetails(); // click the order created to view details
		rfUtils.clickOrderDetailsDrp(); // collapse area to expand details
		Thread.sleep(5000); // for viewwing purposes lol

	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}

}
