package helper;




public class WindowHelper extends StartWebDriver2 {
	
	
	public static void navigateToPage(String url) {
		driver.navigate().to(url);
	}
	
	public static void windowMaximize() {
		driver.manage().window().maximize();
	}

}
