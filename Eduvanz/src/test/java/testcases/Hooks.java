package testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.Base;

public class Hooks extends Base {

	@BeforeTest
	public void Initilization() throws IOException {
		driver = DriverInitilization();
		driver.get(prop.getProperty("url"));
		log.info("Website is opening");
		driver.manage().window().maximize();
		log.trace("maximize screen");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	static final Logger log = LogManager.getLogger(Logic.class.getName());

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
