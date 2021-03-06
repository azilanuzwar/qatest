package sircloproject.qa2022;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v85.cachestorage.model.CachedResponse;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.client.HttpClient;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;

import sircloproject.qa2022.pages.LoginPage;
import sircloproject.qa2022.pages.HomePage;
import sircloproject.qa2022.pages.DataPage;

public class WebTestAfterPOM extends BaseWebTest{
	
	HomePage homePage = new HomePage (driver, explicitWait);
	LoginPage loginPage = new LoginPage (driver, explicitWait);
	DataPage dataPage = new DataPage (driver, explicitWait);
	
	public WebTestAfterPOM() {
		super();
	}

		
	@Test
	public void testLogin () {
		this.driver.get().get("http://qa-interview.srcli.xyz/login");
		
		String username = "root";
		String password = "root123";
		
		loginPage.loginWeb(username, password);
		
		String actualText = homePage.getWelcomeHome();		
		String expectedText = "Welcome!";	    
	    Assert.assertTrue(actualText.contains(expectedText));	
	}
	
	@Test
	public void testLoginInvalidUsernameAndValidPassword () {
		this.driver.get().get("http://qa-interview.srcli.xyz/login");
		
		String username = "rootsalah";
		String password = "root123";
		
		loginPage.loginWeb(username, password);
		
		String actualText = loginPage.falseLogin();		
		String expectedText = "The password or username is wrong";	    
	    Assert.assertTrue(actualText.contains(expectedText));	
	    System.out.println(actualText);
	    System.out.println();
	}
	
	@Test
	public void testLoginValidUsernameAndInvalidPassword () {
		this.driver.get().get("http://qa-interview.srcli.xyz/login");
		
		String username = "root";
		String password = "rootpasssalah";
		
		loginPage.loginWeb(username, password);
		
		String actualText = loginPage.falseLogin();		
		String expectedText = "The password or username is wrong";	    
	    Assert.assertTrue(actualText.contains(expectedText));	
	    System.out.println(actualText);
	}
	
	@Test
	public void testLoginInvalidUsernameAndInvalidPassword () {
		this.driver.get().get("http://qa-interview.srcli.xyz/login");
		
		String username = "rootsalah";
		String password = "rootpasssalah";
		
		loginPage.loginWeb(username, password);
		
		String actualText = loginPage.falseLogin();		
		String expectedText = "The password or username is wrong";	    
	    Assert.assertTrue(actualText.contains(expectedText));	
	    System.out.println(actualText);
	}
		
	
	@Test
	public void testData () {
		this.driver.get().get("http://qa-interview.srcli.xyz/login");
		
		String username = "root";
		String password = "root123";
	
		loginPage.loginWeb(username, password);

		this.driver.get().get("http://qa-interview.srcli.xyz/data");
		
		String actualText = dataPage.getDataPage();		
		String expectedText = "Pemasukan";	    
	    Assert.assertTrue(actualText.contains(expectedText));  
	    
	}
	
	@Test
	public void testFilter () {
		this.driver.get().get("http://qa-interview.srcli.xyz/login");
		
		String username = "root";
		String password = "root123";
	
		loginPage.loginWeb(username, password);

		this.driver.get().get("http://qa-interview.srcli.xyz/data");
		
		String startDate = "2018-07-12";
		String endDate = "2018-07-11";
		
		dataPage.filterData (startDate,endDate);
		
		String actualText = dataPage.getFilterTextError();		
		String expectedText = "Filter Parameter are wrong";
	    Assert.assertTrue(actualText.contains(expectedText));	
	    
	}
	
	@Test
	public void testLogOut () {
		this.driver.get().get("http://qa-interview.srcli.xyz/login");
		
		String username = "root";
		String password = "root123";
	
		loginPage.loginWeb(username, password);

		this.driver.get().get("http://qa-interview.srcli.xyz/data");
				
		HttpClient httpClient = HttpClientBuilder.create().build();
		try {
			HttpPost request = new HttpPost("http://qa-interview.srcli.xyz/logout");
			HttpResponse response = httpClient.execute(request);
			HttpEntity entity = response.getEntity();
			String responseString = EntityUtils.toString(entity, "UTF-8");
			System.out.println(responseString);
			
			String expectedText = "Temporary Redirect";
			Assert.assertTrue(responseString.contains(expectedText));
									
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
	