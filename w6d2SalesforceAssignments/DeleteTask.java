package w6d2SalesforceAssignments;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class DeleteTask extends BaseClass {
	@Test()
	public  void createTask() throws IOException, InterruptedException {
	driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[text()='View All']")).click();
    driver.findElement(By.xpath("//p[text()='Sales']")).click();
	
	Thread.sleep(3000);
    WebElement task = driver.findElement(By.xpath("//span[text()='Tasks']"));
    driver.executeScript("arguments[0].click();", task);
    
    driver.findElement(By.xpath("//button[@title='Select a List View']")).click();
    driver.findElement(By.xpath("(//span[text()='Recently Viewed'])[3]")).click();
    driver.findElement(By.xpath("//a[@title='Show 5 more actions']")).click();
    driver.findElement(By.xpath("//a[@title='Delete']")).click();
    driver.findElement(By.xpath("//span[text()='Delete']")).click();
     String text = driver.findElement(By.xpath("//span[contains(@class,'toastMessage slds-text')]")).getText();
    System.out.println(text);
}
}
