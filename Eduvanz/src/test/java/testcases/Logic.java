package testcases;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.AuthenticationPage_po;
import pageObject.LandingPage_po;
import pageObject.ProductPage_po;
import pageObject.RegistrationPage_po;
import resources.Base;

public class Logic extends Base {

	public static LandingPage_po lp;

	@BeforeTest
	public void Initilization() throws IOException {
		driver = DriverInitilization();
		driver.get(prop.getProperty("url"));
		log.info("Website is opening");
		driver.manage().window().maximize();
		log.trace("maximize screen");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	static final Logger log = LogManager.getLogger(Logic.class.getName());

	public static void loginLogic() throws IOException {

		lp = new LandingPage_po(driver);
		lp.SignIn().click();
		System.out.println("TC1 Click on Signin");
	}

	public static void Authentication() {
		AuthenticationPage_po ap = new AuthenticationPage_po(driver);
		ap.EmailBox();
		log.trace("Enter mail id in box");
		ap.CreateAccountbtn().click();
		log.trace("Click on Create new account button");
		System.out.println("TC2 Authentication completed");
	}

	public static void registrationLogic() {
		RegistrationPage_po rp = new RegistrationPage_po(driver);
		rp.Title().click();
		rp.FirstName().sendKeys("Test");
		rp.LastName().sendKeys("Test");
		rp.Password().sendKeys("abcd1234");
		rp.Address().sendKeys("Cleveland, OH 44113");
		rp.City().sendKeys("Test");

		Select state = new Select(rp.State());
		state.selectByVisibleText("Arizona");

		rp.ZipCode().sendKeys("12345");

		Select country = new Select(rp.Country());
		country.selectByValue("21");

		rp.Mobile().sendKeys("1234567890");
		rp.Register().click();
	}

	public static void dress() {
		lp.Dresses().click();
	}

	/*
	 * ProductPage_po pp = new ProductPage_po(driver); int count =
	 * pp.Products().size(); List<WebElement> s = pp.Products(); for(int i =
	 * 0;i<count;i++) {
	 * 
	 * for (WebElement dress : s) { dress.click();
	 * driver.switchTo().frame("fancybox-frame1625324091841");
	 * System.out.println(driver.findElement(By.id("our_price_display")).getText());
	 * 
	 * } }
	 */

	public static void verifyConditions() throws InterruptedException {
		ProductPage_po pp = new ProductPage_po(driver);
		int count = pp.Products().size();
		List<WebElement> s = pp.Products();
		for (int i = 0; i < count; i++) {

			for (WebElement dress : s) {
				dress.click();
				Thread.sleep(5000);
				driver.switchTo().frame(0);
				WebElement description = driver.findElement(By.xpath("//div[@id='short_description_content']/p"));
				WebElement price = driver.findElement(By.id("our_price_display"));
				String actualPrice = price.getText();
				String[] array1 = actualPrice.split("\\$");
				String[] array2 = array1[1].split("\\.");
				String array3 = array2[0];
				System.out.println(array3);
				int number = Integer.parseInt(array3);

				if (description.getAttribute("innerHTML").contains("100% cotton") && number < 50
						&& (driver.findElement(By.id("color_13")).isDisplayed())
						|| driver.findElement(By.id("color_14")).isDisplayed()) {
					driver.findElement(By.xpath("//p[@id='add_to_cart']//span[text()='Add to cart']")).click();

					Thread.sleep(3000);
					driver.findElement(By.xpath("//span[@title='Continue shopping']")).click();
					Thread.sleep(3000);
				} else
					driver.findElement(By.xpath("//a[@title='Close']")).click();
			}

		}
	}
}
