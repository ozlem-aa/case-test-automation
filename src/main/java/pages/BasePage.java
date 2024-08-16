package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class BasePage {

   protected WebDriver driver;

   public BasePage(WebDriver driver) {
       this.driver = driver;
   }

   public WebElement find(By locator) {
       return driver.findElement(locator);
   }

   public void clickToWebElement(By locator) {
       find(locator).click();
   }
}
