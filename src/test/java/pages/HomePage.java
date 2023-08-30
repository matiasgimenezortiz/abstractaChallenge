package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class HomePage extends BasePage {

    @FindBy(xpath = "//body/div[@id='common-home']/div[@class='row']/div[@id='content']/div[1]")
    private WebElement homeCarousel;

    @FindBy(xpath = "//input[@placeholder='Search']")
    private WebElement searchBox;

    @FindBy(xpath = "//div[@class='col-sm-5']//button")
    private WebElement searchButton;

    public HomePage(WebDriver driver) {
        super(driver);
        if(!isLoaded()){
            getLogger().error("This is not Home Page");
        }
    }

    public boolean isLoaded(){
        return homeCarousel.isDisplayed();
    }

    public SearchPage searchProduct(String productName) {
        wait.waitForElementToBeVisible(driver, searchBox, 10);
        searchBox.sendKeys(productName);
        wait.waitForElementToBeVisible(driver, searchButton, 10);
        searchButton.click();
        return new SearchPage(driver);
    }
}
