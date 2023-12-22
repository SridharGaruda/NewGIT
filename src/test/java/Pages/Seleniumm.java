package Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Seleniumm {
	
	static WebDriverWait wait;
	
	public static void LaunchBrowser() {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver Driver = new ChromeDriver();
		wait = new WebDriverWait(Driver, Duration.ofSeconds(10));
		Driver.manage().window().maximize();
		Driver.get("https://ubstest1.auminfotech.in/VTS/");
	}
	public static void main(String[] args) {
		Seleniumm.LaunchBrowser();
	}
}
