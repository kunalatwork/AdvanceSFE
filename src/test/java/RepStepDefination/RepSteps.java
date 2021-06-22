package RepStepDefination;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import PageObjectClasses.PageObjectAddProduct;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class RepSteps {

	public WebDriver driver;
	public PageObjectAddProduct addProduct;
	public Properties prop;

	@Before
	public void setup() throws IOException {

		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\lakhan\\eclipse-workspace\\AdvanceSFE\\Data\\testData.properties");
		prop.load(fis);
		String browsertype = prop.getProperty("browser");
		if(browsertype.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\lakhan\\eclipse-workspace\\AdvanceSFE\\Drivers\\chromedriver.exe");
			driver= new ChromeDriver();
		}

		else if(browsertype.equalsIgnoreCase("firefox")) 
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\lakhan\\eclipse-workspace\\AdvanceSFE\\Drivers\\geckodriver.exe");

			driver = new FirefoxDriver();
		}

		else if(browsertype.equalsIgnoreCase("edge")) 
		{
			System.setProperty("webdriver.edge.driver", "C:\\Users\\lakhan\\eclipse-workspace\\AdvanceSFE\\Drivers\\msedgedriver.exe");
			driver = new EdgeDriver();

		}
	}

	public String random() {
		String r =RandomStringUtils.randomAlphabetic(2);
		return r;
	}


	@Given("^User launch browser$")
	public void user_launch_browser() throws Throwable {
		addProduct = new PageObjectAddProduct(driver);
	}

	@Given("^Enter url \"([^\"]*)\"$")
	public void enter_url(String url) throws Throwable {
		driver.get(url);
		driver.manage().window().maximize();
	}

	@Then("^User Enter Email \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void user_Enter_Email_and_password(String id, String passwrd) throws Throwable {

		addProduct.Login(id, passwrd);

	}

	@Then("^User click on login button$")
	public void user_click_on_login_button() throws Throwable {
		addProduct.loginButton();
	}


	// General Management //

	@Then("^Select Company Logo$")
	public void select_Company_Logo() throws Throwable {
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor)driver; 

		WebElement a=driver.findElement(By.xpath("//img[starts-with(@id,'SelectedDiv') and contains(@src,'sia_logo.png')]"));

		js.executeScript("arguments[0].scrollIntoView();",a );
		a.click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@class='menu-toggle']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@class='menu-toggle']")).click();
	}
	@Then("^Choose model$")
	public void choose_model() throws Throwable {
		Thread.sleep(4000);
		String Model = prop.getProperty("Model");
		if(Model.equalsIgnoreCase("Scoring")) {
			driver.findElement(By.xpath("//img[@title='Scoring Coaching Form']")).click();
		}
		else if(Model.equalsIgnoreCase("Self")) {
			driver.findElement(By.xpath("//a[@href='#javascriptvoid()']//img[@title='Self Assessment Form']")).click();
		}
		else if(Model.equalsIgnoreCase("compliance")) {
			driver.findElement(By.xpath("//img[@title='Compliance Form']")).click();
		}
		else if(Model.equalsIgnoreCase("Account")) {
			driver.findElement(By.xpath("//img[@title='Account Form']")).click();
		}
		else if(Model.equalsIgnoreCase("Remote Coaching")) {
			driver.findElement(By.xpath("//img[@title='Remote Coaching Form']")).click();
		}
		else if(Model.equalsIgnoreCase("Remote Self")) {
			driver.findElement(By.xpath("//img[@title='Remote Self Assessment Form']")).click();
		}
	}
	@Then("^Select Graph ploter and select required data$")
	public void select_Graph_ploter_and_select_required_data() throws Throwable {
		driver.findElement(By.xpath("//img[@id='new_analytics_gray_icon']")).click();	
		Thread.sleep(2000);
		String SellingSkils = prop.getProperty("SellingSkils"); 
		if(SellingSkils.equalsIgnoreCase("% Level 1")) {
			driver.findElement(By.xpath("//a[normalize-space()='% Level 1']")).click();
			}
		else if(SellingSkils.equalsIgnoreCase("% Level 2")) {
		driver.findElement(By.xpath("//a[normalize-space()='% Level 2']")).click();
		}
		else if(SellingSkils.equalsIgnoreCase("% Level 3")) {
			driver.findElement(By.xpath("//a[normalize-space()='% Level 3']")).click();
			}
		else if(SellingSkils.equalsIgnoreCase("% Level 4")) {
			driver.findElement(By.xpath("//a[normalize-space()='% Level 4']")).click();
			}
		else if(SellingSkils.equalsIgnoreCase("% Level 5")) {
			driver.findElement(By.xpath("//a[normalize-space()='% Level 5']")).click();
			}
	}
}