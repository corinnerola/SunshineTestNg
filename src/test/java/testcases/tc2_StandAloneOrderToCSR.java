package testcases;

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

	@Test
	public void loginToStellest() {
		// login
		Login login = new Login(driver);
		login.verifyLoginToStellestCare(); // call method to login
	}

	@Test
	public void submitStandAloneOrderToCSR() throws InterruptedException {

		RegFormUtils rfUtils = new RegFormUtils(driver);

		wait.until(ExpectedConditions.visibilityOfElementLocated(rfUtils.stellestBtn));
		rfUtils.clickStellestBtn(); // click stellest button

		rfUtils.enterCustomerDetails(); // call method for customer details input
		rfUtils.inputRefNo().sendKeys(rfUtils.refnumberVal);

		rfUtils.clickUploadPhotoList();

		driver.findElement(rfUtils.fileUpload).sendKeys(fileToUpload);

		rfUtils.clickSaveFleBtn();

		rfUtils.clickFinishBtn();

		rfUtils.clickSubmitBtn();

		rfUtils.clickCloseBtn();

		rfUtils.clickViewOrderDetails(); // click the order created to view details
		Thread.sleep(5000); // for viewwing purposes lol

	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}

}
