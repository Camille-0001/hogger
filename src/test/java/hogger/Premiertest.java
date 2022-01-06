package hogger;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PremierTest {

	WebDriver driver;
	WebDriverWait wait;
	
	
	@BeforeEach
	public void setup() {
		System.setProperty("webdriver.chrome.driver","src/main/resources/driver/chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver,20);
		driver.manage().window().maximize();
	}
	
	@Test
	public void run() throws InterruptedException {
		Homepage homepage = new Homepage(driver);

		homepage.getWebsite();
		homepage.accepterCookies();
		homepage.refuserNotifs();
		
		SearchResultPage srpage = homepage.search("Hogger");
		
		MobPage hoggerpage = srpage.getMobById("46254");
		
		int number_of_drops = hoggerpage.getLootTableLength();
		System.out.println(number_of_drops + " drops to check");
		for(int n=1; n<=hoggerpage.getLootTableLength() ; n++) {
			hoggerpage.getNthDrop(n);
			WebElement gold = driver.findElement(By.xpath("//span[@class='moneygold']"));
			System.out.println(gold.getText());
			driver.navigate().back();
			Thread.sleep(3000);			//dirty fix for sudden crashes
		}

		System.out.println("exiting with observed list length " + hoggerpage.getLootTableLength());
	}
	
	@AfterEach
	public void teardown() {
		driver.quit();
	}
	
}
