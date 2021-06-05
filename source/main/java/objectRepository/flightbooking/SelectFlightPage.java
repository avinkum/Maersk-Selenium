package objectRepository.flightbooking;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectFlightPage {

	WebDriver driver;

	@FindBy(xpath="//table/tbody/tr[2]/td[1]")
	WebElement flightTable;




	// constructor method
	public SelectFlightPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public  void selectFlight( int flightname, String airline)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(flightTable));
		flightTable.click();
		System.out.println(driver.getTitle());

	}
}
