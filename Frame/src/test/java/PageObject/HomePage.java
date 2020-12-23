package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	
	@FindBy(xpath="//a[contains(text(),'New Customer')]")
	WebElement addcust;
	
	@FindBy(xpath="//a[contains(text(),'Log out')]")
	WebElement logout;
	
	@FindBy(xpath="//a[contains(text(),'New Customer')]")
	WebElement newcust;

	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void newcust() {
		addcust.click();
	}
	
	public void logoutt() {
		logout.click();
	}
	
	public WebElement addcust() {
		return newcust;
	}
}
