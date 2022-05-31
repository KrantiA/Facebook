package utils;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {
	public static void captureScreenshot(WebDriver driver, int testID) throws IOException 
	{
		
      // DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy//mm//ss");
       Date date = new Date();
	   String date1= date.toString().replace(" ", "-").replace(":", " ");
	   File source =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	   File dest = new File("test-output\\snapshot\\test"+ date1 + testID +".png");
	   FileHandler.copy(source, dest);

	 }

}
