package testcase;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Login {
	
	static WebDriver driver;
	
	@BeforeMethod
	public void browserLaunch() {
		System.setProperty("webdriver.chrome.driver", "D:\\Ravi_Old_Backup\\ravik\\eclipse\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
		
	}
@Test
public static void  testcase1() {
		// TODO Auto-generated method stub
		
		driver.findElement(By.className("login")).click();
		driver.findElement(By.name("email")).sendKeys("testuser901@test.com");
		driver.findElement(By.id("passwd")).sendKeys("test123");
		driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]/span")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.partialLinkText("sign out")).click();
		
		System.out.println("test case 1 passed where user can login and logout from application");
		
	    }
@Test

public static void testcase2() {
	
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.className("login")).click();
		driver.findElement(By.name("email")).sendKeys("testuser901@test.com");
		driver.findElement(By.id("passwd")).sendKeys("test123");
		driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]/span")).click();
		WebDriverWait wait = new WebDriverWait(Login.driver, 1);
		wait.until(ExpectedConditions.visibilityOf(Login.driver.findElement(By.linkText("My addresses")))).click();
		Login.driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[2]/a")).click();
		Login.driver.findElement(By.id("address1")).sendKeys("Testaddress");
		Login.driver.findElement(By.id("city")).sendKeys("city01");
		Select State = new Select(Login.driver.findElement(By.id("id_state")));
		State.selectByVisibleText("California");
		State.selectByIndex(5);
		Login.driver.findElement(By.id("postcode")).sendKeys("90011");
		Login.driver.findElement(By.id("phone")).sendKeys("9876543210");
		Login.driver.findElement(By.id("alias")).clear();
		String TestABC = "Test" + new Random().nextInt(1000);
		Login.driver.findElement(By.id("alias")).sendKeys(TestABC);
		Login.driver.findElement(By.id("submitAddress")).click();
		System.out.println("Test Case2 Passed - where user can create a new address");
	}
}
@AfterMethod
public void tearDown() {
	driver.close();
	
	}
}


