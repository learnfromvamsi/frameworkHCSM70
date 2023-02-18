package pom_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CoreJavaVideoPage {
	//declaration
		
	@FindBy(xpath="//h1")
	private WebElement pageHeader;
	@FindBy(xpath="//button[.='Play']")
	private WebElement playButton;
	
	@FindBy(xpath="//a[@class='close_cookies']")
	private WebElement closeCookies;
	
	@FindBy(xpath="//button[.='Play']")
	private WebElement pauseButton;
	
	@FindBy(xpath="//span[.='Add To Wishlist']")
	private WebElement addToWishList;
	
	@FindBy(xpath="//a[@class='close_cookies']")
	private WebElement closeCookiesIcon;
	
	//initialization
	public CoreJavaVideoPage (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	
	public String getPageHeader() {
		return pageHeader.getText();
	}
	
	public void closeCookies() {
		closeCookies.click();
	}
	public void clickPlayButton() {
		playButton.click();
		
	}
	public void clickPauseButton() {
		pauseButton.click();
		
	}
	public void addToWishList() {
		addToWishList.click();	
	}
	
	public void clickCloseCookies() {
		closeCookiesIcon.click();
		
	}

}
