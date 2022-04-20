package baseclass.hotel;



import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassHotel {
	public static WebDriver driver;
	public static WebDriver browserlanch(String browserName) {
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();		}
		else if(browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();		}
		else {
			System.out.println("invalid Driver name");
			throw new WebDriverException();		}
		return driver;	}
	public static void urllanch(String url) {
		driver.get(url);
		driver.manage().window().maximize();	}
	public static void sendKeys(WebElement e,String value) {
		e.sendKeys(value);	}
	public static void datesendKeys(WebElement e,String value) {
		e.clear();
		e.sendKeys(value);	}
	public static void btnclick(WebElement e) {
		e.click();	}
	public static void select(WebElement e , int c) throws AWTException {
		e.click();
		Robot r =new Robot();
		for (int i = 0; i < c; i++) {
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);}
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);	}
	public static void implicitytime(long sec) {
		driver.manage().timeouts().implicitlyWait(sec,TimeUnit.SECONDS);
	}
	public static void quit() {
		driver.quit();
	}
	public static void maxmize() {
		driver.manage().window().maximize();

	}
	

}
