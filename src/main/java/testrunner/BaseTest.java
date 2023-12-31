package testrunner;

import asserts.Validate;
import driver.DriverFactory;
import driver.DriverManager;
import listeners.TestMethodListener;
import logging.Logging;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.testng.asserts.*;
import seleniumutils.Waits;
import utils.Constants;
import org.testng.asserts.*;

@Listeners(TestMethodListener.class)
public abstract class BaseTest implements Logging {
	
	protected DriverManager driverManager;
	protected WebDriver driver;
	protected Validate validate;
	protected Waits wait;
	protected SoftAssert asserts;

	
	@BeforeMethod
	@Parameters({"driverName"})
	protected void setup(@Optional("CHROME") String driverName) {
		getLogger().info("Starting a Selenium WebDriver instance.");

		initializeDriverManager(driverName);
		asserts = new SoftAssert();
		driver = this.getDriver();
		validate = new Validate(this.getDriver());
		asserts = new SoftAssert();
		
		driver.navigate().to(Constants.getContextUrl());
	}
	
	private synchronized void initializeDriverManager(String driverName) {
		if (null == driverManager) {
			driverManager = DriverFactory.valueOf(driverName).getDriverManager();
		} else {
			driverManager.getDriver();
		}
	}
	
	public Validate getValidator() {
		return validate;
	}
	
	@AfterTest
	protected void afterMethod() {
		getLogger().info("Closing Selenium WebDriver instance.");
		driverManager.quitDriver();
	}
	
	@AfterClass
	protected void cleanUp() {
		driver.close();
	}
	
	protected WebDriver getDriver() {
		return driverManager.getDriver();
	}
}
