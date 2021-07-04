package pageObject;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AuthenticationPage_po {

	public WebDriver driver;

	public AuthenticationPage_po(WebDriver driver) {
		this.driver = driver;
	}

	By emailBox = By.id("email_create");
	By createAccountbtn = By.id("SubmitCreate");

	public void EmailBox() {

		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(1000);
		driver.findElement(emailBox).sendKeys("username" + randomInt + "@gmail000.com");
	}

	public WebElement CreateAccountbtn() {
		return driver.findElement(createAccountbtn);
	}

}
