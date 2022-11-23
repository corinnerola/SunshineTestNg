package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import commons.DriverSetup;
import commons.Login;
import commons.RegFormUtils;

/* 
 * +----------------------------------------------------------------------------+
 * | AUTOMATION TEST CASE FOR:													|
 * |																			|
 * | Scenario 2: SCENARIO 2: Submit a Stellest Lenses (Standalone) Order to CSR |
 * +----------------------------------------------------------------------------+
 */

public class tc2_StandAloneOrderToCSR {

	WebDriver driver;
	WebDriverWait wait;
	

	@BeforeTest
	public void setup() {

		DriverSetup ds = new DriverSetup();
		driver = ds.setupDriver();
		wait = ds.setupDriverWait(driver);
		driver.get("https://staging-admin.eyebooknow.com");

	}

	@Test(priority = 1)
	public void loginToStellest() {
		// login
		Login login = new Login(driver);
		login.verifyLoginToStellestCare(); // call method to login
	}

	@Test(priority = 2)
	public void submitStandAloneOrderToCSR() throws InterruptedException {

		RegFormUtils rfUtils = new RegFormUtils(driver);

		wait.until(ExpectedConditions.visibilityOfElementLocated(rfUtils.stellestBtn));
		
		rfUtils.clickStellestBtn(); // click stellest button
		rfUtils.getCustomerDetails(); // call method for customer details input
		rfUtils.inputRefNo();
		rfUtils.clickMediumDrp();		
		rfUtils.clickUploadRx();
		rfUtils.uploadRx();
		rfUtils.clickSaveFleBtn();
		rfUtils.clickFinishBtn();
		rfUtils.clickSubmitBtn();
		rfUtils.clickCloseBtn();
		rfUtils.clickViewOrderDetails(); // click the order created to view details

	}

	@Test(priority = 3)
	public void completeOrder() throws InterruptedException {

		RegFormUtils rfUtils = new RegFormUtils(driver);


		for (int i = 0; i <= 2; i++) {
			try {
				rfUtils.clickMediumDrp();
				break;
			} catch (Exception e) {
				System.out.print(e.getMessage());
			}
		}

		rfUtils.clickDigitalRx();
		rfUtils.inputDigitalRx();
		rfUtils.clickSubmitBtn(); // submit order

		SoftAssert softAssertion = new SoftAssert();
		softAssertion.assertEquals(driver.findElement(By.xpath("//div[@class='success-container']/h2")).getText(),
				"Success!"); // success order checking
		softAssertion.assertAll();

		rfUtils.clickCloseBtn();
		rfUtils.clickViewOrderDetails(); // click the order created to view details
		rfUtils.clickOrderDetailsDrp(); // collapse area to expand details

	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}

}
