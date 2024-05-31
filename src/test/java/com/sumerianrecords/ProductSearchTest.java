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
            // Открываем главную страницу сайта
            driver.get("https://sumerianrecords.com/");

            // Находим и нажимаем на иконку поиска
            WebElement searchIcon = driver.findElement(By.xpath("//*[@id=\"SiteHeader\"]/div[1]/div[1]/div[1]/div[1]/a"));
            searchIcon.click();

            // Находим поле ввода поиска и вводим "bad omens"
            WebElement searchInput = driver.findElement(By.xpath("//*[@id=\"HeaderSearchForm\"]/input[3]"));
            searchInput.sendKeys("bad omens");
            searchInput.sendKeys(Keys.ENTER);

//            WebElement submitIcon = driver.findElement(By.xpath("//*[@id=\"HeaderSearchForm\"]/button"));
//            submitIcon.click();

            WebDriverWait wait = new WebDriverWait(driver, 10);
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"CollectionAjaxContent\"]/div[2]/div/div[2]/div[1]/div/a")));

            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

            // Находим и нажимаем на первый товар в результатах поиска
            WebElement firstProduct = driver.findElement(By.xpath("//*[@id=\"CollectionAjaxContent\"]/div[2]/div/div[2]/div[1]/div/a"));
            firstProduct.click();

            // Ожидаемая цена товара
            String expectedPrice = "$10.00";  // Замените на фактическую ожидаемую цену

            // Находим элемент, содержащий цену товара
            WebElement priceElement = driver.findElement(By.xpath("//*[@id=\"ProductSection-template--14617934790718__main-7868448840\"]/div/div/div/div[2]/div/div[2]/div[1]/span[2]/span"));

            // Получаем текст элемента
            String actualPrice = priceElement.getText();

            // Проверяем, что цена товара соответствует ожидаемой
            Assertions.assertEquals(expectedPrice, actualPrice, "Цена товара не соответствует ожидаемой");

        } catch (Exception e) {
            e.printStackTrace();
            Assertions.fail("Тест завершился с ошибкой: " + e.getMessage());
        }
    }
}
