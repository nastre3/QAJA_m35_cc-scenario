package ru.sf;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public record PizzaOptionsPage(WebDriver webDriver) {
    private static final String PIZZA_SUPPLEMENT_SPAN_CLASS = "sc-1keftj-1";
    private static final String ADD_CART_BUTTON_CLASS = "sc-15fdqut-22";

    public void chose_pizza_supplement() {
        webDriver.findElements(By.className(PIZZA_SUPPLEMENT_SPAN_CLASS)).get(0).click();
    }

    public void click_add_button_in_shopping_cart() {
        webDriver.findElement(By.className(ADD_CART_BUTTON_CLASS)).click();
    }


}
