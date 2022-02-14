package appUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;





public class Utils {
	public static WebDriver driver;
	File file = new File("C:\\Users\\SPURGE\\eclipse-workspace\\MakeMyTrip\\src\\main\\java\\appUtils\\InitialSetUp");

	Properties prop = new Properties();
	public static ExtentReports report;
	public static ExtentTest test;
	

	

	@BeforeSuite
	public void open() throws IOException {

		FileInputStream fi = new FileInputStream(file);

		prop.load(fi);
		String url = (String) prop.get("url");

		System.out.println(url);

		System.out.println(prop.get("BrowserName"));
		Object BName = prop.get("BrowserName");
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
//------Date Generation------------------------------------------------------------------------------
		Date dd=new Date();
		String cdate = dd.toString().replace(" ","_").replace(":", "_");
//----------------------------------------------------------------------------------------------------
//-----ExtentReports for provide by relevent codes--------------------------------------------------
		report=new ExtentReports((".//Reports//"+cdate+".html"), true);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
	
	}
	@AfterTest
	public void  close() {
		report.endTest(test);
		report.flush();
	}
	
	@AfterSuite
	
	public void browserclose() {
		
		driver.close();

	}
	
	/*
	public void getscreenshot(String testMethodName,WebDriver driver) throws IOException {
		
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir"+"\\screenshots"+testMethodName+".png");
		FileUtils.copyFile(source, new File(destinationFile));
		
	}*/
	
	
}
