package com.sumerianrecords;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderConfirmationTest extends MainTest {
    @Test
    public void testAddToCart() {
        try {
            // Открываем страницу товара
            driver.get("https://sumerianrecords.com/collections/palayeroyale/products/palaye-royale-little-bastards-coffee-mug");

            // Нажимаем на кнопку "Добавить в корзину"
            WebElement addToCartButton = driver.findElement(By.xpath("//*[@id=\"AddToCartForm-template--14617934790718__main-4459923701822\"]/button"));
            addToCartButton.click();

            // Подождем некоторое время, чтобы корзина обновилась
            Thread.sleep(2000);

            WebElement close = driver.findElement(By.xpath("//*[@id=\"dpModal-container\"]/a"));
            close.click();


            WebElement checkout = driver.findElement(By.xpath("//*[@id=\"CartPageForm\"]/div/div[2]/div[4]/button"));
            checkout.click();

            Thread.sleep(2000);


            WebElement contactInput = driver.findElement(By.xpath("//*[@id=\"email\"]"));
            contactInput.sendKeys("aaaaa@aaaa.com");

            WebElement countryDropdown = driver.findElement(By.id("Select0"));
            Select countrySelect = new Select(countryDropdown);
            countrySelect.selectByVisibleText("Germany");


            WebElement newsOffersCheckbox = driver.findElement(By.id("marketing_opt_in"));
            if (newsOffersCheckbox.isSelected()) {
                newsOffersCheckbox.click();
            }

            WebElement shippingAddressInput = driver.findElement(By.id("TextField0"));
            shippingAddressInput.sendKeys("Anna");

            WebElement companyInput = driver.findElement(By.id("TextField1"));
            companyInput.sendKeys("Maria");

            WebDriverWait wait = new WebDriverWait(driver, 2);
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"Form0\"]/div[1]/div/div/div[2]/div/div[2]/div[1]/button")));

            // Скролл к элементу
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

            // Небольшая пауза для завершения скролла
            Thread.sleep(2000);

            WebElement apartmentInput = driver.findElement(By.id("TextField4"));
            apartmentInput.sendKeys("Your Apartment");

//            WebElement postalCodeInput = driver.findElement(By.id("TextField5"));
//            postalCodeInput.sendKeys("10100");

//            WebElement cityInput = driver.findElement(By.id("TextField6"));
//            cityInput.sendKeys("Mainz");

//            WebElement phoneInput = driver.findElement(By.id("TextField7"));
//            phoneInput.sendKeys("+420777555");

//            WebElement addressInput = driver.findElement(By.xpath("//*[@id=\"TextField3\"]"));
//            addressInput.sendKeys("Deutschlandska 15");

            // При необходимости добавьте код для отправки формы, нажатия кнопок и т.д.
            WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"Form0\"]/div[1]/div/div/div[2]/div/div[2]/div[1]/button"));
            submitButton.click();
            Thread.sleep(3000);

            String expectedNewsText = "Enter a phone number"; // Замените на ожидаемый текст новости

            // Находим элемент, содержащий текст новости
            WebElement newsTextElement = driver.findElement(By.xpath("//*[@id=\"error-for-TextField7\"]")); // Замените 'news-content' на реальный класс элемента текста новости

            // Получаем текст элемента
            String actualNewsText = newsTextElement.getText();

            // Проверяем, что текст новости соответствует ожидаемому
            Assertions.assertEquals(expectedNewsText, actualNewsText, "Текст новости не соответствует ожидаемому");


            // Можно добавить дополнительные проверки, например, сравнение названия и цены добавленного товара
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
