package sircloproject.qa2022;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.chrome.ChromeDriver; 
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test; 
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseWebTest {

		
			ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
			ThreadLocal<WebDriverWait> explicitWait = new ThreadLocal<WebDriverWait>();
		
			public BaseWebTest() {
				this.driver = driver;
				this.explicitWait = explicitWait;	
			}
			
			@BeforeMethod
			public void setUp() {
				
			    WebDriverManager.chromedriver().setup(); 
			    this.driver.set(new ChromeDriver()); //inisiasi untuk buka chrome nya
			    this.explicitWait.set(new WebDriverWait(driver.get(), Duration.ofSeconds(60)));
			    this.driver.get().manage().window().maximize();
			   // driver.get().get("https://www.google.com/");
			}

			@AfterMethod
			public void tearDown() {
				
				this.driver.get().quit();
			}
	}


