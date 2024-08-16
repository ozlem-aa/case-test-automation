package locators;

import org.openqa.selenium.By;

public class ProductListLocators {
    public static final By CHEAPEST_PRODUCT = By.xpath("//a[contains(@href, '?sort=price%2Casc')]");
    public static final By PRODUCT = By.cssSelector("[class^='link-detail']");
    public static final By GO_TO_STORE = By.cssSelector("[class^='JumpButton_button']");

}
