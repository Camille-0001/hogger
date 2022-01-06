package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Homepage extends BasePage {
	
	@FindBy (id = "onetrust-accept-btn-handler")
	private WebElement cookie_button;
	
	@FindBy (xpath = "//button[@class='notifications-dialog-buttons-decline btn']")
	private WebElement notifs_button;
	
	public Homepage(WebDriver driver) {
		super(driver);
	}
	
	public void getWebsite() {
		driver.get("https://www.wowhead.com");
	}
	
	public void accepterCookies() {
		wait.until(ExpectedConditions.elementToBeClickable(cookie_button));
		cookie_button.click();
	}
	
	public void refuserNotifs() {
		wait.until(ExpectedConditions.elementToBeClickable(notifs_button));
		notifs_button.click();
	}
	
}
