
package TestClass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.AddCustomer_page;
import PageObject.HomePage;
import PageObject.LoginPage;

public class AddCustomer_Test extends BaseClass {

	
	@Test
	public void Adding() throws IOException, InterruptedException {
		
		LoginPage lp = new LoginPage(driver);
		lp.setuser().sendKeys(user);
		lp.setpass().sendKeys(pass);
		lp.clicklogin().click();
		
		HomePage hp = new HomePage(driver);
		hp.newcust();
		
		AddCustomer_page add = new AddCustomer_page(driver);
		add.name("samarth");
		add.gen();
		add.Dob("24", "04", "1995");
		add.Addrs("Bengaluru");
		add.cit("BENGALURU");
		add.Sttate("KAR");
		add.mobnum("8987534689");
		add.pin("560021");
		add.pwd("Samastha@07");
		add.maill(getmail()+"@gmail.com");
		add.sbmit();
		
		Thread.sleep(3000);
		boolean succ = driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(succ==true) {
			
			Assert.assertTrue(true);
			log.info("test passed");
		}
		else {
			screenshot(driver, "Adding");
			log.error("test failed");
			Assert.assertTrue(false);
		}
	}
	
}
