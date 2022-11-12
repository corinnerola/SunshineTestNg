package commons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Login{

	WebDriver driver;
	WebDriverWait wait;

	// login page xpaths
	By emailInputText = By.xpath("//parent::div/div[@class='login']/section/following-sibling::section/div/h1/following-sibling::h3[@class='login-norm__subtitle']/following-sibling::form/div/div/fieldset/preceding-sibling::input[@type='text']");
	By passwordInputText = By.xpath("//ancestor::div/div[@class='login']/section/following-sibling::section/div/h1/following-sibling::h3[@class='login-norm__subtitle']/following-sibling::form/div/following-sibling::div/div/div/fieldset/preceding-sibling::input[@type='password']");
	By loginBtn = By.xpath("//ancestor::div/div[@class='login']/section/following-sibling::section/div/h1/following-sibling::h3[@class='login-norm__subtitle']/following-sibling::form/div/following-sibling::button[@class='login-norm__login']");

	// values
	String userEmail = "marc.marcella+SGSTAGEStellest06@ext.essilor.com";
	String userEmailAdmin = "laurencehanz.villamar+STGmyAUTO1@essilor.com";
	String password = "Abcd1234%^";
	
	public Login(WebDriver driver) {
		this.driver = driver;
		
	}



	public void verifyLoginToStellestCare() { 
		driver.findElement(emailInputText).sendKeys(userEmail);
		driver.findElement(passwordInputText).sendKeys(password);
		driver.findElement(loginBtn).click();

	}
	
	public void verifyLoginToAdminPage() {
		driver.findElement(emailInputText).sendKeys(userEmailAdmin);
		driver.findElement(passwordInputText).sendKeys(password);
		driver.findElement(loginBtn).click();
		
		
	}


}
