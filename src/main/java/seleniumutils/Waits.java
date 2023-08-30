package seleniumutils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.function.Function;

public class Waits {
	
	private static <T> T waitForCondition(WebDriver driver, Integer timeOutSeconds, Function<WebDriver, T> condition) {
		return new WebDriverWait(driver, Duration.ofSeconds(timeOutSeconds))
                .ignoring(WebDriverException.class)
                .until(condition);
	}

	public void waitForElementToBeVisible(WebDriver driver, final WebElement element, int seconds) {
		waitForCondition(driver, seconds, d -> element.isDisplayed());
	}

	public void waitForElementInvisibility(WebDriver driver, WebElement element, int seconds) {
		waitForCondition(driver, seconds, d -> ExpectedConditions.invisibilityOf(element));
	}

	public boolean waitForTextInElementToDisappear(WebDriver driver, WebElement element, int seconds) {
		return waitForCondition(driver, seconds, d -> !element.isDisplayed());
	}

	public void waitForPageToLoad(WebDriver driver) {
		waitForCondition(driver, 30, d->
		((JavascriptExecutor) driver).executeScript("return document.readyState")
				.equals("complete"));
	}

	public void waitForElementToBeClickeable(WebDriver driver, WebElement element, int seconds){
		waitForCondition(driver, seconds,
				d-> ExpectedConditions.elementToBeClickable(element));
	}

	public void waitForElementToBeEnabled(WebDriver driver, WebElement element, int seconds) {
		waitForCondition(driver, 30, d->
				element.isEnabled());
	}
}
