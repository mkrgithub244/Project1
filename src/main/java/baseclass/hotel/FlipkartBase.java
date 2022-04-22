package baseclass.hotel;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlipkartBase {
	public static WebDriver driver; // static varible not req to create obj for class//

	public static WebDriver lanchbrowser(String browsername) {
		if (browsername.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browsername.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if (browsername.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		return driver;
	}
	public static void lanchUrl(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}
	public static void implicitywait(long sec) {
		driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
	}
	public static void sendKeys(WebElement e, String Value) {
		e.sendKeys(Value);
	}
	public static void btnclick(WebElement e) {
		e.click();
	}
	public static void quitBrowser() {
		driver.quit();
	}
	public static void escBtn() throws AWTException {
		Robot r =new Robot();
		r.keyPress(KeyEvent.VK_ESCAPE);
		r.keyRelease(KeyEvent.VK_ESCAPE);
	}
	public static void enterBtn() throws AWTException {
		Robot r =new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	public static void windowHandling() {
	String parentwindowId = driver.getWindowHandle();
	Set<String> allIds = driver.getWindowHandles();
	for (String eachId : allIds) {
		if(!parentwindowId.equals(allIds)) {
			driver.switchTo().window(eachId);}}
	}
	public static void screenShot(String name) throws IOException {
		TakesScreenshot tk = (TakesScreenshot)driver;
		File scr =tk.getScreenshotAs(OutputType.FILE);
		long dd =System.currentTimeMillis();
		Date dt = new Date(dd);
		File destDir = new File("C:\\Users\\aravi\\eclipse-workspace\\SeleniumCourse\\Screenshot\\"+name+dt+dd+".png");
		FileUtils.copyFile(scr, destDir);
	}
	public static void threadsleep(long sec) throws InterruptedException {
		Thread.sleep(sec);
	}
	public static void listOfProducts() {
		
		FlipkartpageClass f =new FlipkartpageClass();
		for (int i = 0; i < f.getListproductrate().size(); i++) {
			System.out.print((i+1)+")"+f.getListproduct().get(i).getText()+
					"======="+Integer.parseInt(f.getListproductrate().get(i).getText().replace("₹","").replace(",","")));
			System.out.println();
		}

	}

}
