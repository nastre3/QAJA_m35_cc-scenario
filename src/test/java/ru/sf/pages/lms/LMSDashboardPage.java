package ru.sf.pages.lms;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public record LMSDashboardPage(WebDriver webDriver) {
    private final static String SEARCH_COURSES_BUTTON = "btn-primary";
    private final static String DASHBOARD_SEARCH_INPUT_CLASS = "search-field";
    private final static String SEARCH_BUTTON_CLASS = "search-button";
    private final static String DROPDOWN_ITEM_CLASS = "dropdown-nav-item";

    public void ButtonSearchCourses() {
        webDriver.findElement(By.className(SEARCH_COURSES_BUTTON)).click();
    }

    public void assertOpenedURL(String openedURL) {
        String currentURL = webDriver.getCurrentUrl();
        assertEquals(openedURL, currentURL);
    }

    public void fillSearchInput(String searchedPhrase) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.presenceOfElementLocated((By.className(DASHBOARD_SEARCH_INPUT_CLASS))));
        webDriver.findElement(By.className(DASHBOARD_SEARCH_INPUT_CLASS)).sendKeys(searchedPhrase);
        webDriver.findElement(By.className(SEARCH_BUTTON_CLASS)).click();
    }

    public void assertSearchResultNotFound() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.presenceOfElementLocated((By.className("search-count"))));
        String actualSearchResult = webDriver.findElement(By.className("search-count")).getText();
        assertEquals("0 results", actualSearchResult);
    }

    public void clickButtonProfile() {
        webDriver.findElements(By.className("tab-nav-link")).get(1).click();
    }

    public void clickRightMenu() {
        webDriver.findElement(By.className("toggle-user-dropdown")).click();
    }

    public void clickAccountSettings() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className(DROPDOWN_ITEM_CLASS)));
        webDriver.findElements(By.className(DROPDOWN_ITEM_CLASS)).get(2).click();
    }
}
