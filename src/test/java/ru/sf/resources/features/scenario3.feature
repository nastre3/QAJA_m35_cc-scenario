#Gherkin
Feature: SkillFactory ui-tests on lms.skillfactory.ru/register
  # Позитивный сценарий: заполняется корректно форма регистрации, получаем открытие дашборда
  Scenario: fill registration form correctly with additional data
    Given url of school 'https://lms.skillfactory.ru/register'
    Then fill registration form with email 'test@mail.com', fullName 'testName', login 'testLogin', password 'testPassword12'
    Then choose country 'AU'
    Then click button create account
