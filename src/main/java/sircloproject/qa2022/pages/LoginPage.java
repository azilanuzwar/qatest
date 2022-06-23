package sircloproject.qa2022.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{
	
	By username = By.xpath("//input[@name='username']");
	By password = By.xpath("//input[@name='password']");
	By loginBtn = By.xpath("//input[@value='Login']");
	By invalidLogin = By.xpath("//pre[normalize-space()='The password or username is wrong']");
	
	public LoginPage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
		super(driver, explicitWait);
		// TODO Auto-generated constructor stub
	}
	
	public void loginWeb(String user, String pass) {
		setText(username, user);
		setText(password, pass);
		clickAndWait(loginBtn);
	}	
	
	public String falseLogin() {
		return getText(invalidLogin);
	}
}
