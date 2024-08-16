import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import utils.Log;
import locators.SellerProductLocators;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SearchPage;
import pages.ProductListPage;
import pages.SellerProductPage;
import utils.Constants;
import utils.TestUtils;

import java.time.Duration;

public class SearchAndBuyProductTest extends BaseTest {

    SearchPage searchPage;
    ProductListPage productListPage;
    SellerProductPage sellerProductPage;
    TestUtils testUtils;

   @Test(priority = 1)
    public void searchProduct() {
        driver.get(Constants.BASE_URL);
        searchPage = new SearchPage(driver);
        searchPage.searchBox();
        searchPage.searchInput();
        Log.info(Constants.SEARCH_TEXT + " ürünü arandı.");
    }

    @Test(priority = 2)
    public void clickProduct() {
        productListPage = new ProductListPage(driver);
        productListPage.cheapestSorting();
        productListPage.viewProduct();
        productListPage.goToStore();
        Log.info("Satış sayfasına gidildi.");
    }

    @Test(priority = 3)
    public void goToSellerProduct () {
        sellerProductPage = new SellerProductPage(driver);
        testUtils = new TestUtils(driver);
        testUtils.switchToTab(1);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(SellerProductLocators.ADD_QUANTITY));

        try {
            driver.findElement(SellerProductLocators.OUT_OF_STOCK).isDisplayed();
            Log.warn("Ürün stokta bulunamadı.");
            testUtils.closeCurrentTabAndSwitchBack(0);
            Log.error("Loglar kaydedildi.");
        } catch (Exception e) {
            Log.info("Ürün stokta var.");
        }
    }

    @Test(dependsOnMethods="goToSellerProduct")
    public void addToBasketProduct () {
        testUtils.scrollDown();
        sellerProductPage.addQuantity();
        sellerProductPage.addToCart();

        if ((testUtils.isInfoMessageDisplayed(SellerProductLocators.INFO_MESSAGE, Constants.INFO_MESSAGE_TEXT))) {
            Log.error("Sepete 1'den fazla ürün eklenemez.");
            sellerProductPage.decrementQuantity();
            sellerProductPage.addToCart();
            Log.info("Sepete ürün eklendi.");
        }
        sellerProductPage.goToCart();
        Log.info("Sepete gidildi.");

        double calculatedTotal = testUtils.calculateBasketTotal();

        String totalAmountText = driver.findElement(SellerProductLocators.TOTAL_AMOUNT).getText();
        double totalAmount = TestUtils.parseCurrency(totalAmountText);

        Assert.assertEquals(calculatedTotal, totalAmount, "Sepet doğru hesaplanmıştır.");
        Log.info("Ürün fiyatı ve toplam tutar hesaplandı.");
    }
}