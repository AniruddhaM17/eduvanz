package operations;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utilities.Wait;

public class Hooks extends Base {

	@BeforeTest
	public void Initilization() throws IOException {
		driver = DriverInitilization();
		driver.get(prop.getProperty("url")); //Website is opening
		// log.info("Website is opening");
		driver.manage().window().maximize(); //Maximize screen
		// log.trace("maximize screen");
		Wait.impWait(driver, 30);
		
		// static final Logger log = LogManager.getLogger(Logic.class.getName());
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
