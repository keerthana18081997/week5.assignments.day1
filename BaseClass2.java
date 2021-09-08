package week5Assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass2 {
ChromeDriver driver;
	
	@BeforeMethod
	public void  PreCondition() {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://dev112028.service-now.com/navpage.do");
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	WebElement findElement = driver.findElement(By.id("gsft_main"));
	driver.switchTo().frame(findElement);
	driver.findElement(By.id("user_name")).sendKeys("admin");
	driver.findElement(By.id("user_password")).sendKeys("1808@Rtkk");
	driver.findElement(By.id("sysverb_login")).click();

	}
	@AfterMethod
	public void PostCondition() {
		driver.close();
	}
}
