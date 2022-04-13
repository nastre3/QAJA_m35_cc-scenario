#Gherkin
Feature: SkillFactory ui-tests on main page skillfactory.ru for registration
  # Позитивный сценарий: заполняется корректно форма регистрации, получаем нотификацию об успехе
  Scenario: fill registration form correctly
    Given url of school 'https://lms.skillfactory.ru/register'
    Then fill registration form with email 'test@mail.com', fullName 'testName', login 'testLogin', password 'testPassword', country 'Австрия'
    Then click button create account
    And assert that correct login is shown