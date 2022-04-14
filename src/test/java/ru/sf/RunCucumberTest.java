package ru.sf;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.firefox.FirefoxDriver;

//Конфигурация, требующаяся для запуска сценариев через JUnit4
@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features")
public class RunCucumberTest {
    @BeforeClass
    public static void initResources() {
        StepDefinitions.webDriver = new FirefoxDriver();
    }
    //Закрываем браузер, когда тесты отработали
    @AfterClass
    public static void finalizeResources() {
        StepDefinitions.webDriver.close();
    }
}
