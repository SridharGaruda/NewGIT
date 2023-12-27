package ITS.util;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericWaitCode {

	static WebDriver driver;

	public static void login() {
		driver = new ChromeDriver();

		// implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		WebElement ele = driver.findElement(By.name("firstname"));
		SendKeys(driver, ele, 2, "tom");
		ClickOn(driver, ele, 10);

	}

//Generic code for explicit wait	
//Generic code for entering data for text field
	public static void SendKeys(WebDriver driver, WebElement element, int timeout, String value) {
		new WebDriverWait(driver, Duration.ofSeconds(timeout)).until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(value);
	}

//Generic code for click
	public static void ClickOn(WebDriver driver, WebElement element, int timeout) {
		new WebDriverWait(driver, Duration.ofSeconds(timeout)).until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
}
