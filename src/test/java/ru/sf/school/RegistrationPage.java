package ru.sf.school;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public record RegistrationPage(WebDriver webDriver) {
    private final static String REGISTER_COUNTRY_ID = "register-country";
    private final static String OPTIONAL_CHECKBOX_ID = "toggle_optional_fields";
    private final static String GENDER_ID = "toggle_optional_fields";
    private final static String BIRTHDAY_ID = "register-year_of_birth-optional-label";
    private final static String EDUCATION_ID = "register-level_of_education-optional-label";
    private final static String MESSAGE_ID = "register-goals";
    public static long now = System.currentTimeMillis();
    public static String filledLogin = String.format("login%s", now);

    public void fillRegistrationForm(String email, String fullName, String login, String password) {
        email = String.format("user%s@mail.com", now);
        fullName = String.format("fullName%s", now);
        password = String.format("password", now);
        webDriver.findElement(By.id("register-email")).sendKeys(email);
        webDriver.findElement(By.id("register-name")).sendKeys(fullName);
        webDriver.findElement(By.id("register-username")).sendKeys(filledLogin);
        webDriver.findElement(By.id("register-password")).sendKeys(password);
    }

    public void selectCountry(String country) {
        Select drpCountry = new Select(webDriver.findElement((By.id(REGISTER_COUNTRY_ID))));
        drpCountry.selectByVisibleText(country);
    }

    public void clickButtonCreateAccount() {
        webDriver.findElement(By.className("register-button")).click();
    }

    public void clickCheckboxOptionalFields() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20)); // явное ожидание (explicit), 60 - максимальное кол-во сек ожидания
        wait.until(ExpectedConditions.elementToBeClickable(By.className(OPTIONAL_CHECKBOX_ID)));
        webDriver.findElement(By.className(OPTIONAL_CHECKBOX_ID)).click();
    }

    public void fillOptionalFields(String gender, String birthday, String education, String message) {
        Select drpGender = new Select(webDriver.findElement((By.id(GENDER_ID))));
        drpGender.selectByVisibleText(gender);

        Select drpBirthday = new Select(webDriver.findElement((By.id(BIRTHDAY_ID))));
        drpBirthday.selectByVisibleText(birthday);

        Select drpEducation = new Select(webDriver.findElement((By.id(EDUCATION_ID))));
        drpEducation.selectByVisibleText(education);

        webDriver.findElement((By.id(MESSAGE_ID))).sendKeys(message);
    }

    public void assertCorrectLoginShown() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20)); // явное ожидание (explicit), 60 - максимальное кол-во сек ожидания
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("username")));
        String currentLogin = webDriver.findElement(By.className("username")).getText();
        assertEquals(filledLogin, currentLogin);
    }
}
