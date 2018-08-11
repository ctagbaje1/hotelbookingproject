package helper;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;



public class StartWebDriver2{
	
	

	public static WebDriver driver = null;
	protected static ReadConfigProperty file = null;
	
	
	@BeforeSuite
	public void setUp(){
		try {			
			 file = new ReadConfigProperty();
			if("firefox".equalsIgnoreCase(file.getBrowser())){
				System.setProperty("webdriver.gecko.driver",StartWebDriver2.class.getClassLoader().getResource("geckodriver.exe").getPath());
				driver = new FirefoxDriver();
			}else if("chrome".equalsIgnoreCase(file.getBrowser())){
			System.setProperty("webdriver.chrome.driver", StartWebDriver2.class.getClassLoader().getResource("chromedriver.exe").getPath());
			driver = new ChromeDriver();
			}else if("iexplorer".equalsIgnoreCase(file.getBrowser())){
				System.setProperty("webdriver.ie.driver", StartWebDriver2.class.getClassLoader().getResource("IEDriverServer.exe").getPath());
				driver = new InternetExplorerDriver();
			}else{
				driver = new HtmlUnitDriver();
			} 
			driver.manage().timeouts().implicitlyWait(file.getElementWait(), TimeUnit.SECONDS);
			WindowHelper.windowMaximize();
			driver.get(file.getUrl());
			Thread.sleep(2000);
				} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static WebElement getElement(String locator) {
		boolean flag = false;
		if(locator.contains("/"))
			flag = true;
		if(driver.findElements(By.id(locator)).size() == 1){
			return driver.findElement(By.id(locator));
		}else if(driver.findElements(By.name(locator)).size() == 1 ){
			return driver.findElement(By.name(locator));
		}else if(!flag && driver.findElements(By.cssSelector(locator)).size() == 1){
			return driver.findElement(By.cssSelector(locator));
		}else if(driver.findElements(By.xpath(locator)).size() == 1){
			return driver.findElement(By.xpath(locator));
		}else
			throw new NoSuchElementException("No Such Element : " + locator);
		
	}
	
	@AfterSuite(alwaysRun=true)
	public void tearDown() {
		try {
			driver.close();
			driver.quit();
			if(driver != null)
				driver = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

}

