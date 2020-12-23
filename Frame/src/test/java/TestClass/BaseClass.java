package TestClass;



import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import Utils.ReadConfig;

public class BaseClass {

	ReadConfig rc = new ReadConfig();
	public String baseurl=rc.geturl();
	public String user= rc.getusername();
	public String pass= rc.getpassword();
	public String chropath= rc.driverpath();
	public static WebDriver driver;
	public Logger log;
	
	@BeforeClass
	public void setup() {
		log= LogManager.getLogger(BaseClass.class);
		System.setProperty("webdriver.chrome.driver", chropath);
		driver= new ChromeDriver();
		driver.get(baseurl);
	}
	
	@AfterClass
	public void terminate() {
		driver.close();
	}
	
	public void screenshot(WebDriver driver, String name) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src= ts.getScreenshotAs(OutputType.FILE);
		String path= System.getProperty("user.dir")+"/Screenshot/"+name+".png";
		FileUtils.copyFile(src, new File(path));
		
	}
	
	public String getmail() {
		return RandomStringUtils.randomAlphanumeric(7);
	}
	
}
