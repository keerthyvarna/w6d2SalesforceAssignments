package w6d2SalesforceAssignments;
//setTimeout(function(){debugger;}, 5000)


import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateTask extends BaseClass {
	@BeforeTest
	public void setFile() {
		filename="salesforceTaskData";
		Sheet="createTask";
	}
	@Test(dataProvider="myData")
	public  void createTask(String subject) throws IOException, InterruptedException {
		
	driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[text()='View All']")).click();
    driver.findElement(By.xpath("//p[text()='Sales']")).click();
	
	Thread.sleep(3000);
    driver.findElement(By.xpath("(//a[@class='slds-button slds-button_reset'])[3]")).click();
	
    WebElement task = driver.findElement(By.xpath("//a[@role='menuitem']"));
	driver.executeScript("arguments[0].click();", task);
	Thread.sleep(3000);
	driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys(subject);
    driver.findElement(By.xpath("//a[text()='Not Started']")).click();
	
	
	driver.findElement(By.xpath("//a[@title='Waiting on someone else']")).click();
	
	driver.findElement(By.xpath("//span[text()='Save']")).click();
	String text = driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]")).getText();
	System.out.println(text);
	}
}
