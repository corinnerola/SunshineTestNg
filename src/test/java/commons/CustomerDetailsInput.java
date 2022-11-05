package commons;

import java.text.SimpleDateFormat;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;

public class CustomerDetailsInput extends RegFormUtils {
	
	static WebDriver driver;
	WebDriverWait wait;
	static Faker faker = new Faker();
	
	static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	public static String randomDOB = sdf.format(faker.date().birthday(0, 17));
	
	public static void enterCustomerDetails(WebDriver driver) {
		
		// fill registration form
		driver.findElement(cFirstNameText).sendKeys(faker.pokemon().name().toString());
		driver.findElement(cLastNameText).sendKeys(faker.superhero().name().toString());
		driver.findElement(cDOB).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		driver.findElement(cDOB).sendKeys(randomDOB);
		driver.findElement(pNameText).sendKeys(faker.superhero().name());
		driver.findElement(pEmailText).sendKeys("caryll.rola@ext.essilor.com");
		driver.findElement(pPhoneText).sendKeys("555555555");
		
		
		
	}
}
