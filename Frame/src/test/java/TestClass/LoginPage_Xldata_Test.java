package TestClass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObject.HomePage;
import PageObject.LoginPage;
import Utils.XLutils;

public class LoginPage_Xldata_Test extends BaseClass {

	
	@Test(dataProvider = "getdata")
	public void login(String us, String psd) {
		
		log.info("Entered url");
		LoginPage lp = new LoginPage(driver);
		log.info("entered username");
		lp.setuser().sendKeys(us);
		log.info("entered password");
		lp.setpass().sendKeys(psd);
		lp.clicklogin().click();
		
		boolean success = isAlertPresent();
		
		if(success==true) {
			log.error("test fail!!!");
			driver.switchTo().alert().accept();
			Assert.assertTrue(false);
		}
		else {
			HomePage hp = new HomePage(driver);
			hp.logoutt();
			driver.switchTo().alert().accept();
			Assert.assertTrue(true);
		}
	}
	
	
	@DataProvider
	public String[][] getdata() throws IOException {
		
		String xlpath="./"+"\\src\\test\\java\\Testdata\\XLFILE.xlsx";
		int rowcount= XLutils.getRow(xlpath, "Sheet1");
		int colcount= XLutils.getColumn(xlpath, "Sheet1", 1);
		
		String [][] data = new String[rowcount][colcount];
		for(int i=1; i<rowcount; i++) {
			
			for(int j=0; j<colcount; j++) {
				
				data[i-1][j]=XLutils.getCellData(xlpath, "Sheet1", i, j);
				
			}
		}
		return data;
	}
	
}
