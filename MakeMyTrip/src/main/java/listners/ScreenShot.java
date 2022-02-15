package listners;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import appUtils.Utils;

public class ScreenShot extends Utils {

	public void getScreenShot() throws Exception
	{
		Date dd=new Date();
		String ss1 = dd.toString().replace(" ","_").replace(":", "_");
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		 File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		 File DestFile=new File("C:\\Users\\SPURGE\\git\\MakeMyTrip\\MakeMyTrip\\screenShots\\"+ss1+".png");
		 FileUtils.copyFile(SrcFile, DestFile);
	}
	
}
