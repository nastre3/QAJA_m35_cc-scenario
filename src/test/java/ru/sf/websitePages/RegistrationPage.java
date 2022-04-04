package ru.sf.websitePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public record RegistrationPage(WebDriver webDriver) {
    private final static String REGISTER_COUNTRY_ID = "register-country";
    private final static String OPTIONAL_CHECKBOX_ID = "toggle_optional_fields";
    private final static String GENDER_ID = "register-gender";
    private final static String BIRTHDAY_ID = "register-year_of_birth";
    private final static String EDUCATION_ID = "register-level_of_education";
    private final static String MESSAGE_ID = "register-goals";
    private final static String ERROR_EMAIL_ID = "register-email-validation-error-msg";
    private final static String ERROR_NAME_ID = "register-name-validation-error-msg";
    private final static String ERROR_LOGIN_ID = "register-username-validation-error-msg";
    private static final String ERROR_PASSWORD_ID = "register-password-validation-error-msg";
    public static long now = System.currentTimeMillis();
    public static String filledLogin = String.format("login%s", now);

    public void fillRegistrationForm(String s, String email, String fullName, String password) {
        email = String.format("user%s@mail.ru", now);
        fullName = String.format("fullName%s", now);
        password = String.format("password", now);
        fillRegisterForm(email, fullName, filledLogin, password);
    }

    private void fillRegisterForm(String email, String fullName, String login, String password) {
        webDriver.findElement(By.id("register-email")).sendKeys(email);
        webDriver.findElement(By.id("register-name")).sendKeys(fullName);
        webDriver.findElement(By.id("register-username")).sendKeys(login);
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
            webDriver.findElement(By.id(OPTIONAL_CHECKBOX_ID)).click();
    }

    public void fillOptionalFields(String gender, String birthday, String education, String message) {
        Select drpGender = new Select(webDriver.findElement((By.id(GENDER_ID))));
        drpGender.selectByValue(gender);

        Select drpBirthday = new Select(webDriver.findElement((By.id(BIRTHDAY_ID))));
        drpBirthday.selectByVisibleText(birthday);

        Select drpEducation = new Select(webDriver.findElement((By.id(EDUCATION_ID))));
        drpEducation.selectByVisibleText(education);

        webDriver.findElement((By.id(MESSAGE_ID))).sendKeys(message);
    }

    public void assertCorrectLoginShown() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("username")));
        String currentLogin = webDriver.findElement(By.className("username")).getText();
        assertEquals(filledLogin, currentLogin);
    }

    public void fillRegistrationFormIncorrectly(String email, String fullName, String login, String password) {
        fillRegisterForm(email, fullName, login, password);
    }

    public void assertEmptyErrorNotifications() {
        WebDriverWait(By.id(ERROR_EMAIL_ID),
                "Введите корректный адрес электронной почты, который содержит не менее 3 символов.");
        WebDriverWait(By.id(ERROR_NAME_ID), "Введите ваше имя.");
        WebDriverWait(By.id(ERROR_LOGIN_ID), "Имя пользователя должно быть длиной от 2 до 30 символов.");
        WebDriverWait(By.id(ERROR_PASSWORD_ID),
                "Введённый пароль слишком короткий. Он должен содержать как минимум 2 символа.");
    }

    public void assertWrongErrorNotifications(String email, String login) {
        String formatedEmail = String.format("\"%s\" не является корректным адресом электронной почты.", email);
        WebDriverWait(By.id(ERROR_EMAIL_ID), formatedEmail);
        WebDriverWait(By.id(ERROR_LOGIN_ID), "Кажется " + login +
                " уже используется. Попробуйте ещё раз с другим именем пользователя.");
        WebDriverWait(By.id(ERROR_PASSWORD_ID),
                "Введённый пароль слишком похож на адрес электронной почты.");
    }

    private void WebDriverWait(By locator, String searchedText) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.textToBePresentInElement(webDriver.findElement(locator),
                searchedText)
        );
    }

    public void assertCorrectLoginShown(String login) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("username")));
        String currentLogin = webDriver.findElement(By.className("username")).getText();
        assertEquals(login, currentLogin);
    }
}
