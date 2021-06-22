package AdminStepDefination;

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

public class AdminSteps{

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

	@Then("^Select Company Logo and add product$")
	public void select_Company_Logo_and_add_product() throws Throwable {
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor)driver; 

		WebElement a=driver.findElement(By.xpath("//img[starts-with(@id,'SelectedDiv') and contains(@src,'sia_logo.png')]"));

		js.executeScript("arguments[0].scrollIntoView();",a );
		a.click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='advert-button btn_m']")).click();
		Thread.sleep(2000);
		addProduct.AddProducts(prop.getProperty("Productname")+random(), prop.getProperty("ProductGenericName")+random(), prop.getProperty("ProductSequence")+random());
	}

	@Then("^Add Role name and Select Role type$")
	public void add_Role_name_and_Select_Role_type() throws Throwable {

		String RoleType = prop.getProperty("RoleType");
		String Role = prop.getProperty("Role");
		Thread.sleep(2000);

		// Add Role name
		driver.findElement(By.xpath("//div[@class='menubar']//a[normalize-space()='Add Roles']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='CName']")).sendKeys(Role);
		Thread.sleep(1000);

		// Select Role type
		WebElement Selectdrop= driver.findElement(By.xpath("//tbody/tr[3]/td[2]/select[1]"));
		Select select = new Select(Selectdrop);
		System.out.println(Selectdrop);
		if(RoleType.equalsIgnoreCase("1st")) {
			select.selectByVisibleText("1 st Level/Rep");
		}
		else if(RoleType.equalsIgnoreCase("2nd")) {
			select.selectByVisibleText("2 nd Level/FLSM");
		}
		else if(RoleType.equalsIgnoreCase("3rd")) {
			select.selectByVisibleText("3 rd Level/SLSM");
		}
		else if(RoleType.equalsIgnoreCase("4th")) {
			select.selectByVisibleText("4 th Level/TLSM");
		}
		else if(RoleType.equalsIgnoreCase("5th")) {
			select.selectByVisibleText("5 th level/Compliance");
		}
	}

	@Then("^Add Geography and franchises$")
	public void add_Geography_and_franchises() throws Throwable {

		// Add Geography

		String ParentLocation = prop.getProperty("ParentLocation");
		String Location = prop.getProperty("Location");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[contains(text(),'Add Geography')]")).click();
		Thread.sleep(1000);
		WebElement Locationdrop= driver.findElement(By.xpath("//tbody/tr[2]/td[2]/select[1]"));
		Thread.sleep(1000);
		Select selectLoc = new Select(Locationdrop);
		if(ParentLocation.equalsIgnoreCase("India")) {
			selectLoc.selectByVisibleText("India");
		}
		else if(ParentLocation.equalsIgnoreCase("Haryana")) {
			selectLoc.selectByVisibleText("Haryana");
		}
		else if(ParentLocation.equalsIgnoreCase("Uttarakhand")) {
			selectLoc.selectByVisibleText("Uttarakhand");
		}
		else if(ParentLocation.equalsIgnoreCase("Karnataka")) {
			selectLoc.selectByVisibleText("Karnataka");
		}
		else if(ParentLocation.equalsIgnoreCase("Uttar Pardesh")) {
			selectLoc.selectByVisibleText("Uttar Pardesh");
		}

		else
		{
			System.out.println("Parentlocation Doen't Exist. Please Choose from these Locations : India, Haryana, Uttarakhand, Karnataka ,Uttar Pardesh");
		}

		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='Location']")).sendKeys(Location);



		//Add franchises

		String franchises_Name = prop.getProperty("franchises_Name");
		String Select_RoleName = prop.getProperty("Select_RoleName");
		String Select_ProductName = prop.getProperty("Select_ProductName");
		String Select_Location = prop.getProperty("Select_Location");


		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(),'Add Franchises')]")).click();	
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='FName']")).sendKeys(franchises_Name);
		Thread.sleep(2000);

		// Select Role
		List<WebElement> opt = driver.findElements(By.xpath("//div[@id='s2id_RName']//ul[@class='select2-choices']"));
		for(WebElement options:opt)
		{
			if(options.getText().equalsIgnoreCase(Select_RoleName));
			options.click();
			Thread.sleep(2000);
			WebElement d = driver.findElement(By.xpath("//select[@id='RName']"));
			Select g = new Select(d);
			g.selectByVisibleText("Test_Role_Name");
		}


		// Select Product name
		Thread.sleep(2000);
		List<WebElement> opt1 = driver.findElements(By.xpath("//div[@id='s2id_PName']//ul[@class='select2-choices']"));
		for(WebElement options1:opt1)
		{
			if(options1.getText().equalsIgnoreCase(Select_ProductName));
			options1.click();
			Thread.sleep(2000);
			WebElement SelectClick = driver.findElement(By.xpath("//select[@id='PName']"));
			Select chooseproduct = new Select(SelectClick);
			chooseproduct.selectByVisibleText("Test_Product_Name2");
		}

		// Select Location
		Thread.sleep(2000);
		List<WebElement> opt2 = driver.findElements(By.xpath("//tbody/tr[2]/td[2]/div[1]/ul[1]"));
		for(WebElement options2:opt2)
		{
			if(options2.getText().equalsIgnoreCase(Select_Location));
			options2.click();
			Thread.sleep(2000);
			WebElement SelectClick = driver.findElement(By.xpath("//select[@id='GName']"));
			Select chooseLocation = new Select(SelectClick);
			chooseLocation.selectByVisibleText("Karnataka");
		}
	}



	@Then("^fill user detail and map with franchises$")
	public void fill_user_detail_and_map_with_franchises() throws Throwable {

		// Add User

		String FirstName = prop.getProperty("FirstName");
		String LastName = prop.getProperty("LastName");
		String UserSex = prop.getProperty("UserSex");
		String Email = prop.getProperty("Email");
		String Userf = prop.getProperty("Userf");
		String Select_ProductName = prop.getProperty("Select_ProductName");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[normalize-space()='Add Users']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='FName']")).sendKeys(FirstName);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='LName']")).sendKeys(LastName);
		Thread.sleep(1000);
		WebElement selectSex = driver.findElement(By.xpath("//select[@id='Sex']"));
		Select ChooseSex = new Select(selectSex);
		if(UserSex.equalsIgnoreCase("Male")) {
			ChooseSex.selectByVisibleText("Male");
		}
		else if(UserSex.equalsIgnoreCase("Male")) {
			ChooseSex.selectByVisibleText("Female");
		}
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(Email);



		// Map franchises
		Thread.sleep(2000);
		WebElement SelFrn = driver.findElement(By.xpath("//select[@id='FName1']"));
		Select Choosefrn = new Select(SelFrn);
		if(Userf.equalsIgnoreCase("Mojenta india pvt ltd")) {
			Choosefrn.selectByVisibleText("Mojenta India Pvt Ltd");
		}
		else if(Userf.equalsIgnoreCase("Healthcare interAction")) {
			Choosefrn.selectByVisibleText("Healthcare interAction");
		}


		// Select product
		Thread.sleep(2000);
		List<WebElement> opt4 = driver.findElements(By.xpath("//tbody/tr[1]/td[4]/div[1]/ul[1]"));
		for(WebElement options4:opt4)
		{
			if(options4.getText().equalsIgnoreCase(Select_ProductName));
			options4.click();
			Thread.sleep(2000);
			WebElement SelectClick = driver.findElement(By.xpath("//select[@id='FName2']"));
			Select chooseproduct = new Select(SelectClick);
			chooseproduct.selectByVisibleText("Test_Product_Name");
		}

		// Role

		Thread.sleep(2000);
		String ChooseRole1 = prop.getProperty("ChooseRole");
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		WebElement SelRole = driver.findElement(By.xpath("//select[@id='Role']"));
		jse.executeScript("arguments[0].scrollIntoView();",SelRole );	

		Select ChooseRoleTest = new Select(SelRole);
		if(ChooseRole1.equalsIgnoreCase("Test_Role_Name")) {
			ChooseRoleTest.selectByVisibleText("Test_Role_Name");
		}
		Thread.sleep(6000);

		// View Role

		String getRoleView = prop.getProperty("RoleView");
		WebElement SelRoleView = driver.findElement(By.xpath("//select[@id='SView']"));
		Select ChsooseRoleview = new Select(SelRoleView);
		if(getRoleView.equalsIgnoreCase("admin")) {
			ChsooseRoleview.selectByVisibleText("Admin");
		}
		Thread.sleep(2000);


		// Geography
		Thread.sleep(2000);

		String FLOcation = prop.getProperty("UserFLOcation");
		List<WebElement> opt5 = driver.findElements(By.xpath("//div[@id='s2id_RGeography']//ul[@class='select2-choices']"));
		for(WebElement options5:opt5)
		{
			if(options5.getText().equalsIgnoreCase(FLOcation));	
			options5.click();
			Thread.sleep(2000);
			WebElement SelectLoc = driver.findElement(By.xpath("//select[@id='RGeography']"));
			Select chooseproduct = new Select(SelectLoc);
			chooseproduct.selectByVisibleText("India");
		}
		driver.findElement(By.xpath("label1Reset")).click();


	}

	@Then("^Select model according franchises and User$")
	public void select_model_according_franchises_and_User() throws Throwable {
		driver.findElement(By.xpath("//a[normalize-space()='Organisation']")).click();
	}


	// Sales Model Management //


	@Then("^Select Company Logo and add Catagory$")
	public void select_Company_Logo_and_add_Catagory() throws Throwable {

		// add Catagory
		Thread.sleep(2000);
		String Cname = prop.getProperty("Company_Name");
		String Aname = prop.getProperty("Alias_Name");
		String Csequence = prop.getProperty("Company_Sequence");

		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor)driver; 

		WebElement a=driver.findElement(By.xpath("//img[starts-with(@id,'SelectedDiv') and contains(@src,'sia_logo.png')]"));

		js.executeScript("arguments[0].scrollIntoView();",a );
		a.click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='advert-button btn_m']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@data-bind='text: languageko().SalesModelManagement']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//tbody/tr[2]/td[2]/input[1]")).sendKeys(Cname);
		driver.findElement(By.xpath("//tbody/tr[3]/td[2]/input[1]")).sendKeys(Aname);
		driver.findElement(By.xpath("//input[@id='Sequence']")).sendKeys(Csequence);
	}

	@Then("^Add compentency Element and Add Element$")
	public void add_compentency_Element_and_Add_Element() throws Throwable {

		String Ename = prop.getProperty("Element_Name");
		String Esequence = prop.getProperty("Element_Sequence");
		String ESfactory = prop.getProperty("Element_Scale_Factory");

		String AddElementName = prop.getProperty("Add_Element_Name");
		String EAName = prop.getProperty("Element_Alias_Name");
		String AESequence = prop.getProperty("Add_Element_Sequence");

		// Add compentency Element
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(text(),'Competency Element')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@data-bind='value: $root.ElementName']")).sendKeys(Ename);
		driver.findElement(By.xpath("//input[@data-bind='value: $root.Sequence']")).sendKeys(Esequence);
		Thread.sleep(2000);
		WebElement fill = driver.findElement(By.xpath("//input[@data-bind='value: $root.ScaleFacor']"));
		fill.clear();
		fill.sendKeys(ESfactory);

		// Add Element
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@data-bind='text: languageko().AddElement']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@data-bind='value: $root.ElementName']")).sendKeys(AddElementName);
		driver.findElement(By.xpath("//input[@data-bind='value: $root.AliasName']")).sendKeys(EAName);
		driver.findElement(By.xpath("//input[@id='ESequence']")).sendKeys(AESequence);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='ko_unique_1']")).click();
	}

	@Then("^Add Assignment option and Catagory Element Mapping$")
	public void add_Assignment_option_and_Catagory_Element_Mapping() throws Throwable {

		String CEName = prop.getProperty("Choose_Element_Name");
		String CPName = prop.getProperty("Choose_Product_Name");
		String AAO = prop.getProperty("Add_Assignment_Option");
		String CCN = prop.getProperty("Choose_Category_Name");
		String CEN = prop.getProperty("Choose_Element_Name");


		// Add Assignment option
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@data-bind='text: languageko().AddAssessmentOptions']")).click();
		Thread.sleep(2000);
		WebElement chooseElement  = driver.findElement(By.xpath("//select[@data-bind=\"options: ElementsValues,optionsText:'ElementName', value: selectedElementValue\"]"));
		Select SelectElement = new Select(chooseElement);
		SelectElement.selectByVisibleText("Call Plan_Test_4/7");
		Thread.sleep(3000);
		List<WebElement> opt6 = driver.findElements(By.xpath("//ul[@class='select2-choices']"));
		for(WebElement options6:opt6)
		{
			if(options6.getText().equalsIgnoreCase(CPName));	
			options6.click();
			Thread.sleep(3000);
			WebElement SelectLoc = driver.findElement(By.xpath("//select[@id='PName']"));
			Select chooseproduct = new Select(SelectLoc);
			chooseproduct.selectByVisibleText("Test_Product_Name2");
		}

		driver.findElement(By.xpath("//input[@data-bind='value:itemToAdd, valueUpdate: \"afterkeydown\"']")).sendKeys(AAO);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Add']")).click();

		// Catagory Element Mapping //
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@data-bind='click: $root.CategoryElementManagementModelclick']")).click();
		Thread.sleep(3000);
		WebElement chooseCategoryName  = driver.findElement(By.xpath("//select[@data-bind=\"options: Categories,optionsText: 'CategoryName', optionsValue:'CategoryId', value: selectedCategoryValues\"]"));
		Select SelectElementNAme = new Select(chooseCategoryName);
		SelectElementNAme.selectByVisibleText("Other");

		List<WebElement> opt7 = driver.findElements(By.xpath("//ul[@class='select2-choices']"));
		for(WebElement options7:opt7)
		{
			if(options7.getText().equalsIgnoreCase(CEN));	
			options7.click();
			Thread.sleep(2000);
			WebElement SelectLoc = driver.findElement(By.xpath("//select[@id='RManager']"));
			Select chooseproduct = new Select(SelectLoc);
			chooseproduct.selectByVisibleText("KAM");
		}

	}

	@Then("^Add model and Scale factory$")
	public void add_model_and_Scale_factory() throws Throwable {
		String MN = prop.getProperty("Model_Name");
		String MSF = prop.getProperty("Model_Scale_Factor");
		String MT = prop.getProperty("ModelType");
		String AL = prop.getProperty("Assessess_Level");
		String CEN = prop.getProperty("Choose_Element_Name");
		String SelF = prop.getProperty("SelCom");
		String SelCat = prop.getProperty("SelCat");


		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(text(),'Add New Model')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='SMName']")).sendKeys(MN);
		driver.findElement(By.xpath("//input[@id='SFactor']")).sendKeys(MSF);
		WebElement chooseModeltype  = driver.findElement(By.xpath("//select[@data-bind=\"options: SalesModelTypes,optionsText: 'ModelType', optionsValue:'ModelTypeId', value: SelectedModelType\"]"));
		Select SelectModelType = new Select(chooseModeltype);
		SelectModelType.selectByVisibleText("Remote Call");
		Thread.sleep(2000);
		WebElement chooseAType  = driver.findElement(By.xpath("//select[@data-bind=\"options: RoleLevels,optionsText: 'LevelName', optionsValue:'RoleLevelID', value: SelectedRoleLevel\"]"));
		Select SelectAType = new Select(chooseAType);
		SelectAType.selectByVisibleText("3 rd Level/SLSM");
		Thread.sleep(2000);

		List<WebElement> opt8 = driver.findElements(By.xpath("//div[@id='s2id_FName']//ul[@class='select2-choices']"));
		for(WebElement options8:opt8)
		{
			if(options8.getText().equalsIgnoreCase(SelF));	
			options8.click();
			Thread.sleep(2000);
			WebElement SelectLoc = driver.findElement(By.xpath("//select[@id='FName']"));
			Select chooseproduct = new Select(SelectLoc);
			chooseproduct.selectByVisibleText("Mojenta India Pvt Ltd");
		}
		Thread.sleep(1000);

		List<WebElement> opt9 = driver.findElements(By.xpath("//div[@id='s2id_CName']//ul[@class='select2-choices']"));
		for(WebElement options9:opt9)
		{
			if(options9.getText().equalsIgnoreCase(SelCat));	
			options9.click();
			Thread.sleep(2000);
			WebElement SelectLoc = driver.findElement(By.xpath("//select[@id='CName']"));
			Select chooseproduct = new Select(SelectLoc);
			chooseproduct.selectByVisibleText("Category 1");
		}

		Thread.sleep(2000);

		// ****** Add Scale Factor *****

		String SF = prop.getProperty("ScaleFactor");
		String SFT = prop.getProperty("ScaleFactorTest");
		String SFD = prop.getProperty("scaleFactorDesc");

		driver.findElement(By.xpath("//span[contains(text(),'Add Scale Factor')]")).click();
		Thread.sleep(2000);
		WebElement chooseCategory  = driver.findElement(By.xpath("//select[@data-bind=\"options: SalesModelSFList,optionsText: 'SalesModelName', optionsValue:'SalesModelId', value: SelectedSalesModelId\"]"));
		Select SelectElement = new Select(chooseCategory);
		SelectElement.selectByVisibleText("QA_Test_Model");

		driver.findElement(By.xpath("//input[@id='Sequence']")).sendKeys(SF);
		driver.findElement(By.xpath("//tbody/tr[4]/td[2]/input[1]")).sendKeys(SFT);
		driver.findElement(By.xpath("//tbody/tr[5]/td[2]/input[1]")).sendKeys(SFD);

	}

	@Then("^All model group and view mapping$")
	public void all_model_group_and_view_mapping() throws Throwable {
		String MGN = prop.getProperty("modelGroupName");
		String SMN = prop.getProperty("SelModelName");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(text(),'Add Model Group')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@data-bind='value: $root.ModelSetName']")).sendKeys(MGN);
		Thread.sleep(1000);
		List<WebElement> opt5 = driver.findElements(By.xpath("//ul[@class='select2-choices']"));
		for(WebElement options5:opt5)
		{
			if(options5.getText().equalsIgnoreCase(SMN));	
			options5.click();
			Thread.sleep(2000);
			WebElement SelectLoc = driver.findElement(By.xpath("//select[@id='EName']"));
			Select chooseproduct = new Select(SelectLoc);
			chooseproduct.selectByVisibleText("QA_Test_Model");
		}

		driver.findElement(By.xpath("//span[contains(text(),'View Mapping')]")).click();
		Thread.sleep(2000);
		WebElement chooseView  = driver.findElement(By.xpath("//select[@data-bind=\"options: ViewsList,optionsText: 'ViewName', optionsValue:'ViewId', value: selectedViewValues\"]"));
		Select SelectView = new Select(chooseView);
		SelectView.selectByVisibleText("Rep");
		Thread.sleep(2000);
		WebElement chooseOrg  = driver.findElement(By.xpath("//select[@data-bind=\"options: Franchises,optionsText: 'FranchiseName', optionsValue:'FranchiseId', value: SelectedFranchiseId\"]"));
		Select SelectOrg = new Select(chooseOrg);
		SelectOrg.selectByVisibleText("Mojenta India Pvt Ltd");
		Thread.sleep(2000);
		WebElement ChooseModelGroup  = driver.findElement(By.xpath("//select[@data-bind=\"options: ModelSetList,optionsText: 'ModelSetName', optionsValue:'ModelSetId', value: selectedModelGroupValues\"]"));
		Select SelectModelGroup = new Select(ChooseModelGroup);
		SelectModelGroup.selectByVisibleText("TestingGroupModel");
		Thread.sleep(2000);
	}

	@Then("^check Model Managament$")
	public void check_Model_Managament() throws Throwable {
		driver.findElement(By.xpath("//span[@data-bind='text: languageko().ModelManagement']")).click();

	}

	// ***** Coaching Form Management *****

	@Then("^Select Company Logo and Select Coaching Form Management$")
	public void select_Company_Logo_and_Select_Coaching_Form_Management() throws Throwable {
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor)driver; 

		WebElement a=driver.findElement(By.xpath("//img[starts-with(@id,'SelectedDiv') and contains(@src,'sia_logo.png')]"));

		js.executeScript("arguments[0].scrollIntoView();",a );
		a.click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='advert-button btn_m']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(text(),'Coaching Form Management')]")).click();
	}

	@Then("^Select Range of date$")
	public void select_Range_of_date() throws Throwable {

		String FDate = prop.getProperty("FromDate");
		String TDate = prop.getProperty("ToDate");
		Thread.sleep(2000);
		WebElement fromdate = 	driver.findElement(By.xpath("//input[@id='txtDateFrom']"));	
		fromdate.clear();
		fromdate.sendKeys(FDate);
		WebElement Todate	= driver.findElement(By.xpath("//input[@id='txtDateTo']"));
		Todate.clear();
		Todate.sendKeys(TDate);
	}

	@Then("^Click on submit button$")
	public void click_on_submit_button() throws Throwable {
		driver.findElement(By.xpath("//button[normalize-space()='SUBMIT']")).click();
	}

	@Then("^Choose Show limit and Search$")
	public void choose_Show_limit_and_Search() throws Throwable {
		Thread.sleep(1000);		
		WebElement ChooseLimit  = driver.findElement(By.xpath("//select[@name='proposals_length']"));
		Select SelectLimit = new Select(ChooseLimit);
		SelectLimit.selectByVisibleText("100");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys("15-03-2021");
	}


	// ******  LRC Management and Audit trail ******

	@Then("^Select Company Logo and Select LRC Management$")
	public void select_Company_Logo_and_Select_LRC_Management() throws Throwable {
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor)driver; 

		WebElement a=driver.findElement(By.xpath("//img[starts-with(@id,'SelectedDiv') and contains(@src,'sia_logo.png')]"));

		js.executeScript("arguments[0].scrollIntoView();",a );
		a.click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='advert-button btn_m']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(text(),'LRC Management')]")).click();
	}

	@Then("^select Parent and topic$")
	public void select_Parent_and_topic() throws Throwable {
		Thread.sleep(1000);		
		WebElement ChooseParent = driver.findElement(By.xpath("//select[@data-bind=\"options: LearningResourceTopicList,optionsText: 'TopicName', optionsValue:'TopicId', value: SelectedTopicId\"]"));
		Select SelectParent = new Select(ChooseParent);
		SelectParent.selectByVisibleText("User Guide");

		driver.findElement(By.xpath("//input[@id='TopicName']")).sendKeys("test");


	}

	@Then("^Language and upload file$")
	public void language_and_upload_file() throws Throwable {
		Thread.sleep(1000);	

		WebElement ChooseLimit  = driver.findElement(By.xpath("//select[@id='IdLanguage']"));
		Select SelectLimit = new Select(ChooseLimit);
		SelectLimit.selectByVisibleText("English");
		Thread.sleep(2000);

		WebElement uploadFile = driver.findElement(By.xpath("//input[@id='LRC_file']"));
		uploadFile.sendKeys("C:\\Users\\lakhan\\Downloads\\1.png");
	}

	@Then("^add URL$")
	public void add_URL() throws Throwable {
		driver.findElement(By.xpath("//input[@id='VideoUrl']")).sendKeys("https://www.guru99.com/upload-download-file-selenium-webdriver.html");

	}

	@Then("^click on audit trail$")
	public void click_on_audit_trail() throws Throwable {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//body/div[@id='main-section']/div[1]/div[1]/nav[1]/ul[1]/li[7]/a[1]")).click();
	}

	@Then("^Seach data according date$")
	public void seach_data_according_date() throws Throwable {
		Thread.sleep(10000);
		WebElement FDate = driver.findElement(By.xpath("//input[@id='txtDateFrom']"));
		FDate.clear();
		Thread.sleep(1000);
		FDate.sendKeys("2019-06-16");
		Thread.sleep(1000);
		WebElement TDate = driver.findElement(By.xpath("//input[@id='txtDateTo']"));
		TDate.clear();
		Thread.sleep(1000);
		TDate.sendKeys("2019-06-16");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[normalize-space()='SUBMIT']")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys("abhijit@salesinteraction.com");
		Thread.sleep(2000);

		String Working_Enable_check = prop.getProperty("Is_Custom_Ways_of_Working_Enable");
		String Compliance_Enable_check = prop.getProperty("Is_Compliance_Form_Enable");
		String Transactional_Enable_check = prop.getProperty("Is_Transactional_Call_Enable");
		String SelfAssessment_Enable_check = prop.getProperty("Is_SelfAssessment_Enable");

		if(Working_Enable_check.equalsIgnoreCase("yes")) {
			driver.findElement(By.xpath("//input[@data-bind='checked: $root.IsCustomWOWActive']")).click();
		}

		if(Compliance_Enable_check.equalsIgnoreCase("yes")) {
			driver.findElement(By.xpath("//input[@data-bind='checked: $root.IsComplianceActive']")).click();
		}
		if(Transactional_Enable_check.equalsIgnoreCase("yes")) {
			driver.findElement(By.xpath("//input[@data-bind='checked: $root.IsTransactionalCallActive']")).click();
		}
		if(SelfAssessment_Enable_check.equalsIgnoreCase("yes")) {
			driver.findElement(By.xpath("//input[@data-bind='checked: $root.IsSelfAssessmentForm']")).click();		
		}

	}

}
