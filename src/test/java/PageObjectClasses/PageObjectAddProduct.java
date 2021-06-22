package PageObjectClasses;


import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.Select;


public class PageObjectAddProduct {
	
	public WebDriver driver;
	
	public PageObjectAddProduct(WebDriver adddriver) {
		
		driver=adddriver;
		
		PageFactory.initElements(adddriver, this);
		
	}
	// Login Xpaths
	
	@FindBy(how=How.XPATH,using= "//input[@id='userImage']")
	WebElement enterEmail;
	
	@FindBy(how=How.XPATH, using="//input[@id='passwordImage']")
	WebElement EnterPassword;
	
	@FindBy(how=How.XPATH, using="//input[@id='loginSubmit']")
	WebElement LoginButton;
	
	// Click on Ok popup
	
	@FindBy(how=How.XPATH, using="//div[@class='advert-button btn_m']")
	WebElement clickOnOk;
	
	
	// Add Product
	
	@FindBy(xpath="//input[@id='PName']")
	WebElement ProductName;
	
	@FindBy(xpath="//input[@id='Abbreviation']")
	WebElement ProductGenericName;
	
	@FindBy(xpath="//input[@id='Sequence']")
	WebElement ProductSequencen;
	
	@FindBy(xpath="//input[@id='save']")
	WebElement Productsavebutton;
	
	
	// Add Role & Select Role Type
	
	@FindBy(xpath="//input[@id='CName']")
	WebElement AddRole;
	
	@FindBy(xpath="//select[@data-bind=\"options: RoleLevels,optionsText: 'LevelName', optionsValue:'RoleLevelID', value: SelectedRoleLevel\"]")
	WebElement SelectRoleType;	
	
	
	// Action Class
	
	public void Login(String id, String passwrd) throws InterruptedException {
		enterEmail.clear();
		Thread.sleep(1000);
		enterEmail.sendKeys(id);
		
		EnterPassword.clear();
		Thread.sleep(1000);
		EnterPassword.sendKeys(passwrd);
		
	}
	
	public void loginButton() {
		LoginButton.click();
	}

	
	public void AddProducts(String name, String Gname , String Seq) throws InterruptedException {
		Thread.sleep(500);
		ProductName.sendKeys(name);
		Thread.sleep(500);
		ProductGenericName.sendKeys(Gname);
		Thread.sleep(500);
		ProductSequencen.sendKeys(Seq);
		Thread.sleep(500);
		//Productsavebutton.click();
	}
	
	public void AddRole_SelectType(String RoleName , String Role) throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[normalize-space()='Add Roles']")).click();
		Thread.sleep(1000);
		AddRole.sendKeys(RoleName);
		Select select = new Select(SelectRoleType);
		
		if(Role.equalsIgnoreCase("1st")) {
			select.selectByVisibleText("1 st Level/Rep");
		}
		else if(Role.equalsIgnoreCase("2nd")) {
			select.selectByVisibleText("2 nd Level/FLSM");
		}
		else if(Role.equalsIgnoreCase("3rd")) {
			select.selectByVisibleText("3 rd Level/SLSM");
		}
		else if(Role.equalsIgnoreCase("4th")) {
			select.selectByVisibleText("4 th Level/TLSM");
		}
		else if(Role.equalsIgnoreCase("5th")) {
			select.selectByVisibleText("5 th level/Compliance");
		}
    }

}
