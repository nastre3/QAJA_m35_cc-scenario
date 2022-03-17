package ru.sf;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public record PizzaContactPage(WebDriver webDriver) {

    private final static String PIZZA_DELIVERY_ZONE_CLASS = "contacts-pizzerias__filter-input";
    private final static String ERROR_MESSAGE_SPAN_CLASS = "contacts-pizzerias__filter-desc";

    public void add_city(String deliveryZone) {
        final var searchInput = webDriver.findElement(By.className(PIZZA_DELIVERY_ZONE_CLASS));
        searchInput.sendKeys(deliveryZone, Keys.ENTER);
    }

    public String getNotification() {
        return webDriver.findElement(By.className(ERROR_MESSAGE_SPAN_CLASS)).getText();
    }
}
