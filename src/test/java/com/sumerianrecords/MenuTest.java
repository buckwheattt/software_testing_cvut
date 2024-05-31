package com.sumerianrecords;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MenuTest extends MainTest {

    @Test
    public void testThirdNewsText() {
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

            // Подождем некоторое время, чтобы страница новостей загрузилась
            Thread.sleep(3000);

            // Находим все sidebar
            WebElement newsItem = driver.findElement(By.xpath("//*[@id=\"CollectionSidebar\"]/div[1]/form/div[2]/div/button")); // Замените 'news-item' на реальный класс элементов новостей
            newsItem.click();

            WebElement choise = driver.findElement(By.xpath("//*[@id=\"CollectionSidebar-2-filter-product-type\"]/div/ul/li[8]/label/span[2]")); // Замените 'news-item' на реальный класс элементов новостей
            choise.click();

            // Подождем некоторое время, чтобы страница новости загрузилась
            Thread.sleep(2000);

            WebElement element = driver.findElement(By.xpath("//*[@id=\"CollectionAjaxContent\"]/div[2]/div/div[2]/div/div/a/div[1]/div[2]/img"));
            element.click();


            // Ожидаемый текст новости
            String expectedNewsText = "BAD OMENS - TDOPOM ENAMEL PIN"; // Замените на ожидаемый текст новости

            // Находим элемент, содержащий текст новости
            WebElement newsTextElement = driver.findElement(By.xpath("//*[@id=\"ProductSection-template--14617934790718__main-6967532224574\"]/div/div/div/div[2]/div/div[1]/h1")); // Замените 'news-content' на реальный класс элемента текста новости

            // Получаем текст элемента
            String actualNewsText = newsTextElement.getText();

            // Проверяем, что текст новости соответствует ожидаемому
            Assertions.assertEquals(expectedNewsText, actualNewsText, "Текст новости не соответствует ожидаемому");

        } catch (Exception e) {
            e.printStackTrace();
            Assertions.fail("Тест завершился с ошибкой: " + e.getMessage());
        }
    }
}
