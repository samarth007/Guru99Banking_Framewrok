package TestClass;



import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.Add_Account_Page;
import PageObject.HomePage;
import PageObject.LoginPage;

public class Add_Account_Test extends BaseClass {

	
	
	@Test()
	public void addAccount() throws IOException {
		log.info("entered website");
		LoginPage lp = new LoginPage(driver);
		lp.setuser().sendKeys(user);
		log.info("entered username");
		lp.setpass().sendKeys(pass);
		log.info("entered password");
		lp.clicklogin().click();
		
		HomePage hp = new HomePage(driver);
		hp.addAcc().click();
		
		Add_Account_Page adAc= new Add_Account_Page(driver);
		adAc.setCust().sendKeys(rc.cust());
		log.info("entered customer id");
		adAc.setActype().selectByValue(rc.getAccountType());
		log.info("entred account type");
		adAc.setInDep().sendKeys("1000");
		log.info("entered amount");
		adAc.ClickSubmit();
		
		boolean valid= driver.getPageSource().contains(rc.cust());
		
		if(valid==true) {
			log.info("test passed");
			Assert.assertTrue(true);
		}
		else {
			log.warn("test failed");
			screenshot(driver, "adAccount");
			Assert.assertTrue(false);
		}
		
	}
	
	
	
}
