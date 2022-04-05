#Gherkin
Feature: SkillFactory ui-tests on main page skillfactory.ru
  # Позитивный сценарий: нажатие на быстрые фильтры курсов на главной странице, получаем открытие страниц
  Scenario: check links on main page
    Given url of school 'https://skillfactory.ru/'
    Then click 'Data Science'
    And assert that correct page is opened 'https://skillfactory.ru/data-science'
  # Позитивный сценарий: нажатие на изображения курсов на главной странице, получаем открытие страниц
  Scenario: check image links on main page
    Given url of school 'https://skillfactory.ru/'
    Then click image for 'Data Science'
    And assert that correct page is opened 'https://skillfactory.ru/data-science'
  # Негативный сценарий: отправка пустой формы email без соглашения
  Scenario: check email subscribe form
    Given url of school 'https://skillfactory.ru/'
    Then click on Submit button
    And assert that error notifications appear for subscribe form 'Пожалуйста, заполните все обязательные поля'
  # Позитивный сценарий: фильтр мероприятий на странице /events, получаем открытие страниц
  Scenario: check filters on /events
    Given url of school 'https://skillfactory.ru/events'
    Then click filter name 'Актуальные мероприятия'
    And assert that date for course is more then current date

