package ru.sf.pages.website;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public record CataloguePage(WebDriver webDriver) {
    public void clickButtonSendForm() {
        webDriver.findElement(By.linkText("https://skillfactory.ru/catalogue#phoneform"));
    }

    public void fillForm(String name, String phone, String email) {
        webDriver.findElements(By.className("t-input_pvis")).get(1).sendKeys(name);
        webDriver.findElements(By.className("t-input_pvis")).get(2).sendKeys(phone);
        webDriver.findElements(By.className("t-input_pvis")).get(3).sendKeys(email);
    }
}
