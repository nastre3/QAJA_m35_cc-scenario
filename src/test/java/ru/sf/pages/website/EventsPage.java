package ru.sf.pages.website;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public record EventsPage(WebDriver webDriver) {

    public void clickEventsFilter(String eventFilter) {
        webDriver.findElement(By.className("t397__title")).click();
    }

    public void assertDateFilterSorts() {
        getFirstCourseDate();
    }

    private void getFirstCourseDate() {
        String firstCourseDate = webDriver.findElement(By.className("t774__uptitle")).getText();
        System.out.println("date 1st course: " + firstCourseDate);
        /*Date date = new Date();
        System.out.println("current date: " + date); // текущее время
        System.out.println(firstCourseDate.after(date));//true
         */
    }
}
