package operations;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pageObject.AddressPage_po;
import pageObject.AuthenticationPage_po;
import pageObject.BasketPage_po;
import pageObject.LandingPage_po;
import pageObject.PaymentPage_po;
import pageObject.ProductPage_po;
import pageObject.RegistrationPage_po;
import pageObject.ShippingPage_po;
import utilities.Wait;

public class Logic extends Base {

	public static LandingPage_po lp;
	public static ProductPage_po pp;

	public static void loginLogic() throws IOException {

		lp = new LandingPage_po(driver);
		lp.SignIn().click();
		System.out.println("Click on Signin button");
	}

	public static void Authentication() {
		AuthenticationPage_po ap = new AuthenticationPage_po(driver);
		ap.EmailBox();

		ap.CreateAccountbtn().click();

		System.out.println("Authentication completed");
	}

	public static void registrationLogic() {
		RegistrationPage_po rp = new RegistrationPage_po(driver);
		rp.Title().click();
		Faker faker = new Faker(); // For random values
		rp.FirstName().sendKeys(faker.name().firstName());
		rp.LastName().sendKeys(faker.name().lastName());
		rp.Password().sendKeys(faker.food().dish());
		rp.Address().sendKeys("Cleveland, OH 44113");
		rp.City().sendKeys(faker.address().cityName());

		Select state = new Select(rp.State());
		state.selectByVisibleText("Arizona");

		rp.ZipCode().sendKeys("12345");

		Select country = new Select(rp.Country());
		country.selectByValue("21");

		rp.Mobile().sendKeys(faker.phoneNumber().cellPhone());
		rp.Register().click();
		System.out.println("Customer registation completed");
	}

	public static void dress() {
		lp.Dresses().click();
	}

	public static void verifyConditions() throws InterruptedException {
		pp = new ProductPage_po(driver);
		int count = pp.Products().size();
		List<WebElement> products = pp.Products();

		for (WebElement dress : products) {
			Wait.expWait(driver, 5, dress);
			dress.click();
			Wait.expWaitFrame(driver, 5, 0); // Explicit wait

			String actualPrice = pp.Price().getText();

			String[] filterPrice = actualPrice.split("\\$");
			String[] sortedPrice = filterPrice[1].split("\\.");
			String finalPrice = sortedPrice[0];
			int number = Integer.parseInt(finalPrice);

			// checking conditions- 1) 100% cotton 2) Prices are less than 50 3) Colour can
			// be orange or blue

			if (pp.Description().getAttribute("innerHTML").contains("100% cotton") && number < 50
					&& (checkElement() || checkElement1())) {

				Wait.expWait(driver, 5, pp.AddToCartBtn());
				pp.AddToCartBtn().click();

				// Wait.expWait(driver, 5, pp.ContinueBtn());
				Thread.sleep(3000);

				Wait.expWait(driver, 5, pp.ContinueBtn()); // Explicit wait

				pp.ContinueBtn().click();

			} else {
				driver.switchTo().defaultContent();
				pp.Close().click();
			}
		}
		System.out.println("Conditions checked");

		pp.Cart().click();
	}

	public static boolean checkElement() {

		try {
			pp.OrganeColor().isDisplayed();

		} catch (Exception e) {
			return false;
		}
		return true;

	}

	public static boolean checkElement1() {

		try {
			pp.BlueColor().isDisplayed();

		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public static void purchaseProcess() {
		BasketPage_po bp = new BasketPage_po(driver);
		bp.CheckoutBtn().click();

		AddressPage_po ap = new AddressPage_po(driver);
		ap.CheckoutBtn().click();

		ShippingPage_po sp = new ShippingPage_po(driver);
		sp.Cgv().click();
		sp.CheckoutBtn().click();

		PaymentPage_po payment = new PaymentPage_po(driver);
		payment.Bank().click();
		payment.ConfirmOrder().click();
		payment.ValidateOrder().isDisplayed();
		Assert.assertEquals(payment.ValidateOrder().getText(), "Your order on My Store is complete.");
		// System.out.println(payment.ValidateOrder().getText());
	}
}
