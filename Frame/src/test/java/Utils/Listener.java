package Utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listener implements ITestListener {

	ExtentReports extent;
	ExtentTest test;
	
	@Override
	public void onTestStart(ITestResult result) {
		String timestamp= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String repname="Test-Output- "+timestamp+".html";
		
		ExtentSparkReporter esr= new ExtentSparkReporter(System.getProperty("user.dir")+"//reports//"+repname);
		esr.config().setDocumentTitle("Banking Application");
		esr.config().setReportName("ebanking");
		esr.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(esr);
		extent.setSystemInfo("Tester", "Demo");
		extent.setSystemInfo("Browser", "chrome");
		
	}
	@Override
	public void onTestSuccess(ITestResult result) {
	test= extent.createTest(result.getMethod().getMethodName());
	test.log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));
		
	}
	@Override
	public void onTestFailure(ITestResult result) {
		test= extent.createTest(result.getMethod().getMethodName());
		test.log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.RED));
		
		String screenshotpath=System.getProperty("user.dir")+"//Screenshot//"+result.getName()+".png";
		
		File f =new File(screenshotpath);
		
		if(f.exists()) {
			
			try {
				test.fail("Screenshot is below; "+test.addScreenCaptureFromPath(screenshotpath));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	@Override
	public void onFinish(ITestContext context) {
		
		extent.flush();
	}
	
	
	
	
	
}
