package ru.sf.pages.website;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public record MainPage(WebDriver webDriver) {

    public void clickFilter(String courseName) {
        final var linkName = webDriver.findElement(By.linkText(courseName));
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(linkName));
        linkName.click();
    }

    public void clickImageLink(String courseName) {
        webDriver.findElements(By.partialLinkText(courseName)).get(1).click();
    }

    public void clickSubmitBitton() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(By.className("t-submit")));
        webDriver.findElement(By.className("t-submit")).click();
    }

    public void AssertErrorNotificationShown(String expectedError) {
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.textToBePresentInElement(webDriver.findElement(By.id("tilda-popup-for-error")),
                expectedError));
    }
}
