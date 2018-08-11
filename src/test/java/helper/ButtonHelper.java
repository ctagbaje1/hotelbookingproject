package helper;



import org.openqa.selenium.WebElement;

public class ButtonHelper extends StartWebDriver2 {
	
	public static void clickButton(String locator) {
		WebElement ele = getElement(locator);
		ele.click();
		
	}
	

	}
	
	

