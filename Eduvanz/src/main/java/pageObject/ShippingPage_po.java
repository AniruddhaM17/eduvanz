package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShippingPage_po {

	public WebDriver driver;

	By cgv = By.xpath("//input[@id='cgv']");
	By checkoutBtn = By.xpath("//button[@name='processCarrier']");

	public ShippingPage_po(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement Cgv() {
		return driver.findElement(cgv);
	}

	public WebElement CheckoutBtn() {
		return driver.findElement(checkoutBtn);
	}
}