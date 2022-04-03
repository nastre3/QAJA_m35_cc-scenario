package ru.sf.school;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public record MainPage(WebDriver webDriver) {
    private final static String SEARCH_INPUT_CLASS = "search-input";
    private final static String FOOTER_LIST_ITEMS_CLASS = "footer-list_link";
    private final static String ICON_LIST_CLASS = "icon-list_icon";

    public void chose_pizza_item() {
        // webDriver.findElements(By.className()).get(1).click();
    }

    public void click_shopping_cart_button() {
        //webDriver.findElement(By.className()).click();
    }

    //new
    public void go (String url) {
        webDriver.get(url);
    }

    public void searchCourse(String courseName) {
        final var searchInput = webDriver.findElement(By.className(SEARCH_INPUT_CLASS));
        searchInput.sendKeys(courseName, Keys.ENTER);
    }

    public void clickFooterListItems() {
        for (int i = 0; i < 3; i++) {
            webDriver.findElements(By.className(FOOTER_LIST_ITEMS_CLASS)).get(i).click();
        }
    }

    public void clickIconItems() {
        for (int i = 0; i < 8; i++) {
            webDriver.findElements(By.className(ICON_LIST_CLASS)).get(i).click();
        }
        assertEquals(webDriver().getCurrentUrl(), "");
    }
}
