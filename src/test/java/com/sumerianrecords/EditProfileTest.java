package com.sumerianrecords;

import com.sumerianrecords.MainTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditProfileTest extends MainTest {
    @Test
    public void signUp() {
        try {
            driver.get("https://sumerianrecords.com/");

            // Находим кнопку входа и переходим на страницу входа
            WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"SiteHeader\"]/div[1]/div[1]/div[3]/div/div/a[1]"));
            loginButton.click();

            // Вводим логин и пароль
            WebElement emailInput = driver.findElement(By.xpath("//*[@id=\"CustomerEmail\"]"));
            emailInput.sendKeys("aaaaa@aaaa.com");

            WebElement passwordInput = driver.findElement(By.xpath("//*[@id=\"CustomerPassword\"]"));
            passwordInput.sendKeys("qwertyuiop");

            // Нажимаем кнопку входа
            WebElement signInButton = driver.findElement(By.xpath("//*[@id=\"customer_login\"]/p[1]/button"));
            signInButton.click();
            Thread.sleep(5000);

            WebElement changesddreses = driver.findElement(By.xpath("//*[@id=\"MainContent\"]/div[1]/div/div[2]/p[3]/a"));
            changesddreses.click();
            Thread.sleep(2000);

            WebElement edit = driver.findElement(By.xpath("//*[@id=\"MainContent\"]/div/p[3]/button[1]"));
            edit.click();
            Thread.sleep(2000);

            WebDriverWait wait = new WebDriverWait(driver, 5);
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"Form0\"]/div[1]/div/div/div[2]/div/div[2]/div[1]/button")));

            // Скролл к элементу
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

            // Небольшая пауза для завершения скролла
            Thread.sleep(5000);

            WebElement apartmentInput = driver.findElement(By.xpath("//*[@id=\"AddressFirstName_8427510562878\"]"));
            apartmentInput.sendKeys("White");
            //
            WebDriverWait wait2 = new WebDriverWait(driver, 2);
            WebElement element2 = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"Form0\"]/div[1]/div/div/div[2]/div/div[2]/div[1]/button")));

            // Скролл к элементу
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

            // Небольшая пауза для завершения скролла
            Thread.sleep(2000);

            WebElement button = driver.findElement(By.xpath("//*[@id=\"address_form_8427510562878\"]/p[2]/button"));
            button.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}