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

	public List Products() {
		List<WebElement> product = driver.findElements(products);
		return product;
	}
}
