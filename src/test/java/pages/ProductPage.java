package pages;

import org.apache.commons.lang3.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class ProductPage extends BasePage{

    @FindBy(xpath = "//*[@id=\"product-product\"]/ul/li[3]/a")
    private WebElement productName;

    @FindBy(xpath = "//*[@id=\"button-cart\"]")
    private WebElement addToCartButton;

    @FindBy(xpath = "//*[@id=\"product-product\"]/div[1]")
    private WebElement successMessage;

    @FindBy(xpath = "//*[@id=\"cart\"]/button")
    private WebElement cartButton;

    @FindBy(xpath = "//*[@id=\"cart\"]/ul")
    private WebElement cartModal;

    @FindBy(xpath = "//*[@id=\"cart\"]//strong[contains(text(),'View Cart')]")
    private WebElement viewCartLink;

    @FindBy(xpath = "//*[@id=\"content\"]//li[contains(text(),'Product Code')]")
    private WebElement productCode;

    public ProductPage(WebDriver driver) {
        super(driver);
        if(!isLoaded()){
            getLogger().error("This is not Product Page");
        }
    }

    public boolean isLoaded(){
        return productName.isDisplayed();
    }

    public void addToCart() {
        wait.waitForElementToBeVisible(driver, addToCartButton, 10);
        addToCartButton.click();
    }

    public boolean isProductAdded() {
        wait.waitForElementToBeVisible(driver, successMessage, 10);
        return successMessage.isDisplayed();
    }

    public void showCartOptions() {
        wait.waitForElementToBeVisible(driver, cartButton, 10);
        cartButton.click();
        wait.waitForElementToBeVisible(driver, cartModal, 10);
    }

    public CartPage viewCart() {
        wait.waitForElementToBeVisible(driver, viewCartLink, 10);
        viewCartLink.click();
        return new CartPage(driver);
    }

    public String getProductCode() {
        return StringUtils.substringAfter(productCode.getText(), "Product Code: ").trim();
    }
}
