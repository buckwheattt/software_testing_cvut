package com.sumerianrecords;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ShoppingCartTest extends MainTest {
    @Test
    public void testAddToCart() {
        try {
            // Open the product page
            driver.get("https://sumerianrecords.com/collections/palayeroyale/products/palaye-royale-little-bastards-coffee-mug");

            // Click on the "Add to cart" button
            WebElement addToCartButton = driver.findElement(By.xpath("//*[@id=\"AddToCartForm-template--14617934790718__main-4459923701822\"]/button"));
            addToCartButton.click();

            // Waiting a while for the basket to update.
            Thread.sleep(3000);

            // Checking that the cart contains the added product
            WebElement cartIcon = driver.findElement(By.xpath("//*[@id=\"SiteHeader\"]/div[1]/div[1]/div[3]/div/div/a[3]]"));
            cartIcon.click();

            // Getting the number of items in the basket
            WebElement cartItemCount = driver.findElement(By.xpath("//*[@id=\"SiteHeader\"]/div[1]/div[1]/div[3]/div/div/a[3]"));
            int itemCount = Integer.parseInt(cartItemCount.getText());

            // Checking that there is at least one item in the cart
            Assertions.assertTrue(itemCount > 0, "Товар не был добавлен в корзину");

            // Possible to add additional checks, for example, comparing the name and price of the added product.
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
