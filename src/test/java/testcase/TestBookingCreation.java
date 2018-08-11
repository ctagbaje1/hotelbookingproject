package testcase;



import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import pageobjectmodel.HomePage;
import helper.GenericHelper;
import helper.StartWebDriver2;


public class TestBookingCreation extends StartWebDriver2{
	
	
	@Test(priority=1)
	public void validateBookingsWithDeposit() throws InterruptedException 
	{
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("C:/gradleproject/hotelbookingproject/src/main/java/report/HotelBooking2.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		ExtentTest logger=extent.createTest("Hotel Bookings with Deposit");
		Assert.assertTrue(driver.getTitle().contains("Hotel booking form"));
		HomePage hpage = new HomePage(driver);
		hpage.CustomerDetails(file.getFirstName(), file.getLastName(), file.getFirstDeposit());
		hpage.SelectDeposit("true");
		hpage.BookingDates(file.getFirstDate(), file.getSecondDate());
		logger.log(Status.PASS, "Booking details saved");
		/* Assertion for booking - firstname and lastname saved */
		Assert.assertTrue(driver.getPageSource().contains(file.getFirstName()));
		Thread.sleep(1000);
		Assert.assertTrue(driver.getPageSource().contains(file.getLastName()));
		
		/* Take screenshot and save in your projectfolder */
		GenericHelper.takeScreenShot();
		extent.flush();		
	}
	
	
	@Test(priority=2)
	public void validateBookingsWithNoDeposit() throws InterruptedException 
	{
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("C:/gradleproject/hotelbookingproject/src/main/java/report/HotelBooking.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		ExtentTest logger=extent.createTest("Hotel Bookings with No Deposit");
		Assert.assertTrue(driver.getTitle().contains("Hotel booking form"));
		HomePage hpage = new HomePage(driver);
		hpage.CustomerDetails(file.getFirstName2(), file.getLastName2(), file.getSecondDeposit());
		logger.log(Status.INFO, "Hotel Booking Page");
		logger.log(Status.PASS, "Customer firstname and lastname entered");
		hpage.SelectDeposit("false");
		hpage.BookingDates(file.getFirstDate(), file.getSecondDate());
				
		/* Assertion for booking - firstname and lastname saved for no deposit */
		Thread.sleep(4000);
		Assert.assertTrue(driver.getPageSource().contains(file.getFirstName2()));
		
		/* Take screenshot and save in your projectfolder */
		GenericHelper.takeScreenShot2();
		/* end report */
	    extent.flush();
			
	}
	
	@Test(priority=3)
	public void validateBookingDeleted() throws InterruptedException {
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("C:/gradleproject/hotelbookingproject/src/main/java/report/HotelBooking3.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		ExtentTest logger=extent.createTest("Hotel Booking Deleted");
	    
		Assert.assertTrue(driver.getTitle().contains("Hotel booking form"));
		HomePage hpage = new HomePage(driver);
		hpage.DeleteBooking();
		logger.log(Status.PASS, "Booking deleted");
        Thread.sleep(4000);
        
        /* Assertion for bookings deleted - firstname and lastname saved */
		Assert.assertFalse(driver.getPageSource().contains(file.getFirstName3()));
		extent.flush();
	}
	


}
