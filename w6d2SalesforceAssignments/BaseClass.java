package w6d2SalesforceAssignments;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import w6d2serviceNowAssignments.ReadExcel;

public class BaseClass {
	public ChromeDriver driver;
	public String filename;
	public String Sheet;
	public static String sub;
	
	@Parameters({"url","user","password"})
	@BeforeMethod()
	
		public void preCondition(String url,String user,String pwd) throws InterruptedException {
		        driver = new ChromeDriver();
				driver.get(url);
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
				driver.findElement(By.xpath("//input[@id='username']")).sendKeys(user);
				driver.findElement(By.xpath("//input[@id='password']")).sendKeys(pwd);
				driver.findElement(By.xpath("//input[@id='Login']")).click();
		}

     @AfterMethod()
		  public void postCondition() {
		  		  driver.quit();
		  		  }
		 
    @DataProvider(name="myData")
        public String[][] sendData() throws IOException,InterruptedException {		
	   return ReadExcel.readExcel(filename);	
     }
   }



