#Gherkin
Feature: SkillFactory ui-tests on lms.skillfactory.ru/register
  # Позитивный сценарий: заполняется корректно форма регистрации с дополнительными данными, получаем открытие дашборда
  Scenario: fill registration form correctly with additional data
    Given url of school 'https://lms.skillfactory.ru/register'
    Then fill registration form with email 'test@mail.com', fullName 'testName', login 'testLogin', password 'testPassword', country 'Австралия'
    Then click checkbox for providing additional data
    Then click checkbox for providing additional data
    Then fill additional information with gender 'f', birthday '2000', education 'Магистратура или специалитет', message 'I love coding'
    Then click button create account