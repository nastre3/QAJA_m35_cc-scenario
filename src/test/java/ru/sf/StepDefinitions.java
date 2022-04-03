package ru.sf;

import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.sf.pizza.CityMenuPage;
import ru.sf.pizza.PizzaCartPage;
import ru.sf.pizza.PizzaContactPage;
import ru.sf.pizza.PizzaOptionsPage;
import ru.sf.school.*;

import java.time.Duration;

import static org.junit.Assert.assertEquals;


/**
 * Варинаты запуска сценариев:
 * Команда 'mvn clean test' в консоли
 * Через UI intellij IDEA
 */
public class StepDefinitions {

    public static final WebDriver webDriver;
    public static final MainPage mainPage;
    public static final CoursesPage coursesPage;
    public static final RegistrationPage registrationPage;
    public static final LoginPage loginPage;
    public static final DashboardPage dashboardPage;
    public static final AccountPage accountPage;
    public static final AccountSettingsPage accountSettingsPage;

    //Процесс инициализации необходимых ресурсов
    static {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        webDriver.manage().window().maximize();
        mainPage = new MainPage(webDriver);
        coursesPage = new CoursesPage(webDriver);
        registrationPage = new RegistrationPage(webDriver);
        loginPage = new LoginPage(webDriver);
        dashboardPage = new DashboardPage(webDriver);
        accountPage = new AccountPage(webDriver);
        accountSettingsPage = new AccountSettingsPage(webDriver);
    }

    @BeforeStep
    public void timeoutDelay() {
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

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
    public void fill_registration_form_with_email_full_name_login_password_country
            (String email, String fullName, String login, String password, String country) {
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

    @Then("fill registration form incorrectly with email {string}, fullName {string}, login {string}, password {string}, country {string}")
    public void fill_registration_form_incorrectly_with_email_full_name_login_password_country(String email, String fullName, String login, String password, String country) {
        registrationPage.fillRegistrationFormIncorrectly(email, fullName, login, password);
        registrationPage.selectCountry(country);
    }

    @And("assert that empty error notifications appear")
    public void assertThatEmptyErrorNotificationsAppear() {
        registrationPage.assertEmptyErrorNotifications();
    }

    @And("assert that wrong error notifications appear: wrong email {string}, wrong login {string}")
    public void assertThatWrongErrorNotificationsAppear(String email, String login) {
        registrationPage.assertWrongErrorNotifications(email, login);
    }

    @Then("fill login form incorrectly with email {string}, password {string}")
    public void fill_login_form_incorrectly_with_email_password(String email, String password) {
        loginPage.fillLoginFormIncorrectly(email, password);
    }

    @Then("click button login")
    public void click_button_login() {
        loginPage.clickLoginButton();
    }

    @Then("assert that empty login error notifications appear {string}")
    public void assert_that_empty_login_error_notifications_appear(String emptyLoginError) {
        loginPage.assertLoginError(emptyLoginError);
    }

    @And("assert that correct login is shown {string}")
    public void assertThatCorrectLoginIsShownLogin(String login) {
        registrationPage.assertCorrectLoginShown(login);
    }

    @Then("click button search courses")
    public void clickButtonSearchCourses() {
        dashboardPage.ButtonSearchCourses();
    }

    @Then("assert that correct page is opened {string}")
    public void assert_that_correct_page_is_opened(String openedURL) {
        dashboardPage.assertOpenedURL(openedURL);
    }

    @Then("fill search input {string}")
    public void fill_search_input(String searchedPhrase) throws InterruptedException {
        dashboardPage.fillSearchInput(searchedPhrase);
    }
    @Then("assert that no results were found")
    public void assert_that_no_results_were_found() {
       dashboardPage.assertSearchResultNotFound();
    }

    @Then("change photo")
    public void clickChangePhotoButton() {
        accountPage.changePhoto();
    }

    @Then("click button Profile")
    public void clickButtonProfile() {
        dashboardPage.clickButtonProfile();
    }

    @Then("change photo wrongly")
    public void changePhotoWrongly() {
        accountPage.changePhotoWrongly();
    }

    @Then("open rightMenuPanel")
    public void open_right_menu_panel() {
        dashboardPage.clickRightMenu();
    }

    @Then("click accountSettings")
    public void click_account_settings() {
        dashboardPage.clickAccountSettings();
    }

    @Then("change full name {string}")
    public void change_full_name(String newName) {
        accountSettingsPage.changeFullName(newName);
    }

    @Then("select country {string}")
    public void change_country(String country) {
        accountSettingsPage.selectCountry(country);
    }
    @Then("change timezone {string}")
    public void change_timezone(String timeZone) {
        accountSettingsPage.changeTimeZone(timeZone);
    }


}
