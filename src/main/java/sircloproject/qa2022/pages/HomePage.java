package sircloproject.qa2022.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {
	
	By homeText = By.xpath("//h1[normalize-space()='Welcome!']");

	public HomePage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
		super(driver, explicitWait);
		// TODO Auto-generated constructor stub
	}
	
	public String getWelcomeHome() {
		return getText(homeText);
	}

//	private String getText(By homeText2) {
//		// TODO Auto-generated method stub
//		return null;
}

