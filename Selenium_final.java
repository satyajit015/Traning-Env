package octopus.selenium.sample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Program {

	public static void main(String[] args) {

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

		// Selecting Tab
		driver.findElement(By.linkText("Metric Units")).click();

		// Selecting age textbox
		driver.findElement(By.id("cage")).clear();
		driver.findElement(By.id("cage")).sendKeys("50");

		// Radio Button
		driver.findElement(By.id("csex2")).click();

		driver.findElement(By.id("cheightmeter")).clear();
		driver.findElement(By.id("cheightmeter")).sendKeys("120");

		driver.findElement(By.id("ckg")).clear();
		driver.findElement(By.id("ckg")).sendKeys("40");

		System.out.println("Click on Calculator");

		driver.findElement(By.xpath("//input[@value='Calculate']")).click();

		System.out.println("Item is selected");

		String result = driver.findElement(By.xpath("//div[@class='bigtext']")).getText();

		System.out.println("output: " + result);

		if (result.contains("(Overweight)")) {
			System.out.println("Passed");
		} else {
			System.out.println("Failed");

			driver.close();

		}
	}

}
