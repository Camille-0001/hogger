package hogger;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MobPage extends BasePage{

	@FindBy (xpath = "//div[@id='tab-drops']//a[@class='q3 listview-cleartext']")
	private List<WebElement> loot_list;
	
	public MobPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
	}

	
	
	public ItemPage getDropById(String id) {
		WebElement dropped_item = driver.findElement(By.xpath("//div[@id='tab-drops']//a[@class='q3 listview-cleartext'][contains(@href,'item="+id+"')]"));
		wait.until(ExpectedConditions.elementToBeClickable(dropped_item));
		dropped_item.click();
		return new ItemPage(driver);
	}
	
	public ItemPage getNthDrop(int n) {
		WebElement nth_drop = loot_list.get(n-1);
		wait.until(ExpectedConditions.elementToBeClickable(nth_drop));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", nth_drop);
		nth_drop.click();
		return new ItemPage(driver);
	}
	
	public int getLootTableLength() {
		return loot_list.size();
	}
}
