package objectRepository.flightbooking;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookingHomePage {

	WebDriver driver;

	@FindBy(xpath="//select[@name='fromPort']")
	WebElement fromPort;

	@FindBy(xpath="//select[@name='toPort']")
	WebElement toPort;

	@FindBy(xpath="//input[@class='btn btn-primary']")
	WebElement btnFindFlights;

	@FindBy(xpath="//h3[contains(text(),'Flights from Boston to']")
	WebElement flightSelectionPageHeader;



	// constructor method
	public BookingHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public  void SourceDestination( String source, String destination) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(fromPort));
		Select fromDropdown= new Select(fromPort);
		fromDropdown.selectByValue(source);
		wait.until(ExpectedConditions.visibilityOf(toPort));
		Select toDropDown= new Select(toPort);
		toDropDown.selectByValue(destination);
		wait.until(ExpectedConditions.visibilityOf(btnFindFlights));
		Thread.sleep(10000);
		btnFindFlights.click();
		wait.until(ExpectedConditions.titleIs("BlazeDemo - reserve"));

	}
}
