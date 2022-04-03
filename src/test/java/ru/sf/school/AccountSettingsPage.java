package ru.sf.school;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public record AccountSettingsPage(WebDriver webDriver) {
    private final static String COUNTRY_ID = "u-field-select-country";
    private final static String TIME_ZONE_ID = "u-field-select-time_zone";

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
}
