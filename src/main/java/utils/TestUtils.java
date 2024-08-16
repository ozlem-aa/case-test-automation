package utils;

import locators.SellerProductLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

import java.util.ArrayList;

public class TestUtils extends BasePage {

    public TestUtils(WebDriver driver) {
        super(driver);
    }

    public void switchToTab(Integer tabIndex) {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabIndex));
    }

    public void closeCurrentTabAndSwitchBack(Integer tabIndex) {
        driver.close();
        switchToTab(tabIndex);
        driver.navigate().back();
    }

    public boolean isInfoMessageDisplayed(By infoMessageLocator, String expectedMessage) {
        String message = driver.findElement(infoMessageLocator).getText();
        return expectedMessage.equals(message);
    }

    public static double parseCurrency(String currencyText) {
        return Double.parseDouble(currencyText.replace("₺", "").replace(".", "").replace(",", "."));
    }

    public double calculateBasketTotal() {

        String amountText = driver.findElement(SellerProductLocators.AMOUNT).getText();
        String quantityText = driver.findElement(SellerProductLocators.QUANTITY).getAttribute("value");

        double amount = parseCurrency(amountText);
        int quantity = Integer.parseInt(quantityText);

        return amount * quantity;
    }

    public void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 300)");
    }
}
