package ru.sf.websitePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public record LoginPage(WebDriver webDriver) {
    public void fillLoginFormIncorrectly(String email, String password) {
        webDriver.findElement(By.id("login-email")).sendKeys(email);
        webDriver.findElement(By.id("login-password")).sendKeys(password);
    }

    public void clickLoginButton() {
        webDriver.findElement(By.className("login-button")).click();
    }

    public void assertLoginError(String emptyLoginError) {
        String actualError = webDriver.findElement(By.xpath("//ul[@class='message-copy']/li[1]")).getText();
        System.out.println("actualError:" + actualError);
        assertEquals(emptyLoginError, actualError);
    }
}
