package ru.sf.pages.lms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public record LMSAccountPage(WebDriver webDriver) {
    public void changePhoto() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));

        // Найти на странице кнопку отправки формы и нажать её
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("upload-submit")));
        webDriver.findElement(By.className("u-field-upload-button")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated((By.className("upload-button-input"))));
        // Найти на странице элемент для заливки файла и указать элементу абсолютный путь до файла
        webDriver.findElement(By.className("upload-button-input")).sendKeys
                ("C:\\Users\\Anastasia\\IdeaProjects\\FinalWebsiteProjectSF\\src\\test\\java\\ru\\sf\\resources\\QAJA_m34_u4_1.png");
    }
}
