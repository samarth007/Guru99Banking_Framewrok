
package TestClass;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.AddCustomer_page;
import PageObject.HomePage;
import PageObject.LoginPage;

public class AddCustomer_Test extends BaseClass {

	
	@Test
	public void Adding() {
		
		LoginPage lp = new LoginPage(driver);
		lp.setuser().sendKeys(user);
		lp.setpass().sendKeys(pass);
		lp.clicklogin().click();
		
		HomePage hp = new HomePage(driver);
		hp.addcust().click();
		
		AddCustomer_page add = new AddCustomer_page(driver);
		add.name("samarth");
		add.gen();
		add.Dob("23", "04", "1996");
		add.Addrs("Bengaluru");
		add.cit("BENGALURU");
		add.Sttate("KAR");
		add.mobnum("8987534689");
		add.pin("560021");
		add.pwd("Samastha@07");
		add.maill(getmail()+"@gmail.com");
		
		boolean succ = driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(succ==true) {
			
			Assert.assertTrue(true);
			log.info("test passed");
		}
		else {
			log.error("test failed");
			Assert.assertTrue(false);
		}
	}
	
}
