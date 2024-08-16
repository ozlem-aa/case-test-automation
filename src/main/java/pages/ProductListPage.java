package pages;

import locators.ProductListLocators;
import org.openqa.selenium.WebDriver;

public class ProductListPage extends BasePage {

    public ProductListPage(WebDriver driver) {
        super(driver);
    }

    public void cheapestSorting() {
        clickToWebElement(ProductListLocators.CHEAPEST_PRODUCT);
    }

    public void viewProduct() {
        clickToWebElement(ProductListLocators.PRODUCT);
    }

    public void goToStore() {
        clickToWebElement(ProductListLocators.GO_TO_STORE);
    }
}
