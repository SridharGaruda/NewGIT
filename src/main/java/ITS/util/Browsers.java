package ITS.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browsers {
public static void main(String[] args) throws InterruptedException {
	//Launching browser without specifying driver path
	WebDriver driver = new ChromeDriver();
	driver.get("https://ubstest1.auminfotech.in");
	System.out.println(driver.getTitle());
	Thread.sleep(2000);
	System.out.println(driver.getTitle());
}
}
