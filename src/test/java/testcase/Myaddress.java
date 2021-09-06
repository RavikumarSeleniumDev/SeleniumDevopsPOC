package testcase;



import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Myaddress {

	public void newaddress()
	{
				
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
		//driver.get("http://automationpractice.com/index.php?controller=addresses");
		//driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[2]/a/span")).click();
	}
}

