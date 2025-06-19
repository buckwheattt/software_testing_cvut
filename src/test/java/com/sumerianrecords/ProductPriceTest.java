package com.sumerianrecords;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProductPriceTest extends MainTest {

    @Test
    public void testProductPrice() {
        try {
            // Open the product page
            driver.get("https://sumerianrecords.com/collections/iseestars/products/i-see-stars-iss-gunmetal-hoodie");

            // Expected price
            String expectedPrice = "$55.00";

            // Find the element containing the price of the product
            WebElement priceElement = driver.findElement(By.xpath("//*[@id=\"ProductSection-template--14617934790718__main-7252699054142\"]/div/div/div/div[2]/div/div[2]/div[1]/span[2]/span"));  // Замените XPath на корректный, если требуется

            // Getting the text of the element
            String actualPrice = priceElement.getText();

            // Checking that the price of the product corresponds to the expected one
            Assertions.assertEquals(expectedPrice, actualPrice, "price is different");
        } catch (Exception e) {
            e.printStackTrace();
            Assertions.fail("error: " + e.getMessage());
        }
    }
}
