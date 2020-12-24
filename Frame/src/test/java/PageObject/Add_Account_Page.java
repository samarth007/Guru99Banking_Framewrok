package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Add_Account_Page {

	WebDriver driver;
	Select s;
	
	@FindBy(name="cusid")
	WebElement custid;
	
	@FindBy(name="inideposit")
	WebElement deposit;
	
	@FindBy(name="selaccount")
	WebElement actype;
	
	@FindBy(name="button2")
	WebElement submit;
	
	public Add_Account_Page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement setCust() {
		return custid;
	}
	
	public WebElement setInDep() {
		return deposit;
	}
	
	public Select setActype() {
	 s = new Select(actype);
	 return s;
	}
	
	public void ClickSubmit() {
		submit.click();
	}
}
