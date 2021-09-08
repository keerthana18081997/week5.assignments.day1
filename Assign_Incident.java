package week5Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Assign_Incident extends BaseClass2 {
	@Test
	public void Assign() throws InterruptedException {
		
	
	driver.findElement(By.id("filter")).sendKeys("incident");
	Thread.sleep(1500);
	driver.findElement(By.xpath("//div[text()='Open']")).click();
	Thread.sleep(1500);
	WebElement frame2 = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
	driver.switchTo().frame(frame2);
	WebElement find = driver.findElement(By.xpath("//input[@class='form-control']"));
	find.click();
	Thread.sleep(1000);
	find.sendKeys("INC0010");
	Thread.sleep(1500);
	find.sendKeys(Keys.ENTER);
	driver.findElement(By.xpath("//td[@class='vt']")).click();
	Thread.sleep(3000);
	WebElement find1=driver.findElement(By.id("sys_display.incident.assignment_group"));
			find1.clear();
			find1.sendKeys("Software");
			Thread.sleep(3000);
			find1.sendKeys(Keys.ENTER);
	driver.findElement(By.id("activity-stream-textarea")).sendKeys("none");
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@class= 'form_action_button  action_context btn btn-default']")).click();
	
	String text=driver.findElement(By.xpath("//a[@class='linked']")).getText();
	System.out.println(text);
	if(text.equals("Software")) {
		System.out.println("verified");
	}
	else {
		System.out.println("not assigned");
	}
}
	

}