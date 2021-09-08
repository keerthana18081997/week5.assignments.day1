package week5Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Update_Existing_incident extends BaseClass2 {

	@Test
	public void Update() throws InterruptedException
	{
		
		driver.findElement(By.id("filter")).sendKeys("incident");
		Thread.sleep(1500);
		driver.findElement(By.xpath("(//div[text()='All'])[2]")).click();
		Thread.sleep(1500);
		WebElement frame2 = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(frame2);
		WebElement find = driver.findElement(By.xpath("//input[@class='form-control']"));
		find.click();
		Thread.sleep(1000);
		find.sendKeys("INC0010");
		find.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//td[@class='vt']")).click();

	
		String numb = driver.findElement(By.id("incident.number")).getAttribute("value");
		Thread.sleep(1000);
		
		
		WebElement ele_dr_urgency =  driver.findElement(By.id("incident.urgency"));
		Select dr_urgency = new Select(ele_dr_urgency);
		dr_urgency.selectByValue("1");
		

		WebElement ele_dr_state =  driver.findElement(By.id("incident.state"));
		Select dr_state = new Select(ele_dr_state);
		dr_state.selectByIndex(2);
		
		driver.findElement(By.xpath("//button[@id='sysverb_update_bottom']")).click();
		Thread.sleep(1500);
		WebElement findd = driver.findElement(By.xpath("//input[@class='form-control']"));
		findd.click();
		findd.sendKeys(numb);
		findd.sendKeys(Keys.ENTER);
		String progress = "In Progress";
		String text = driver.findElement(By.xpath("(//td[@class='vt'])[6]")).getText();
		System.out.println("Modified state is: " + text);
		if (progress.equals(text)) {
			System.out.println("incident update");
		} else {
			System.out.println("incident not update");
		}

}
}
