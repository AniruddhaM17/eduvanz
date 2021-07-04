package operations;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {

	public static WebDriver driver;
	public Properties prop;

	public WebDriver DriverInitilization() throws IOException {

		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\files\\data.properties");
		prop.load(fis);

		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			// For initilization Chrome Driver
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();

		} else if (browserName.equals("firefox")) {
			// For initilization Firefox Driver
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();

		} else if (browserName.equals("IE")) {
			// For initilization Internet Explorer Driver)
			System.setProperty("webdriver.ie.driver",
					System.getProperty("user.dir") + "\\drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		return driver;
	}

	// To take screenshot
	/*
	 * public String getScreenShotPath(String testCaseName, WebDriver driver) throws
	 * IOException { TakesScreenshot screenshot = (TakesScreenshot) driver; File
	 * source = screenshot.getScreenshotAs(OutputType.FILE); String destinationFile
	 * = System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
	 * FileUtils.copyFile(source, new File(destinationFile)); return
	 * destinationFile; }
	 */
}