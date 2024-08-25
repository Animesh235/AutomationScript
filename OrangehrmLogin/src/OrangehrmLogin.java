import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangehrmLogin {

	public static void main(String[] args) {
		
		try {
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com");
		
		driver.manage().window().maximize();
		
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		
		WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		WebElement loginbutton = driver.findElement(By.xpath("//button[@type='submit']"));
		
		username.sendKeys("Admin");
		password.sendKeys("admin123");
		loginbutton.click();
		
		WebElement clickMyinfo = driver.findElement(By.xpath("//span[text() = 'My Info' ]"));
		clickMyinfo.click();
		
		driver.findElement(By.className("oxd-userdropdown-name")).click();
		driver.findElement(By.xpath("//a[text() = 'Logout']")).click();
		
		System.out.println("Testcase pass");
		
		driver.close();
		driver.quit();
		}
		catch(Exception e) {
			System.out.println("Testcase fail");
		}
		
		
	}
	
	
	
	
}
