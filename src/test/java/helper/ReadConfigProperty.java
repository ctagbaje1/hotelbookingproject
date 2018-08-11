package helper;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadConfigProperty {

	protected InputStream input = null;
	protected Properties prop = null;
	
	public ReadConfigProperty() {
		try {
			input = this.getClass().getClassLoader().getResourceAsStream("config.properties");
			prop = new Properties();
			prop.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
	public String getUrl() {
		if(prop.getProperty("url") == null)
			return "";
		return prop.getProperty("url");
	}
	
	public String getBrowser() {
		if(prop.getProperty("browser") == null)
			return "";
		return prop.getProperty("browser");
	}
	

	public int getElementWait() {
		if(prop.getProperty("ElementWait") == null)
			return 0;
		return Integer.parseInt(prop.getProperty("ElementWait")); 
	}
	public String getFirstName() {
		if(prop.getProperty("FirstName") == null)
			return "";
		return prop.getProperty("FirstName");
	}
	public String getFirstName2() {
		if(prop.getProperty("FirstName2") == null)
			return "";
		return prop.getProperty("FirstName2");
	}
	public String getFirstName3() {
		if(prop.getProperty("FirstName3") == null)
			return "";
		return prop.getProperty("FirstName3");
	}
	
	public String getLastName() {
		if(prop.getProperty("LastName") == null)
			return "";
		return prop.getProperty("LastName");
	}
	public String getLastName2() {
		if(prop.getProperty("LastName2") == null)
			return "";
		return prop.getProperty("LastName2");
	}
	
	public String getFirstDeposit() {
		if(prop.getProperty("FirstDeposit") == null)
			return "";
		return prop.getProperty("FirstDeposit"); 
	}
	
	public String getSecondDeposit() {
		if(prop.getProperty("SecondDeposit") == null)
			return "";
		return prop.getProperty("SecondDeposit"); 
	}
	public String getFirstDate() {
		if(prop.getProperty("FirstDate") == null)
			return "";
		return prop.getProperty("FirstDate"); 
	}
	public String getSecondDate() {
		if(prop.getProperty("SecondDate") == null)
			return "";
		return prop.getProperty("SecondDate"); 
	}

}
