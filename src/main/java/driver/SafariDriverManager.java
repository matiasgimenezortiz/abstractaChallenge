package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

import static io.github.bonigarcia.wdm.config.DriverManagerType.SAFARI;

public class SafariDriverManager extends DriverManager {
	
	@Override
	protected WebDriver createDriver() {
		if (!super.is64bits()) {
			WebDriverManager.getInstance(SAFARI).arch32().setup();
		} else {
			WebDriverManager.getInstance(SAFARI).setup();
		}

		SafariDesiredCapabilities();
		return new SafariDriver();
	}

	public void SafariDesiredCapabilities() {
		getDriver().manage().window().maximize();
	}

}
