package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import static io.github.bonigarcia.wdm.config.DriverManagerType.CHROME;

public class ChromeDriverManager extends DriverManager {
	
	@Override
	protected WebDriver createDriver() {
		if (!super.is64bits()) {
			WebDriverManager.getInstance(CHROME).arch32().setup();
		} else {
			WebDriverManager.getInstance(CHROME).setup();
		}
		
		return new ChromeDriver(getChromeOptions());
	}

	

	private ChromeOptions getChromeOptions() {
		ChromeOptions options = new ChromeOptions();

		//options.addArguments("--remote-allow-origins=*");
        //options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");
        options.addArguments("--disable-features=EnableEphemeralFlashPermission");
        // Disable extensions and hide infobars
        options.addArguments("--disable-infobars");
		//options.addArguments("headless");

		return options;
	}

}
