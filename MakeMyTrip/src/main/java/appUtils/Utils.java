package appUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;





public class Utils {
	public  WebDriver driver=null;
	File file = new File("C:\\Users\\SPURGE\\Desktop\\New folder\\MakeMyTrip\\MakeMyTrip\\src\\main\\java\\appUtils\\InitialSetUp");

	Properties prop = new Properties();
	public static ExtentReports report;
	public static ExtentTest test;
	public String url="https://www.cleartrip.com/";

	

	@BeforeSuite
	public   void open() throws IOException {

		FileInputStream fi = new FileInputStream(file);

		prop.load(fi);
		// url = (String) prop.get("url");

		System.out.println(url);

		System.out.println(prop.get("BrowserName"));
		Object BName = prop.get("BrowserName");
		//------Date Generation------------------------------------------------------------------------------
		Date dd=new Date();
		String cdate = dd.toString().replace(" ","_").replace(":", "_");
//----------------------------------------------------------------------------------------------------
//-----ExtentReports for provide by relevent codes--------------------------------------------------
		report=new ExtentReports((".//Reports//"+cdate+".html"), true);
//--------------------------------------------------------------------------------------------------
		if (BName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "Browsers/chromedriver.exe");
			driver = new ChromeDriver();

		} else if (BName.equals("firefox")) {
			System.setProperty("webdriver.firefox.driver", "Browsers/geckodriver.exe");
			driver = new FirefoxDriver();

		} else if (BName.equals("edge")) {
			System.setProperty("webdriver.edge.driver", "Browsers/msedgedriver.exe");
			driver = new EdgeDriver();

		}
	
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
	
	}
	
	/*
	@BeforeSuite
	public void reoports() {
		
		//------Date Generation------------------------------------------------------------------------------
				Date dd=new Date();
				String cdate = dd.toString().replace(" ","_").replace(":", "_");
		//----------------------------------------------------------------------------------------------------
		//-----ExtentReports for provide by relevent codes--------------------------------------------------
				report=new ExtentReports((".//Reports//"+cdate+".html"), true);
		//--------------------------------------------------------------------------------------------------
	}
	*/
/*	@BeforeTest
	public void browserurl()  {
		System.out.println(url);

		driver.get(url);

	} */
/*	@AfterSuite
	public void  close() {
		report.endTest(test);
		report.flush();
	}
	*/
	public String getScreenShot() throws Exception
	{
		Date dd=new Date();
		String ss1 = dd.toString().replace(" ","_").replace(":", "_");
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		 File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		 String screenshotpath =  System.getProperty("user.dir")+"/ScreenShots/"+ss1+".png";
		 File DestFile=new File(screenshotpath);
		 FileUtils.copyFile(SrcFile, DestFile);
		 return screenshotpath;
	}

@AfterMethod
	public void Screenshots(ITestResult result) throws IOException {
		  if (result.getStatus() == ITestResult.FAILURE) {
		try {
			test.log(LogStatus.FAIL, test.addScreenCapture(getScreenShot()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 	
	}

}
	@AfterSuite
	public void browserclose() {
		report.endTest(test);
		report.flush();
		driver.quit();

	}
	
	/*
	public void getscreenshot(String testMethodName,WebDriver driver) throws IOException {
		
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir"+"\\screenshots"+testMethodName+".png");
		FileUtils.copyFile(source, new File(destinationFile));
		
	}*/
	
	
}
