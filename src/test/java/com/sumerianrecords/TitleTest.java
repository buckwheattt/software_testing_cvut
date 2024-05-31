package com.sumerianrecords;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TitleTest extends MainTest {
    @Test
    public void checkTitle() {
        try {
            driver.get("https://sumerianrecords.com/");

            // Получаем заголовок страницы
            String actualTitle = driver.getTitle();

            // Ожидаемый заголовок
            String expectedTitle = "Sumerian Records – Sumerian Merch";

            // Проверяем соответствие заголовка
            Assertions.assertEquals(expectedTitle, actualTitle, "another title is displayed");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
