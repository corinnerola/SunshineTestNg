package commons;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;



public class DriverSetup {
	
	
	public WebDriver setupDriver() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		
		return driver;
	}
	
	public WebDriverWait setupDriverWait(WebDriver driverReq) {
		WebDriverWait wait = new WebDriverWait(driverReq, Duration.ofSeconds(20));
		
		return wait;
	}
	

}
