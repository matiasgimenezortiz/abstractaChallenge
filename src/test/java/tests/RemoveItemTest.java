package tests;

import org.testng.annotations.*;
import pages.*;
import testrunner.*;

public class RemoveItemTest extends BaseTest {

    @Test
    public void removeItemTest() {

        HomePage homePage = new HomePage(driver);
        SearchPage searchPage = homePage.searchProduct("iPhone");
        ProductPage productPage = searchPage.selectProduct(1);
        productPage.addToCart();
        validate.assertTrue(productPage.isProductAdded(), "The product was not successfully added to the cart");

        String productCode = productPage.getProductCode();

        productPage.showCartOptions();
        CartPage cartPage = productPage.viewCart();

        validate.assertTrue(cartPage.isProductAdded(productCode), "The product is not present in the cart");

        cartPage.removeItem(1);
        validate.assertTrue(cartPage.isCartEmpty(), "The cart is not empty");
    }

}