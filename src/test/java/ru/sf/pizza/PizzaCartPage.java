package ru.sf.pizza;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public record PizzaCartPage(WebDriver webDriver) {
    private static final String CART_CLASS = "sc-1mwp4sh-5";
    private static final String SUPPLEMENT_CLASS = "sc-1874jt1-0";

    public String get_pizza_name() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));// таймаут 2 сек
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(CART_CLASS)));
        System.out.println(webDriver.findElements(By.className(CART_CLASS)).get(0).getText());
        return webDriver.findElements(By.className(CART_CLASS)).get(0).getText();
    }

}
