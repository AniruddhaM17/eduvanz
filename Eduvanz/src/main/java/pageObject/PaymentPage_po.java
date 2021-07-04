package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PaymentPage_po {

	public WebDriver driver;

	By bank = By.cssSelector(".bankwire");
	By confirmOrder = By.xpath("//p//button[@type='submit']");
	By validateOrder = By.xpath("//p//strong[@class='dark']");

	public PaymentPage_po(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement Bank() {
		return driver.findElement(bank);
	}

	public WebElement ConfirmOrder() {
		return driver.findElement(confirmOrder);
	}

	public WebElement ValidateOrder() {
		return driver.findElement(validateOrder);
	}
}