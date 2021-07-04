package utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {

	public static void impWait(WebDriver driver, int sec) {
		// Implicit Wait
		driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
	}

	public static void expWait(WebDriver driver, int sec, WebElement element) {
		// Explicit Wait
		WebDriverWait wait = new WebDriverWait(driver, sec);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void expWaitFrame(WebDriver driver, int sec, int index) {
		// Explicit Wait for frame
		WebDriverWait wait = new WebDriverWait(driver, sec);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(index));
	}

}
