package pages;

import locators.SellerProductLocators;
import org.openqa.selenium.WebDriver;

public class SellerProductPage extends BasePage {

    public SellerProductPage(WebDriver driver) {
        super(driver);
    }

    public void addQuantity() {
        clickToWebElement(SellerProductLocators.ADD_QUANTITY);
    }

    public void decrementQuantity () {
        clickToWebElement(SellerProductLocators.DECREMENT_QUANTITY);
    }

    public void addToCart () {
        clickToWebElement(SellerProductLocators.ADD_TO_CART);
    }

    public void goToCart() {
        clickToWebElement(SellerProductLocators.GO_TO_CART);
    }
}

