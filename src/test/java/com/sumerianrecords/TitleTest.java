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

            // Getting the page title
            String actualTitle = driver.getTitle();

            // Expected page title
            String expectedTitle = "Sumerian Records – Sumerian Merch";

            // Checking the title for compliance
            Assertions.assertEquals(expectedTitle, actualTitle, "another title is displayed");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
