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

            // Finding the login button and go to the login page
            WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"SiteHeader\"]/div[1]/div[1]/div[3]/div/div/a[1]"));
            loginButton.click();

            // Entering login and password
            WebElement emailInput = driver.findElement(By.xpath("//*[@id=\"CustomerEmail\"]"));
            emailInput.sendKeys(email);

            WebElement passwordInput = driver.findElement(By.xpath("//*[@id=\"CustomerPassword\"]"));
            passwordInput.sendKeys(password);

            // Pressing the enter button
            WebElement signInButton = driver.findElement(By.xpath("//*[@id=\"customer_login\"]/p[1]/button"));
            signInButton.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


