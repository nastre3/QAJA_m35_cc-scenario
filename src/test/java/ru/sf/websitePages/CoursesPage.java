package ru.sf.websitePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public record CoursesPage(WebDriver webDriver) {
    private final static String COURSE_STATUS_LABEL_CLASS = "discovery-message";
    private final static String COURSE_TITLE_CLASS = "course-title";
    private final static String COURSE_OPTIONS_CLASS = "facet-option";
    private final static String COURSE_ORGANIZATION_CLASS = "course-organization";

    public String getCourseTitle() {
        return webDriver.findElement(By.className(COURSE_TITLE_CLASS)).getText();
    }

    public String getSearchStatusLabel() {
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.textToBePresentInElement(webDriver.findElement(By.id(COURSE_STATUS_LABEL_CLASS)),
                "Нет результатов для «unknown»."));
        final var searchStatusLabel = webDriver.findElement(By.id(COURSE_STATUS_LABEL_CLASS)).getText();
        return searchStatusLabel;
    }

    public void clickFilter(int optionNumber) {
        webDriver.findElements(By.className(COURSE_OPTIONS_CLASS)).get(optionNumber).click();
    }

    public String getCourseOrganization() {
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.textToBe(By.className(COURSE_ORGANIZATION_CLASS), "Internetcollege"));
        return webDriver.findElement(By.className(COURSE_ORGANIZATION_CLASS)).getText();
    }
}
