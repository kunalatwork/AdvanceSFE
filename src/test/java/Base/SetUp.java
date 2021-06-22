package Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


    public class SetUp {
   	
    public WebDriver driver;
    public Properties prop;

    public SetUp() throws IOException {

	prop = new Properties();
	FileInputStream fis = new FileInputStream("C:\\Users\\lakhan\\eclipse-workspace\\NopCommerce\\Data\\testData");
	prop.load(fis);

    }

	public void initialization() throws IOException {


		String browsertype= prop.getProperty("browser");
		if(browsertype.equalsIgnoreCase("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\lakhan\\eclipse-workspace\\NopCommerce\\Drivers\\chromedriver.exe");
			driver= new ChromeDriver();
		}

		else if(browsertype.equalsIgnoreCase("firefox")) 
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\lakhan\\eclipse-workspace\\NopCommerce\\Drivers\\geckodriver.exe");

			driver = new FirefoxDriver();
		}

		else if(browsertype.equalsIgnoreCase("edge")) 
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\lakhan\\eclipse-workspace\\NopCommerce\\Drivers\\msedgedriver.exe");
			driver = new EdgeDriver();

		}

	}

}
