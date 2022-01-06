package test;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
	WebDriver driver;
	WebDriverWait wait;

	@FindBy (xpath = "//input[@name='q']")
	private WebElement search_bar;
	
	@FindBy (xpath = "//a[@class='header-search-button fa fa-search']")
	private WebElement search_button;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver,20);
		PageFactory.initElements(driver, this);	
	}
	
	public SearchResultPage search(String search_string){
		
		wait.until(ExpectedConditions.visibilityOf(search_bar));
		search_bar.sendKeys(search_string);
		search_bar.sendKeys(Keys.ENTER);
		/*also possible to click on the magnifying glass button :
		wait.until(ExpectedConditions.elementToBeClickable(search_button));
		search_button.click();
		*/
		
		return new SearchResultPage(driver);
	}
}
