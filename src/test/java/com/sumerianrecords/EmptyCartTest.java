package com.sumerianrecords;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class EmptyCartTest extends MainTest {

    @Test
    public void testClearCart() {
        try {
            // Открываем страницу товара
            driver.get("https://sumerianrecords.com/collections/palayeroyale/products/palaye-royale-little-bastards-coffee-mug");

            // Нажимаем на кнопку "Добавить в корзину"
            WebElement addToCartButton = driver.findElement(By.xpath("//*[@id=\"AddToCartForm-template--14617934790718__main-4459923701822\"]/button"));
            addToCartButton.click();

            // Подождем некоторое время, чтобы корзина обновилась
            Thread.sleep(3000);

            // Проверяем, что корзина содержит добавленный товар
            WebElement cartIcon = driver.findElement(By.xpath("//*[@id=\"SiteHeader\"]/div[1]/div[1]/div[3]/div/div/a[3]]"));
            cartIcon.click();

            // Нажимаем на кнопку "Очистить корзину"
            WebElement clearCartButton = driver.findElement(By.xpath("//*[@id=\"CartPageForm\"]/div/div[1]/div/div[2]/div[2]/div[1]/div[2]/a"));
            clearCartButton.click();

            // Подождем некоторое время, чтобы корзина обновилась
            Thread.sleep(3000);

            // Проверяем, что корзина пуста
            WebElement emptyCartMessage = driver.findElement(By.xpath("//*[@id=\"shopify-section-template--14617933348926__main\"]/div/header/div/p[1]"));
            Assertions.assertTrue(emptyCartMessage.isDisplayed(), "cart is not empty");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
