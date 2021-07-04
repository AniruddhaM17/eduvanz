package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasketPage_po {

	public WebDriver driver;

	By checkoutBtn = By.xpath("//p//a[@title='Proceed to checkout']");

	public BasketPage_po(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement CheckoutBtn() {
		return driver.findElement(checkoutBtn);
	}
}
