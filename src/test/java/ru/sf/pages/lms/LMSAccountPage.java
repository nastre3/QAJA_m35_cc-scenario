package ru.sf.pages.lms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public record LMSAccountPage(WebDriver webDriver) {
    public void changePhoto() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.presenceOfElementLocated((By.className("upload-button-input"))));
        webDriver.findElement(By.className("upload-button-input")).sendKeys
                ("C:/Users/Anastasia/IdeaProjects/FinalWebsiteProjectSF/src/test/resources/QAJA_m34_u4_1.png");
    }

    public void changePhotoWrongly() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.presenceOfElementLocated((By.className("upload-button-input"))));
        webDriver.findElement(By.className("upload-button-input")).sendKeys
                ("C:/Users/Anastasia/IdeaProjects/FinalWebsiteProjectSF/src/test/resources/1269-Locators_table_1_0_2.pdf");
    }
}
