package w6d2SalesforceAssignments;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateTask2 extends BaseClass {
	//without mandatory fields
	@BeforeTest
	public void setFile() {
		filename="salesforceTaskData";
		Sheet="createTask2";
	}
	@Test(dataProvider="myData")
	public  void createTask2(String name) throws IOException, InterruptedException {
		
	driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
	Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='View All']")).click();
    driver.findElement(By.xpath("//p[text()='Sales']")).click();
	
	Thread.sleep(3000);
    driver.findElement(By.xpath("(//a[@class='slds-button slds-button_reset'])[3]")).click();
	
    WebElement task = driver.findElement(By.xpath("//a[@role='menuitem']"));
	driver.executeScript("arguments[0].click();", task);
	Thread.sleep(3000);
	driver.findElement(By.xpath("//input[@title='Search Contacts']")).sendKeys(name);
	driver.findElement(By.xpath("//span[text()='Save']")).click();
	String text = driver.findElement(By.xpath("//ul[@class='errorsList']/li")).getText();
	System.out.println("Error Message: "+text);
	
	

}
}
