package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage_po {

	public WebDriver driver;

	public LandingPage_po(WebDriver driver) {
		this.driver = driver;
	}

	By signIn = By.cssSelector(".login");
	By dresses = By.xpath("(//a[text()='Dresses'])[2]");

	public WebElement SignIn() {
		return driver.findElement(signIn);
	}

	public WebElement Dresses() {
		return driver.findElement(dresses);
	}

}
