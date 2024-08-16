package pages;

import locators.SearchLocators;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import utils.Constants;

public class SearchPage extends BasePage {

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void searchBox() {
       find(SearchLocators.SEARCH_BOX).click();
    }

    public void searchInput() {
       find(SearchLocators.SEARCH_INPUT).sendKeys(Constants.SEARCH_TEXT, Keys.RETURN);
    }
}
