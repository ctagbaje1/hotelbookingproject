package pageobjectmodel;

import helper.ButtonHelper;
import helper.GenericHelper;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;



public class HomePage {
	
	
	/* All Web Element */
	
	@SuppressWarnings("unused")
	private WebDriver webDriver;

	@FindBy(how=How.ID,id="firstname")
	private WebElement FNTxtBox;
	
	@FindBy(how=How.ID,using="lastname")
	private WebElement LNTxtBox;
	
	@FindBy(how=How.ID,using="totalprice")
	private WebElement PrceTxtBox;
	@FindBy(how=How.ID,using="depositpaid")
	private WebElement PaidDeposit;
	@FindBy(how=How.ID,using="checkin")
	private WebElement ChkinTxtBox;
	@FindBy(how=How.ID,using="checkout")
	private WebElement ChkoutTxtBox;
	
	@FindBy(how=How.XPATH,using="//input[@value=' Save ']")
	private WebElement SaveButtn; 
	
	@FindBy(how=How.XPATH,using="//input[@onclick='deleteBooking(42272)']")	
	private WebElement DeleteButtn; 
	
	
	
/* Region - All the actions */
	
	public HomePage(WebDriver _driver){
			PageFactory.initElements(_driver, this);
		this.webDriver = _driver;
	} 
	
	public void CustomerDetails(String frstnme, String lstnme,  String deposit) throws InterruptedException {
		FNTxtBox.sendKeys(frstnme);
		Thread.sleep(1000);
		LNTxtBox.sendKeys(lstnme);
		Thread.sleep(1000);
		PrceTxtBox.sendKeys(deposit);
		Thread.sleep(1000);
			
	}
	public void SelectDeposit(String visibletext) throws InterruptedException {
		/*Select select = new Select(driver.findElement(Severity));*/
		Select select = new Select(PaidDeposit);
		select.selectByVisibleText(visibletext);
		Thread.sleep(1000);
	}
	
	public void BookingDates(String frstdate, String lstdate) throws InterruptedException {
		ChkinTxtBox.sendKeys(frstdate);
		Thread.sleep(1000);
		ChkoutTxtBox.sendKeys(lstdate);
		Thread.sleep(3000);
		SaveButtn.sendKeys(Keys.ENTER);
		Thread.sleep(4000);					
	}
	
	public void DeleteBooking() throws InterruptedException {
		
		Thread.sleep(2000);
		if (GenericHelper.IsElementPresent2(By.xpath("//input[@onclick='deleteBooking(42272)']")))
        {
            ButtonHelper.clickButton("//input[@onclick='deleteBooking(42272)']");
        }
		
			
	}
	


}
