package octopus.selenium.sample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Program {

	public static void main(String[] args) {

		// public void ExecuteScript()

		Program obj = new Program();
		obj.InitDriver();
		obj.ExecuteBMIScript();

	}
	
	WebDriver driver;

	public void InitDriver() {

		try {
			System.setProperty("webdriver.chrome.driver",
					"D:\\sample\\Selenium\\lib\\SeleniumEssential\\chromedriver_win32\\chromedriver.exe");

			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();

			driver.manage().window().maximize();

			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

			// Invoke the web page
			driver.get("https://www.calculator.net/bmi-calculator.html");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void ExecuteBMIScript() {
		driver.findElement(By.linkText("Metric Units")).click();
		
		driver.findElement(By.id("cage")).clear();
		driver.findElement(By.id("cage")).sendKeys("50");
		
		driver.findElement(By.id("cheightmeter")).clear();
		driver.findElement(By.id("cheightmeter")).sendKeys("160");
		
		driver.findElement(By.id("ckg")).clear();
		driver.findElement(By.id("ckg")).sendKeys("70");
		
		driver.findElement(By.xpath(".//*[@id=\"content\"]/div[3]/div[2]/table/tbody/tr/td/table[4]/tbody/tr/td/input[2]")).click();		
		
		
	
	}

}
