package testcases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import pageObject.AuthenticationPage_po;
import pageObject.LandingPage_po;
import pageObject.ProductPage_po;
import pageObject.RegistrationPage_po;
import resources.Base;

public class MethodCalling extends Hooks {

	public LandingPage_po lp;

	@Test(priority = 0)
	public void login() throws IOException {

		Logic.loginLogic();

		/*
		 * lp = new LandingPage_po(driver); lp.SignIn().click();
		 * System.out.println("TC1 Click on Signin"); }
		 */
	}

	@Test(priority = 1)
	public void authentication() {

		Logic.Authentication();
		/*
		 * AuthenticationPage_po ap = new AuthenticationPage_po(driver); ap.EmailBox();
		 * log.trace("Enter mail id in box"); ap.CreateAccountbtn().click();
		 * log.trace("Click on Create new account button");
		 * System.out.println("TC2 Authentication completed"); }
		 */
	}

	@Test(priority = 2)
	public void registration() {

		Logic.registrationLogic();
		/*
		 * RegistrationPage_po rp = new RegistrationPage_po(driver); rp.Title().click();
		 * rp.FirstName().sendKeys("Test"); rp.LastName().sendKeys("Test");
		 * rp.Password().sendKeys("abcd1234");
		 * rp.Address().sendKeys("Cleveland, OH 44113"); rp.City().sendKeys("Test");
		 * 
		 * Select state = new Select(rp.State()); state.selectByVisibleText("Arizona");
		 * 
		 * rp.ZipCode().sendKeys("12345");
		 * 
		 * Select country = new Select(rp.Country()); country.selectByValue("21");
		 * 
		 * rp.Mobile().sendKeys("1234567890"); rp.Register().click();
		 * 
		 * System.out.println("TC3 Registation completed")
		 */
	}

	@Test(priority = 3)
	public void clickOndresses() throws InterruptedException {
		// lp.Dresses().click();
		Logic.dress();

		/*
		 * ProductPage_po pp = new ProductPage_po(driver); int count =
		 * pp.Products().size(); List<WebElement> s = pp.Products(); for (int i = 0; i <
		 * count; i++) {
		 * 
		 * for (WebElement dress : s) { dress.click(); Thread.sleep(5000);
		 * driver.switchTo().frame(0); System.out.println("Hello"); WebElement
		 * description =
		 * driver.findElement(By.xpath("//div[@id='short_description_content']/p"));
		 * WebElement price = driver.findElement(By.id("our_price_display")); String
		 * actualPrice = price.getText(); String[] arr = actualPrice.split("\\$"); int
		 * number = Integer.parseInt(arr[1]);
		 * 
		 * if (description.getAttribute("innerHTML").contains("100% cotton") && number <
		 * 50 && (driver.findElement(By.id("color_13")).isDisplayed()) ||
		 * driver.findElement(By.id("color_14")).isDisplayed()) { driver.findElement(By.
		 * xpath("//p[@id='add_to_cart']//span[text()='Add to cart']")).click(); } else
		 * driver.findElement(By.xpath("//a[@title='Close']")).click(); }
		 * 
		 * }
		 */
	}

	@Test(priority = 4)
	public void conditions() throws InterruptedException {
		Logic.verifyConditions();
	}
}
