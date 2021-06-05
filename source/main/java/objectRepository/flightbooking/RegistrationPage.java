package objectRepository.flightbooking;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {

	WebDriver driver;
	WebDriverWait wait ;
	@FindBy(xpath="//*[@id=\"inputName\"]")
	WebElement name;

	@FindBy(xpath="//*[@id=\"address\"]")
	WebElement address;

	@FindBy(xpath="//*[@id=\"city\"]")
	WebElement city;

	@FindBy(xpath="//*[@id=\"state\"]")
	WebElement state;

	@FindBy(xpath="//*[@id=\"zipCode\"]")
	WebElement zipCode;

	@FindBy(xpath="//*[@id=\"cardType\"]")
	WebElement cardType;

	@FindBy(xpath="//*[@id=\"creditCardNumber\"]")
	WebElement cardNumber;

	@FindBy(xpath="//*[@id=\"creditCardMonth\"]")
	WebElement month;

	@FindBy(xpath="//*[@id=\"creditCardYear\"]")
	WebElement year;

	@FindBy(xpath="//*[@id=\"nameOnCard\"]")
	WebElement nameOnCard;

	@FindBy(xpath="//input[@value=\"Purchase Flight\"]")
	WebElement buttonPurchaseFlight;

	@FindBy(xpath="//h1[contains(text(),'Thank you for your purchase today!')]")
	WebElement titleBookingConfirmation;

	@FindBy(xpath="//table/tbody/tr[1]/td[2]")
	WebElement bookingConfirmationID;





	// constructor method
	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	     wait = new WebDriverWait(driver, 10);
	}
	
	public void  doRegistration() throws InterruptedException {

		wait.until(ExpectedConditions.visibilityOf(name));
		name.sendKeys("name");
		wait.until(ExpectedConditions.visibilityOf(address));
		address.sendKeys("address");
		wait.until(ExpectedConditions.visibilityOf(city));
		city.sendKeys("city");
		wait.until(ExpectedConditions.visibilityOf(state));
		state.sendKeys("state");
		wait.until(ExpectedConditions.visibilityOf(zipCode));
		zipCode.sendKeys("123456");
/*		wait.until(ExpectedConditions.visibilityOf(cardType));
		Select fromDropdown= new Select(cardType);
		fromDropdown.selectByValue("American Express");*/
		wait.until(ExpectedConditions.visibilityOf(cardNumber));
		cardNumber.sendKeys("123456");
		wait.until(ExpectedConditions.visibilityOf(month));
		month.sendKeys("11");
		wait.until(ExpectedConditions.visibilityOf(year));
		year.sendKeys("3");
		wait.until(ExpectedConditions.visibilityOf(nameOnCard));
		nameOnCard.sendKeys("avinash");
		wait.until(ExpectedConditions.visibilityOf(buttonPurchaseFlight));
		buttonPurchaseFlight.click();

		Thread.sleep(5000);


	}

	public  String  returnBookingID()
	{
		//verify booking confirmation ID
		wait.until(ExpectedConditions.visibilityOf(titleBookingConfirmation));
		wait.until(ExpectedConditions.visibilityOf(bookingConfirmationID));
		String  bookingId = bookingConfirmationID.getText();
		return  bookingId;
	}
}
