package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

import java.util.*;

public class SearchPage extends BasePage{

    @FindBy(xpath = "//*[@id=\"product-search\"]/ul/li[2]/a")
    private WebElement searchTitle;

    @FindBy(xpath = "//*[@id=\"cart\"]/button")
    private WebElement cartButton;

    @FindBy(xpath = "//strong[normalize-space()='View Cart']")
    private WebElement viewCartButton;

    @FindBy(xpath = "//*[@id=\"content\"]//img")
    private List<WebElement> productsList;

    public SearchPage(WebDriver driver) {
        super(driver);
        if(!isLoaded()){
            getLogger().error("This is not Search Page");
        }
    }

    public boolean isLoaded(){
        return searchTitle.isDisplayed();
    }

    public ProductPage selectProduct(int productIndex) {
        productsList.get(productIndex - 1).click();
        return new ProductPage(driver);
    }
}
