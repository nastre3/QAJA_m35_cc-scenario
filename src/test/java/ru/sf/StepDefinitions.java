package ru.sf;

import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.sf.pizza.CityMenuPage;
import ru.sf.pizza.PizzaCartPage;
import ru.sf.pizza.PizzaContactPage;
import ru.sf.pizza.PizzaOptionsPage;
import ru.sf.school.CoursesPage;
import ru.sf.school.MainPage;
import ru.sf.school.RegistrationPage;

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
    public static final MainPage mainPage;
    public static final CoursesPage coursesPage;
    public static final RegistrationPage registrationPage;

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
        mainPage = new MainPage(webDriver);
        coursesPage = new CoursesPage(webDriver);
        registrationPage = new RegistrationPage(webDriver);
    }

    @BeforeStep
    public void timeoutDelay() {
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    //Реализация шага
    @Given("url of restaurant {string}")
    public void url_of_restaurant(String url) {
        cityMenuPage.go(url);
    }

    @Then("chose pizza item")
    public void chose_pizza_item() {
        cityMenuPage.chose_pizza_item();
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



    @Then("assert cart has pizza_name {string}")
    public void assert_cart_has_item_with_pizza_name(String pizza_name) {
        final var choosenPizzaName = pizzaCartPage.get_pizza_name();
        assertEquals(pizza_name, choosenPizzaName);
    }

    @Then("add city {string}")
    public void add_city(String city) {
        pizzaContactPage.add_city(city);
    }


    // new
    @Given("url of school {string}")
    public void url_of_school(String url) {
        mainPage.go(url);
    }

    @Then("type course item {string}")
    public void type_course_item(String searchedCourseTitle) {
        mainPage.searchCourse(searchedCourseTitle);
    }

    @Then("assert that first course is named {string}")
    public void assert_that_first_course_is_named(String expectedCourseTitle) {
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        final var courseTitle = coursesPage.getCourseTitle();
        assertEquals(expectedCourseTitle, courseTitle);
    }

    @Then("assert that appears message {string}")
    public void assert_that_appears_message(String notFoundMessage) {
        final var actualMessage = coursesPage.getSearchStatusLabel();
        assertEquals(notFoundMessage, actualMessage);
    }

    @Then("click filter {int}")
    public void click_filter(int optionNumber) {
        coursesPage.clickFilter(optionNumber);
    }

    @Then("assert that course organization is {string}")
    public void assert_that_course_organization_is(String courseOrganization) {

        final var chosenCourseOrganization = coursesPage.getCourseOrganization();
        assertEquals(courseOrganization, chosenCourseOrganization);
    }

    @Then("click footer list items")
    public void clickFooterListItems() {
        mainPage.clickFooterListItems();
    }

    @Then("click icon items")
    public void clickIconItems() {
        mainPage.clickIconItems();
    }

    @Then("fill registration form with email {string}, fullName {string}, login {string}, password {string}, country {string}")
    public void fill_registration_form_with_email_full_name_login_password_country(String email, String fullName, String login, String password, String country) {
        registrationPage.fillRegistrationForm(email, fullName, login, password);
        registrationPage.selectCountry(country);
    }
    @Then("click button create account")
    public void click_button_create_account() {
        registrationPage.clickButtonCreateAccount();
    }

    @Then("click checkbox for providing additional data")
    public void click_checkbox_for_providing_additional_data() {
        registrationPage.clickCheckboxOptionalFields();
    }

    @Then("fill additional information with gender {string}, birthday {string}, education {string}, message {string}")
    public void fill_additional_information_with_sex_birthday_education_message(String gender, String birthday, String education, String message) {
        registrationPage.fillOptionalFields(gender, birthday, education, message);
    }

    @And("assert that correct login is shown")
    public void assertThatCorrectLoginTestLoginIsShown() {
        registrationPage.assertCorrectLoginShown();
    }
}
