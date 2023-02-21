package testScripts;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;

public class FirstTest extends BaseClass {
	
	@Test
	public void firstTest() {
		SoftAssert soft = new SoftAssert();
		home.clickGears();
		home.clickSkillrarydemoApp();
		web.handleChildBrowser();
		soft.assertTrue(skillraryDemo.getPageHeader().isDisplayed());
		skillraryDemo.mouseHoverToCourse(web);
		skillraryDemo.clickSeleniumTraining();
		soft.assertEquals(selenium.getPageHeader().getText(),"Selenium Training");
		selenium.doubleClickPlusButton(web);
		selenium.clickAddToCart();
		web.handleAlert();
		web.explicitlywait(time,selenium.getItemAddedMessage());
		web.takeScreenshot();
		soft.assertTrue(selenium.getItemAddedMessage().isDisplayed());
		soft.assertAll();
		
		
	}
}
