package TestClass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.LoginPage;

public class LoginPageTest extends BaseClass {

	
	@Test
	public void atTest() throws IOException {
		
		log.info("entered website");
		LoginPage lp = new LoginPage(driver);
		lp.setuser().sendKeys(user);
		log.info("entered username");
		lp.setpass().sendKeys(pass);
		log.info("entered password");
		lp.clicklogin().click();
		
		boolean valid= driver.getPageSource().contains(user);
		
		if(valid==true) {
			
			log.info("test success");
			Assert.assertTrue(true);
		}
		else {
			screenshot(driver, "atTest");
			log.warn("test failed");
			Assert.assertTrue(false);
		}
		
	}
	
	
	
	
}
