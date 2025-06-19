package com.sumerianrecords;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductSearchTest extends MainTest {

    @Test
    public void testSearchAndCheckPrice() {
        try {
            // Open the main page of the website
            driver.get("https://sumerianrecords.com/");

            // Find and click on the search icon
            WebElement searchIcon = driver.findElement(By.xpath("//*[@id=\"SiteHeader\"]/div[1]/div[1]/div[1]/div[1]/a"));
            searchIcon.click();

            // Find the search input field and enter "bad omens"
            WebElement searchInput = driver.findElement(By.xpath("//*[@id=\"HeaderSearchForm\"]/input[3]"));
            searchInput.sendKeys("bad omens");
            searchInput.sendKeys(Keys.ENTER);

            WebDriverWait wait = new WebDriverWait(driver, 10);
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"CollectionAjaxContent\"]/div[2]/div/div[2]/div[1]/div/a")));

            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

            // Find and click on the first product in the search results
            WebElement firstProduct = driver.findElement(By.xpath("//*[@id=\"CollectionAjaxContent\"]/div[2]/div/div[2]/div[1]/div/a"));
            firstProduct.click();

            // Expected price of the product
            String expectedPrice = "$10.00";

            // Find the element containing the price of the product
            WebElement priceElement = driver.findElement(By.xpath("//*[@id=\"ProductSection-template--14617934790718__main-7868448840\"]/div/div/div/div[2]/div/div[2]/div[1]/span[2]/span"));

            // Getting the text of the element
            String actualPrice = priceElement.getText();

            // Checking that the price of the product corresponds to the expected one
            Assertions.assertEquals(expectedPrice, actualPrice, "Цена товара не соответствует ожидаемой");

        } catch (Exception e) {
            e.printStackTrace();
            Assertions.fail("Тест завершился с ошибкой: " + e.getMessage());
        }
    }
}
