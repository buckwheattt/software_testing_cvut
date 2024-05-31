package com.sumerianrecords;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ShoppingCartTest extends MainTest {
    @Test
    public void testAddToCart() {
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

            // Получаем количество товаров в корзине
            WebElement cartItemCount = driver.findElement(By.xpath("//*[@id=\"SiteHeader\"]/div[1]/div[1]/div[3]/div/div/a[3]"));
            int itemCount = Integer.parseInt(cartItemCount.getText());

            // Проверяем, что в корзине есть хотя бы один товар
            Assertions.assertTrue(itemCount > 0, "Товар не был добавлен в корзину");

            // Можно добавить дополнительные проверки, например, сравнение названия и цены добавленного товара
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
