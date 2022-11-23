package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

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
	String fileToUpload = "C:\\Users\\caryll.rola\\Downloads\\download.jpg";

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
		rfUtils.inputRefNo().sendKeys(rfUtils.refnumberVal);

		rfUtils.clickMediumDrp();
		rfUtils.clickUploadRx();

		driver.findElement(rfUtils.fileUpload).sendKeys(fileToUpload);

		rfUtils.clickSaveFleBtn();

		rfUtils.clickFinishBtn();

		rfUtils.clickSubmitBtn();

		rfUtils.clickCloseBtn();

		rfUtils.clickViewOrderDetails(); // click the order created to view details

	}

	@Test(priority = 3)
	public void completeOrder() throws InterruptedException {

		RegFormUtils rfUtils = new RegFormUtils(driver);

		tc1_StandAloneOrderToLab tc1 = new tc1_StandAloneOrderToLab(driver);

		for (int i = 0; i <= 2; i++) {
			try {
				rfUtils.clickMediumDrp();
				break;
			} catch (Exception e) {
				System.out.print(e.getMessage());
			}
		}

		rfUtils.clickDigitalRx();
		tc1.inputDigitalRx();

		tc1.submitAndViewOrder();

	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}

}
