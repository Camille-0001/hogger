package hogger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchResultPage extends BasePage{

	@FindBy (xpath = "//div[@id='tab-npcs']//td[@class='icon-boss-padded']/a[contains(text(),'Hogger')]")
	private WebElement literally_just_hogger;
	
	public SearchResultPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
	}
	
	public MobPage getLiterallyJustHogger(){
				wait.until(ExpectedConditions.elementToBeClickable(literally_just_hogger));
				literally_just_hogger.click();
		return new MobPage(driver);
	}
	
	public MobPage getMobById(String id) {
				WebElement mob_result = driver.findElement(By.xpath("//div[@id='tab-npcs']//td/a[contains(@href,'npc="+id+"')]"));
				wait.until(ExpectedConditions.elementToBeClickable(mob_result));
				mob_result.click();
		return new MobPage(driver);
	}
	

}
