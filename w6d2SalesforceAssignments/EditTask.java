package w6d2SalesforceAssignments;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EditTask extends BaseClass {
	@BeforeTest
	public void setFile() {
		filename="salesforceTaskData";
		Sheet="editTask";
	}
	
	@Test(dataProvider="myData")
	public  void createTask(String sub ) throws IOException, InterruptedException {
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
    driver.findElement(By.xpath("//a[@title='Edit']")).click();
    driver.findElement(By.xpath("(//input[@class='slds-input'])[2]")).click();
    driver.findElement(By.xpath("//button[@name='today']")).click();
    driver.findElement(By.xpath("//a[text()='Normal']")).click();
    driver.findElement(By.xpath("//a[@title='Low']")).click();
    driver.findElement(By.xpath("//span[text()='Save']")).click();
    String text = driver.findElement(By.xpath("(//span[contains(@class,'test-id__field-value')])[3]/span")).getText();
    if(text.equalsIgnoreCase(sub)) {
    	System.out.println("Task is edited and subject is verified");
    }else {
    	System.out.println("Task is edited but Subject is not verified");
    }
	}
}
    
    
    


