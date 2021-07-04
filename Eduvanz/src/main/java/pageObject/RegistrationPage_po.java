package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage_po {

	public WebDriver driver;

	public RegistrationPage_po(WebDriver driver) {
		this.driver = driver;
	}

	By title = By.id("id_gender1");
	By firstName = By.id("customer_firstname");
	By lastName = By.id("customer_lastname");
	By password = By.id("passwd");
	By address = By.id("address1");
	By city = By.id("city");
	By state = By.id("id_state");
	By zipcode = By.id("postcode");
	By country = By.id("id_country");
	By mobile = By.id("phone_mobile");
	By register = By.id("submitAccount");

	public WebElement Title() {
		return driver.findElement(title);
	}

	public WebElement FirstName() {
		return driver.findElement(firstName);
	}

	public WebElement LastName() {
		return driver.findElement(lastName);
	}

	public WebElement Password() {
		return driver.findElement(password);
	}

	public WebElement Address() {
		return driver.findElement(address);
	}

	public WebElement City() {
		return driver.findElement(city);
	}

	public WebElement State() {
		return driver.findElement(state);
	}

	public WebElement ZipCode() {
		return driver.findElement(zipcode);
	}

	public WebElement Country() {
		return driver.findElement(country);
	}

	public WebElement Mobile() {
		return driver.findElement(mobile);
	}

	public WebElement Register() {
		return driver.findElement(register);
	}
}