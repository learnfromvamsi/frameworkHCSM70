package pom_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibraries.WebDriverUtility;

public class SeleniumTrainingPage {
	//declaration
	@FindBy(xpath="//h1[@class='page-header']")
	private WebElement pageHeader;
	@FindBy(id="add")
	private WebElement plusButton;
	@FindBy(xpath="//button[.=' Add to Cart']")
	private WebElement addToCartButton;
	@FindBy(xpath="//div[@id='callout']/span")
	private WebElement itemAddedMessage;
	
	//initialization
	public SeleniumTrainingPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	//utilization
	public WebElement getPageHeader() {
		return pageHeader;
	}
	
	public void doubleClickPlusButton(WebDriverUtility web) {
		web.doubleClickOnElement(plusButton);
	}
	public void clickAddToCart() {
		addToCartButton.click();
	}
	 public WebElement getItemAddedMessage() {
		 return itemAddedMessage;
	 }

}
