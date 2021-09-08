package week5Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class CreateIncident extends BaseClass2 {
	@Test
	public void Create() throws InterruptedException {
		
		WebElement findElement3=driver.findElement(By.id("filter"));
		findElement3.sendKeys("Incident");
		Thread.sleep(2000);
		findElement3.sendKeys(Keys.ENTER);
		WebElement findElement4 = driver.findElement(By.id("gsft_main"));
		driver.switchTo().frame(findElement4);
		driver.findElement(By.xpath("//span[@id='incident_breadcrumb']//b")).click();
		driver.findElement(By.xpath("//button[text()='New']")).click();
		driver.switchTo().parentFrame();
		WebElement findElement5 = driver.findElement(By.id("gsft_main"));
		driver.switchTo().frame(findElement5);
		String attribute = driver.findElement(By.id("incident.number")).getAttribute("value");
		System.out.println("Incident number:" +attribute);
		WebElement findElement6 = driver.findElement(By.id("sys_display.incident.caller_id"));
		findElement6.click();
		Thread.sleep(4000);
		findElement6.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(4000);
		findElement6.sendKeys(Keys.ENTER);
		driver.findElement(By.id("incident.short_description")).sendKeys("Created to check on new incident creation");
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		driver.switchTo().parentFrame();
	}
	

}
