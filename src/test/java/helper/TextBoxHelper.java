package helper;


import org.openqa.selenium.WebElement;

public class TextBoxHelper extends StartWebDriver2 {
	
	public static void typeInTextBox(String locator,String value) {
		
				WebElement ele = getElement(locator);
				ele.sendKeys(value);
				
			}
	public static void clear(String locator) {
		WebElement ele = getElement(locator);
		ele.clear();
		
	}

		
	}
	
	
	
		
		
		
	


