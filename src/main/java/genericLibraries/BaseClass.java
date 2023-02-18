package genericLibraries;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pom_pages.ContactUsPage;
import pom_pages.CoreJavaForSeleniumPage;
import pom_pages.CoreJavaVideoPage;
import pom_pages.HomePage;
import pom_pages.SeleniumTrainingPage;
import pom_pages.SkillraryDemoAppPage;
import pom_pages.TestingPage;

public class BaseClass {
	protected PropertiesFileUtility property;
	protected ExcelUtility excel;
	protected WebDriverUtility web;
	protected WebDriver driver;
	protected HomePage home;
	protected SkillraryDemoAppPage skillraryDemo;
	protected SeleniumTrainingPage selenium;
	protected TestingPage testing;
	protected CoreJavaForSeleniumPage coreJava;
	protected CoreJavaVideoPage javaVideo;
	protected ContactUsPage contact;
	protected long time;

	// @BeforeSuite --> it is used in the case of database connectivity
	// @BeforeTest --> it is used in parallel execution

	@BeforeClass
	public void classConfiguration() {
		 property = new PropertiesFileUtility();

		 excel = new ExcelUtility();
		 web = new WebDriverUtility();

		property.propertyFileInitialization(IConstantPath.PROPERTIES_FILE_PATH);
		excel.excelInitialization(IConstantPath.EXCEL_FILE_PATH);

	}

	@BeforeMethod
	public void methodConfiguration() {
		long time = Long.parseLong(property.fetchProperty("timeouts"));
		driver = web.openApplication(property.fetchProperty("browser"), property.fetchProperty("url"), time);
		home = new HomePage(driver);
		Assert.assertTrue(home.getLogo().isDisplayed());
		skillraryDemo = new SkillraryDemoAppPage(driver);
		selenium = new SeleniumTrainingPage(driver);
		coreJava = new CoreJavaForSeleniumPage(driver);
		javaVideo = new CoreJavaVideoPage(driver);
		testing = new TestingPage(driver);
		contact = new ContactUsPage(driver);

	}

	@AfterMethod
	public void methodTearDown() {
		web.quitBrowser();
	}

	@AfterClass
	public void classTearDown() {
		excel.closeExcel();
	}
	// @AfterTest
	// @AfterSuite

}
