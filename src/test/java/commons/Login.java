package commons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Login{

	static WebDriver driver;

	// login page xpaths
	public static By emailInputText = By.xpath("//ancestor::form[@class='login-norm__form']//input[@type='text']");
	public static By passwordInputText = By.xpath("//ancestor::div[@class='login-norm__group']//input[@type='password']");
	public static By loginBtn = By.xpath("//ancestor::form[@class='login-norm__form']//button[@class='login-norm__login']");

	// values
	public static String userEmail[] = {"marc.marcella+SGSTAGEStellest06@ext.essilor.com", "laurencehanz.villamar+STGmyAUTO1@essilor.com"};
	public static String password = "Abcd1234%^";
	


	public static void verifyLoginToStellestCare(WebDriver driver) {
		driver.findElement(emailInputText).sendKeys(userEmail[0]);
		driver.findElement(passwordInputText).sendKeys(password);
		driver.findElement(loginBtn).click();

	}
	
	public static void verifyLoginToAdminPage(WebDriver driver) {
		driver.findElement(emailInputText).sendKeys(userEmail[1]);
		driver.findElement(passwordInputText).sendKeys(password);
		driver.findElement(loginBtn).click();
		
		
	}

}
