package locators;

import org.openqa.selenium.By;

public class SellerProductLocators {
    public static final By ADD_TO_CART = By.name("add-to-cart");
    public static final By ADD_QUANTITY = By.cssSelector("input.ux-quantity__button--plus");
    public static final By DECREMENT_QUANTITY  = By.cssSelector("input.ux-quantity__button--minus");
    public static final By INFO_MESSAGE = By.cssSelector(".message-container");
    public static final By OUT_OF_STOCK = By.className("stock.out-of-stock");
    public static final By GO_TO_CART = By.className("header-cart-title");
    public static final By AMOUNT = By.cssSelector("td.product-price bdi");
    public static final By QUANTITY = By.cssSelector("[id^='quantity_']");
    public static final By TOTAL_AMOUNT = By.cssSelector("tr.order-total bdi");
}
