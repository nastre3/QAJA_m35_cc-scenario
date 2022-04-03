package ru.sf.websitePages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public record AccountSettingsPage(WebDriver webDriver) {
    private final static String COUNTRY_ID = "u-field-select-country";
    private final static String TIME_ZONE_ID = "u-field-select-time_zone";
    private final static String EDUCATION_ID = "u-field-select-level_of_education";
    private final static String GENDER_ID = "u-field-select-gender";
    private final static String BIRTHDAY_YEAR_ID = "u-field-select-year_of_birth";
    private final static String LANGUAGE_ID = "u-field-select-year_of_birth";

    public void changeFullName(String newName) {
        webDriver.findElement(By.id("field-input-name")).clear();
        webDriver.findElement(By.id("field-input-name")).sendKeys(newName,Keys.ENTER);
    }

    public void selectCountry(String country) {
        Select drpCountry = new Select(webDriver.findElement((By.id(COUNTRY_ID))));
        drpCountry.selectByVisibleText(country);
    }

    public void changeTimeZone(String timeZone) {
        Select drpTimeZone = new Select(webDriver.findElement((By.id(TIME_ZONE_ID))));
        drpTimeZone.selectByVisibleText(timeZone);
    }

    public void selectEducation(String education) {
        Select drpEducation = new Select(webDriver.findElement((By.id(EDUCATION_ID))));
        drpEducation.selectByVisibleText(education);
    }

    public void selectGender(String gender) {
        Select drpGender = new Select(webDriver.findElement((By.id(GENDER_ID))));
        drpGender.selectByVisibleText(gender);
    }

    public void selectBirthday(String birthdayYear) {
        Select drpBirthday = new Select(webDriver.findElement((By.id(BIRTHDAY_YEAR_ID))));
        drpBirthday.selectByVisibleText(birthdayYear);
    }

    public void selectLanguage(String language) {
        Select drpLanguage = new Select(webDriver.findElement((By.id(LANGUAGE_ID))));
        drpLanguage.selectByVisibleText(language);
    }

    public void addTwitterLink(String twitter) {
        webDriver.findElement(By.id("field-input-social_links_twitter")).sendKeys(twitter);
    }

    public void addFacebookLink(String facebook) {
        webDriver.findElement(By.id("field-input-social_links_facebook")).sendKeys(facebook);
    }

    public void addLinkedinLink(String linkedin) {
        webDriver.findElement(By.id("field-input-social_links_linkedin")).sendKeys(linkedin);
    }
}
