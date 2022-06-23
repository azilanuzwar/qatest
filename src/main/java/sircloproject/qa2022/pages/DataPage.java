package sircloproject.qa2022.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DataPage extends BasePage {
	
	By dataText = By.xpath("//h1[normalize-space()='Pemasukan']");
	
	By filterError = By.xpath("//pre[normalize-space()='Filter Parameter are wrong']");
	
	By startDate = By.xpath("//input[@name='start']");
	By endDate = By.xpath("//input[@name='end']");
	By filterBtn = By.xpath("//input[@value='Filter']");


	public DataPage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
		super(driver, explicitWait);
		// TODO Auto-generated constructor stub
	}
	public String getDataPage() {
		return getText(dataText);
	}
	
	public String getFilterTextError() {
		return getText(filterError);
	}
	
	public void filterData(String start, String end) {
		setText(startDate, start);
		setText(endDate, end);
		clickAndWait(filterBtn);
	}

}
