package ru.sf.pages.website;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public record EventsPage(WebDriver webDriver) {

    public void clickEventsFilter(String eventFilter) {
        webDriver.findElement(By.className("t397__title")).click();
    }

    public void assertDateFilterSorts() throws ParseException {
        getFirstCourseDate();
    }

    private void getFirstCourseDate() throws ParseException {
        String firstCourseDate = webDriver.findElement(By.className("t774__uptitle")).getText().substring(0, 10);
        Date currentDate = new Date();
        System.out.println("current currentDate: " + currentDate); // текущее время

        Date firstCourseDateFormatted = new SimpleDateFormat("d MMMM yyyy").parse(firstCourseDate + "2022");
        System.out.println("first course currentDate: " + firstCourseDateFormatted);
        assertTrue(firstCourseDateFormatted.after(currentDate));
    }
}
