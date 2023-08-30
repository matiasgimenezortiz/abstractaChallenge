package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import static io.github.bonigarcia.wdm.config.DriverManagerType.IEXPLORER;

public class IEDriverManager extends DriverManager {
	
	@Override
	protected WebDriver createDriver() {
		if (!super.is64bits()) {
			WebDriverManager.getInstance(IEXPLORER).arch32().setup();
		} else {
			WebDriverManager.getInstance(IEXPLORER).setup();
		}

		IEDesiredCapabilities();
		return new InternetExplorerDriver();
	}

	public void IEDesiredCapabilities() {
		getDriver().manage().window().maximize();
	}
}
