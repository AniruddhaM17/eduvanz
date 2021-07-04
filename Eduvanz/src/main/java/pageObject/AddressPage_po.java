package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddressPage_po {

	public WebDriver driver;

	By checkoutBtn = By.xpath("//button[@name='processAddress']");

	public AddressPage_po(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement CheckoutBtn() {
		return driver.findElement(checkoutBtn);
	}
}
