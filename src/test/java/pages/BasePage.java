package pages;

import logging.Logging;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import seleniumutils.Waits;

public abstract class BasePage implements Logging {

    protected WebDriver driver;
    protected Waits wait = new Waits();
    protected WebElement loadedElement;

    @FindBy(xpath = "//a[normalize-space()='Your Store']")
    protected WebElement yourStoreLink;

    public BasePage(WebDriver driver) {
        setDriver(driver);
        PageFactory.initElements(driver, this);
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public void navigateBack() {
        driver.navigate().back();
    }

    public void navigateForward() {
        driver.navigate().forward();
    }

    public boolean isLoaded() {
        wait.waitForElementToBeVisible(driver, loadedElement, 5);
        return loadedElement.isDisplayed();
    }

}
