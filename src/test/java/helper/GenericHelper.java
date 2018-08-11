package helper;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class GenericHelper extends StartWebDriver2 {
	
	public static void takeScreenShot() {
		try {
			File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("HotelBookingWithDeposit.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void takeScreenShot2() {
		try {
			File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("HotelBookingNoDeposit.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	

	public static boolean isElementPresent(String locator) {
		boolean status = false;
		
		boolean flag = false;
		if(locator.contains("/"))
			flag = true;
		if(driver.findElements(By.id(locator)).size() >= 1){
			status = true;
		}else if(driver.findElements(By.name(locator)).size() >= 1 ){
			status = true;
		}else if(!flag && driver.findElements(By.cssSelector(locator)).size() >= 1){
			status = true;
		}else if(driver.findElements(By.xpath(locator)).size() >= 1){
			status = true;
		}else
			status = false;
		return status;
	}
	
	 public static boolean IsElementPresent2(By locator)
     {
         try
         {
             return driver.findElements(locator).size() == 1;
         }
         catch (Exception e)
         {

             return false;
         }
         
     }
	
	





}

