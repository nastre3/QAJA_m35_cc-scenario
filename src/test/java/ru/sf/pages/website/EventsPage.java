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

public record EventsPage(WebDriver webDriver) {

    public void clickEventsFilter(String eventFilter) {
        webDriver.findElement(By.className("t397__title")).click();
    }

    public void assertDateFilterSorts() throws ParseException {
        getFirstCourseDate();
    }

    private void getFirstCourseDate() throws ParseException {
        String firstCourseDate = webDriver.findElement(By.className("t774__uptitle")).getText();
        Pattern pattern = Pattern.compile("* ?в ");
        Matcher matcher = pattern.matcher(firstCourseDate);

        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            System.out.println("Found match\n" + firstCourseDate.substring(start, end) + "\nfrom " + start + " to " + (end - 1));
        }

        System.out.println("Clean the text");
        System.out.println(matcher.replaceAll(""));

        Date date = new Date();
        System.out.println("current date: " + date); // текущее время

        Date firstCourseDateFormatted = new SimpleDateFormat("d MMMM yyyy").parse("7 апреля " + "2022");
        System.out.println("first date: " + firstCourseDateFormatted);
        System.out.println(firstCourseDateFormatted.after(date));
    }
}
