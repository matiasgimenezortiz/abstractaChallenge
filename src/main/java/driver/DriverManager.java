package driver;

import logging.Logging;
import org.openqa.selenium.WebDriver;
import utils.Architecture;
import java.util.concurrent.TimeUnit;

public abstract class DriverManager implements Logging {

	protected ThreadLocal<WebDriver> drivers = new ThreadLocal<>();
	protected abstract WebDriver createDriver();
	
	public void quitDriver() {
		if (null != drivers.get()) {
			try {
				drivers.get().quit();
				drivers.remove();
			} catch (Exception e) {
				getLogger().error("Unable to gracefully quit WebDriver.", e);
			}
			
		}
	}
	
	public WebDriver getDriver() {
		if (null == drivers.get()) {
			drivers.set(this.createDriver());
		}
		drivers.get().manage().timeouts().implicitlyWait(1L, TimeUnit.SECONDS);
		
		return drivers.get();
	}
	
	protected boolean is64bits() {
		return Architecture.is64bits();
	}
}
