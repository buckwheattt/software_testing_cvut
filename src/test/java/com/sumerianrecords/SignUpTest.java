package com.sumerianrecords;

import csv.SignUpDataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignUpTest extends MainTest {
    @Test(dataProvider = "signUpData", dataProviderClass = SignUpDataProvider.class)
    public void signUp(String email, String password) {
        try {
            driver.get("https://sumerianrecords.com/");

            // Находим кнопку входа и переходим на страницу входа
            WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"SiteHeader\"]/div[1]/div[1]/div[3]/div/div/a[1]"));
            loginButton.click();

            // Вводим логин и пароль
            WebElement emailInput = driver.findElement(By.xpath("//*[@id=\"CustomerEmail\"]"));
            emailInput.sendKeys(email);

            WebElement passwordInput = driver.findElement(By.xpath("//*[@id=\"CustomerPassword\"]"));
            passwordInput.sendKeys(password);

            // Нажимаем кнопку входа
            WebElement signInButton = driver.findElement(By.xpath("//*[@id=\"customer_login\"]/p[1]/button"));
            signInButton.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


