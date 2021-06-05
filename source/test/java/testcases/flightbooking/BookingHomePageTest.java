package testcases.flightbooking;

import objectRepository.flightbooking.*;
import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BookingHomePageTest {

	BookingHomePage bookingHomePage = null;
	SelectFlightPage selectFlightPage = null;
	RegistrationPage registrationPage =null;

	@BeforeClass
	public void VerifySourceDestination() {

		BrowserSetting bs = new BrowserSetting();
		WebDriver driver = bs.BrowserSettings();
		bookingHomePage = new BookingHomePage(driver);
		selectFlightPage = new SelectFlightPage(driver);
		registrationPage = new RegistrationPage(driver);
	}
    @Test(priority = 0, description = "user selecting the source and destination")
	private void verifyValidBooking() throws InterruptedException {

		bookingHomePage.SourceDestination("Boston", "London");
		 Thread.sleep(5000);
		selectFlightPage.selectFlight(234,"United Airlines");
		Thread.sleep(5000);
		registrationPage.doRegistration();
		registrationPage.returnBookingID();

	}





}
