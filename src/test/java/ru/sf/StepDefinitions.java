package ru.sf;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.assertEquals;


/**
 * Варинаты запуска сценариев:
 * Команда 'mvn clean test' в консоли
 * Через UI intellij IDEA
 */
public class StepDefinitions {

    public static final WebDriver webDriver;
    public static final CityMenuPage cityMenuPage;
    public static final PizzaOptionsPage pizzaOptionsPage;
    public static final PizzaCartPage pizzaCartPage;
    public static final PizzaContactPage pizzaContactPage;

    //Процесс инициализации необходимых ресурсов
    static {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        webDriver.manage().window().maximize();
        cityMenuPage = new CityMenuPage(webDriver);
        pizzaOptionsPage = new PizzaOptionsPage(webDriver);
        pizzaCartPage = new PizzaCartPage(webDriver);
        pizzaContactPage = new PizzaContactPage(webDriver);
    }

    //Реализация шага
    @Given("url of restaurant {string}")
    public void url_of_restaurant(String url) {
        cityMenuPage.go(url);
    }

    @Then("chose pizza item {string}")
    public void chose_pizza_item(String pizza_item) {
        cityMenuPage.chose_pizza_item(pizza_item);
    }

    @Then("chose pizza supplement")
    public void chose_pizza_supplement() {
        pizzaOptionsPage.chose_pizza_supplement();
    }

    @Then("click add button in shopping cart")
    public void click_add_button_in_shopping_cart() {
        pizzaOptionsPage.click_add_button_in_shopping_cart();
    }

    @Then("click shopping cart button")
    public void click_shopping_cart_button() {
        cityMenuPage.click_shopping_cart_button();
    }

    @Then("assert that appears notification text {string}")
    public void assert_that_appears_notification_text(String errorMessage) {
        final var spotNotFoundNotification = pizzaContactPage.getNotification();
        assertEquals(errorMessage, spotNotFoundNotification);
    }

    @Then("assert cart has pizza_name {string}")
    public void assert_cart_has_item_with_pizza_name(String pizza_name) {
        final var choosenPizzaName = pizzaCartPage.get_pizza_name();
        assertEquals(pizza_name, choosenPizzaName);
    }

    @Then("add city {string}")
    public void add_city(String city) {
        pizzaContactPage.add_city(city);
    }
}
