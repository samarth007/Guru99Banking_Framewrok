package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	
	Properties p;
	
	public ReadConfig()  {
		
		File f = new File("./configuration/config.properties");
		try {
		FileInputStream fis = new FileInputStream(f);
		p=new Properties();
		p.load(fis);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public String geturl() {
		return p.getProperty("url");
	}
	
	public String getusername() {
		return p.getProperty("username");
	}
	
	public String getpassword() {
		return p.getProperty("password");
	}
	
	public String driverpath() {
		return p.getProperty("chromepath");
	}
	
	public String cust() {
		return p.getProperty("custid");
	}
	
	public String getAccountType() {
		
	return	p.getProperty("AccountType");
}
	
}