package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage_po {

	public WebDriver driver;

	public ProductPage_po(WebDriver driver) {
		this.driver = driver;
	}

	By products = By.xpath("//a[@class='product_img_link']");
	By addToCartBtn = By.xpath("//p[@id='add_to_cart']//span[text()='Add to cart']");
	By continueBtn = By.xpath("//span[@title='Continue shopping']");
	By close = By.xpath("//a[@title='Close']");
	By description = By.xpath("//div[@id='short_description_content']/p");
	By price = By.id("our_price_display");
	By orangeColor = By.id("color_13");
	By blueColor = By.id("color_14");
	By cart = By.xpath("//a[@title='View my shopping cart']");

	public List Products() {
		List<WebElement> product = driver.findElements(products);
		return product;
	}

	public WebElement AddToCartBtn() {
		return driver.findElement(addToCartBtn);
	}

	public WebElement ContinueBtn() {
		return driver.findElement(continueBtn);
	}

	public WebElement Close() {
		return driver.findElement(close);
	}

	public WebElement Description() {
		return driver.findElement(description);
	}

	public WebElement Price() {
		return driver.findElement(price);
	}

	public WebElement OrganeColor() {
		return driver.findElement(orangeColor);
	}

	public WebElement BlueColor() {
		return driver.findElement(blueColor);
	}
	
	public WebElement Cart() {
		return driver.findElement(cart);
	}
}