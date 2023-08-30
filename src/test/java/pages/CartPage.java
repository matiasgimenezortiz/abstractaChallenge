package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

import java.util.*;
import java.util.logging.*;

public class CartPage extends BasePage {
    @FindBy(xpath = "//*[@id=\"checkout-cart\"]//a[contains(text(),'Shopping Cart')]")
    private WebElement shoppingCartMenu;

    @FindBy(xpath = "//*[@id=\"content\"]//td[3]")
    private List<WebElement> addedProductsList;

    @FindBy(xpath = "//*[@id=\"content\"]//button[@data-original-title='Remove']")
    private List<WebElement> removeItemButtonsList;

    @FindBy(xpath = "//*[@id=\"content\"]/p[contains(text(),'Your shopping cart is empty!')]")
    private WebElement emptyCartMessage;

    public CartPage(WebDriver driver) {
        super(driver);
        if(!isLoaded()){
            getLogger().error("This is not Cart Page");
        }
    }

    public boolean isLoaded(){
        return shoppingCartMenu.isDisplayed();
    }

    public boolean isProductAdded(String modelName) {
        wait.waitForElementToBeVisible(driver, addedProductsList.get(0), 10);
        for (WebElement element : addedProductsList) {
            if (element.getText().contains(modelName)) {
                return true;
            }
        }
        return false;
    }

    public void removeItem(int productIndex) {
        removeItemButtonsList.get(productIndex - 1).click();
    }

    public boolean isCartEmpty() {
        wait.waitForElementToBeVisible(driver, emptyCartMessage, 10);
        return emptyCartMessage.isDisplayed();
    }
}
