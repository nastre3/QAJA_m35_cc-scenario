package ru.sf.pizza;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public record CityMenuPage(WebDriver webDriver) {

    private final static String ACTIVE_PIZZA_ITEM_SPAN_XPATH = "sc-2v0umu-1";
    private static final String CART_TITLE_CLASS = "cart-button__quantity";
    private static final String CART_BUTTON = "bUUipH";

    public void go (String url) {
        webDriver.get(url);
    }

    public void chose_pizza_item() {
        webDriver.findElements(By.className(ACTIVE_PIZZA_ITEM_SPAN_XPATH)).get(1).click();
    }

    public void click_shopping_cart_button() {
        webDriver.findElement(By.className(CART_BUTTON)).click();
    }


}
