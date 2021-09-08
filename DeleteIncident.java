package week5Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class DeleteIncident extends BaseClass2 {
        @Test
		public void Delete() throws InterruptedException {
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
		WebElement find1=driver.findElement(By.xpath("//td[@class='vt']"));
		String a=find1.getText();
		System.out.println();
				find1.click();
		Thread.sleep(3000);
		driver.findElement(By.id("sysverb_delete")).click();
		driver.findElement(By.xpath("//button[@id='ok_button']")).click();
		
		System.out.println("deleted sucessfully");
		Thread.sleep(3000);
		WebElement findd = driver.findElement(By.xpath("//input[@class='form-control']"));
		findd.click();
		findd.sendKeys(a);
		findd.sendKeys(Keys.ENTER);
		String text = driver.findElement(By.xpath("//td[text()='No records to display']")).getText();
		String record = "No records to display";
		if (text.equals(record)) {
			System.out.println("deleted successfully");
		} else {
			System.out.println("not deleted");
		}
}
}
